package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.ValueObject

/*
 * wannatag作者名
 *
 * @param value 作者名の値
 */
case class WannatagAuthorName private (value: String) extends AnyVal with ValueObject[String]

object WannatagAuthorName {
  def apply(value: String): WannatagAuthorName = {
    require(value.length > 0,
      "Wannatag Body's length must be greater than 0.")
    new WannatagAuthorName(value)
  }
}