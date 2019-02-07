package com.tiloom6.wannatag.usecase.wannatag

import com.tiloom6.wannatag.domain.wannatag._
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
   * [[com.tiloom6.wannatag.domain.wannatag.WannatagRepository]]
   */
  val wannatagRepository: WannatagRepository

  /*
   * 取得基準とするWannatag投稿日
   */
  val m_criterionPostDate: WannatagPostDate

  /*
   * m_criterionPostDateより新しいものを取得するか古いものを取得するか
   */
  val m_olderOrNewer: OlderOrNewer

  /*
   * 取得件数
   */
  val m_limit: WannatagsSearchLimit

  /*
   * 実行
   *
   * @return 検索結果Wannatagリスト
   */
  def execute(): Future[Either[ServiceError, Seq[Wannatag]]] = {
    for {
      tryWannatags <- wannatagRepository.searchWannatagsThatSatisfyCondition(m_criterionPostDate, m_olderOrNewer, m_limit)
      wannatags = tryWannatags ifFailureThen asServiceError
    } yield wannatags
  }
}