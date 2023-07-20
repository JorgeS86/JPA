/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

/**
 *
 * @author jorge
 */
public class AutorDAO extends DAO{
    public void nuevoAutor(Object A) throws Exception {
          try {
            guardar(A);
        } catch (Exception e) {
            System.err.println("ERROR AL CREAR AUTOR");
        }
    }
}
