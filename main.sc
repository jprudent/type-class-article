def todo = 42
type Height = Int
type Block = Int
def http(uri: String): Block = todo

object Lib1:
  trait Blockchain:
    def getBlock(height: Height): Block

  case class Ethereum(lastBlock: Block) extends Blockchain:
    override def getBlock(height: Height) = todo

  case class Bitcoin() extends Blockchain:
    override def getBlock(height: Height) = todo

object GenericLib:

  trait Named[A]:
    def blockchainName(instance: A): String

  object Named:
    import scala.deriving.*

    inline final def derived[A](using inline m: Mirror.Of[A]): Named[A] =
      val nameOfType: String = inline m match
        case p: Mirror.ProductOf[A] => compiletime.constValue[p.MirroredLabel]
        case _ => compiletime.error("Not a product")
      new Named[A]:
        override def blockchainName(instance: A):String = nameOfType.toLowerCase

  extension[A] (instance: A)(using tc: Named[A])
    def blockchainName = tc.blockchainName(instance)

import Lib1.*, GenericLib.*

case class Polkadot() derives Named
given Named[Bitcoin] = Named.derived
given Named[Ethereum] = Named.derived

println(Ethereum(lastBlock = 2).blockchainName)
println(Bitcoin().blockchainName)
println(Polkadot().blockchainName)
