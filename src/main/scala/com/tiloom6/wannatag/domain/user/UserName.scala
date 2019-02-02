package com.tiloom6.wannatag.domain.user

import com.tiloom6.wannatag.domain.ValueObject

/*
 * userの名称
 *
 * @param value 名称の値
 */
case class UserName private (value: String) extends AnyVal with ValueObject[String]

/*
 * [[com.tiloom6.wannatag.domain.model.user.UsrName]] のコンパニオンオブジェクト
 */
object UserName {

  /*
   * [[com.tiloom6.wannatag.domain.model.user.UsrName]] のファクトリ
   *
   * @param value 名称の値
   * @return [[com.tiloom6.wannatag.domain.model.user.UsrName]]
   */
  def apply(value: String): UserName = {
    require(value.length > 0,
      "User Name's length must be greater than 0.")
    new UserName(value)
  }
}
