/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mundo;

/**
 *
 * @author Gabriela Delgado
 */
public class Alumno {
    
    // Atributos
    private String cedula;
    private String nombre;
    private String apellido;
    private int semestre;
    private String correo;
    private String celular;
    
    // Constructor vacio
    public Alumno() {
    }
    
    // Constructor con parametros
    public Alumno(String cedula, String nombre, String apellido, int semestre, String correo, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.correo = correo;
        this.celular = celular;
    }

    // get y set de los atributos de la clase alumno
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }  

    @Override
    public String toString() {
        return "Alumno{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", semestre=" + semestre + ", correo=" + correo + ", celular=" + celular + '}';
    }
}