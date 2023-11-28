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

  extension[A](instance: A)(using tc: LastBlock[A])
    def lastBlock = tc.lastBlock(instance)
    def penultimateBlock = tc.lastBlock(instance) - 1

import Lib1.*, Lib2.*

val eth = Ethereum(lastBlock = 2)
println(eth.lastBlock)
println(eth.penultimateBlock)

val btc = Bitcoin()
println(btc.lastBlock)
println(btc.penultimateBlock)
