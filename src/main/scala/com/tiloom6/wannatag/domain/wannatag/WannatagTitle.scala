package com.tiloom6.wannatag.domain.wannatag

import com.tiloom6.wannatag.domain.ValueObject

/*
 * wannatagのタイトル
 *
 * @param value タイトルの値
 */
case class WannatagTitle private (value: String) extends AnyVal with ValueObject[String]

/*
 * [[com.tiloom6.wannatag.domain.wannatag.WannatagTitle]] のコンパニオンオブジェクト
 */
object WannatagTitle {

  /*
   * [[com.tiloom6.wannatag.domain.wannatag.WannatagTitle]] のファクトリ
   *
   * @param value タイトルの値
   * @return [[com.tiloom6.wannatag.domain.wannatag.WannatagTitle]]
   */
  def apply(value: String): WannatagTitle = {
    require(value.length > 0 && value.length <= 50,
      "Wannatag Title's length must be greater than 0 and less than or equal to 50.")
    new WannatagTitle(value)
  }
}