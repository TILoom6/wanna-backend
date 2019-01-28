package com.tiloom6.wannatag.usecase.wannatag

import com.tiloom6.wannatag.domain.model.wannatag.{Wannatag, WannatagPostDate}
import com.tiloom6.wannatag.domain.repository.wannatag.{WannatagsSearchLimit, OlderOrNewer, WannatagRepository}
import com.tiloom6.wannatag.usecase.Implicits._
import com.tiloom6.wannatag.usecase.ErrorHandleHelper._
import com.tiloom6.wannatag.usecase.ServiceError

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Either

/*
 * Wannatag検索トレイト
 */
trait SearchWannatagsUseCase {

  /*
   * 検索処理実行用 execution context
   */
  implicit val executionContext: ExecutionContext

  /*
   * リポジトリのエラーハンドラ
   */
  implicit val repositoryErrorHandler: Throwable => ServiceError

  /*
   * [[com.tiloom6.wannatag.domain.repository.wannatag.WannatagRepository]]
   */
  val wannatagRepository: WannatagRepository

  /*
   * 実行
   *
   * @param criterionPostDate 取得基準とするWannatag投稿日
   * @param olderOrNewer criterionPostDateより新しいものを取得するか古いものを取得するか
   * @param limit 取得件数
   * @return 検索結果Wannatagリスト
   */
  def execute(criterionPostDate: WannatagPostDate, olderOrNewer: OlderOrNewer, limit: WannatagsSearchLimit): Future[Either[ServiceError, Seq[Wannatag]]] = {
    for {
      tryWannatags <- wannatagRepository.searchWannatagsThatSatisfyCondition(criterionPostDate, olderOrNewer, limit)
    } yield for {
        wannatags <- tryWannatags ifFailureThen asServiceError
    } yield wannatags
  }
}