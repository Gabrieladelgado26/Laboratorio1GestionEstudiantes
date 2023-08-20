/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;

import Mundo.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gabriela Delgado
 */
public class Proyecto {

    public static void main(String[] args) {
        // Función que permite leer la opción del usuario
        Scanner lector = new Scanner (System.in);
        
        //Bandera que permite terminar el programa
        boolean activo = true;
        
        // ArrayList que almacena los alumnos
        ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();
        
        do{
            
        // Muestra un menú al usuario
        System.out.println("---------MENÚ DE OPCIONES---------");
        System.out.println("Qué operación quieres hacer?");
        System.out.println("1.- Insertar alumno");
        System.out.println("2.- Eliminar alumno");
        System.out.println("3.- Modificar alumno");
        System.out.println("4.- Consultar alumno");
        System.out.println("5.- Terminar programa");
        System.out.println("----------------------------------");
        
        int opcion = lector.nextInt();
        
        // switch que permite evaluar la opción y segun la misma realizar una acción
        switch (opcion) {
            case 1:
                System.out.println("Introduce la cédula del alumno");
                String cedula = lector.next();
                
                System.out.println("Introduce el nombre del alumno");
                String nombre = lector.next();
                
                System.out.println("Introduce el apellido del alumno");
                String apellido = lector.next();
               
                System.out.println("Introduce el semestre del alumno");
                int semestre = lector.nextInt();
                
                System.out.println("Introduce el correo del alumno");
                String correo = lector.next();
                
                System.out.println("Introduce el celular del alumno");
                String celular = lector.next();
                
                // Se crea un objeto para guardar la información de cada alumno
                Alumno a = new Alumno();
                a.setCedula(cedula);
                a.setNombre(nombre);
                a.setApellido(apellido);
                a.setSemestre(semestre);
                a.setCorreo(correo);
                a.setCelular(celular);
            
                // Se agrega el valos del objeto al ArrayList
                misAlumnos.add(a);
                
                break;
                
            case 2:
                System.out.println("Opción 2");
                break;
                
            case 3:
                System.out.println("Opción 3");
                break;
                
            case 4:
                System.out.println("Opción 4");
                break;
                
            case 5:
                System.out.println("Gracias por ingresas, nos vemos pronto!");
                activo = false;
                break;
                
            default:
                System.out.println("Debe seleccionar una de las opciones del menú");
                break;
            }
        
        } while(activo);
    }
}