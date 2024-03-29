package com.example.corretagemapp.models;

public class Corretora {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static class CorretoraBuilder{
        private String name;
        public CorretoraBuilder setName(String name) {
            this.name = name;
            return this;
        }
        private CorretoraBuilder(){}
        public static CorretoraBuilder builder(){
            return new CorretoraBuilder();
        }
        public Corretora build(){
            Corretora corretora = new Corretora();
            corretora.name = name;
            return corretora;
        }
    }

}
