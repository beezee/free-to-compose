package freetocompose.example

import freetocompose.{AddComposingFunctions, FreeToCompose}

object StoreOps {
  sealed trait StoreOp[+A]
  case class Put(key: String, value: String) extends StoreOp[Unit]
  case class Get(key: String) extends StoreOp[String]
}

object Store {
  val functions = FreeToCompose.liftFunctions[StoreOps.StoreOp]('Store)
  @AddComposingFunctions[StoreOps.StoreOp]('Store) object composing
}
