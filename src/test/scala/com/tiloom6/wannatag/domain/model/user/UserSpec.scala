package com.tiloom6.wannatag.domain.model.user

import org.joda.time.DateTime
import org.scalatest.{MustMatchers, WordSpecLike}

/*
 * [[com.tiloom6.wannatag.domain.model.user.User]] のテスト
 */
final class UserSpec extends WordSpecLike
  with MustMatchers {

  private val id = UserId(1)
  private val name = UserName("user name")
  private val createAt = UserCreateAt(DateTime.now)

  private val user = User(id, name, createAt)

  "Userは" should {
    "引数で渡した値をプロパティとして保持している" in {
      user.id must be(id)
      user.name must be(name)
      user.createAt must be(createAt)
    }

    "unapplyでプロパティを展開する" in {
      user match {
        case User(_id, _name, _createAt) =>
          _id must be(id)
          _name must be(name)
          _createAt must be(createAt)
        case _ => fail()
      }
    }
  }
}
