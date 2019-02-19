package com.marlon.fireapp.pojos;

public class User {

    private String nombre;
    private String apellido;
    private int edad;
    private  String email;

    public User(){

    }

    public User(String nombre, String apellido, int edad,String email){
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }


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

    public int getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public void setEmail (String email){ this.email = email; }

    public String getEmail(){return this.email;}
}
