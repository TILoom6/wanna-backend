package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.common.ValueObject

case class WannatagBody(value: String) extends ValueObject {
  require(value.length > 0 && value.length <= 250,
    "Wannatag Body's length must be greater than 0 and less than or equal to 250.")
}
