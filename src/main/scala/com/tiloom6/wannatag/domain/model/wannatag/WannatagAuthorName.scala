package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.common.ValueObject

case class WannatagAuthorName(value: String) extends ValueObject {
  require(value.length > 0,
    "Wannatag Body's length must be greater than 0.")
}
