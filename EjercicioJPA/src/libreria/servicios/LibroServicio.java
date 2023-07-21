/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author jorge
 */
public class LibroServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    LibroDAO LDAO = new LibroDAO();
    AutorServicio AS = new AutorServicio();
    EditorialServicio ES = new EditorialServicio();

    public void nuevoLibro() throws Exception {
        Libro L = new Libro();
        System.out.println("Ingrese el Titulo del Libro");
        L.setTitulo(leer.next());
        System.out.println("Ingrese el año de Edicion");
        L.setAnio(leer.nextInt());
        System.out.println("Ingrese la cantidad de Ejemplares");
        L.setEjemplares(leer.nextInt());
        L.setEjemplaresRestantes(L.getEjemplares());
        L.setEjemplaresPrestados(L.getEjemplares());
        L.setAlta(true);

        System.out.println("El libro pertenece a un Autor Nuevo?(S/N)");
        if (leer.next().equalsIgnoreCase("S")) {
            L.setAutor(AS.nuevoAutor());
        } else {
            System.out.println("Seleccione Autor Existente");
            AS.mostrarTodosAutores(1);
            System.out.println("Seleccione el ID del Autor para el Libro Nuevo");
            Long id = leer.nextLong();
            Autor X = AS.buscarAutor(id);
            System.out.println(X);
            L.setAutor(X);
        }

        System.out.println("El libro pertenece a una Editorial Nueva?(S/N)");
        if (leer.next().equalsIgnoreCase("S")) {
            L.setEditorial(ES.nuevaEditorial());
        } else {
            System.out.println("Seleccione Editorial Existente");
            ES.mostrarTodasEditoriales(1);
            System.out.println("Seleccione el ID de la Editorial para el Libro Nuevo");
            Long id = leer.nextLong();
            Editorial X = ES.buscarEditorial(id);
            System.out.println(X);
            L.setEditorial(X);
        }

        LDAO.nuevoLibro(L);
        System.out.println("LIBRO INGRESADO A LA BD");
    }

    public void editarLibro() throws Exception {
        Libro L = new Libro();
        System.out.println("Ingrese el ID del Libro a Editar");
        L.setId(leer.nextLong());
        System.out.println("Ingrese el Titulo Modificado");
        L.setTitulo(leer.next());
        System.out.println("Ingrese el año de Edicion");
        L.setAnio(leer.nextInt());
        System.out.println("Ingrese la cantidad de Ejemplares");
        L.setEjemplaresRestantes(leer.nextInt());
        L.setEjemplaresPrestados(L.getEjemplaresRestantes());
        L.setAlta(true);

        System.out.println("El libro pertenece a un Autor Nuevo?(S/N)");
        if (leer.next().equalsIgnoreCase("S")) {
            L.setAutor(AS.nuevoAutor());
        }

        System.out.println("El libro pertenece a una Editorial Nueva?(S/N)");
        if (leer.next().equalsIgnoreCase("S")) {
            L.setEditorial(ES.nuevaEditorial());
        } else {
            System.out.println("INSERTAR PROCESO PARA TRAER INFO DE EDITORIALES EXISTENTES");
        }

        LDAO.editarLibro(L);
        System.out.println("LIBRO ACTUALIZADO");
    }

    public void bajaAltaLibro() throws Exception {
        System.out.println("Ingrese el nro de ID a dar de Baja/Alta");
        Long id = leer.nextLong();
        LDAO.bajaAltaLibro(id);
    }

    public void mostrarTodosLibros(Integer n) throws Exception {
        List<Libro> libros = new ArrayList();
        switch (n) {
            case 1:
                libros = LDAO.mostrarTodosLibros();
                break;
            case 2:
                System.out.println("Ingrese el Nombre del Libro");
                String nombre = leer.next();
                libros = LDAO.mostrarLibrosPorNombre(nombre);
                break;
            case 3:
                System.out.println("Ingrese el ID del Libro");
                String id = leer.next();
                libros = LDAO.mostrarLibrosPorID(id);
                break;
                 case 4:
                System.out.println("Ingrese el nombre de autor para buscar el libro/s");
                String nombreAutor = leer.next();
                libros = LDAO.mostrarLibrosPorNombreAutor(nombreAutor);
                break;
        }
        if (libros.isEmpty()) {
            System.err.println("NO HAY DATOS QUE COINCIDAN CON LA BUSQUEDA ACTUAL");
        } else {
            System.out.printf("%-5s %-5s %-5s %-30s %-50s %-20s\n", "ID", "ALTA", "AÑO", "TITULO LIBRO", "AUTOR", "EDITORIAL");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Libro libro : libros) {
                System.out.printf("%-5s %-5s %-5s %-30s %-50s %-20s\n",
                        libro.getId(),
                        libro.getAlta(),
                        libro.getAnio(),
                        libro.getTitulo(),
                        libro.getAutor().getNombre(),
                        libro.getEditorial().getNombre());
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
//MOSTRAR POR MEDIO DE BUSQUEDA EN UN ARRAYLIST
//    public void mostrarLibrosxAutor() throws Exception {
//        System.out.println("Ingrese el nombre de autor para buscar el libro/s");
//        String nombreAutor = leer.next();
//        List<Libro> libros = LDAO.mostrarTodosLibros();
//        if (libros.isEmpty()) {
//            System.err.println("NO HAY DATOS QUE COINCIDAN CON LA BUSQUEDA ACTUAL");
//        } else {
//            System.out.printf("%-5s %-5s %-5s %-30s %-50s %-20s\n", "ID", "ALTA", "AÑO", "TITULO LIBRO", "AUTOR", "EDITORIAL");
//            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
//            for (Libro libro : libros) {
//                if (libro.getAutor().getNombre().equalsIgnoreCase(nombreAutor)) {
//                    System.out.printf("%-5s %-5s %-5s %-30s %-50s %-20s\n",
//                        libro.getId(),
//                        libro.getAlta(),
//                        libro.getAnio(),
//                        libro.getTitulo(),
//                        libro.getAutor().getNombre(),
//                        libro.getEditorial().getNombre()); 
//                }
//            }
//            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
//        }
//    }
}
