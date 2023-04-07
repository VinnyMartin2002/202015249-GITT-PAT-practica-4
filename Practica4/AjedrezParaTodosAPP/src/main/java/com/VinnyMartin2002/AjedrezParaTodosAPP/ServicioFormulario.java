package com.VinnyMartin2002.AjedrezParaTodosAPP;

import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ServicioFormulario {

    InfoManager infoManager;

    ServicioFormulario() {
        this.infoManager = new InfoManager();
    }

    public  Form addMessage(Map<String, Object> message) {
        try {
            checkIfPayloadIsValid(message);
            Form contactMessage = new Form((String) message.get("nombre"), (String) message.get("apellido"), (String) message.get("email"),
                    (String) message.get("ciudad"),(String) message.get("comunidadAutonoma"));
            infoManager.addMessage(contactMessage);
            return contactMessage;
        }
        catch (Exception e) {
            throw e;
        }


    }

    public void checkIfPayloadIsValid(Map<String, Object> payload) {
        if(payload == null) {
            throw new IllegalArgumentException("Message is required");
        }
        if (!payload.containsKey("name")) {
            throw new IllegalArgumentException("Name is required");
        }
        if (!payload.containsKey("email")) {
            throw new IllegalArgumentException("Email is required");
        }
        if (!payload.containsKey("message")) {
            throw new IllegalArgumentException("Message is required");
        }

        // check that email is valid with regex

        String email = (String) payload.get("email");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Email is invalid");
        }


    }


}