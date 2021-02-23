package com.example.corretagemapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class CotacaoModelPreco implements Parcelable {
    private int tipo;
    private String preco;
    private String title;

    protected CotacaoModelPreco(Parcel in) {
        tipo = in.readInt();
        preco = in.readString();
        title = in.readString();
    }

    public static final Creator<CotacaoModelPreco> CREATOR = new Creator<CotacaoModelPreco>() {
        @Override
        public CotacaoModelPreco createFromParcel(Parcel in) {
            return new CotacaoModelPreco(in);
        }

        @Override
        public CotacaoModelPreco[] newArray(int size) {
            return new CotacaoModelPreco[size];
        }
    };

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tipo);
        dest.writeString(preco);
        dest.writeString(title);
    }

    public static class CotacaoModelPrecoBuilder{
        private int tipo;
        private String preco;
        private String title;
        private CotacaoModelPrecoBuilder(){}
        public CotacaoModelPreco.CotacaoModelPrecoBuilder setTipo(int tipo) {
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

