package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.EntityId

/*
 * wannatagの識別子
 *
 * @param value 識別子の値
 */
case class WannatagId private (value: Long) extends AnyVal with EntityId[Long]

/*
 * wannatagの識別子コンパニオンオブジェクト
 */
object WannatagId {

  /*
   * wannatagの識別子ファクトリ
   *
   * @param value 識別子の値
   * @return wannatagの識別子
   */
  def apply(value: Long): WannatagId = {
    require(value > 0,
      "Wannatag id's value must be greater than 0.")
    new WannatagId(value)
  }
}