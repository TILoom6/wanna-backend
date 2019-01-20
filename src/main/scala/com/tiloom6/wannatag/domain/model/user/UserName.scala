package com.tiloom6.wannatag.domain.model.user

import com.tiloom6.wannatag.domain.model.ValueObject

case class UserName private (value: String) extends AnyVal with ValueObject[String]

object UserName {
  def apply(value: String): UserName = {
    require(value.length > 0,
      "User Name's length must be greater than 0.")
    new UserName(value)
  }
}
