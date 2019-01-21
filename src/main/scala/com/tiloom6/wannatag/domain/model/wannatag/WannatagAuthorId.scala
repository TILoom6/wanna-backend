package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.ValueObject

/*
 * wannatag作者の識別子
 *
 * @param value 作者の識別子の値
 */
case class WannatagAuthorId private(value: Long) extends AnyVal with ValueObject[Long]

/*
 * [[com.tiloom6.wannatag.domain.model.wannatag.WannatagAuthorId]] のコンパニオンオブジェクト
 */
object WannatagAuthorId {

  /*
   * [[com.tiloom6.wannatag.domain.model.wannatag.WannatagAuthorId]] のファクトリ
   *
   * @param value 作者の識別子の値
   * @return [[com.tiloom6.wannatag.domain.model.wannatag.WannatagAuthorId]]
   */
  def apply(value: Long): WannatagAuthorId = {
    require(value > 0, "User id's value must be greater than 0.")
    new WannatagAuthorId(value)
  }
}