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
        System.out.println("\n" + "------------BIENVENID@------------" + "\n" +
                           "---------MENÚ DE OPCIONES---------" + "\n" +
                           "¿Qué operación quieres hacer?" + "\n" +
                           "1.- Ingresar alumno" + "\n" +
                           "2.- Eliminar alumno" + "\n" +
                           "3.- Modificar alumno" + "\n" +
                           "4.- Consultar alumno" + "\n" +
                           "5.- Terminar programa" + "\n" +
                           "==================================");
        
        int opcion = lector.nextInt();
        
        // switch que permite evaluar la opción y segun la misma realizar una acción
        switch (opcion) {
            
            case 1:
                
                // Mensaje inicial opción 1
                System.out.println("\n" + "-----------------INGRESAR ALUMNO-----------------" + "\n" +
                                          "-------------------------------------------------" + "\n");
                
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
                
                System.out.println("\n" + "---ALUMNO REGISTRADO CORRECTAMENTE---" + "\n");
                
                break;
                
            case 2:
                
                // Mensaje inicial opción 2
                System.out.println("\n" + "-----------------ELIMINAR ALUMNO-----------------" + "\n" +
                                          "-------------------------------------------------" + "\n");
                
                // Variable de tipo boolean que sera true si existe el número de cédula del alumno que se desea eliminar, si es falso envia un mensaje informando la situación
                boolean encontrarAlumnoEliminar = false;
                
                // Condicional if que evalua si hay algun alumno para eliminar, en el caso contrario envia un mensaje informando la situación
                if (misAlumnos.size() > 0)
                {
                System.out.println("\n" + "Introduce la cédula del alumno que desea eliminar");
                String alumnoEliminar = lector.next();

                    // Ciclo for que recorre los datos del arrayList llamado misAlumnos
                    for (int i = 0; i < misAlumnos.size(); i ++)
                    {
                        if (misAlumnos.get(i).getCedula().equals(alumnoEliminar))
                        {
                            misAlumnos.remove(i);
                            System.out.println("\n" + "El alumno de cédula: " + alumnoEliminar + "ha sido eliminado" + "\n");
                        }
                    }
                } else {
                    System.out.println("EL REGISTRO DE ALUMNOS ESTA VACIO" + "\n" +
                                       "=================================");
                }
                if (!encontrarAlumnoEliminar)
                {
                    System.out.println("No se encontro alumnos con ese número de cédula" + "\n");
                }
                break;
                
            case 3:
                
                // Mensaje inicial opción 3
                System.out.println("\n" + "----------------MODIFICAR ALUMNO-----------------" + "\n" +
                                          "-------------------------------------------------" + "\n");
                
                // Variable de tipo boolean que sera true si existe el número de cédula del alumno que se desea eliminar, si es falso envia un mensaje informando la situación
                    boolean encontrarAlumno = false;
                
                // Condicional if que evalua si hay algun alumno para modificar, en el caso contrario envia un mensaje informando la situación
                if (misAlumnos.size() > 0)
                {
                    System.out.println("\n" + "Introduce la cédula del alumno que desea modificar");
                    String cedulaModificar = lector.next();

                    // Variable de tipo boolean que en caso de ser true seguira mostrando el menú para modificar, si es false sale de la opción 3
                    boolean opcionSalir = true;
                    
                    // Ciclo for que recorre los datos del arrayList llamado misAlumnos
                    for (int i = 0; i < misAlumnos.size(); i ++)
                    {
                        if (misAlumnos.get(i).getCedula().equals(cedulaModificar)){
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
                                               "Si desea salir de esta opción digite s");
//                                               "Opción 1: Modificar cédula" + "\n" +
//                                               "Opción 2: Modificar nombre" + "\n" +
//                                               "Opción 3: Modificar apellido" + "\n" +
//                                               "Opción 4: Modificar semestre" + "\n" +
//                                               "Opción 5: Modificar correo" + "\n" +
//                                               "Opción 6: Modificar celular" + "\n" +
//                                               "Para salir de esta opción digite 0" + "\n");

                            String datoModificar = lector.next();

                                switch (datoModificar){
                                    case "cedula":
                                        System.out.println("\n" + "Digite la cédula nueva");
                                        String cedulaModificada = lector.next();
                                        alumno.setCedula(cedulaModificada);
                                        break;

                                    case "nombre":
                                        System.out.println("\n" + "Digite el nuevo nombre del alumno");
                                        String nombreModificado = lector.next();
                                        alumno.setNombre(nombreModificado);
                                        break;

                                    case "apellido":
                                        System.out.println("\n" + "Digite el nuevo apellido del alumno");
                                        String apellidoModificado = lector.next();
                                        alumno.setApellido(apellidoModificado);
                                        break;

                                    case "semestre":
                                        System.out.println("\n" + "Digite el nuevo semestre del alumno");
                                        int semestreModificado = lector.nextInt();
                                        alumno.setSemestre(semestreModificado);
                                        break;

                                    case "correo":
                                        System.out.println("\n" + "Digite el nuevo correo del alumno");
                                        String correoModificado = lector.next();
                                        alumno.setCorreo(correoModificado);
                                        break;

                                    case "celular":
                                        System.out.println("\n" + "Digite el nuevo celular del alumno");
                                        String celularModificado = lector.next();
                                        alumno.setCelular(celularModificado);
                                        break;
                                        
                                    case "s":
                                        System.out.println("LOS DATOS NUEVOS FUERON MODIFICADOS CORRECTAMENTE" + "\n");
                                        opcionSalir = false;
                                        break;
                                        
                                    default:
                                        System.out.println("Los datos ingresados no son validos, por favor verifica la información" + "\n");
                                }
                            }  while (opcionSalir);
                        }
                    }
                } else {
                    System.out.println("EL REGISTRO DE ALUMNOS ESTA VACIO" + "\n" +
                                       "=================================");
                }
            if (!encontrarAlumno)
            {
                System.out.println("No se encontro alumnos con el número de cédula ingresado");
            }
            break;

            case 4:
                
                // Mensaje inicial opción 4
                System.out.println("\n" + "-----------------CONSULTAR ALUMNO-----------------" + "\n" +
                                          "-------------------------------------------------" + "\n");
                // Condicional if que evalua si hay algun alumno para eliminar, en el caso contrario envia un mensaje informando la situación
                if (misAlumnos.size() > 0){
                
                // Mensaje inicial de la opción consultar alumnos
                System.out.println("\n" + "LOS ALUMNOS REGISTRADOS SON:" + "\n");
                
                // Ciclo for que recorre los datos del arrayList llamado misAlumnos
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