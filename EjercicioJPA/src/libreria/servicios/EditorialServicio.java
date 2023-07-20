/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

/**
 *
 * @author jorge
 */
public class EditorialServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    EditorialDAO EDAO = new EditorialDAO();

    public Editorial nuevaEditorial() {
        Editorial E = new Editorial();
        System.out.println("Ingrese el nombre de la Editorial");
        E.setNombre(leer.next());
        E.setAlta(true);
        EDAO.nuevaEditorial(E);
        System.out.println("EDITORIAL INGRESADA A LA BD");
        return E;
    }

    public void editarEditorial() throws Exception {
        Editorial E = new Editorial();
        System.out.println("Ingrese el ID de la Editorial a Editar");
        E.setId(leer.nextLong());
        System.out.println("Ingrese el Nombre Modificado");
        E.setNombre(leer.next());
        E.setAlta(true);
        EDAO.editarEditorial(E);
        System.out.println("EDITORIAL ACTUALIZADA");
    }

    public void bajaAltaEditor() throws Exception {
        System.out.println("Ingrese el nro de ID a dar de Baja/Alta");
        Long id = leer.nextLong();
        EDAO.bajaAltaEditorial(id);
    }

    public void mostrarTodasEditoriales(Integer n) throws Exception {
        List<Editorial> editoriales = new ArrayList();
        switch (n) {
            case 1:
                editoriales = EDAO.mostrarTodasEditoriales();
                break;
            case 2:
                System.out.println("Ingrese el Nombre de la Editorial");
                String nombre = leer.next();
                editoriales = EDAO.mostrarEditorialesPorNombre(nombre);
                break;
            case 3:
                System.out.println("Ingrese el ID de la Editorial");
                String id = leer.next();
                editoriales = EDAO.mostrarEditorialesPorID(id);
                break;
        }
        if (editoriales.isEmpty()) {
            System.err.println("NO HAY DATOS QUE COINCIDAN CON LA BUSQUEDA ACTUAL");
        } else {
            System.out.printf("%-5s %-10s %-10s\n", "ID", "ALTA", "NOMBRE AUTOR");
            System.out.println("---------------------------------");
            for (Editorial editorial : editoriales) {
                System.out.printf("%-5s %-10s %-10s\n",
                        editorial.getId(),
                        editorial.getAlta(),
                        editorial.getNombre());
            }
            System.out.println("---------------------------------");
        }
    }
    
    public Editorial buscarEditorial(Long id) throws Exception{
        Editorial E = EDAO.buscarEditorial(id);
        return E;
    }
}
