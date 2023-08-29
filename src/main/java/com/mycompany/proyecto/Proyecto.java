/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;

import Mundo.Alumno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gabriela Delgado
 */
public class Proyecto {

    public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException, IOException {
        
        // Función que permite leer la opción del usuario
        Scanner lector = new Scanner (System.in);
        
        //Bandera que permite terminar el programa
        boolean activo = true;
        
        // ArrayList que almacena los alumnos
        ArrayList <Alumno> misAlumnos = new ArrayList <Alumno>();
        
        // Llamado al metodo para que cargue los alumnos que esten registrados en el sistema (Persistencia)
        leerRegistroAlumnos(misAlumnos);
         
        do{

            // Muestra un menú al usuario
            System.out.println("\n" + "---------MENÚ DE OPCIONES---------" + "\n" +
                               "¿Qué operación quieres hacer?" + "\n" +
                               "1.- Ingresar alumno" + "\n" +
                               "2.- Eliminar alumno" + "\n" +
                               "3.- Modificar alumno" + "\n" +
                               "4.- Consultar alumno" + "\n" +
                               "5.- Generar reporte por semestre" + "\n" +
                               "6.- Terminar programa" + "\n" +
                               "==================================");

            try {
                int opcion = lector.nextInt();

                // switch que permite evaluar la opción y segun la misma realizar una acción
                switch (opcion) {

                    case 1:
                        // LLamando al metodo que permite ingresar alumnos
                        ingresarAlumno(misAlumnos, lector);
                        escribirRegistroAlumnos(misAlumnos);
                        break;

                    case 2:
                        // LLamando al metodo que permite eliminar alumnos
                        eliminarAlumno(misAlumnos, lector);
                        escribirRegistroAlumnos(misAlumnos);
                        break;

                    case 3:
                        // LLamando al metodo que permite modificar un alumno
                        modificarAlumno(misAlumnos, lector);
                        escribirRegistroAlumnos(misAlumnos);
                        break;

                    case 4:
                        // LLamando al metodo que permite consultar la lista de alumnos
                        consultarAlumno(misAlumnos);
                        break;

                    case 5:
                        try {
                            GenerarReporteSemestral(misAlumnos, lector);
                        } catch(Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 6:
                        // Permite salir del programa
                        System.out.println("Gracias por ingresar, vuelve pronto! :)");
                        activo = false;
                        break;

                    default:
                        // Si el usuario selecciona una opción diferente a la del menú principal se envia un mensaje
                        System.out.println("Debe seleccionar una de las opciones del menú");
                        break;
                    }
                } catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Los datos ingresados no son validos, porfavor verifique la información");
                }
            } while(activo);
    }
    
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Metodo que permite ingresar un alumno al sistema
     * @param misAlumnos ArrayList que guarda los alumnos ingresados al sistema
     * @param lector Scanner que recibe la entrada del usuario
     */
    public static void ingresarAlumno(ArrayList <Alumno> misAlumnos, Scanner lector)
    {
    	// Variable de tipo boolean que verifica si la cédula a ingresar ya esta registrada en el sistema
        boolean registrada = false;

        // Mensaje inicial opción 1
        System.out.println("\n" + "-----------------INGRESAR ALUMNO-----------------" + "\n" +
                                  "-------------------------------------------------" + "\n");
        
        // try - catch que atrapa los posibles errores de ingresar valores incorrectos
        try {
            System.out.println("Introduce la cédula del alumno");
            String cedula = lector.next();

            // Condicional if que verifica que la cédula solo contenga números, de lo contrario se envia mensaje de error
            if (!cedula.matches("\\d+")){
                throw new InputMismatchException();
            }

            // Recorre el arrayList para verificar que la cédula a ingresar no este registrada en el sistema
            for (int i = 0; i < misAlumnos.size(); i++){
                Alumno alumno = misAlumnos.get(i);
                if (alumno.getCedula().equals(cedula))
                {
                    registrada = true;
                }
            }
            
            // Si la cédula no esta en el sistema continua con el proceso de ingreso del alumno
            if (registrada != true){
                System.out.println("\n" +"Introduce el nombre del alumno");
                String nombre = lector.next();
                if (nombre.matches(".*[0-9].*")){
                    throw new InputMismatchException();
                }

                System.out.println("\n" + "Introduce el apellido del alumno");
                String apellido = lector.next();
                if (apellido.matches(".*[0-9].*")){
                    throw new InputMismatchException();
                }

                System.out.println("\n" +"Introduce el semestre del alumno");
                int semestre = lector.nextInt();

                System.out.println("\n" +"Introduce el correo del alumno");
                String correo = lector.next();

                System.out.println("\n" +"Introduce el celular del alumno");
                String celular = lector.next();
                if (!celular.matches("\\d+")){
                    throw new InputMismatchException();
                }

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

                System.out.println("\n" + "ALUMNO REGISTRADO CORRECTAMENTE" + "\n" +
                                   "-------------------------------");
            // Si se intenta ingresar un alumno con una cédula que ya esta en el sistema, se envia un mensaje informando al usuario
            } else {
                System.out.println("La cédula del alumno que intenta ingresar ya se encuentra registrada");
            }
        // Atrapa los posibles errores de ingresar un tipo de dato incorrecto
        } catch (InputMismatchException | NumberFormatException e){
            System.out.println("Los datos ingresados no son validos, porfavor verifique la información");
        }
    }
    
