package com.tiloom6.wannatag.adapter.interface

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import scala.concurrent.ExecutionContext

trait WannatagController {
  self: WannatagValidator with WannatagConvertor =>

  def searchWannatags(implicit executionContext: ExecutionContext): Route = pathPrefix("wannatags") {
    pathEndOrSingleSlash {
      get {
        parameters('compare ?, 'postDate ?, 'limit ?) { (compare, postDate, limit) =>
          val (maybeCompare, maybePostDate, maybeLimit) = self.validateSearchingCondition(compare, postDate, limit)
          val (olderOrNewer, criterionPostDate, wannatagSearchinglimit) = self.convertParamator(maybeCompare, maybePostDate, maybeLimit)
          complete("OK")
        }
      }
    }
  }
}
