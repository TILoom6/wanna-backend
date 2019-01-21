package com.tiloom6.wannatag.domain.model.user

import com.tiloom6.wannatag.domain.model.ValueObject
import org.joda.time.DateTime

/*
 * userの作成日時
 *
 * @param value 作成日時
 */
case class UserCreateAt(value: DateTime) extends AnyVal with ValueObject[DateTime]
