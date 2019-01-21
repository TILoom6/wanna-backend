package com.tiloom6.wannatag.domain.model.user

import com.tiloom6.wannatag.domain.model.Entity

/*
 * userエンティティトレイト
 */
trait User extends Entity[UserId] {

  /*
   * ユーザーネーム
   */
  val name: UserName

  /*
   * ユーザー作成日時
   */
  val createAt: UserCreateAt
}


/*
 * [[com.tiloom6.wannatag.domain.model.user.User]] のコンパニオンオブジェクト
 */
object User {

  /*
   * [[com.tiloom6.wannatag.domain.model.user.User]] apply
   *
   * @param id ユーザーID
   * @param name ユーザーネーム
   * @param createAt ユーザー作成日時
   * @return [[com.tiloom6.wannatag.domain.model.user.UserImpl]]
   */
  def apply(id: UserId, name: UserName, createAt: UserCreateAt): User = new UserImpl(id, name, createAt)

  /*
   * [[com.tiloom6.wannatag.domain.model.user.User]] unapply
   *
   * @param user ユーザー
   * @return (UserId, UserName, UserCreateAt)
   */
  def unapply(user: User): Option[(UserId, UserName, UserCreateAt)] = Some((user.id, user.name, user.createAt))


  /*
   * [[com.tiloom6.wannatag.domain.model.user.User]] エンティティ
   *
   * @param id ユーザーID
   * @param name ユーザーネーム
   * @param createAt ユーザー作成日時
   */
  private case class UserImpl(id: UserId, name: UserName, createAt: UserCreateAt) extends User
}