    /**
     * Metodo que permite eliminar un alumno al sistema
     * @param misAlumnos ArrayList que guarda los alumnos ingresados al sistema
     * @param lector Scanner que recibe la entrada del usuario
     */
    public static void eliminarAlumno(ArrayList <Alumno> misAlumnos, Scanner lector) 
    {
        // Mensaje inicial opción 2
        System.out.println("\n" + "-----------------ELIMINAR ALUMNO-----------------" + "\n" +
                           "-------------------------------------------------" + "\n");

        // Variable de tipo boolean que sera true si existe el número de cédula del alumno que se desea eliminar, si es falso envia un mensaje informando la situación
        boolean encontrarAlumnoEliminar = false;

        // try - catch que atrapa los posibles errores de ingresar valores incorrectos
        try{ 
        // Condicional if que evalua si hay algun alumno para eliminar, en el caso contrario envia un mensaje informando la situación
        if (misAlumnos.size() > 0)
        {
            // El usuario debe ingresar la cédula del alumno que desea eliminar
            System.out.println("Introduce la cédula del alumno que desea eliminar");
            String alumnoEliminar = lector.next();
            // Excepción que envia mensaje de error si el usuario digita un tipo de dato incorrecto
            if (!alumnoEliminar.matches("\\d+")){
                throw new InputMismatchException();
            }

            // Ciclo for que recorre los datos del arrayList llamado misAlumnos
            for (int i = 0; i < misAlumnos.size(); i ++)
            {
                // Condicional if que evalua si la cédula ingresada por el usuario es igual a la cédula de un alumno especifico del ArrayList 
                if (misAlumnos.get(i).getCedula().equals(alumnoEliminar))
                {
                    encontrarAlumnoEliminar = true;
                    Alumno alumno = misAlumnos.get(i);
                    // Mensaje para confirmar si el usuario desea eliminar al alumno, en caso contrario sale de la opción dos
                    System.out.println("Esta seguro que desea eliminar a el alumno " + alumno.getNombre() + " de cédula: " + alumnoEliminar + "\n" +
                                       "Digite (si) para eliminar el alumno o digite (x) si desea cancelar la eliminación (en minusculas)");
                    String eliminar = lector.next();
                    if (eliminar.matches(".*[0-9].*")){
                        throw new InputMismatchException();
                    }

                    // Evalua si el usuario esta seguro de eliminar al alumno seleccionado
                    if (eliminar.equals("si"))
                    {
                        misAlumnos.remove(i);
                        System.out.println("\n" + "EL ALUMNO DE CÉDULA " + alumnoEliminar + " HA SIDO ELIMINADO" + "\n" +
                                               "------------------------------------------------------------");
                    } else {
                        System.out.println("Eligio la opción de cancelar, el alumno " + alumnoEliminar + " NO ha sigo eliminado");
                    }
                }
            }
            // Si no hay alumnos con la cédula ingresada por el usuario, se envia un mensaje informando la situación
            if (!encontrarAlumnoEliminar)
            {
                System.out.println("No se encontro alumnos con el número de cédula ingresado");
            }
        // Si no hay alumnos registrados se envia un mensaje informando la situación
        } else {
            System.out.println("EL REGISTRO DE ALUMNOS ESTA VACIO" + "\n" +
                               "=================================");
        }
        // Atrapa los posibles errores de ingresar un tipo de dato incorrecto
        } catch (InputMismatchException | NumberFormatException e){
            System.out.println("Los datos ingresados no son validos, porfavor verifique la información");
        }   
    }
    
