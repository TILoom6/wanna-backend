package com.tiloom6.wannatag

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.Http
import akka.stream.Materializer

import scala.concurrent.{ExecutionContext, Future}

/*
 * サーバトレイト
 */
trait Server {

  /*
   * APIルート
   */
  protected val route: Route

  /*
   * ホスト
   */
  protected val host: String

  /*
   * ポート番号
   */
  protected val port: Int

  /*
   * ActorSystem
   */
  protected implicit val actorSystem: ActorSystem

  /*
   * Materializer
   */
  protected implicit val materializer: Materializer

  /*
   * ExecutionContext
   */
  protected implicit val executionContext: ExecutionContext

  /*
   * サーバ起動
   *
   * @return 起動したサーバ
   */
  def start(): Future[Http.ServerBinding] = {
    // サーバ起動
    val server = Http().bindAndHandle(route, host, port)
    println(s"Server online at host = $host, port = $port. Press RETURN to stop...")

    server.flatMap(_.unbind()).onComplete(_ => actorSystem.terminate())
    server
  }
}
