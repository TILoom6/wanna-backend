package com.tiloom6.wannatag.adapter.interface

trait WannatagValidator {

  def validateSearchingCondition(compare: Option[String], postDate: Option[String], limit: Option[String]): (Option[String], Option[Long], Option[Long])
}
