package com.tiloom6.wannatag.domain.repository.wannatag

import com.tiloom6.wannatag.domain.model.wannatag.{Wannatag, WannatagId}
import org.joda.time.DateTime

import scala.concurrent.Future
import scala.util.Try

/*
 * [[com.tiloom6.wannatag.domain.model.wannatag.Wannatag]] のリポジトリトレイト
 */
trait WannatagRepository {

  /*
   * 条件を満たすWannatagリストを取得する
   *
   * @param criterionPostDate 取得基準とするWannatag投稿日 TODO ValueObject定義する
   * @param compare criterionPostDateより新しいものを取得するか古いものを取得するか TODO ValueObject定義する
   * @param limit 取得件数 TODO ValueObject定義する
   * @return Wannatagリストを取得するFuture
   */
  def searchWannatagsThatSatisfyCondition(criterionPostDate: DateTime, isOlder: Boolean, limit: Long): Future[Try[Seq[Wannatag]]]

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
   * @param id 削除対象の [[com.tiloom6.wannatag.domain.model.wannatag.WannatagId]]
   * @return 削除したWannatag
   */
  def delete(id: WannatagId): Future[Try[Wannatag]]
}
