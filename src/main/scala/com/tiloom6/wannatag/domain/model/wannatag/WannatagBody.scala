package com.tiloom6.wannatag.domain.model.wannatag

/*
 * wannatag本文
 *
 * @param value 本文の値
 */
case class WannatagBody(value: String) {
  require(value.length > 0 && value.length <= 250,
    "Wannatag Body's length must be greater than 0 and less than or equal to 250.")
}
