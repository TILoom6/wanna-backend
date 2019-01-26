package com.tiloom6.wannatag.adapter.interface

import akka.http.scaladsl.server.Route

import scala.concurrent.ExecutionContext

trait Routes {

  def route(implicit executionContext: ExecutionContext): Route
}
