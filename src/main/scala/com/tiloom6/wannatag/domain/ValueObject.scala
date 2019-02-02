package com.tiloom6.wannatag.domain

/*
 * ValueObjectであることを表す汎用トレイと
 *
 * @tparam T 値の型
 */
trait ValueObject[T] extends Any {

  /*
   * @return 値
   */
  def value: T
}
