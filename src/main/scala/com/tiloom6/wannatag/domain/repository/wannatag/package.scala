package com.tiloom6.wannatag.domain.repository

import com.tiloom6.wannatag.domain.model.ValueObject

package object wannatag {

  sealed trait OlderOrNewer

  object OlderOrNewer {
    object Older extends OlderOrNewer

    object Newer extends OlderOrNewer
  }

  case class WannatagsSearchLimit(value: Option[Long]) extends AnyVal with ValueObject[Option[Long]]
}
