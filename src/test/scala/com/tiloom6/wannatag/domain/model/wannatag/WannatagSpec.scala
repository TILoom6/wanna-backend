package com.tiloom6.wannatag.domain.model.wannatag

import org.scalatest._

/*
 * [[com.tiloom6.wannatag.domain.model.wannatag.Wannatag]] のテスト
 */
final class WannatagSpec extends WordSpecLike
  with MustMatchers {

  private val id = WannatagId(1)
  private val title = WannatagTitle("title")
  private val body = WannatagBody("body")
  private val authorId = WannatagAuthorId(1)
  private val postDate = WannatagPostDate(1)

  private val wannatag = Wannatag(id, title, body, authorId, postDate)

  "Wannatagは" should {
    "引数で渡した値をプロパティとして保持している" in {
      wannatag.id must be(id)
      wannatag.title must be(title)
      wannatag.body must be(body)
      wannatag.authorId must be(authorId)
      wannatag.postDate must be(postDate)
    }

    "unapplyでプロパティを展開する" in {
      wannatag match {
        case Wannatag(_id: WannatagId, _title: WannatagTitle, _body: WannatagBody, _authorId: WannatagAuthorId, _postDate: WannatagPostDate) =>
          id must be(_id)
          title must be(_title)
          body must be(_body)
          authorId must be(_authorId)
          postDate must be(_postDate)
        case _ => fail()
      }
    }
  }
}