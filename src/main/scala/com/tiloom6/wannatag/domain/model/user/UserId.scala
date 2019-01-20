package com.tiloom6.wannatag.domain.model.user

import com.tiloom6.wannatag.domain.model.EntityId

case class UserId private (value: Long) extends AnyVal with EntityId[Long]

object UserId {

  def apply(value: Long): UserId = {
    require(value > 0, "User id's value must be greater than 0.")
    new UserId(value)
  }
}
