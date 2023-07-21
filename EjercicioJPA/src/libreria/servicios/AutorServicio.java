/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author jorge
 */
public class AutorServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorDAO ADAO = new AutorDAO();

    public Autor nuevoAutor() {
        Autor A = new Autor();
        try {
            System.out.println("Ingrese el nombre del autor");
            A.setNombre(leer.next());
            A.setAlta(true);
            ADAO.nuevoAutor(A);
            System.out.println("AUTOR INGRESADO A LA BD");
        } catch (Exception e) {
            System.err.println("Error en datos ingresados");
        }
        return A;
    }

    public void editarAutor() throws Exception {
        Autor A = new Autor();
        System.out.println("Ingrese el ID del Autor a Editar");
        A.setId(leer.nextLong());
        System.out.println("Ingrese el Nombre Modificado");
        A.setNombre(leer.next());
        A.setAlta(true);
        ADAO.editarAutor(A);
        System.out.println("AUTOR ACTUALIZADO");
    }

    public void bajaAltaAutor() throws Exception {
        System.out.println("Ingrese el nro de ID a dar de Baja/Alta");
        Long id = leer.nextLong();
        ADAO.bajaAltaAutor(id);
    }

    public void mostrarTodosAutores(Integer n) throws Exception {
        List<Autor> autores = new ArrayList();
        switch (n) {
            case 1:
                autores = ADAO.mostrarTodosAutores();
                break;
            case 2:
                System.out.println("Ingrese el Nombre del Autor");
                String nombre = leer.next();
                autores = ADAO.mostrarAutoresPorNombre(nombre);
                break;
            case 3:
                System.out.println("Ingrese el ID del Autor");
                String id = leer.next();
                autores = ADAO.mostrarAutoresPorID(id);
                break;
        }
        if (autores.isEmpty()) {
            System.err.println("NO HAY DATOS QUE COINCIDAN CON LA BUSQUEDA ACTUAL");
        } else {
            System.out.printf("%-5s %-10s %-10s\n", "ID", "ALTA", "NOMBRE AUTOR");
            System.out.println("---------------------------------");
            for (Autor autor : autores) {
                System.out.printf("%-5s %-10s %-10s\n",
                        autor.getId(),
                        autor.getAlta(),
                        autor.getNombre());
            }
            System.out.println("---------------------------------");
        }
    }

    public Autor buscarAutor(Long id) throws Exception {
        Autor A = ADAO.buscarAutor(id);
        return A;
    }

}
