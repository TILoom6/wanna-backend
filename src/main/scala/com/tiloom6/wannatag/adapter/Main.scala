package com.tiloom6.wannatag.adapter

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import slick.basic.DatabaseConfig

object Main extends App {

  private val serverConfig = ConfigFactory.load("wannatag")
  private val mysqlConfig = ConfigFactory.load("wannamysql")
  private val dbConfig = DatabaseConfig.forConfig("mysql.db", config = mysqlConfig)

  /** WannaTagのREST-APIを統括するActorSystem */
  private implicit val wannatagActorSystem = ActorSystem("wannatag", serverConfig)
  private implicit val materializer = ActorMaterializer()
  private implicit val executionContext = wannatagActorSystem.dispatcher


  sys.addShutdownHook()
}
