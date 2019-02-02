package com.tiloom6.wannatag.domain

/*
 * エンティティの処理の結果
 *
 * @tparam EntityType [[com.tiloom6.wannatag.domain.Entity]] の具象クラス
 * @tparam Event [[com.tiloom6.wannatag.domain.DomainEvent]] の具象クラス
 * @param entity [[com.tiloom6.wannatag.domain.Entity]] の具象オブジェクト
 * @param event [[com.tiloom6.wannatag.domain.DomainEvent]] の具象オブジェクト
 */
case class DomainResult[+EntityType <: Entity[_ <: EntityId[_]], +Event <: DomainEvent](entity: EntityType, event: Event)
