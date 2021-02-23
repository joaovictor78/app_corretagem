package com.example.corretagemapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class CotacaoModel implements Parcelable {
    private String idade;
    private  String idade_min;
    private  String idade_max;
    private List<CotacaoModelPreco> listEnfermagemPreco;
    private List<CotacaoModelPreco> listApartamentoPreco;
    private String imageUrl;
    private List<CotacaoModelPreco> listCarencia;



    public List<CotacaoModelPreco> getListEnfermagemPreco() {
        return listEnfermagemPreco;
    }

    public void setListEnfermagemPreco(List<CotacaoModelPreco> listEnfermagemPreco) {
        this.listEnfermagemPreco = listEnfermagemPreco;
    }

    public List<CotacaoModelPreco> getListApartamentoPreco() {
        return listApartamentoPreco;
    }

    public void setListApartamentoPreco(List<CotacaoModelPreco> listApartamentoPreco) {
        this.listApartamentoPreco = listApartamentoPreco;
    }
    public List<CotacaoModelPreco> getListCarencia() {
        return listCarencia;
    }

    public void setListCarencia(List<CotacaoModelPreco> listCarencia) {
        this.listCarencia = listCarencia;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

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

    public CotacaoModel(){ }
    protected CotacaoModel(Parcel in) {
        idade = in.readString();
        idade_max = in.readString();
        idade_min = in.readString();
        listEnfermagemPreco = new ArrayList<CotacaoModelPreco>();
        listApartamentoPreco = new ArrayList<CotacaoModelPreco>();
        listCarencia = new ArrayList<CotacaoModelPreco>();
        in.readTypedList(listEnfermagemPreco, CotacaoModelPreco.CREATOR);
        in.readTypedList(listApartamentoPreco, CotacaoModelPreco.CREATOR);
        in.readTypedList(listCarencia, CotacaoModelPreco.CREATOR);
        imageUrl = in.readString();
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
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
        dest.writeTypedList(listEnfermagemPreco);
        dest.writeTypedList(listApartamentoPreco);
        dest.writeTypedList(listCarencia);
        dest.writeString(imageUrl);
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
        private List<CotacaoModelPreco> listEnfermagemPreco;
        private List<CotacaoModelPreco> listApartamentoPreco;
        private List<CotacaoModelPreco> listCarencia;


        public  CotacaoModel.CotacaoBuilder setImage_url(String image_url) {
            this.image_url = image_url;
            return this;
        }
        private String image_url;
        private String image_background;
        public CotacaoModel.CotacaoBuilder setIdadeMin(String idade_min) {
            this.idade_min = idade_min;
            return this;
        }

        public CotacaoModel.CotacaoBuilder setIdadeMax(String idade_max) {
            this.idade_max = idade_max;
            return this;
        }
        public CotacaoModel.CotacaoBuilder setEnfermariaPreco(List<CotacaoModelPreco> listEnfermagemPreco) {
            this.listEnfermagemPreco = listEnfermagemPreco;
            return this;
        }

        public CotacaoModel.CotacaoBuilder setApartamentoPreco(List<CotacaoModelPreco> listApartamentoPreco) {
            this.listApartamentoPreco = listApartamentoPreco;
            return this;
        }

        public CotacaoModel.CotacaoBuilder setIdade(String idade) {
            this.idade = idade;
            return this;
        }
        public CotacaoModel.CotacaoBuilder setCarencia(List<CotacaoModelPreco> listCarencia) {
            this.listCarencia = listCarencia;
            return this;
        }
        private CotacaoBuilder(){}
        public static CotacaoModel.CotacaoBuilder builder(){
            return new CotacaoBuilder();
        }
        public CotacaoModel build(){
            CotacaoModel cotacao = new CotacaoModel();
            cotacao.idade = idade;
            cotacao.listEnfermagemPreco = listEnfermagemPreco;
            cotacao.listApartamentoPreco = listApartamentoPreco;
            cotacao.idade_min = idade_min;
            cotacao.idade_max = idade_max;
            cotacao.imageUrl = image_url;
            cotacao.listCarencia = listCarencia;
            return cotacao;
        }
    }
}
