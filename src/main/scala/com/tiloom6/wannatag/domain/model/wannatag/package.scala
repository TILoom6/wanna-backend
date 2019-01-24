package com.tiloom6.wannatag.domain.model

import com.tiloom6.wannatag.domain.model.user.{User, UserId}

/*
 * [[com.tiloom6.wannatag.domain.model.wannatag.Wannatag]] の暗黙定義パッケージ
 */
package object wannatag {

  /*
   * [[com.tiloom6.wannatag.domain.model.wannatag.Wannatag]] の暗黙変換メソッド
   */
  object Implicits {

    /*
     * [[com.tiloom6.wannatag.domain.model.user.UserId]] を [[com.tiloom6.wannatag.domain.model.wannatag.WannatagAuthorId]] に変換する
     *
     * @param [[com.tiloom6.wannatag.domain.model.user.UserId]]
     * @return [[com.tiloom6.wannatag.domain.model.wannatag.WannatagAuthorId]]
     */
    implicit def UserIdToWannatagAuthorId(userId: UserId) = WannatagAuthorId(userId.value)

    /*
     * 作者
     * [[com.tiloom6.wannatag.domain.model.user.User]] の拡張クラス
     *
     * @param user [[com.tiloom6.wannatag.domain.model.user.User]]
     */
    implicit class Author(user: User) {

      /*
       * wannatagを作成する
       *
       * @param title [[com.tiloom6.wannatag.domain.model.wannatag.WannatagTitle]]
       * @param body [[com.tiloom6.wannatag.domain.model.wannatag.WannatagBody]]
       * @param postDate [[com.tiloom6.wannatag.domain.model.wannatag.WannatagPostDate]]
       * @return [[com.tiloom6.wannatag.domain.model.DomainResult]] ([[com.tiloom6.wannatag.domain.model.wannatag.Wannatag]], [[com.tiloom6.wannatag.domain.model.wannatag.WannatagCreated]])
       */
      def createWannatag(title: WannatagTitle, body: WannatagBody, postDate: WannatagPostDate)(implicit idGenerator: EntityIdGenerator[WannatagId]): DomainResult[Wannatag, WannatagCreated] = {
        val wannatag = Wannatag(
          id = idGenerator.generate(),
          title = title,
          body = body,
          authorId = user.id,
          postDate = postDate
        )

        val result = WannatagCreated(
          id = wannatag.id
        )

        DomainResult(wannatag, result)
      }
    }
  }
}
