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

    def lastBlock(): Block = todo

  extension (eth: Ethereum) def lastBlock(): Block = todo

  extension (btc: Bitcoin) def lastBlock(): Block = todo

import Lib1.*, Lib2.*
println(Bitcoin().lastBlock())
println(Ethereum().lastBlock())
println(Polkadot().lastBlock())

def polymorphic(blockchain: Blockchain) =
  // blockchain.lastBlock()
  ???
