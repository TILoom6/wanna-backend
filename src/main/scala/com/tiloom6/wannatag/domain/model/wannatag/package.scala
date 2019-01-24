package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.{DomainResult, EntityIdGenerator}
import com.tiloom6.wannatag.domain.model.user.{User, UserId}

/*
 * [[com.tiloom6.wannatag.domain.model.wannatag.Wannatag]] の暗黙定義パッケージ
 */
package object implicits {

  /*
   * [[com.tiloom6.wannatag.domain.model.wannatag.Wannatag]] の暗黙変換メソッド
   */
  object Conversion {

    /*
     * [[com.tiloom6.wannatag.domain.model.user.UserId]] を [[com.tiloom6.wannatag.domain.model.wannatag.WannatagAuthorId]] に変換する
     *
     * @param [[com.tiloom6.wannatag.domain.model.user.UserId]]
     * @return [[com.tiloom6.wannatag.domain.model.wannatag.WannatagAuthorId]]
     */
    implicit def UserIdToWannatagAuthorId(userId: UserId) = WannatagAuthorId(userId.value)
  }

  object Extension {
    implicit case class Author(user: User) {
      def createWannatag(title: WannatagTitle, body: WannatagBody, postDate: WannatagPostDate)(implicit idGenerator: EntityIdGenerator[WannatagId]): DomainResult[Wannatag, _] = {
        val wannatag = Wannatag(
          id = idGenerator.generate(),
          title = title,
          body = body,
          authorId = user.id,
          postDate = postDate
        )
      }
    }
  }
}