    /**
     * Metodo que permite modificar los datos de un alumno en el sistema
     * @param misAlumnos ArrayList que guarda los alumnos ingresados al sistema
     * @param lector Scanner que recibe la entrada del usuario
     */
    public static void modificarAlumno(ArrayList <Alumno> misAlumnos, Scanner lector)
    {
        // Mensaje inicial opción 3
        System.out.println("\n" + "----------------MODIFICAR ALUMNO-----------------" + "\n" +
                                  "-------------------------------------------------" + "\n");

        // Variable de tipo boolean que sera true si existe el número de cédula del alumno que se desea eliminar, si es falso envia un mensaje informando la situación
        boolean encontrarAlumno = false;

        try 
        {
        // Condicional if que evalua si hay algun alumno para modificar, en el caso contrario envia un mensaje informando la situación
        if (misAlumnos.size() > 0)
        {
            System.out.println("Ingrese la cédula del alumno que desea modificar");
            String cedulaModificar = lector.next();
            if (!cedulaModificar.matches("\\d+")){
                throw new InputMismatchException();
            }

            // Variable de tipo boolean que en caso de ser true seguira mostrando el menú para modificar, si es false sale de la opción 3
            boolean opcionSalir = true;

            // Ciclo for que recorre los datos del arrayList llamado misAlumnos
            for (int i = 0; i < misAlumnos.size(); i ++)
            {
                if (misAlumnos.get(i).getCedula().equals(cedulaModificar)){
                    Alumno alumno = misAlumnos.get(i);
                    encontrarAlumno = true;
                    // Muestra los datos del alumno elegido para modificar
                    System.out.println("\n" + "Los datos del alumno elegido son:" + "\n" +
                                       "Cédula: " + alumno.getCedula() + "\n" +
                                       "Nombre: " + alumno.getNombre() + "\n" +
                                       "Apellido: " + alumno.getApellido() + "\n" +
                                       "Semestre: " + alumno.getSemestre() + "\n" +
                                       "Correo: " + alumno.getCorreo() + "\n" +
                                       "Celular: " + alumno.getCelular() + "\n" +
                                       "================================");
                    do {
                        // Muestra un menú de opciones con los datos que se pueden modificar
                        System.out.println("\n" + "Ingrese el dato que desea modificar" + "\n" +
                                           "Opción 1: Modificar cédula" + "\n" +
                                           "Opción 2: Modificar nombre" + "\n" +
                                           "Opción 3: Modificar apellido" + "\n" +
                                           "Opción 4: Modificar semestre" + "\n" +
                                           "Opción 5: Modificar correo" + "\n" +
                                           "Opción 6: Modificar celular" + "\n" +
                                           "Para salir de esta opción digite 0" + "\n");

                        int datoModificar = lector.nextInt();

                        // Según el dato a modificar se realiza el proceso de cambio de datos, dato antiguo por dato modificado
                        switch (datoModificar){

                            case 1 -> {
                                System.out.println("\n" + "Digite la cédula nueva");
                                String cedulaModificada = lector.next();
                                if (!cedulaModificada.matches("\\d+")){
                                    throw new InputMismatchException();
                                }
                                alumno.setCedula(cedulaModificada);
                            }

                            case 2 -> {
                                System.out.println("\n" + "Digite el nuevo nombre del alumno");
                                String nombreModificado = lector.next();
                                if (nombreModificado.matches(".*[0-9].*")){
                                    throw new InputMismatchException();
                                }
                                alumno.setNombre(nombreModificado);
                            }

                            case 3 -> {
                                System.out.println("\n" + "Digite el nuevo apellido del alumno");
                                String apellidoModificado = lector.next();
                                if (apellidoModificado.matches(".*[0-9].*")){
                                    throw new InputMismatchException();
                                }
                                alumno.setApellido(apellidoModificado);
                            }

                            case 4 -> {
                                System.out.println("\n" + "Digite el nuevo semestre del alumno");
                                int semestreModificado = lector.nextInt();
                                alumno.setSemestre(semestreModificado);
                            }

                            case 5 -> {
                                System.out.println("\n" + "Digite el nuevo correo del alumno");
                                String correoModificado = lector.next();
                                alumno.setCorreo(correoModificado);
                            }

                            case 6 -> {
                                System.out.println("\n" + "Digite el nuevo celular del alumno");
                                String celularModificado = lector.next();
                                if (!celularModificado.matches("\\d+")){
                                    throw new InputMismatchException();
                                }
                                alumno.setCelular(celularModificado);
                            }

                            case 0 -> {
                                System.out.println("\n" + "LOS DATOS FUERON MODIFICADOS CORRECTAMENTE" + "\n" +
                                        "-------------------------------------------------");
                                opcionSalir = false;
                            }
                            default -> System.out.println("El dato ingresado no es valido, por favor selecciona una de las opciones del menú" + "\n");
                        }
                        // Si el usuario ingresa un valor diferente al del menú, se envia un mensaje informando la situación
                    } while (opcionSalir);
                }
            // Si no hay alumnos con la cédula ingresada por el usuario, se envia un mensaje informando la situación
            } if (!encontrarAlumno) {
                System.out.println("No se encontro alumnos con el número de cédula ingresado");
            }   
        // Si no hay alumnos registrados se envia un mensaje informando la situación
        } else {
            System.out.println("EL REGISTRO DE ALUMNOS ESTA VACIO" + "\n" +
                               "---------------------------------");
        } 
        // Atrapa los posibles errores de ingresar un tipo de dato incorrecto
        } catch (InputMismatchException | NumberFormatException e){
            System.out.println("Los datos ingresados no son validos, porfavor verifique la información");
        }
    }
    
