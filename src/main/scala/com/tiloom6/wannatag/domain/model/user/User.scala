package com.tiloom6.wannatag.domain.model.user

import com.tiloom6.wannatag.domain.model.Entity

trait User extends Entity[UserId] {

  val name: UserName

  val createAt: UserCreateAt
}

object User {
  def apply(id: UserId, name: UserName, createAt: UserCreateAt): User = new UserImpl(id, name, createAt)

  def unapply(user: User): Option[(UserId, UserName, UserCreateAt)] = Some((user.id, user.name, user.createAt))

  private case class UserImpl(id: UserId, name: UserName, createAt: UserCreateAt) extends User
}


