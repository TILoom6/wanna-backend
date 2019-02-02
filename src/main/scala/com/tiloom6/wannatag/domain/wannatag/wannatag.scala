package com.tiloom6.wannatag.domain.wannatag

import com.tiloom6.wannatag.domain.Entity

/*
 * Wannatagエンティティトレイト
 */
trait Wannatag extends Entity[WannatagId]{

  /*
   * [[WannatagTitle]]
   */
  val title: WannatagTitle

  /*
   * [[WannatagBody]]
   */
  val body: WannatagBody

  /*
   * [[WannatagAuthorName]]
   */
  val authorId: WannatagAuthorId

  /*
   * [[WannatagPostDate]]
   */
  val postDate: WannatagPostDate
}

/*
 * Wannatagコンパニオンオブジェクト
 */
object Wannatag {

  /*
   * Wannatag apply
   *
   * @param id [[com.tiloom6.wannatag.domain.wannatag.WannatagId]]
   * @param title [[com.tiloom6.wannatag.domain.wannatag.WannatagTitle]]
   * @param body [[com.tiloom6.wannatag.domain.wannatag.WannatagBody]]
   * @param authorId [[com.tiloom6.wannatag.domain.wannatag.WannatagAuthorId]]
   * @param postDate [[com.tiloom6.wannatag.domain.wannatag.WannatagPostDate]]
   *
   * @return Wannatagエンティティ
   */
  def apply(id: WannatagId,
            title: WannatagTitle,
            body: WannatagBody,
            authorId: WannatagAuthorId,
            postDate: WannatagPostDate): Wannatag = WannatagImpl(id, title, body, authorId, postDate)

  /*
   * Wannatag unapply
   *
   * @param wannatag Wannatag
   *
   * @return (WannatagId, WannatagTitle, WannatagBody, WannatagAuthorId, WannatagPostDate) tuple
   */
  def unapply(wannatag: Wannatag): Option[(WannatagId, WannatagTitle, WannatagBody, WannatagAuthorId, WannatagPostDate)] =
    Some((wannatag.id, wannatag.title, wannatag.body, wannatag.authorId, wannatag.postDate))

  /*
   * Wannatagエンティティ
   *
   * @param id [[com.tiloom6.wannatag.domain.wannatag.WannatagId]]
   * @param title [[com.tiloom6.wannatag.domain.wannatag.WannatagTitle]]
   * @param body [[com.tiloom6.wannatag.domain.wannatag.WannatagBody]]
   * @param authorId [[com.tiloom6.wannatag.domain.wannatag.WannatagAuthorId]]
   * @param postDate [[com.tiloom6.wannatag.domain.wannatag.WannatagPostDate]]
   */
  private case class WannatagImpl(id: WannatagId,
                                  title: WannatagTitle,
                                  body: WannatagBody,
                                  authorId: WannatagAuthorId,
                                  postDate: WannatagPostDate) extends Wannatag
}