package com.tiloom6.wannatag.domain.model

trait Entity[ID <: EntityId[_]] {
  val id: ID

  override def equals(obj: Any): Boolean = obj match {
    case that: Entity[_] => getClass == that.getClass && id == that.id
    case _ => false
  }

  override def hashCode: Int = 31 * id.##
}

trait EntityId[T] extends Any with ValueObject[T] {
  override def equals(obj: Any): Boolean = obj match {
    case that: EntityId[_] => value == that.value
    case _ => false
  }
}

trait EntityIdGenerator[T] {
  def generate(): T
}