    /**
     * Metodo que permite consultar la lista de alumnos del sistema
     * @param misAlumnos ArrayList que guarda los alumnos ingresados al sistema
     */
    public static void consultarAlumno(ArrayList <Alumno> misAlumnos)
    {
        // Mensaje inicial opción 4
        System.out.println("\n" + "-----------------CONSULTAR ALUMNO-----------------" + "\n" +
                                  "--------------------------------------------------" + "\n");
        // Condicional if que evalua si hay algun alumno para eliminar, en el caso contrario envia un mensaje informando la situación
        if (misAlumnos.size() > 0){

            // Mensaje inicial de la opción consultar alumnos
            System.out.println("LOS ALUMNOS REGISTRADOS SON:" + "\n");

            // Ciclo for que recorre los datos del arrayList llamado misAlumnos
            for (Alumno alumno: misAlumnos)
            {
                System.out.println("Cédula: " + alumno.getCedula() + "\n" +
                                   "Nombre: " + alumno.getNombre() + "\n" +
                                   "Apellido: " + alumno.getApellido() + "\n" +
                                   "Semestre: " + alumno.getSemestre() + "\n" +
                                   "Correo: " + alumno.getCorreo() + "\n" +
                                   "Celular: " + alumno.getCelular() + "\n" +
                                   "\n" + "======================================" + "\n");
            }
        // Si no hay alumnos registrados se envia un mensaje informando la situación
        } else {
            System.out.println("EL REGISTRO DE ALUMNOS ESTA VACIO" + "\n" +
                               "---------------------------------");
        }
    }
    
