package com.example.corretagemapp.models;

import java.util.Arrays;
import java.util.List;

public class Funcionarios {
    public static List<Funcionario> listFuncionario(){
        return Arrays.asList(
                Funcionario.FuncionarioBuilder.builder().setName("Joao").setEmail("joao@gmail.com").setPhone("69 4002-8922").build(),
                Funcionario.FuncionarioBuilder.builder().setName("Playstation").setEmail("yudi@gmail.com").setPhone("69 4002-8922").build(),
                Funcionario.FuncionarioBuilder.builder().setName("KimJoum1").setEmail("capitalistaoficial@gmail.com").setPhone("69 4002-8922").build());
    }

    }

