package com.tiloom6.wannatag.domain.wannatag

import scala.concurrent.Future
import scala.util.Try

/*
 * [[com.tiloom6.wannatag.domain.wannatag.Wannatag]] のリポジトリトレイト
 */
trait WannatagRepository {

  /*
   * 条件を満たすWannatagリストを取得する
   *
   * @param criterionPostDate 取得基準とするWannatag投稿日
   * @param olderOrNewer criterionPostDateより新しいものを取得するか古いものを取得するか
   * @param limit 取得件数
   * @return Wannatagリストを取得するFuture
   */
  def searchWannatagsThatSatisfyCondition(criterionPostDate: WannatagPostDate, olderOrNewer: OlderOrNewer, limit: WannatagsSearchLimit): Future[Try[Seq[Wannatag]]]

  /*
   * Wannatagを保存（Insert or Update）する
   *
   * @param wannatag 保存対象のWannatag
   * @return 保存したWannatag
   */
  def save(wannatag: Wannatag): Future[Try[Wannatag]]

  /*
   * Wannatagを削除する
   *
   * @param id 削除対象の [[com.tiloom6.wannatag.domain.wannatag.WannatagId]]
   * @return 削除したWannatag
   */
  def delete(id: WannatagId): Future[Try[Wannatag]]

  /*
   * IDを元にWannatagを取得する
   *
   *　@param id 取得対象の [[com.tiloom6.wannatag.domain.wannatag.WannatagId]]
   * @return 取得したWannatag
   */
  def findById(id: WannatagId): Future[Try[Wannatag]]
}
