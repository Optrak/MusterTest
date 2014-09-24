package com.optrak.muster

import muster.ast.{AstNode, TextNode}
import muster.input.Consumer
import muster.output.{Producer, OutputFormatter}
import org.joda.time.{DateTimeZone, DateTime}
import org.json4s._

object DateTimeUtils {
  implicit object DateTimeConsumer extends Consumer[DateTime] {
    def consume(node: AstNode[_]): DateTime = node match {
      case TextNode(value) =>
        val timeZone = DateTimeZone.getDefault
        DateTime.parse(value).withZone(timeZone) //otherwise the parsed DateTime won't equal the original
      case n => throw new MappingException(s"Can't parse timestamp from ${n.getClass}")
    }
  }

  implicit object DateTimeProducer extends Producer[DateTime] {
    def produce(value: DateTime, formatter: OutputFormatter[_]) = formatter.string(value.toString)
  }
}