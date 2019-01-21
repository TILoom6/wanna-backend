package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.user.UserId

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
}
