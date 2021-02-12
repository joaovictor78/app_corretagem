package com.example.corretagemapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class CotacaoModel implements Parcelable {
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
    public CotacaoModel(){ }
    protected CotacaoModel(Parcel in) {
        idade = in.readString();
        idade_max = in.readString();
        idade_min = in.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idade);
        dest.writeString(idade_max);
        dest.writeString(idade_min);
        dest.writeString(enfermaria_preco);
        dest.writeString(apartamento_preco);
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CotacaoModel createFromParcel(Parcel in) {
            return new CotacaoModel(in);
        }

        public CotacaoModel[] newArray(int size) {
            return new CotacaoModel[size];
        }
    };

    public static class CotacaoBuilder{
        private String idade = "";
        private String idade_min;
        private String idade_max;
        private String enfermaria_preco;
        private String apartamento_preco;

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
            return cotacao;
        }
    }
}
