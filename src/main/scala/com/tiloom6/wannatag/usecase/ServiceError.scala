package com.tiloom6.wannatag.usecase

/*
 * 独自エラーの汎用トレイと
 */
sealed trait ServiceError

/*
 * ApplicationService層で発生したエラーを表す汎用トレイト
 */
sealed trait ApplicationError extends ServiceError

/*
 * 見つからなかった場合のエラー
 */
final case class NotFoundError() extends ApplicationError
