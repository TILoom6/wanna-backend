package com.tiloom6.wannatag

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.Http
import akka.stream.Materializer

import scala.concurrent.ExecutionContext
import scala.io.StdIn

trait Server {
  protected val route: Route

  protected val host: String

  protected val port: Int

  protected implicit val actorSystem: ActorSystem

  protected implicit val materializer: Materializer

  protected implicit val executionContext: ExecutionContext

  def start() => {
    val server = Http().bindAndHandle(route, host, port)

    println(s"Server online at host = $host, port = $port. Press RETURN to stop...")

    // enter押下でサーバ停止
    StdIn.readLine()
    server.flatMap(_.unbind()).onComplete(_ => actorSystem.terminate())
  }
}
