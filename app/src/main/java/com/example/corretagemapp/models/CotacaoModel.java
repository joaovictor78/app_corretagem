package com.example.corretagemapp.models;

public class CotacaoModel {
    private String idade;

    public String getIdade_min() {
        return idade_min;
    }

    public void setIdade_min(String idade_min) {
        this.idade_min = idade_min;
    }

    public String getIdade_max() {
        return idade_max;
    }

    public void setIdade_max(String idade_max) {
        this.idade_max = idade_max;
    }

    private  String idade_min;
    private  String idade_max;
    private String enfermaria_preco;
    private String apartamento_preco;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;
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
        private String idade = "";
        private String idade_min;
        private String idade_max;
        private String enfermaria_preco;
        private String apartamento_preco;

        public CotacaoModel.CotacaoBuilder setImage_background(String image_background) {
            this.image_background = image_background;
            return this;
        }

        private String image_background;
        public CotacaoModel.CotacaoBuilder setIdadeMin(String idade_min) {
            this.idade_min = idade_min;
            return this;
        }

        public CotacaoModel.CotacaoBuilder setIdadeMax(String idade_max) {
            this.idade_max = idade_max;
            return this;
        }
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
            cotacao.idade_min = idade_min;
            cotacao.idade_max = idade_max;
            cotacao.image = image_background;
            return cotacao;
        }
    }



}
