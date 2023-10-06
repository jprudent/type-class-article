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

val eth = Lib1.Ethereum()
val btc = Lib1.Bitcoin()
val dot = Lib2.Polkadot()

