package com.VinnyMartin2002.AjedrezParaTodosAPP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InfoManager {

    ArrayList<Form> messages;
    public  String CSV_FILE = "respuestasFormulario.csv";

    public InfoManager(ArrayList<Form> messages) {
        this.messages = messages;
    }

    public InfoManager() {
        this.messages = new ArrayList<>();
    }

    private void addMessageToCsv(Form message) {
        try (FileWriter fileWriter = new FileWriter(CSV_FILE, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String messageData = String.format("\"%s\",\"%s\",\"%s\"\n", message.getNombre(), message.getApellido(), message.getEmail(),message.getCiudad(), message.getComunidadAutonoma());
            bufferedWriter.write(messageData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addMessage(Form message) {
        this.messages.add(message);
        addMessageToCsv(message);
    }
}