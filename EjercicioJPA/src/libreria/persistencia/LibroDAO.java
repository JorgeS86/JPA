/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Libro;

/**
 *
 * @author jorge
 */
public class LibroDAO extends DAO {

    public void nuevoLibro(Object L) {
        try {
            guardar(L);
        } catch (Exception e) {
            System.err.println("ERROR AL CREAR LIBRO");
        }
    }

    public void editarLibro(Object L) throws Exception {
        try {
            editar(L);
        } catch (Exception e) {
            System.err.println("Error al intentar Editar Libro");
        }
    }

    public void bajaAltaLibro(Long id) throws Exception {
        conectar();
        try {
            Libro L = em.find(Libro.class, id);
            desconectar();
            if (L == null) {
                System.err.println("EL ID SELECCIONADO ESTÁ VACIO");
            } else {
                if (L.getAlta()) {
                    L.setAlta(false);
                    System.out.println("Se ha dado de baja el Libro");
                } else {
                    L.setAlta(true);
                    System.out.println("Se ha dado de alta el Libro");
                }
                editar(L);
            }
        } catch (Exception e) {
            System.out.println("Error al intentar dar ALTA/BAJA de la Editorial");
        }
    }

    public List mostrarTodosLibros() throws Exception {
        String jpql = "SELECT l FROM Libro l";
        List L = mostrarLista(jpql);
        return L;
    }

    public List mostrarLibrosPorNombre(String nombre) throws Exception {
        System.out.println("Buscando Libros que incluyan " + nombre);
        String jpql = "SELECT l FROM Libro l WHERE l.titulo LIKE '%" + nombre + "%'";
        List L = mostrarLista(jpql);
        return L;
    }

    public List mostrarLibrosPorID(String id) throws Exception {
        System.out.println("Buscando IDs que incluyan " + id);
        String jpql = "SELECT l FROM Libro l WHERE l.id =" + id;
        List L = mostrarLista(jpql);
        return L;
    }
    
    public List mostrarLibrosPorNombreAutor(String nombreAutor) throws Exception {
        System.out.println("Buscando Libros que incluyan " + nombreAutor);
        String jpql = "SELECT l FROM Libro l JOIN l.autor a WHERE a.nombre LIKE '%" + nombreAutor + "%'";
        List L = mostrarLista(jpql);
        return L;
    }
    
     public Libro buscarLibro(Long id) throws Exception {
        System.out.println("Buscando Libro");
        conectar();
        Libro L = em.find(Libro.class, id);
        desconectar();
        return L;
    }
}
