/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Cliente;

/**
 *
 * @author jorge
 */
public class ClienteDAO extends DAO{
   public void nuevoCliente(Object C) {
        try {
            guardar(C);
        } catch (Exception e) {
            System.err.println("ERROR AL CREAR CLIENTE");
        }
    }

    public List mostrarTodosClientes() throws Exception {
        String jpql = "SELECT c FROM Cliente c";
        List L = mostrarLista(jpql);
        return L;
    }

    public List mostrarClientesPorNombre(String nombre) throws Exception {
        System.out.println("Buscando Clientes que incluyan " + nombre);
        String jpql = "SELECT c FROM Cliente c WHERE c.nombre LIKE '%" + nombre + "%'";
        List L = mostrarLista(jpql);
        return L;
    }

    public List mostrarClientesPorID(String id) throws Exception {
        System.out.println("Buscando IDs que incluyan " + id);
        String jpql = "SELECT c FROM Cliente c WHERE c.id =" + id;
        List L = mostrarLista(jpql);
        return L;
    }

    public void editarCliente(Object C) throws Exception {
        try {
            editar(C);
        } catch (Exception e) {
            System.err.println("Error al intentar Editar Cliente");
        }
    }

    public Cliente buscarCliente(Integer id) throws Exception {
        System.out.println("Buscando Cliente");
        conectar();
        Cliente C = em.find(Cliente.class, id);
        desconectar();
        return C;
    }
}
