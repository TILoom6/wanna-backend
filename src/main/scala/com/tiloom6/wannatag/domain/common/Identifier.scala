package com.tiloom6.wannatag.domain.common

/*
 * 識別子を表すトレイト
 *
 * @tparam A 識別子の値型
 */
trait Identifier [+A] extends ValueObject {

  /** 識別子の値 */
  def value: A

  /** 定義済みであるか */
  val isDefined: Boolean = true

  /** 識別子が存在しないか */
  val isEmpty: Boolean = !isDefined

  /*
   * @inheritdoc
   */
  override def equals(obj: Any): Boolean = obj match {
    case that: Identifier[_] =>
        value == that.value
    case _ => false
  }

  /*
   * @inheritdoc
   */
  override def hashCode: Int = 31 * value.##
}

/*
 * 値のない識別子
 */
trait EmptyIdentifier extends Identifier[Nothing] {

  /*
   * @inheritdoc
   */
  def value: Nothing = throw new NoSuchElementException

  /*
   * @inheritdoc
   */
  override val isDefined: Boolean = false

  /*
   * @inheritdoc
   */
  override def equals(obj: Any) = obj match {
    case that: EmptyIdentifier => this eq that
    case _ => false
  }

  /*
   * @inheritdoc
   */
  override def hashCode: Int = 0
}

/*
 * 値のない識別子のコンパニオンオブジェクト
 */
object EmptyIdentifier extends EmptyIdentifier