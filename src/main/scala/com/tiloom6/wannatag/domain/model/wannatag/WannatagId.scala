package com.tiloom6.wannatag.domain.model.wannatag

import com.tiloom6.wannatag.domain.common.Identifier

/*
 * wannatagの識別子
 *
 * @param value 識別子の値
 */
case class WannatagId(value: Long) extends Identifier[Long]