/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Editorial;

/**
 *
 * @author jorge
 */
public class EditorialDAO extends DAO {

    public void nuevaEditorial(Object E) {
        try {
            guardar(E);
        } catch (Exception e) {
            System.err.println("ERROR AL CREAR EDITORIAL");
        }
    }

    public void editarEditorial(Object E) throws Exception {
        try {
            editar(E);
        } catch (Exception e) {
            System.err.println("Error al intentar Editar Editorial");
        }
    }

    public List mostrarTodasEditoriales() throws Exception {
        String jpql = "SELECT e FROM Editorial e";
        List L = mostrarLista(jpql);
        return L;
    }

    public List mostrarEditorialesPorNombre(String nombre) throws Exception {
        System.out.println("Buscando Editoriales que incluyan " + nombre);
        String jpql = "SELECT e FROM Editorial e WHERE e.nombre LIKE '%" + nombre + "%'";
        List L = mostrarLista(jpql);
        return L;
    }

    public List mostrarEditorialesPorID(String id) throws Exception {
        System.out.println("Buscando IDs que incluyan " + id);
        String jpql = "SELECT e FROM Editorial e WHERE e.id =" + id;
        List L = mostrarLista(jpql);
        return L;
    }

    public void bajaAltaEditorial(Long id) throws Exception {
        conectar();
        try {
            Editorial E = em.find(Editorial.class, id);
            desconectar();
            if (E == null) {
                System.err.println("EL ID SELECCIONADO ESTÁ VACIO");
            } else {
                if (E.getAlta()) {
                    E.setAlta(false);
                    System.out.println("Se ha dado de baja la Editorial");
                } else {
                    E.setAlta(true);
                    System.out.println("Se ha dado de alta la Editorial");
                }
                editar(E);
            }
        } catch (Exception e) {
            System.out.println("Error al intentar dar ALTA/BAJA de la Editorial");
        }
    }
    
    public Editorial buscarEditorial(Long id) throws Exception {
        System.out.println("Buscando Editorial");
        conectar();
        Editorial E = em.find(Editorial.class, id);
        desconectar();
        return E;
    }
}
