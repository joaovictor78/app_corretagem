package com.example.corretagemapp.database;

public class ScriptDLL {
    public static String getCreateCompromisso(){
        StringBuilder createTableCompromisso = new StringBuilder();
        createTableCompromisso.append("CREATE TABLE IF NOT EXISTS compromisso(");
        createTableCompromisso.append("codigo_compromisso INTEGER AUTOINCREMENT PRIMARY KEY,");
        createTableCompromisso.append("assunto TEXT NOT NULL,");
        createTableCompromisso.append("data TEXT NOT NULL,");
        createTableCompromisso.append("horario TEXT NOT NULL,");
        createTableCompromisso.append("descricao TEXT NOT NULL);");
        return createTableCompromisso.toString();
    }
}
