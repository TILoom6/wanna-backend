package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.common.ValueObject

/*
 * wannatagのタイトル
 *
 * @param value タイトルの値（文字数制限 50 >= value > 0）
 */
case class WannatagTitle(value: String) extends ValueObject {
  require(value.length > 0 && value.length <= 50,
    "Wannatag Title's length must be greater than 0 and less than or equal to 50.")
}
