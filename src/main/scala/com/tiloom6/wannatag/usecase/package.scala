package com.tiloom6.wannatag

import scala.util.{Failure, Success, Try}

/*
 * usecase 汎用定義パッケージ
 */
package object usecase {

  /*
   * usecaseの暗黙定義
   */
  object Implicits {

    /*
     * [[Try]] の拡張クラス
     *
     * @param repositoryResult Try抽象型のリポジトリのリザルト
     * @tparam Result リポジトリのリザルト
     */
    implicit class RepositoryErrorOps[Result](repositoryResult: Try[Result]) {

      /*
       * Failureの場合エラーハンドリングを適用し、 [[com.tiloom6.wannatag.usecase.ServiceError]] に変換する
       *
       * @param failureFunction Failureの場合に適用するエラーハンドリング
       * @return Left => [[com.tiloom6.wannatag.usecase.ServiceError]] , Right => Successの場合のリザルト値
       */
      def ifFailureThen(failureFunction: Throwable => ServiceError): Either[ServiceError, Result] = {
        repositoryResult match {
          case Failure(throwable) => Left(failureFunction(throwable))
          case Success(result) => Right(result)
        }
      }
    }
  }

  /*
   * エラーハンドリングのヘルパー
   */
  object ErrorHandleHelper {

    /*
     * 型引数で指定した型を [[com.tiloom6.wannatag.usecase.ServiceError]] に変換する
     *
     * @param asServiceErrorFunction 型引数で指定した型を [[com.tiloom6.wannatag.usecase.ServiceError]] に変換する実際の処理関数
     * @tparam BeConvertedType 変換される型
     * @return asServiceErrorFunction
     */
    def asServiceError[BeConvertedType](implicit asServiceErrorFunction: BeConvertedType => ServiceError): BeConvertedType => ServiceError = asServiceErrorFunction
  }
}
