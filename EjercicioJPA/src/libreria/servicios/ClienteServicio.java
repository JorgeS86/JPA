/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDAO;

/**
 *
 * @author jorge
 */
public class ClienteServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ClienteDAO CDAO = new ClienteDAO();

    public Cliente nuevoCliente() {
        Cliente C = new Cliente();
        try {
            System.out.println("Ingrese el Documento del Cliente");
            C.setDocumento(leer.nextLong());
            System.out.println("Ingrese el nombre del Cliente");
            C.setNombre(leer.next());
            System.out.println("Ingrese el apellido del Cliente");
            C.setApellido(leer.next());
            System.out.println("Ingrese nro de Telefono");
            C.setTelefono(leer.next());
            CDAO.nuevoCliente(C);
            System.out.println("CLIENTE INGRESADO A LA BD");
        } catch (Exception e) {
            System.err.println("Error en datos ingresados");
        }
        return C;
    }

    public void editarCliente() throws Exception {
        Cliente C = new Cliente();
        System.out.println("Ingrese el ID del Cliente a Editar");
        C.setId(leer.nextInt());
        System.out.println("INGRESE LOS DATOS A MODIFICAR");
        System.out.println("Ingrese el nombre del Cliente");
        C.setNombre(leer.next());
        System.out.println("Ingrese el apellido del Cliente");
        C.setApellido(leer.next());
        System.out.println("Ingrese nro de Telefono");
        C.setTelefono(leer.next());
        C.setNombre(leer.next());

        CDAO.editarCliente(C);
        System.out.println("CLIENTE ACTUALIZADO");
    }

    public void mostrarTodosClientes(Integer n) throws Exception {
        List<Cliente> clientes = new ArrayList();
        switch (n) {
            case 1:
                clientes = CDAO.mostrarTodosClientes();
                break;
            case 2:
                System.out.println("Ingrese el Nombre del Autor");
                String nombre = leer.next();
                clientes = CDAO.mostrarClientesPorNombre(nombre);
                break;
            case 3:
                System.out.println("Ingrese el ID del Autor");
                String id = leer.next();
                clientes = CDAO.mostrarClientesPorID(id);
                break;
        }
        if (clientes.isEmpty()) {
            System.err.println("NO HAY DATOS QUE COINCIDAN CON LA BUSQUEDA ACTUAL");
        } else {
            System.out.printf("%-5s %-10s %-10s %-10s %-10s\n", "ID", "DOCUMENTO", "NOMBRE", "APELLIDO", "TELEFONO");
            System.out.println("---------------------------------");
            for (Cliente cliente : clientes) {
                System.out.printf("%-5s %-10s %-10s %-10s %-10s\n",
                        cliente.getId(),
                        cliente.getDocumento(),
                        cliente.getNombre(),
                        cliente.getApellido(),
                        cliente.getTelefono());
            }
            System.out.println("---------------------------------");
        }
    }

    public Cliente buscarCliente(Integer id) throws Exception {
        Cliente C = CDAO.buscarCliente(id);
        return C;
    }

}
