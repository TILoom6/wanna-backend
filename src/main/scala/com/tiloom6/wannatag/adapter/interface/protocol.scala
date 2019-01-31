package com.tiloom6.wannatag.adapter.interface

import spray.json.{DefaultJsonProtocol, JsBoolean, JsNumber, JsObject, JsString, JsValue, RootJsonFormat}

/*
 * `/wannatags` response protocol
 */
object SearchWannatagsResponseProtocol extends DefaultJsonProtocol {

  /*
   * `/wannatags` response protocol
   *
   * @param wannatagId wannatagを一意に表す識別子
   * @param title wannatagのタイトル
   * @param body wannatagの内容
   * @param username 作者名
   * @param postDate 投稿日時
   * @param isOwner 作者か
   */
  case class SearchWannatagsResponse(wannatagId: Long, title: String, body: String, username: String, postDate: Long, isOwner: Boolean)

  /*
   * `/wannatags` response protocol json resolver
   */
  implicit val searchWannatagsResponseFormat: RootJsonFormat[SearchWannatagsResponse] = new RootJsonFormat[SearchWannatagsResponse] {

    /*
     * deserialize resolver
     *
     * @param json
     */
    override def read(json: JsValue): SearchWannatagsResponse = ???

    /*
     * serialize resolver
     *
     * @param response レスポンス用case class
     * @return json
     */
    override def write(response: SearchWannatagsResponse): JsValue = JsObject(
      "wannnatagId" -> JsNumber(response.wannatagId),
      "title" -> JsString(response.title),
      "body" -> JsString(response.body),
      "username" -> JsString(response.username),
      "postDate" -> JsNumber(response.postDate),
      "isOwner" -> JsBoolean(response.isOwner)
    )
  }
}
