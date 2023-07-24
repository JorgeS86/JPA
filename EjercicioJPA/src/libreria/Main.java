/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

import java.util.Scanner;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import libreria.servicios.PrestamoServicio;

/**
 *
 * @author jorge
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AutorServicio AS = new AutorServicio();
        EditorialServicio ES = new EditorialServicio();
        LibroServicio LS = new LibroServicio();
        ClienteServicio CS = new ClienteServicio();
        PrestamoServicio PS = new PrestamoServicio();

        boolean salir = true;
        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1-INGRESAR");
            System.out.println("2-EDITAR");
            System.out.println("3-ALTA/BAJA");
            System.out.println("4-MOSTRAR");
            System.out.println("5-PRESTAMO/DEVOLUCION");
            System.out.println("0-SALIR");

            System.out.println("Ingrese la opcion deseada");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    boolean salirNuevo = true;
                    do {
                        System.out.println("SUB-MENU 'NUEVO'");
                        System.out.println("1-NUEVO LIBRO");
                        System.out.println("2-NUEVA EDITORIAL");
                        System.out.println("3-NUEVO AUTOR");
                        System.out.println("4-NUEVO CLIENTE");
                        System.out.println("0-SALIR");

                        System.out.println("Ingrese la opcion deseada");
                        opcion = leer.nextInt();

                        switch (opcion) {
                            case 1:
                                LS.nuevoLibro();
                                break;
                            case 2:
                                ES.nuevaEditorial();
                                break;
                            case 3:
                                AS.nuevoAutor();
                                break;
                            case 4:
                                CS.nuevoCliente();
                                break;
                            case 0:
                                System.out.println("SALIENDO AL MENU ANTERIOR");
                                salirNuevo = false;
                                break;
                            default:
                                System.err.println("SELECCION INVALIDA");
                        }
                    } while (salirNuevo);
                    break;
                case 2:
                    boolean salirEditar = true;
                    do {
                        System.out.println("SUB-MENU 'EDITAR'");
                        System.out.println("1-EDITAR LIBRO");
                        System.out.println("2-EDITAR EDITORIAL");
                        System.out.println("3-EDITAR AUTOR");
                        System.out.println("3-EDITAR CLIENTE");
                        System.out.println("0-SALIR");

                        System.out.println("Ingrese la opcion deseada");
                        opcion = leer.nextInt();

                        switch (opcion) {
                            case 1:
                                LS.editarLibro();
                                break;
                            case 2:
                                ES.editarEditorial();
                                break;
                            case 3:
                                AS.editarAutor();
                                break;
                            case 4:
                                CS.editarCliente();
                                break;
                            case 0:
                                System.out.println("SALIENDO AL MENU ANTERIOR");
                                salirEditar = false;
                                break;
                            default:
                                System.err.println("SELECCION INVALIDA");
                        }
                    } while (salirEditar);
                    break;
                case 3:
                    boolean salirAltBaj = true;
                    do {
                        System.out.println("SUB-MENU 'ALTA/BAJA'");
                        System.out.println("1-ALTA/BAJA LIBRO");
                        System.out.println("2-ALTA/BAJA EDITORIAL");
                        System.out.println("3-ALTA/BAJA AUTOR");
                        System.out.println("0-SALIR");

                        System.out.println("Ingrese la opcion deseada");
                        opcion = leer.nextInt();

                        switch (opcion) {
                            case 1:
                                LS.bajaAltaLibro();
                                break;
                            case 2:
                                ES.bajaAltaEditor();
                                break;
                            case 3:
                                AS.bajaAltaAutor();
                                break;
                            case 0:
                                System.out.println("SALIENDO AL MENU ANTERIOR");
                                salirAltBaj = false;
                                break;
                            default:
                                System.err.println("SELECCION INVALIDA");
                        }
                    } while (salirAltBaj);
                    break;
                case 4:
                    boolean salirMostrar = true;
                    do {
                        System.out.println("SUB-MENU 'MOSTRAR'");
                        System.out.println("1-MOSTRAR LIBROS");
                        System.out.println("2-MOSTRAR EDITORIALES");
                        System.out.println("3-MOSTRAR AUTORES");
                        System.out.println("4-MOSTRAR CLIENTES");
                        System.out.println("0-SALIR");

                        System.out.println("Ingrese la opcion deseada");
                        opcion = leer.nextInt();

                        switch (opcion) {
                            case 1:
                                boolean salirMostrarLibros = true;
                                do {
                                    System.out.println("SUB-MENU 'MOSTRAR LIBROS'");
                                    System.out.println("1-MOSTRAR TODOS LOS LIBROS");
                                    System.out.println("2-MOSTRAR LIBROS POR NOMBRE");
                                    System.out.println("3-MOSTRAR LIBROS POR ID");
                                    System.out.println("4-MOSTRAR LIBROS POR NOMBRE DE AUTOR");
                                    System.out.println("0-SALIR");

                                    System.out.println("Ingrese la opcion deseada");
                                    opcion = leer.nextInt();

                                    switch (opcion) {
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                            LS.mostrarTodosLibros(opcion);
                                            break;
                                        case 0:
                                            System.out.println("SALIENDO AL MENU ANTERIOR");
                                            salirMostrarLibros = false;
                                            break;
                                        default:
                                            System.err.println("SELECCION INVALIDA");
                                    }
                                } while (salirMostrarLibros);
                                break;
                            case 2:
                                boolean salirMostrarEditoriales = true;
                                do {
                                    System.out.println("SUB-MENU 'MOSTRAR EDITORIALES'");
                                    System.out.println("1-MOSTRAR TODAS LAS EDITORIALES");
                                    System.out.println("2-MOSTRAR EDITORIALES POR NOMBRE");
                                    System.out.println("3-MOSTRAR EDITORIALES POR ID");
                                    System.out.println("0-SALIR");

                                    System.out.println("Ingrese la opcion deseada");
                                    opcion = leer.nextInt();

                                    switch (opcion) {
                                        case 1:
                                        case 2:
                                        case 3:
                                            ES.mostrarTodasEditoriales(opcion);
                                            break;
                                        case 0:
                                            System.out.println("SALIENDO AL MENU ANTERIOR");
                                            salirMostrarEditoriales = false;
                                            break;
                                        default:
                                            System.err.println("SELECCION INVALIDA");
                                    }
                                } while (salirMostrarEditoriales);
                                break;
                            case 3:
                                boolean salirMostrarAutores = true;
                                do {
                                    System.out.println("SUB-MENU 'MOSTRAR AUTORES'");
                                    System.out.println("1-MOSTRAR TODOS LOS AUTORES");
                                    System.out.println("2-MOSTRAR AUTORES POR NOMBRE");
                                    System.out.println("3-MOSTRAR AUTORES POR ID");
                                    System.out.println("0-SALIR");

                                    System.out.println("Ingrese la opcion deseada");
                                    opcion = leer.nextInt();

                                    switch (opcion) {
                                        case 1:
                                        case 2:
                                        case 3:
                                            AS.mostrarTodosAutores(opcion);
                                            break;
                                        case 0:
                                            System.out.println("SALIENDO AL MENU ANTERIOR");
                                            salirMostrarAutores = false;
                                            break;
                                        default:
                                            System.err.println("SELECCION INVALIDA");
                                    }
                                } while (salirMostrarAutores);
                                break;
                            case 4:
                                boolean salirMostrarClientes = true;
                                do {
                                    System.out.println("SUB-MENU 'MOSTRAR CLIENTES'");
                                    System.out.println("1-MOSTRAR TODOS LOS CLIENTES");
                                    System.out.println("2-MOSTRAR CLIENTES POR NOMBRE");
                                    System.out.println("3-MOSTRAR CLIENTES POR ID");
                                    System.out.println("0-SALIR");

                                    System.out.println("Ingrese la opcion deseada");
                                    opcion = leer.nextInt();

                                    switch (opcion) {
                                        case 1:
                                        case 2:
                                        case 3:
                                            CS.mostrarTodosClientes(opcion);
                                            break;

                                        case 0:
                                            System.out.println("SALIENDO AL MENU ANTERIOR");
                                            salirMostrarClientes = false;
                                            break;
                                        default:
                                            System.err.println("SELECCION INVALIDA");
                                    }
                                } while (salirMostrarClientes);
                                break;
                            case 0:
                                System.out.println("SALIENDO AL MENU ANTERIOR");
                                salirMostrar = false;
                                break;
                            default:
                                System.err.println("SELECCION INVALIDA");
                        }
                    } while (salirMostrar);
                    break;
                case 5:
                    boolean salirPrestamo = true;
                    do {
                        System.out.println("SUB-MENU 'PRESTAMO / DEVOLUCION'");
                        System.out.println("1-PRESTAMO");
                        System.out.println("2-DEVOLUCION");
                        System.out.println("3-MOSTRAR PRESTAMOS");
                        System.out.println("0-SALIR");

                        System.out.println("Ingrese la opcion deseada");
                        opcion = leer.nextInt();

                        switch (opcion) {
                            case 1:
                                PS.nuevoPrestamo();
                                break;
                            case 2:
                                PS.devolucion();
                                break;
                            case 3:
                                PS.mostrarTodosPrestamos(2);
                                break;
                            case 0:
                                System.out.println("SALIENDO AL MENU ANTERIOR");
                                salirPrestamo = false;
                                break;
                            default:
                                System.err.println("SELECCION INVALIDA");
                        }
                    } while (salirPrestamo);
                    break;
                case 0:
                    System.out.println("SALIENDO DEL SISTEMA");
                    salir = false;
                    break;
                default:
                    System.err.println("SELECCION INVALIDA");
            }
        } while (salir);
    }
}
