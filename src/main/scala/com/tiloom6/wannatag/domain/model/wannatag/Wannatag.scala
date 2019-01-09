package com.tiloom6.wannatag.domain.model.wannatag

/*
 * Wannatagエンティティトレイト
 */
trait Wannatag {

  /*
   * [[WannatagId]]
   */
  def id: WannatagId

  /*
   * [[WannatagTitle]]
   */
  def title: WannatagTitle

  /*
   * [[WannatagBody]]
   */
  def body: WannatagBody

  /*
   * [[WannatagAuthorName]]
   */
  def username: WannatagAuthorName

  /*
   * [[WannatagPostDate]]
   */
  def postDate: WannatagPostDate
}

/*
 * Wannatagコンパニオンオブジェクト
 */
object Wannatag {

  /*
   * Wannatagファクトリメソッド
   *
   * @param id [[WannatagId]]
   * @param title [[WannatagTitle]]
   * @param body [[WannatagBody]]
   * @param username [[WannatagAuthorName]]
   * @param postDate [[WannatagPostDate]]
   */
  def apply(id: WannatagId,
            title: WannatagTitle,
            body: WannatagBody,
            username: WannatagAuthorName,
            postDate: WannatagPostDate): Wannatag = WannatagImpl(id, title, body, username, postDate)
}

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
