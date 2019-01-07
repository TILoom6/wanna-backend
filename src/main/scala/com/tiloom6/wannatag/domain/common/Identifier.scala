package com.tiloom6.wannatag.domain.common

/*
 * 識別子を表すトレイト
 *
 * @tparam A 識別子の値型
 */
trait Identifier [+A] {

  def value: A

  val isDefined: Boolean = true

  val isEmpty: Boolean = !isDefined

  override def equals(obj: Any): Boolean = obj match {
    case that: Identifier[_] =>
        value == that.value
    case _ => false
  }

  override def hashCode: Int = 31 * value.##
}
