/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.PrestamoDAO;

/**
 *
 * @author jorge
 */
public class PrestamoServicio {
   Scanner leer = new Scanner(System.in).useDelimiter("\n");
    PrestamoDAO PDAO = new PrestamoDAO();
    LibroServicio LS = new LibroServicio();
    ClienteServicio CS = new ClienteServicio();

    public Prestamo nuevoPrestamo() {
        Prestamo P = new Prestamo();
        try {
            System.out.println("Libros Disponibles");
            LS.mostrarTodosLibros(1);
            System.out.println("Seleccione el ID del Libro para el Libro Nuevo");
            Long id = leer.nextLong();
            Libro LX = LS.buscarLibro(id);
            LX.setEjemplaresPrestados(LX.getEjemplaresPrestados()+1);
            LX.setEjemplaresRestantes(LX.getEjemplares()-LX.getEjemplaresPrestados());
            System.out.println(LX);
            //ver como editar el libro
            P.setLibro(LX);

        System.out.println("El Cliente es Nuevo?(S/N)");
        if (leer.next().equalsIgnoreCase("S")) {
            P.setCliente(CS.nuevoCliente());
        } else {
            System.out.println("Seleccione Cliente Existente");
            CS.mostrarTodosClientes(1);
            System.out.println("Seleccione el ID Cliente");
            Integer idcl = leer.nextInt();
            Cliente CX = CS.buscarCliente(idcl);
            System.out.println(CX);
            P.setCliente(CX);
        }  
            PDAO.nuevoPrestamo(P);
            System.out.println("PRESTAMO INGRESADO A LA BD");
        } catch (Exception e) {
            System.err.println("Error en datos ingresados");
        }
        return P;
    }

    public void editarPrestamo() throws Exception {
        Prestamo P = new Prestamo();
        System.out.println("Ingrese el ID del Cliente a Editar");
        P.setId(leer.nextInt());
        System.out.println("INGRESE LOS DATOS A MODIFICAR");
        
        PDAO.editarPrestamo(nuevoPrestamo());
        System.out.println("PRESTAMO ACTUALIZADO");
    }

    public void mostrarTodosPrestamos(Integer n) throws Exception {
        List<Prestamo> prestamos = new ArrayList();
        switch (n) {
            case 1:
                prestamos = PDAO.mostrarTodosPrestamos();
                break;
            case 2:
                System.out.println("Ingrese el nombre de Cliente para buscar el prestamo");
                String nombreCliente = leer.next();
                prestamos = PDAO.mostrarPrestamoPorNombreCliente(nombreCliente);
                break;
        }
        if (prestamos.isEmpty()) {
            System.err.println("NO HAY DATOS QUE COINCIDAN CON LA BUSQUEDA ACTUAL");
        } else {
            System.out.printf("%-5s %-20s %-20s %-30s %-30s\n", "ID", "FECHA PRESTAMO", "FECHA DEV", "TITULO LIBRO", "NOMBRE CLIENTE");
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            for (Prestamo prestamo : prestamos) {
                System.out.printf("%-5s %-20s %-20s %-30s %-30s\n",
                        prestamo.getId(),
                        prestamo.getFechaPrestamo(),
                        prestamo.getFechaDevolucion(),
                        prestamo.getLibro().getTitulo(),
                        prestamo.getCliente().getNombre());
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
        }
    }

    public Prestamo buscarprestamo(Integer id) throws Exception {
        Prestamo P = PDAO.buscarPrestamo(id);
        return P;
    }

}
