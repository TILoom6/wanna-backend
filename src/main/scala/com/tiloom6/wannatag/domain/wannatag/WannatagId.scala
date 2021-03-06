package com.tiloom6.wannatag.domain.wannatag

import com.tiloom6.wannatag.domain.EntityId

/*
 * wannatagの識別子
 *
 * @param value 識別子の値
 */
case class WannatagId private (value: Long) extends AnyVal with EntityId[Long]

/*
 * [[com.tiloom6.wannatag.domain.wannatag.WannatagId]] のコンパニオンオブジェクト
 */
object WannatagId {

  /*
   * [[com.tiloom6.wannatag.domain.wannatag.WannatagId]] のファクトリ
   *
   * @param value 識別子の値
   * @return [[com.tiloom6.wannatag.domain.wannatag.WannatagId]]
   */
  def apply(value: Long): WannatagId = {
    require(value > 0,
      "Wannatag id's value must be greater than 0.")
    new WannatagId(value)
  }
}