package com.example.corretagemapp.models;

import java.util.Arrays;
import java.util.List;

public class Corretoras{
    public static List<Corretora> listCorretoras(){
        return Arrays.asList(
                Corretora.CorretoraBuilder.builder().setName("Unir").build(),
                Corretora.CorretoraBuilder.builder().setName("Ifro").build(),
                Corretora.CorretoraBuilder.builder().setName("Alguem").build(),
                Corretora.CorretoraBuilder.builder().setName("Goku").build());
    }
}
