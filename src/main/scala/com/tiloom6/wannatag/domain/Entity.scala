package com.tiloom6.wannatag.domain

/*
 * entityであることを表す汎用トレイト
 *
 * @tparam ID Entityの識別子型
 */
trait Entity[ID <: EntityId[_]] {

  /*
   * entityの識別子
   */
  val id: ID

  /*
   * 等価性比較
   *
   * @param obj 比較対象オブジェクト
   * @return 同じentityの場合true
   */
  override def equals(obj: Any): Boolean = obj match {
    case that: Entity[_] => getClass == that.getClass && id == that.id
    case _ => false
  }

  /*
   * ハッシュコード
   *
   * @return ハッシュコード
   */
  override def hashCode: Int = 31 * id.##
}

/*
 * entityの識別子
 *
 * @tparam T 値の型
 */
trait EntityId[T] extends Any with ValueObject[T] {

  /*
   * 等価性比較
   *
   * @param obj 比較対象オブジェクト
   * @return 同じIDの場合true
   */
  override def equals(obj: Any): Boolean = obj match {
    case that: EntityId[_] => getClass == that.getClass && value == that.value
    case _ => false
  }

  /*
   * ハッシュコード
   *
   * @return ハッシュコード
   */
  override def hashCode(): Int = 31 * value.##
}

/*
 * entity識別子生成汎用トレイト
 *
 * @tparam ID Entityの識別子型
 */
trait EntityIdGenerator[ID <: EntityId[_]] {

  /*
   * entity識別子生成
   *
   * @return entity識別子
   */
  def generate(): ID
}
