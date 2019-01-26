package com.tiloom6.wannatag.adapter.interface

import com.tiloom6.wannatag.domain.model.wannatag.WannatagPostDate
import com.tiloom6.wannatag.domain.repository.wannatag.{OlderOrNewer, WannatagsSearchLimit}

trait WannatagConvertor {

  def convertParamator(compare: Option[String], postDate: Option[Long], limit: Option[Long]): (OlderOrNewer, WannatagPostDate, WannatagsSearchLimit)

}
