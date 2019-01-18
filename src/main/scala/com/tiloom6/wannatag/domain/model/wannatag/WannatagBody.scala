package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.ValueObject

/*
 * wannatag本文
 *
 * @param value 本文の値
 */
case class WannatagBody private (value: String) extends AnyVal with ValueObject[String]

object WannatagBody {
  def apply(value: String): WannatagBody = {
    require(value.length > 0 && value.length <= 250,
      "Wannatag Body's length must be greater than 0 and less than or equal to 250.")
    new WannatagBody(value)
  }
}