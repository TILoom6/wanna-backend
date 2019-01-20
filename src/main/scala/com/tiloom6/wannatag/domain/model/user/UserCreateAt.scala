package com.tiloom6.wannatag.domain.model.user

import com.tiloom6.wannatag.domain.model.ValueObject
import org.joda.time.DateTime

case class UserCreateAt(value: DateTime) extends AnyVal with ValueObject[DateTime]
