def todo = 42
type Height = Int
type Block = Int

object Lib1:
  trait Blockchain:
    def getBlock(height: Height): Block

  case class Ethereum() extends Blockchain:
    override def getBlock(height: Height) = todo

  case class Bitcoin() extends Blockchain:
    override def getBlock(height: Height) = todo

object Lib2:
  import Lib1.*

  case class Polkadot() extends Blockchain:
    override def getBlock(height: Height): Block = todo

import Lib1.*, Lib2.*
println(Ethereum().getBlock(1))
println(Bitcoin().getBlock(1))
println(Polkadot().getBlock(1))
