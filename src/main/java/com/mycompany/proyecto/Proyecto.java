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
        ArrayList <Alumno> misAlumnos = new ArrayList <Alumno>();
        
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
                System.out.println("\n" + "Introduce la cédula del alumno");
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
            
                // Se agrega el valor del objeto al ArrayList
                misAlumnos.add(a);
                
                System.out.println("\n" + "Alumno registrado" + "\n");
                
                break;
                
            case 2:
                System.out.println("Opción 2");
                break;
                
            case 3:
                
                if (misAlumnos.size() > 0)
                {
                    System.out.println("\n" + "Introduce la cédula del alumno que desea modificar");
                    String cedulaModificar = lector.next();

                    boolean encontrarAlumno;
                    boolean salirOpcion = true;

                    for (int i = 0; i < misAlumnos.size(); i ++)
                    {
                        if (misAlumnos.get(i).getCedula().equals(cedulaModificar)){
                            encontrarAlumno = true;
                            Alumno alumno = misAlumnos.get(i);
                            System.out.println("\n" + "Los datos del alumno elegido son:" + "\n" +
                                               "Cédula: " + alumno.getCedula() + "\n" +
                                               "Nombre: " + alumno.getNombre() + "\n" +
                                               "Apellido: " + alumno.getApellido() + "\n" +
                                               "Semestre: " + alumno.getSemestre() + "\n" +
                                               "Correo: " + alumno.getCorreo() + "\n" +
                                               "Celular: " + alumno.getCelular() + "\n" +
                                               "======================================");

                            do {

                            System.out.println("\n" + "Ingrese el dato que desea modificar" + "\n" +
                                               "Opción 1: Modificar cédula" + "\n" +
                                               "Opción 2: Modificar nombre" + "\n" +
                                               "Opción 3: Modificar apellido" + "\n" +
                                               "Opción 4: Modificar semestre" + "\n" +
                                               "Opción 5: Modificar correo" + "\n" +
                                               "Opción 6: Modificar celular" + "\n" +
                                               "Para salir de esta opción digite 0" + "\n");

                            int datoModificar = lector.nextInt();

                                switch (datoModificar){
                                    case 1:
                                        System.out.println("Digite la cédula nueva");
                                        String cedulaModificada = lector.next();
                                        alumno.setCedula(cedulaModificada);
                                        break;

                                    case 2:
                                        System.out.println("Digite el nuevo nombre del alumno");
                                        String nombreModificado = lector.next();
                                        alumno.setNombre(nombreModificado);
                                        break;

                                    case 3:
                                        System.out.println("Digite el nuevo apellido del alumno");
                                        String apellidoModificado = lector.next();
                                        alumno.setApellido(apellidoModificado);
                                        break;

                                    case 4:
                                        System.out.println("Digite el nuevo semestre del alumno");
                                        int semestreModificado = lector.nextInt();
                                        alumno.setSemestre(semestreModificado);
                                        break;

                                    case 5:
                                        System.out.println("Digite el nuevo correo del alumno");
                                        String correoModificado = lector.next();
                                        alumno.setCorreo(correoModificado);
                                        break;

                                    case 6:
                                        System.out.println("Digite el nuevo celular del alumno");
                                        String celularModificado = lector.next();
                                        alumno.setCelular(celularModificado);
                                        break;

                                    default:
                                        System.out.println("Los datos nuevos se guardaron correctamente");
                                        salirOpcion = false;
                                }
                            }  while (salirOpcion);
                        }   
                    }

                    if (encontrarAlumno = false){
                        System.out.println("No se encontro alumnos con ese número de cédula");
                    }
                } else {
                    System.out.println("EL REGISTRO DE ALUMNOS ESTA VACIO");
                }
                break;
                
                
            case 4:
                
                if (misAlumnos.size() > 0){
                // Mensaje inicial de la opción consultar alumnos
                System.out.println("\n" + "LOS ALUMNOS REGISTRADOS SON:" + "\n");
                
                // Ciclo for que recorre que es menor al tamaño del arrayList misAlumnos
                    for (int i = 0; i < misAlumnos.size(); i ++)
                    {
                        Alumno alumno = misAlumnos.get(i);
                        System.out.println("Cédula: " + alumno.getCedula() + "\n" +
                                           "Nombre: " + alumno.getNombre() + "\n" +
                                           "Apellido: " + alumno.getApellido() + "\n" +
                                           "Semestre: " + alumno.getSemestre() + "\n" +
                                           "Correo: " + alumno.getCorreo() + "\n" +
                                           "Celular: " + alumno.getCelular() + "\n" +
                                           "\n" + "======================================" + "\n");
                    }
                } else {
                    System.out.println("\n" + "En el momento no hay alumnos registrados" + "\n");
                }
                break;
                
            case 5:
                System.out.println("Gracias por ingresar, vuelve pronto!");
                activo = false;
                break;
                
            default:
                System.out.println("Debe seleccionar una de las opciones del menú");
                break;
            }
        
        } while(activo);
    }
}