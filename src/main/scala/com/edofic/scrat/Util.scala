package com.edofic.scrat

/**
 * User: andraz
 * Date: 8/25/12
 * Time: 11:08 PM
 */
object Util {

  object Exceptions {

    case class ScratSyntaxError(msg: String) extends Exception(msg)

    case class ScratSemanticError(msg: String) extends Exception(msg)

    case class ScratInvalidTokenError(msg: String) extends Exception(msg)

    case class ScratInvalidTypeError(msg: String) extends Exception(msg)

    case class ScratNotAllowedError(msg: String) extends Exception(msg)

  }

  object Implicits {
    //allow visual representation of data flow
    implicit def any2applyFunc[A](a: A) = new AnyRef {
      def -->[B](f: A => B): B = f(a)
    }
  }

  object Debugging{
    val p = Parser.apply _ andThen (_(0))
    val runtime = new ScratRuntime
    val eval = runtime.cleanRoomEval _
    val toTree = p andThen Optimizer.apply
    val mod = TreeOps.applyRecursiveModificaton _
  }

}
