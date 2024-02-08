package com.example.demoproject.CustomSerializer;

import com.example.demoproject.Model.Move.NormalMove;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class CustomModule extends SimpleModule {

    public CustomModule(){
        addSerializer(NormalMove.class, new NormalMoveSerializer());
    }
}
