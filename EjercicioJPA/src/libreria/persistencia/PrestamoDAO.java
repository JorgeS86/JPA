/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Prestamo;

/**
 *
 * @author jorge
 */
public class PrestamoDAO extends DAO{
    
   public void nuevoPrestamo(Object P) {
        try {
            guardar(P);
        } catch (Exception e) {
            System.err.println("ERROR AL CREAR CLIENTE");
        }
    }

    public List mostrarTodosPrestamos() throws Exception {
        String jpql = "SELECT p FROM Prestamo p";
        List L = mostrarLista(jpql);
        return L;
    }

    public List mostrarPrestamoPorID(String id) throws Exception {
        System.out.println("Buscando IDs que incluyan " + id);
        String jpql = "SELECT p FROM Prestamo p WHERE p.id =" + id;
        List L = mostrarLista(jpql);
        return L;
    }

    public void editarPrestamo(Object C) throws Exception {
        try {
            editar(C);
        } catch (Exception e) {
            System.err.println("Error al intentar Editar Prestamo");
        }
    }

    public Prestamo buscarPrestamo(Integer id) throws Exception {
        System.out.println("Buscando Cliente");
        conectar();
        Prestamo P = em.find(Prestamo.class, id);
        desconectar();
        return P;
    }
    
    public List mostrarPrestamoPorNombreCliente(String nombreCliente) throws Exception {
        System.out.println("Buscando Prestamos que incluyan " + nombreCliente);
        String jpql = "SELECT p FROM Prestamo p JOIN p.cliente c WHERE c.nombre LIKE '%" + nombreCliente + "%'";
        List L = mostrarLista(jpql);
        return L;
    }
}