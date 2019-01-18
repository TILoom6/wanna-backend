package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.Entity

/*
 * Wannatagエンティティトレイト
 */
trait Wannatag extends Entity[WannatagId]{

  /*
   * [[WannatagId]]
   */
  override val id: WannatagId

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
  val username: WannatagAuthorName

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
   * @param id [[WannatagId]]
   * @param title [[WannatagTitle]]
   * @param body [[WannatagBody]]
   * @param username [[WannatagAuthorName]]
   * @param postDate [[WannatagPostDate]]
   *
   * @return Wannatagエンティティ
   */
  def apply(id: WannatagId,
            title: WannatagTitle,
            body: WannatagBody,
            username: WannatagAuthorName,
            postDate: WannatagPostDate): Wannatag = WannatagImpl(id, title, body, username, postDate)

  /*
   * Wannatag unapply
   *
   * @param wannatag Wannatag
   *
   * @return (WannatagId, WannatagTitle, WannatagBody, WannatagAuthorName, WannatagPostDate) tuple
   */
  def unapply(wannatag: Wannatag): Option[(WannatagId, WannatagTitle, WannatagBody, WannatagAuthorName, WannatagPostDate)] =
    Some(wannatag.id, wannatag.title, wannatag.body, wannatag.username, wannatag.postDate)

  /*
   * Wannatagエンティティ
   *
   * @param id [[WannatagId]]
   * @param title [[WannatagTitle]]
   * @param body [[WannatagBody]]
   * @param username [[WannatagAuthorName]]
   * @param postDate [[WannatagPostDate]]
   */
  private case class WannatagImpl(id: WannatagId,
                                  title: WannatagTitle,
                                  body: WannatagBody,
                                  username: WannatagAuthorName,
                                  postDate: WannatagPostDate) extends Wannatag
}
