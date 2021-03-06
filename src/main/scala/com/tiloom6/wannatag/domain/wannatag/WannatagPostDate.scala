package com.tiloom6.wannatag.domain.wannatag

import com.tiloom6.wannatag.domain.ValueObject

/*
 * wannatag登録日時
 *
 * @param value 登録日時の値
 */
case class WannatagPostDate(value: Long) extends AnyVal with ValueObject[Long]
