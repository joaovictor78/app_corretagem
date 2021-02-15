package com.example.corretagemapp.database;

public class ScriptDLL {
    public static String getCreateCompromisso(){
        StringBuilder createTableCompromisso = new StringBuilder();
        createTableCompromisso.append("CREATE TABLE IF NOT EXISTS compromisso(");
        createTableCompromisso.append("codigo_compromisso INTEGER PRIMARY KEY AUTOINCREMENT,");
        createTableCompromisso.append("assunto TEXT NOT NULL,");
        createTableCompromisso.append("horario TEXT NOT NULL,");
        createTableCompromisso.append("descricao TEXT NOT NULL);");
        return createTableCompromisso.toString();
    }
    public static String getCreateDataCompromisso(){
        StringBuilder createTableDataCompromisso = new StringBuilder();
        createTableDataCompromisso.append("CREATE TABLE IF NOT EXISTS data_compromisso(");
        createTableDataCompromisso.append("id_data INTEGER PRIMARY KEY AUTOINCREMENT,");
        createTableDataCompromisso.append("id_compromisso INTEGER NOT NULL,");
        createTableDataCompromisso.append("data TEXT NOT NULL,");
        createTableDataCompromisso.append("FOREIGN KEY (id_compromisso) REFERENCES compromisso(codigo_compromisso) );");
        return createTableDataCompromisso.toString();
    }
}
