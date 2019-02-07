package com.tiloom6.wannatag.usecase.wannatag

import com.tiloom6.wannatag.domain.user.UserRepository
import com.tiloom6.wannatag.domain.wannatag._
import com.tiloom6.wannatag.domain.wannatag.Implicits._
import com.tiloom6.wannatag.usecase.ErrorHandleHelper._
import com.tiloom6.wannatag.usecase.ServiceError
import com.tiloom6.wannatag.usecase.Implicits._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Either

/*
 * Wannatag作成トレイト
 */
trait CreateWannatagUseCase {

  /*
   * 検索処理実行用 execution context
   */
  implicit val executionContext: ExecutionContext

  /*
   * リポジトリのエラーハンドラ
   */
  implicit val repositoryErrorHandler: Throwable => ServiceError

  /*
   * [[com.tiloom6.wannatag.domain.wannatag.WannatagRepository]]
   */
  val wannatagRepository: WannatagRepository

  /*
   * [[com.tiloom6.wannatag.domain.user.UserRepository]]
   */
  val userRepository: UserRepository

  /*
   * [[com.tiloom6.wannatag.domain.wannatag.WannatagAuthorId]]
   */
  val m_authorId: WannatagAuthorId

  /*
   * [[com.tiloom6.wannatag.domain.wannatag.WannatagTitle]]
   */
  val m_title: WannatagTitle

  /*
   * [[com.tiloom6.wannatag.domain.wannatag.WannatagBody]]
   */
  val m_body: WannatagBody

  /*
   * [[com.tiloom6.wannatag.domain.wannatag.WannatagPostDate]]
   */
  val m_postDate: WannatagPostDate

  /*
   * 実行
   *
   * @return 作成したWannatag
   */
  def execute(): Future[Either[ServiceError, Wannatag]] = ???
//    for {
//      tryAuthor <- userRepository.findById(m_authorId)
//      author = tryAuthor からTry外す
//      createdWannatag = author.createWannatag(m_title, m_body, m_postDate)
//      savedWannatag <- wannatagRepository.save(createdWannatag)
//    } yield savedWannatag
}
