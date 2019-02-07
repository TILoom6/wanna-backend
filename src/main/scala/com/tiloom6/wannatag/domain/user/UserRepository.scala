package com.tiloom6.wannatag.domain.user

import scala.concurrent.Future
import scala.util.Try

/*
 * [[com.tiloom6.wannatag.domain.user.User]] のリポジトリトレイト
 */
trait UserRepository {

  /*
   * IDを元にWannatagを取得する
   *
   *　@param id 取得対象の [[com.tiloom6.wannatag.domain.user.UserId]]
   * @return 取得したUser
   */
  def findById(id: UserId): Future[Try[User]]
}
