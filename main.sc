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

import Lib1.*, Lib2.*

def useLastBlock[A](instance: A)(using behavior: LastBlock[A]) =
  behavior.lastBlock(instance)

println(useLastBlock(Ethereum(lastBlock = 2)))
println(useLastBlock(Bitcoin()))
