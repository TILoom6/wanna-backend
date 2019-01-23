package com.tiloom6.wannatag.domain.model

/*
 * エンティティの処理の結果
 *
 * @tparam EntityType [[com.tiloom6.wannatag.domain.model.Entity]] の具象クラス
 * @tparam Event [[com.tiloom6.wannatag.domain.model.DomainEvent]] の具象クラス
 * @param entity [[com.tiloom6.wannatag.domain.model.Entity]] の具象オブジェクト
 * @param event [[com.tiloom6.wannatag.domain.model.DomainEvent]] の具象オブジェクト
 */
case class DomainResult[+EntityType <: Entity[_ <: EntityId[_]], +Event <: DomainEvent](entity: EntityType, event: Event)
