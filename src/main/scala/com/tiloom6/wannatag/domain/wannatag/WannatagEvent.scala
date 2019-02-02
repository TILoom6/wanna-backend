package com.tiloom6.wannatag.domain.wannatag

import com.tiloom6.wannatag.domain.DomainEvent

/*
 * [[com.tiloom6.wannatag.domain.wannatag.Wannatag]] のイベントを表すトレイト
 */
sealed trait WannatagEvent extends DomainEvent {

  /*
   * [[com.tiloom6.wannatag.domain.wannatag.WannatagId]]
   */
  val id: WannatagId
}

/*
 * wannatag作成イベント
 *
 * @param id [[com.tiloom6.wannatag.domain.wannatag.WannatagId]]
 */
case class WannatagCreated(id: WannatagId) extends WannatagEvent
