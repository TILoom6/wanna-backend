package com.tiloom6.wannatag.adapter.interface

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import com.tiloom6.wannatag.domain.wannatag._
import com.tiloom6.wannatag.usecase.{NotFoundError, ServiceError}
import com.tiloom6.wannatag.usecase.wannatag.SearchWannatagsUseCase
import com.tiloom6.wannatag.adapter.interface.SearchWannatagsResponseProtocol._
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import com.tiloom6.wannatag.domain.user.UserId
import com.tiloom6.wannatag.domain.wannatag.{OlderOrNewer, WannatagsSearchLimit}
import com.tiloom6.wannatag.domain.wannatag.{Wannatag, WannatagRepository}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

trait WannatagController {
  self: WannatagValidator with WannatagConvertor =>

  def searchWannatags(implicit executionContext: ExecutionContext): Route = pathPrefix("wannatags") {
    import com.tiloom6.wannatag.domain.wannatag.Implicits._

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
            case Success(maybe) => maybe match {
              // TODO エラーハンドリングする
              case Left(serviceError) => complete(BadRequest, "serviceError.getMessage")
              case Right(wannatags) => {
                // TODO responseの生成はusecase側で行う
                val response = wannatags.map(wannatag => SearchWannatagsResponse(
                  wannatag.id.value,
                  wannatag.title.value,
                  wannatag.body.value,
                  // TODO usecase側でuserIdと紐づけてusername取得する
                  wannatag.authorId.value.toString,
                  wannatag.postDate.value,
                  // TODO usecase側でuserIdと紐づけてAPI叩いているユーザと比較する
                  true
                ))
                complete(OK, response)
              }
            }
            // TODO エラーハンドリングする
            case Failure(exception) => complete(InternalServerError, exception.getMessage)
          }
        }
      }
    }
  }
}
