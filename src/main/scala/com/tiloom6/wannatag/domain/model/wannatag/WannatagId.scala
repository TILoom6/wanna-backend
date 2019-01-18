package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.EntityId

/*
 * wannatagの識別子
 *
 * @param value 識別子の値
 */
case class WannatagId private (value: Long) extends AnyVal with EntityId[Long]

object WannatagId {
  def apply(value: Long): WannatagId = {
    require(value > 0,
      "Wannatag id's value must be greater than 0.")
    new WannatagId(value)
  }
}