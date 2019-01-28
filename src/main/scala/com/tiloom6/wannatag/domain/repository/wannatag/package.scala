package com.tiloom6.wannatag.domain.repository

import com.tiloom6.wannatag.domain.model.ValueObject

/*
 * Wannatag Repositoryのはb尿定義パッケージ
 */
package object wannatag {

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