    /**
     * Metodo que permite generar un reporte de estudiantes del semestre que desee el usuario
     * @param misAlumnos ArrayList que guarda los alumnos ingresados al sistema
     * @param lector Scanner que recibe la entrada del usuario
     * @throws FileNotFoundException Excepción que se lanza en caso de que el archivo no exista
     */
    public static void GenerarReporteSemestral(ArrayList <Alumno> misAlumnos, Scanner lector) throws FileNotFoundException, IllegalArgumentException
    {
        // Mensaje inicial opción 5
        System.out.println("\n" + "------------GENERAR REPORTE SEMESTRAL-------------" + "\n" +
                           "--------------------------------------------------" + "\n");

        // Pregunta a el usuario de que semestre desea generar el reporte
        System.out.println("¿De que semestre deseas generar el reporte");
        int reporteSemestre = lector.nextInt();
        
        // Crear el archivo con la clase FILE
     	File reporteSemestral = new File("./data/reporteSemestral.txt");
     	
        // Mensaje inicial opción 5
        try (PrintWriter pluma = new PrintWriter(reporteSemestral)) {
            // Ciclo for que recorre los datos del arrayList llamado misAlumnos
            for (Alumno alumno : misAlumnos) {
                if (alumno.getSemestre() == reporteSemestre)
                {
                    pluma.println("\n" + "------------GENERAR REPORTE SEMESTRAL-------------" + "\n" +
                    "--------------------------------------------------" + "\n");
                    pluma.println("LOS ALUMNOS REGISTRADOS DEL SEMESTRE " + reporteSemestre +" SON:" + "\n");
                    pluma.println("Cédula: " + alumno.getCedula() + "\n" +
                                  "Nombre: " + alumno.getNombre() + "\n" +
                                  "Apellido: " + alumno.getApellido() + "\n" +
                                  "Semestre: " + alumno.getSemestre() + "\n" +
                                  "Correo: " + alumno.getCorreo() + "\n" +
                                  "Celular: " + alumno.getCelular() + "\n" +
                                  "\n" + "======================================" + "\n");
                    
                    System.out.println("EL REPORTE SE GENERO CORRECTAMENTE" + "\n" +
                            "----------------------------------");
                }
            }
            // Cerrar pluma
            pluma.close();
        }  
        if (misAlumnos.isEmpty()){
            System.out.println("No hay alumnos para mostrar");
        }
    }
    
    /**
     * Metodo que permite leer el reporte del registro de alumnos del sistema
     * @param misAlumnos ArrayList que guarda los alumnos ingresados al sistema
     * @throws FileNotFoundException Excepción que se lanza en caso de que el archivo no exista
     * @throws IOException Excepción que se lanza en caso de que haya errores al leer el archivo
     */
    public static void leerRegistroAlumnos(ArrayList<Alumno> misAlumnos) throws FileNotFoundException, IOException 
    {
        // Crear el archivo con la clase FILE
        File archivo = new File("./data/reporteAlumnos.txt");

        try (FileReader reporteAlumnos = new FileReader(archivo);
             BufferedReader lector = new BufferedReader(reporteAlumnos)) {

            String cadenaCaracteres;
            
            while ((cadenaCaracteres = lector.readLine()) != null) {
                String[] datos = cadenaCaracteres.split(",");

                String cedula = datos[0].trim();
                String nombre = datos[1].trim();
                String apellido = datos[2].trim();
                String semestre = datos[3].trim();
                String correo = datos[4].trim();
                String celular = datos[5].trim();

                int semestreI = Integer.parseInt(semestre);

                Alumno alumno = new Alumno(cedula, nombre, apellido, semestreI, correo, celular);
                misAlumnos.add(alumno);
            }
        } catch (FileNotFoundException e) {
            System.out.println("En el momento no existen alumnos registrados en el sistema :(");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Metodo que permite escribir el reporte del registro de alumnos del sistema
     * @param misAlumnos ArrayList que guarda los alumnos ingresados al sistema
     * @throws FileNotFoundException Excepción que se lanza en caso de que el archivo no exista
     */
    public static void escribirRegistroAlumnos(ArrayList <Alumno> misAlumnos) throws FileNotFoundException
    {
        // Crear archivo en la clase FILE
        File archivo = new File("./data/reporteAlumnos.txt");

        try (PrintWriter pluma = new PrintWriter(archivo)) {
            // Ciclo for que recorre los datos del arrayList llamado misAlumnos
            for (Alumno alumno: misAlumnos)
            {
                    String cadenaCaracteres = alumno.getCedula() + "," + alumno.getNombre() + "," + alumno.getApellido() + "," +
                                              alumno.getSemestre() + "," + alumno.getCorreo() + "," + alumno.getCelular();
                    pluma.write(cadenaCaracteres);
                    pluma.write("\n");
            }
            pluma.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}