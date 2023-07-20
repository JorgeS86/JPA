/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author jorge
 */
public class AutorServicio {
    
    AutorDAO ADAO = new AutorDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public void nuevoAutor() throws Exception{
        Autor A = new Autor();
        System.out.println("Ingrese nombre de autor");
        A.setNombre(leer.next());
        A.setAlta(true);
        ADAO.nuevoAutor(A);
    }
}
