package com.tiloom6.wannatag.domain.model

/*
 * ValueObjectであることを表すinterface
 *
 * @tparam T 値の型
 */
trait ValueObject[T] extends Any {
  def value: T
}
