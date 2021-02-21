package com.example.corretagemapp.models;

public class CotacaoModelPreco {
    private String tipo;
    private String preco;
    private String title;
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    public CotacaoModelPreco(){}
    public static class CotacaoModelPrecoBuilder{
        private String tipo;
        private String preco;
        private String title;
        private CotacaoModelPrecoBuilder(){}
        public CotacaoModelPreco.CotacaoModelPrecoBuilder setTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }
        public CotacaoModelPreco.CotacaoModelPrecoBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        public CotacaoModelPreco.CotacaoModelPrecoBuilder setPreco(String preco) {
            this.preco = preco;
            return this;
        }
        public static CotacaoModelPreco.CotacaoModelPrecoBuilder builder(){
            return new CotacaoModelPreco.CotacaoModelPrecoBuilder();
        }
        public CotacaoModelPreco build(){
            CotacaoModelPreco cotacaoModelPreco = new CotacaoModelPreco();
            cotacaoModelPreco.preco = preco;
            cotacaoModelPreco.tipo = tipo;
            cotacaoModelPreco.title = title;
            return cotacaoModelPreco;
        }
    }
    }

