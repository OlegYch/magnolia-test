import magnolia1.*

trait Print[T] {
  extension (x: T) def print: String
}

object Print extends Derivation[Print]:
  inline def derive[T: scala.deriving.Mirror.Of] = derived[T]
  def join[T](ctx: CaseClass[Print, T]): Print[T] = value =>
    ctx.params.map { param =>
      param.typeclass.print(param.deref(value))
    }.mkString(s"${ctx.typeInfo.short}(", ",", ")")

  override def split[T](ctx: SealedTrait[Print, T]): Print[T] = value =>
    ctx.choose(value) { sub => sub.typeclass.print(sub.cast(value)) }

  given Print[Int] = _.toString
  given Print[String] = _.toString

object generate extends App {
  for (i <- 0 to 200) println(s"case class A${i}(i: Int, s: String) derives Print")
}
