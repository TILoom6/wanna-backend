package com.tiloom6.wannatag.domain.model.wannatag

import org.scalatest._

final class WannatagSpec extends WordSpecLike
  with MustMatchers {

  private val id = WannatagId(1)
  private val title = WannatagTitle("title")
  private val body = WannatagBody("body")
  private val username = WannatagAuthorName("author name")
  private val postDate = WannatagPostDate(1)

  "wannatag" should {
    "have properties" in {
      val wannatag = Wannatag(id, title, body, username, postDate)

      wannatag.id must be(id)
      wannatag.title must be(title)
      wannatag.body must be(body)
      wannatag.username must be(username)
      wannatag.postDate must be(postDate)
    }
  }
}
