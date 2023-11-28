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

  def lastBlock(blockchain: Blockchain): Block = blockchain match
      case _:Ethereum => todo
      case _:Bitcoin  => todo
      case _:Polkadot => todo
  

object Lib3:
  import Lib1.*

  case class Polygon() extends Blockchain:
    override def getBlock(height: Height): Block = todo

import Lib1.*, Lib2.*, Lib3.*
println(lastBlock(Bitcoin()))
println(lastBlock(Ethereum()))
println(lastBlock(Polkadot()))
println(lastBlock(Polygon()))
