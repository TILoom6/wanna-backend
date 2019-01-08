package com.tiloom6.wannatag.domain.common

/*
 * バリューオブジェクトあることを表すためのトレイト
 */
trait ValueObject {

  /*
   * ハッシュコード
   *
   * ＠return ハッシュコード
   */
  override def hashCode: Int

  /*
   * 等価であるか判定する
   *
   * @param obj オブジェクト
   * @return 等価である場合はtrue
   */
  override def equals(obj: Any): Boolean
}
