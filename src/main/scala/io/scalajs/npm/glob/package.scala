package io.scalajs.npm

import io.scalajs.util.PromiseHelper._
import io.scalajs.RawOptions

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.{Array, |}

/**
  * glob package object
  * @author lawrence.daniels@gmail.com
  */
package object glob {

  type GlobError = js.Any

  type GlobCallback = js.Function2[GlobError, js.Array[String], Any]

  /**
    * Glob Enrichment
    * @param glob the given [[GlobClass glob]]
    */
  implicit class GlobObjectEnrichment(val glob: GlobClass) extends AnyVal {

    @inline
    def async(pattern: String, options: GlobOptions | RawOptions = null): Promise[Array[String]] = {
      promiseWithError1[GlobError, js.Array[String]](glob(pattern, options, _))
    }

  }

}
