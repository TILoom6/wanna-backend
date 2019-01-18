package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.ValueObject

/*
 * wannatagのタイトル
 *
 * @param value タイトルの値
 */
case class WannatagTitle private (value: String) extends AnyVal with ValueObject[String]

/*
 * wannatagのタイトルコンパニオンオブジェクト
 */
object WannatagTitle {

  /*
   * wannatagのタイトルファクトリ
   *
   * @param value タイトルの値
   * @return wannatagのタイトル
   */
  def apply(value: String): WannatagTitle = {
    require(value.length > 0 && value.length <= 50,
      "Wannatag Title's length must be greater than 0 and less than or equal to 50.")
    new WannatagTitle(value)
  }
}