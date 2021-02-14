package com.example.corretagemapp.models;

public class CompromissoModel {
    private String assunto;
    private String data;
    private String horario;
    private String descricao;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    private CompromissoModel(){}
    public static class CompromissoModelBuilder{
        private String assunto;
        private String data;
        private String horario;
        private String descricao;
        public void setAssunto(String assunto) {
            this.assunto = assunto;
        }


        public CompromissoModel.CompromissoModelBuilder setData(String data) {
            this.data = data;
            return this;
        }


        public CompromissoModel.CompromissoModelBuilder  setHorario(String horario) {
            this.horario = horario;
            return this;
        }


        public CompromissoModel.CompromissoModelBuilder  setDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        private CompromissoModelBuilder(){}
        public static CompromissoModel.CompromissoModelBuilder builder(){
            return new CompromissoModel.CompromissoModelBuilder();
        }
        public CotacaoModel build(){
            CotacaoModel compromisso = new CotacaoModel();
            this.assunto = assunto;
            this.data = data;
            this.descricao = descricao;
            this.horario = horario;
            return compromisso;
        }
    }



}
