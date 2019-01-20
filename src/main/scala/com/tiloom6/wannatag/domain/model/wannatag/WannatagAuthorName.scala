package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.ValueObject

/*
 * wannatag作者名
 *
 * @param value 作者名の値
 */
case class WannatagAuthorName private (value: String) extends AnyVal with ValueObject[String]

/*
 * wannatag作者名コンパニオンオブジェクト
 */
object WannatagAuthorName {

  /*
   * wannatag作者名ファクトリ
   *
   * @param value 作者名の値
   * @return wannatag作者名
   */
  def apply(value: String): WannatagAuthorName = {
    require(value.length > 0,
      "Wannatag Author Name's length must be greater than 0.")
    new WannatagAuthorName(value)
  }
}