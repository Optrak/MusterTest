 Test project for json4s muster [issue](https://github.com/json4s/muster/issues/14)
===================================================================================

This illustrates how DateTime is serialized and deserialized with custom producer and consumer for json4s muster codec as a standalone value (first test), but fails to deserialize being a field in a case class (second test) with 
    
    MappingException: : Expected an object field for timestamp but found a JString  (json4s_input.scala:44)
      muster.codec.json4s.Json4sInputCursor$Json4sObjectNode.readObjectFieldOpt(json4s_input.scala:44)
      com.optrak.muster.LowLevelMusterTest$$anonfun$1$$anonfun$apply$4$$anon$2.consume(LowLevelMusterTest.scala:33)
      com.optrak.muster.LowLevelMusterTest$$anonfun$1$$anonfun$apply$4$$anon$2.consume(LowLevelMusterTest.scala:33)
      muster.input.InputFormat$class.as(input.scala:89)
      muster.codec.json4s.Json4sCodec$.as(Json4sCodec.scala:8)
      com.optrak.muster.LowLevelMusterTest$$anonfun$1$$anonfun$apply$4.apply(LowLevelMusterTest.scala:33)
      com.optrak.muster.LowLevelMusterTest$$anonfun$1$$anonfun$apply$4.apply(LowLevelMusterTest.scala:25)