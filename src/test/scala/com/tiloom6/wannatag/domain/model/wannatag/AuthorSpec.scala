package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.{DomainResult, EntityIdGenerator}
import com.tiloom6.wannatag.domain.model.user.{User, UserCreateAt, UserId, UserName}
import org.joda.time.DateTime
import org.scalatest.{MustMatchers, WordSpecLike}

final class AuthorSpec extends WordSpecLike
  with MustMatchers {

  import com.tiloom6.wannatag.domain.model.wannatag.Implicits._

  private val userId = UserId(1)
  private val userName = UserName("user name")
  private val userCreateAt = UserCreateAt(DateTime.now)

  private val expectWannatag = Wannatag(WannatagId(1), WannatagTitle("title"), WannatagBody("body"), userId, WannatagPostDate(1))

  implicit val wannatagIdGenerator = new EntityIdGenerator[WannatagId] {
    override def generate(): WannatagId = expectWannatag.id
  }

  "Authorは" should {
    "Wannatagを生成し、生成した情報を返す" in {
      val user = User(userId, userName, userCreateAt)
      val result = user.createWannatag(expectWannatag.title, expectWannatag.body, expectWannatag.postDate)

      result match {
        case DomainResult(actualWannatag, wannatagCreated) =>
          actualWannatag must be(expectWannatag)
          wannatagCreated.id must be(actualWannatag.id)
        case _ => fail()
      }
    }
  }
}
