/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

/**
 *
 * @author jorge
 */
public class AutorDAO extends DAO {

    public void nuevoAutor(Object A) {
        try {
            guardar(A);
        } catch (Exception e) {
            System.err.println("ERROR AL CREAR AUTOR");
        }
    }

    public List mostrarTodosAutores() throws Exception {
        String jpql = "SELECT a FROM Autor a";
        List L = mostrarLista(jpql);
        return L;
    }

    public List mostrarAutoresPorNombre(String nombre) throws Exception {
        System.out.println("Buscando autores que incluyan " + nombre);
        String jpql = "SELECT a FROM Autor a WHERE a.nombre LIKE '%" + nombre + "%'";
        List L = mostrarLista(jpql);
        return L;
    }

    public List mostrarAutoresPorID(String id) throws Exception {
        System.out.println("Buscando IDs que incluyan " + id);
        String jpql = "SELECT a FROM Autor a WHERE a.id =" + id;
        List L = mostrarLista(jpql);
        return L;
    }

    public void editarAutor(Object A) throws Exception {
        try {
            editar(A);
        } catch (Exception e) {
            System.err.println("Error al intentar Editar Autor");
        }
    }

    public void bajaAltaAutor(Long id) throws Exception {
        conectar();
        try {
            Autor A = em.find(Autor.class, id);
            desconectar();
            if (A == null) {
                System.err.println("EL ID SELECCIONADO ESTÁ VACIO");
            } else {
                if (A.getAlta()) {
                    A.setAlta(false);
                    System.out.println("Se ha dado de baja el Autor");
                } else {
                    A.setAlta(true);
                    System.out.println("Se ha dado de alta el Autor");
                }
                editar(A);
            }
        } catch (Exception e) {
            System.out.println("Error al intentar dar ALTA/BAJA de la Editorial");
        }
    }

    public Autor buscarAutor(Long id) throws Exception {
        System.out.println("Buscando Autor");
        conectar();
        Autor A = em.find(Autor.class, id);
        desconectar();
        return A;
    }
}
