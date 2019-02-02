package com.tiloom6.wannatag.adapter.interface

import com.tiloom6.wannatag.domain.wannatag._

trait WannatagConvertor {

  def convertParamator(compare: Option[String], postDate: Option[Long], limit: Option[Long]): (OlderOrNewer, WannatagPostDate, WannatagsSearchLimit)

}
