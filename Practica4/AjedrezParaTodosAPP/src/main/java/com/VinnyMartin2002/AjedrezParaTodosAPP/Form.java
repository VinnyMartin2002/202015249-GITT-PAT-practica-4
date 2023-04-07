package com.VinnyMartin2002.AjedrezParaTodosAPP;

import org.springframework.lang.NonNull;

import java.io.Serializable;

public class Form implements Serializable {
    @NonNull
    private String nombre;
    @NonNull
    private String apellido;
    @NonNull
    private String email;
    @NonNull
    private String ciudad;
    @NonNull
    private String comunidadAutonoma;


    public Form(String nombre, String apellido, String email, String ciudad, String comunidadAutonoma) {
        if (nombre == null ||apellido==null || email == null || ciudad == null || comunidadAutonoma==null) {
            throw new IllegalArgumentException("Nombre, apellido, email, ciudad y comunidad autónoma no pueden estar vacios");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.comunidadAutonoma = comunidadAutonoma;
    }

    public Form(){}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComunidadAutonoma() {
        return comunidadAutonoma;
    }

    public void setComunidadAutonoma(String comunidadAutonoma) {
        this.comunidadAutonoma = comunidadAutonoma;
    }

    @Override
    public String toString() {
        return "[Nombre: "+nombre+" Apellido: "+apellido+" Correo electrónico: "+email+" Comunidad Autónoma: "+comunidadAutonoma+" Ciudad: "+ciudad+"]";
    }
}
