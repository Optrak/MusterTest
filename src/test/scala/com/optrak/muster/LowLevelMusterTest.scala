package com.optrak.muster

import muster.codec.json4s._
import DateTimeUtils._
import org.joda.time.DateTime
import com.typesafe.scalalogging.LazyLogging
import org.specs2.mutable._
import org.json4s.native.JsonMethods._

class LowLevelMusterTest extends Specification with LazyLogging {
  val now = new DateTime

  "Json4sCodec" should {
    "serialize and deserialize DateTime with custom producer and consumer" in {
      val nowSerialized = Json4sCodec.from(now)

      val back = Json4sCodec.as[DateTime](nowSerialized)
      /* Note: even if string representations of DateTime objects are the same, the objects may not be
         equal by hashcode. See
         http://stackoverflow.com/questions/21002385/datetime-does-not-equal-itself-after-unserialization
      */
      back shouldEqual now
    }
    
    "serialize and deserialize a case class containing DateTime with auto-generated producer and consumer" in {
      import DateTimeUtils._

      case class SomeClass(timestamp: DateTime)
      val testEvent = SomeClass (timestamp = new DateTime)

      val json = Json4sCodec.from(testEvent)
      logger.debug(pretty(render(json)))
      val back = Json4sCodec.as[SomeClass](json)

      back shouldEqual testEvent
    }
  }
}