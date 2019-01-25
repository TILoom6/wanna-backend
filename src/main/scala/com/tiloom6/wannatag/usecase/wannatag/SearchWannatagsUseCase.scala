package com.tiloom6.wannatag.usecase.wannatag

import com.tiloom6.wannatag.domain.model.wannatag.Wannatag
import com.tiloom6.wannatag.domain.repository.wannatag.WannatagRepository
import org.joda.time.DateTime

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
   * [[com.tiloom6.wannatag.domain.repository.wannatag.WannatagRepository]]
   */
  val wannatagRepository: WannatagRepository

  /*
   * 実行
   *
   * @param criterionPostDate 取得基準とするWannatag投稿日 TODO ValueObject定義する
   * @param compare criterionPostDateより新しいものを取得するか古いものを取得するか TODO ValueObject定義する
   * @param limit 取得件数 TODO ValueObject定義する
   * @return 検索結果Wannatagリスト
   */
  def Execute(criterionPostDate: DateTime, isOlder: Boolean = true, limit: Long = -1L): Future[Either[_, Seq[Wannatag]]] = {
    for {
      tryWannatags <- wannatagRepository.searchWannatagsThatSatisfyCondition(criterionPostDate, isOlder, limit)
    } yield for {
      wannatags <- tryWannatags.toEither.right
    } yield wannatags
  }
}