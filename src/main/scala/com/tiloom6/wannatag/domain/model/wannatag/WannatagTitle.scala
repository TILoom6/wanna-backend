package com.tiloom6.wannatag.domain.model.wannatag

/*
 * wannatagのタイトル
 *
 * @param value タイトルの値
 */
case class WannatagTitle(value: String) {
  require(value.length > 0 && value.length <= 50,
    "Wannatag Title's length must be greater than 0 and less than or equal to 50.")
}
