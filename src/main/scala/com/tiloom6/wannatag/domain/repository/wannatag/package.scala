package com.tiloom6.wannatag.domain.repository

import com.tiloom6.wannatag.domain.model.ValueObject

package object wannatag {

  import scala.language.implicitConversions

  sealed trait OlderOrNewer

  object OlderOrNewer {
    object Older extends AnyVal with OlderOrNewer

    object Newer extends AnyVal with OlderOrNewer
  }

  case class WannatagsSearchLimit(value: Option[Long]) extends AnyVal with ValueObject[Option[Long]]
}
