package com.tiloom6.wannatag.domain.model.wannatag

/*
 * wannatag作者名
 *
 * @param value 作者名の値
 */
case class WannatagAuthorName(value: String) {
  require(value.length > 0,
    "Wannatag Body's length must be greater than 0.")
}
