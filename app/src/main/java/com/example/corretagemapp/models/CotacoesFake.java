package com.example.corretagemapp.models;

import java.util.Arrays;
import java.util.List;

public class CotacoesFake {
    public static List<CotacaoModel> listaCotacoes(){
        return Arrays.asList(
                CotacaoModel.CotacaoBuilder.builder().setIdade("14").setApartamentoPreco("14.40").setEnfermariaPreco("342.2").build(),
                CotacaoModel.CotacaoBuilder.builder().setIdade("14").setApartamentoPreco("14.40").setEnfermariaPreco("342.2").build());
    }
}
