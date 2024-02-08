package com.example.demoproject.CustomSerializer;

import com.example.demoproject.Model.Move.NormalMove;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class NormalMoveSerializer extends JsonSerializer<NormalMove> {

    @Override
    public void serialize(NormalMove normalMove, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("fromPos", normalMove.getFromPos());
        jsonGenerator.writeObjectField("toPos", normalMove.getToPos());
        // Add more fields as needed
        jsonGenerator.writeEndObject();
    }
}
