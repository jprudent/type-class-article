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

object Lib2:
  import Lib1.*

  trait LastBlock[A]:
    def lastBlock(instance: A): Block

  given LastBlock[Ethereum] with
    def lastBlock(eth: Ethereum) = eth.lastBlock

  given LastBlock[Bitcoin] with
    def lastBlock(btc: Bitcoin) = http("http://bitcoin/last")

  extension[A](instance: A)
    def lastBlock(using tc: LastBlock[A]) = tc.lastBlock(instance)

import Lib1.*, Lib2.*

println(Ethereum(lastBlock = 2).lastBlock)
println(Bitcoin().lastBlock)
