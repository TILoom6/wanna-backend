package com.tiloom6.wannatag.domain

import com.tiloom6.wannatag.domain
import com.tiloom6.wannatag.domain.user.{User, UserId}

package object wannatag {

  /*
   * [[com.tiloom6.wannatag.domain.wannatag.Wannatag]] の暗黙変換
   */
  object Implicits {
    import scala.language.implicitConversions

    /*
     * [[com.tiloom6.wannatag.domain.user.UserId]] を [[com.tiloom6.wannatag.domain.wannatag.WannatagAuthorId]] に変換する
     *
     * @param [[com.tiloom6.wannatag.domain.user.UserId]]
     * @return [[com.tiloom6.wannatag.domain.wannatag.WannatagAuthorId]]
     */
    implicit def UserIdToWannatagAuthorId(userId: UserId) = WannatagAuthorId(userId.value)

    /*
     * 作者
     * [[com.tiloom6.wannatag.domain.user.User]] の拡張クラス
     *
     * @param user [[com.tiloom6.wannatag.domain.user.User]]
     */
    implicit class Author(user: User) {

      /*
       * wannatagを作成する
       *
       * @param title [[com.tiloom6.wannatag.domain.wannatag.WannatagTitle]]
       * @param body [[com.tiloom6.wannatag.domain.wannatag.WannatagBody]]
       * @param postDate [[com.tiloom6.wannatag.domain.wannatag.WannatagPostDate]]
       * @return [[com.tiloom6.wannatag.domain.DomainResult]] ([[com.tiloom6.wannatag.domain.wannatag.Wannatag]], [[com.tiloom6.wannatag.domain.wannatag.WannatagCreated]])
       */
      def createWannatag(title: WannatagTitle, body: WannatagBody, postDate: WannatagPostDate)(implicit idGenerator: EntityIdGenerator[WannatagId]): DomainResult[Wannatag, WannatagCreated] = {
        val wannatag = Wannatag(
          id = idGenerator.generate(),
          title = title,
          body = body,
          authorId = user.id,
          postDate = postDate
        )

        val wannatagCreatedEvent = domain.wannatag.WannatagCreated(
          id = wannatag.id
        )

        domain.DomainResult(wannatag, wannatagCreatedEvent)
      }
    }
  }

  /*
   * 古いか新しいか
   */
  sealed trait OlderOrNewer

  /*
   * 古いか新しいかのコンパニオンオブジェクト
   */
  object OlderOrNewer {

    /*
     * 古い
     */
    object Older extends OlderOrNewer

    /*
     * 新しい
     */
    object Newer extends OlderOrNewer
  }

  /*
   * Wannatag検索上限数
   *
   * @param value Wannatag検索上限数のMaybe抽象値
   */
  case class WannatagsSearchLimit(value: Option[Long]) extends AnyVal with ValueObject[Option[Long]]
}
