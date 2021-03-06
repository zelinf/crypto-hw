package net.zelinf.cryptohw.aes

import net.zelinf.cryptohw.UnitSpec
import TestUtils._

final class KeySpec extends UnitSpec {

  describe("rotWord") {
    it("works for a sample") {
      assert(Key.rotWord(0xAABBCCDD) == 0xDDAABBCC)
    }
  }

  describe("roundKeys") {
    it("works for known sample") {
      val key = Key(
        Array(0x54, 0x68, 0x61, 0x74, 0x73, 0x20, 0x6D, 0x79, 0x20, 0x4B, 0x75,
          0x6E, 0x67, 0x20, 0x46, 0x75).map(_.toByte)
      )

      val roundKeys: Seq[Key] = key.roundKeys
      assert(roundKeys.size == 11)
      assert(
        roundKeys(1) == intsToKey(0xE2, 0x32, 0xFC, 0xF1, 0x91, 0x12, 0x91,
          0x88, 0xB1, 0x59, 0xE4, 0xE6, 0xD6, 0x79, 0xA2, 0x93)
      )

      assert(
        roundKeys(2) == intsToKey(0x56, 0x08, 0x20, 0x07, 0xC7, 0x1A, 0xB1,
          0x8F, 0x76, 0x43, 0x55, 0x69, 0xA0, 0x3A, 0xF7, 0xFA)
      )
      assert(
        roundKeys(10) == intsToKey(0x28, 0xFD, 0xDE, 0xF8, 0x6D, 0xA4, 0x24,
          0x4A, 0xCC, 0xC0, 0xA4, 0xFE, 0x3B, 0x31, 0x6F, 0x26)
      )
    }
  }

}
