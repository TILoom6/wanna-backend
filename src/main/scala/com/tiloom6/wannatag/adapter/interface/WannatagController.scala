package com.tiloom6.wannatag.adapter.interface

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import com.tiloom6.wannatag.domain.model.user.UserId
import com.tiloom6.wannatag.domain.model.wannatag._
import com.tiloom6.wannatag.domain.repository.wannatag.{OlderOrNewer, WannatagRepository, WannatagsSearchLimit}
import com.tiloom6.wannatag.usecase.{NotFoundError, ServiceError}
import com.tiloom6.wannatag.usecase.wannatag.SearchWannatagsUseCase

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

trait WannatagController {
  self: WannatagValidator with WannatagConvertor =>

  def searchWannatags(implicit executionContext: ExecutionContext): Route = pathPrefix("wannatags") {
    import com.tiloom6.wannatag.domain.model.wannatag.Implicits._

    pathEndOrSingleSlash {
      get {
        parameters('compare ?, 'postDate ?, 'limit ?) { (compare, postDate, limit) =>

          // TODO stream的に値流す形に修正する
          val (maybeCompare, maybePostDate, maybeLimit) = self.validateSearchingCondition(compare, postDate, limit)
          val (olderOrNewer, criterionPostDate, wannatagSearchinglimit) = self.convertParamator(maybeCompare, maybePostDate, maybeLimit)

          // TODO 仮でテキトーなオブジェクト作ってる
          val searchWannatagsUseCase = new SearchWannatagsUseCase {
            override implicit val executionContext: ExecutionContext = executionContext
            override implicit val repositoryErrorHandler: Throwable => ServiceError = _ => NotFoundError()
            override val wannatagRepository: WannatagRepository = new WannatagRepository {
              def searchWannatagsThatSatisfyCondition(criterionPostDate: WannatagPostDate, olderOrNewer: OlderOrNewer, limit: WannatagsSearchLimit): Future[Try[Seq[Wannatag]]] = {
                Future.successful(Try(Seq(Wannatag(WannatagId(1), WannatagTitle("title"), WannatagBody("body"), UserId(1), WannatagPostDate(1)))))
              }
              def save(wannatag: Wannatag): Future[Try[Wannatag]] = {
                Future.successful(Try(Wannatag(WannatagId(1), WannatagTitle("title"), WannatagBody("body"), UserId(1), WannatagPostDate(1))))
              }
              def delete(id: WannatagId): Future[Try[Wannatag]] = {
                Future.successful(Try(Wannatag(WannatagId(1), WannatagTitle("title"), WannatagBody("body"), UserId(1), WannatagPostDate(1))))
              }
            }
          }

          onComplete(searchWannatagsUseCase.execute(criterionPostDate, olderOrNewer, wannatagSearchinglimit)) {
            case Success(value) => complete("OK") // TODO Eitherでパターン分けて求められるものを返す
            case Failure(exception) => complete(exception.getMessage) // TODO エラーハンドリングする
          }
        }
      }
    }
  }
}
