package com.example.corretagemapp.models;

public class Funcionario {
    private String name;
    private String phone;
    private String email;
    private boolean select;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    public boolean getSelect() {return select;}

    public  void setSelect(boolean select) {this.select = select;}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
    public static class FuncionarioBuilder{
        private String name;
        private String email;
        private String phone;

        public Funcionario.FuncionarioBuilder setId(String id) {
            this.id = id;
            return  this;
        }

        private  String id;
        private boolean select;

        public Funcionario.FuncionarioBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public Funcionario.FuncionarioBuilder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Funcionario.FuncionarioBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public Funcionario.FuncionarioBuilder setSelect(boolean select) {
            this.select = select;
            return this;
        }

        private FuncionarioBuilder(){}
        public static FuncionarioBuilder builder(){
            return new FuncionarioBuilder();
        }
        public Funcionario build(){
            Funcionario funcionario = new Funcionario();
            funcionario.name = name;
            funcionario.email = email;
            funcionario.phone = phone;
            funcionario.select = select;
            funcionario.id = id;
            return funcionario;
        }
    }
}
