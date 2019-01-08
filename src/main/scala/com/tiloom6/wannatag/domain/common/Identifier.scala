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

/*
 * 値のない識別子
 */
trait EmptyIdentifier extends Identifier[Nothing] {

  def value: Nothing = throw new NoSuchElementException

  override val isDefined: Boolean = false

  override def equals(obj: Any) = obj match {
    case that: EmptyIdentifier => this eq that
    case _ => false
  }

  override def hashCode: Int = 0
}

/*
 * 値のない識別子のコンパニオンオブジェクト
 */
object EmptyIdentifier extends EmptyIdentifier