package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.model.DomainEvent

/*
 * [[com.tiloom6.wannatag.domain.model.wannatag.Wannatag]] のイベントを表すトレイト
 */
sealed trait WannatagEvent extends DomainEvent {

  /*
   * [[com.tiloom6.wannatag.domain.model.wannatag.WannatagId]]
   */
  val id: WannatagId
}

/*
 * wannatag作成イベント
 *
 * @param id [[com.tiloom6.wannatag.domain.model.wannatag.WannatagId]]
 */
case class WannatagCreated(id: WannatagId) extends WannatagEvent