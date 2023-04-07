package com.VinnyMartin2002.AjedrezParaTodosAPP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class FormController {
    private static final Logger logger = LoggerFactory.getLogger(FormController.class);
    private ArrayList<String>respuestas=new ArrayList<String>();
    @Autowired
    private ServicioFormulario servicioFormulario;



    @GetMapping("/form")
    public ResponseEntity<ArrayList<String>> getForm(){
        Form formularioPrueba=new Form("Vicente","Martin","a@a","Palma","Baleares");
        respuestas.add(formularioPrueba.toString());
        return new ResponseEntity<ArrayList<String>>(respuestas, HttpStatus.OK);
    }
    @PostMapping(value = "/enviar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> addForm(@RequestBody Map<String, Object> message) {
        try {
            Form infoForm = servicioFormulario.addMessage(message);
            logger.info("Added contact message: " + infoForm.toString());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error adding contact message: " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
