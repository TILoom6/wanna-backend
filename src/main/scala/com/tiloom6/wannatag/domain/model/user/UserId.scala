package com.tiloom6.wannatag.domain.model.user

import com.tiloom6.wannatag.domain.model.EntityId

/*
 * userの識別子
 *
 * @param value 識別子の値
 */
case class UserId private (value: Long) extends AnyVal with EntityId[Long]

/*
 * [[com.tiloom6.wannatag.domain.model.user.UserId]] のコンパニオンオブジェクト
 */
object UserId {

  /*
   * [[com.tiloom6.wannatag.domain.model.user.UserId]] のファクトリ
   *
   * @param value 名称の値
   * @return [[com.tiloom6.wannatag.domain.model.user.UserId]]
   */
  def apply(value: Long): UserId = {
    require(value > 0, "User id's value must be greater than 0.")
    new UserId(value)
  }
}
