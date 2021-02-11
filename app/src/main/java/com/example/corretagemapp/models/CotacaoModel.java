package com.example.corretagemapp.models;

public class CotacaoModel {
    private  String idade;
    private String enfermaria_preco;
    private String apartamento_preco;
    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEnfermaria_preco() {
        return enfermaria_preco;
    }

    public void setEnfermaria_preco(String enfermaria_preco) {
        this.enfermaria_preco = enfermaria_preco;
    }

    public String getApartamento_preco() {
        return apartamento_preco;
    }

    public void setApartamento_preco(String apartamento_preco) {
        this.apartamento_preco = apartamento_preco;
    }
    public static class CotacaoBuilder{
        private String idade;
        private String enfermaria_preco;
        private String apartamento_preco;


        public CotacaoModel.CotacaoBuilder setEnfermariaPreco(String enfermaria_preco) {
            this.enfermaria_preco = enfermaria_preco;
            return this;
        }

        public CotacaoModel.CotacaoBuilder setApartamentoPreco(String apartamento_preco) {
            this.apartamento_preco = apartamento_preco;
            return this;
        }

        public CotacaoModel.CotacaoBuilder setIdade(String idade) {
            this.idade = idade;
            return this;
        }
        private CotacaoBuilder(){}
        public static CotacaoModel.CotacaoBuilder builder(){
            return new CotacaoBuilder();
        }
        public CotacaoModel build(){
            CotacaoModel cotacao = new CotacaoModel();
            cotacao.idade = idade;
            cotacao.apartamento_preco = apartamento_preco;
            cotacao.enfermaria_preco = enfermaria_preco;
            return cotacao;
        }
    }



}
