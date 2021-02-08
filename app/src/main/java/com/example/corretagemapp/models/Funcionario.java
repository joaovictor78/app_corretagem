package com.example.corretagemapp.models;

public class Funcionario {
    private String name;
    private String phone;
    private String email;

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
        private FuncionarioBuilder(){}
        public static FuncionarioBuilder builder(){
            return new FuncionarioBuilder();
        }
        public Funcionario build(){
            Funcionario funcionario = new Funcionario();
            funcionario.name = name;
            funcionario.email = email;
            funcionario.phone = phone;
            return funcionario;
        }
    }
}
