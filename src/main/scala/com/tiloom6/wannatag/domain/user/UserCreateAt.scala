package com.tiloom6.wannatag.domain.user

import com.tiloom6.wannatag.domain.ValueObject
import org.joda.time.DateTime

/*
 * userの作成日時
 *
 * @param value 作成日時
 */
case class UserCreateAt(value: DateTime) extends AnyVal with ValueObject[DateTime]
