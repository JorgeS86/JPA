/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

/**
 *
 * @author jorge
 */
public class DAO {

    protected final EntityManagerFactory emf;
    protected EntityManager em;

    public DAO() {
        emf = Persistence.createEntityManagerFactory("Persistencia");
        em = emf.createEntityManager();
    }

    public void conectar() throws Exception {
        try {
            if (!em.isOpen()) {
                em = emf.createEntityManager();
            }
        } catch (Exception e) {
            System.out.println("Error al conectar a BD");
        }
    }

    public void desconectar() throws Exception {
        if (em.isOpen()) {
            em.close();
        }
    }

    public void guardar(Object objeto) throws Exception {
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            System.out.println(" Error al guardar en BD");
        }
    }

    public void editar(Object objeto) throws Exception {
        try {
            conectar();
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            System.out.println(" Error al editar en BD");
        }
    }

    public void eliminar(Object objeto) throws Exception {
        try {
            conectar();
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            System.out.println(" Error al eliminar en BD : " + e.getMessage());
        }
    }

    public List mostrarLista(String jpql) throws Exception {
        conectar();
        List L = em.createQuery(jpql).getResultList();
        desconectar();
        return L;
    }
    
    
   /*public Object buscarObjeto(Integer id) throws Exception {
        conectar();
        Object O = em.find(Object.class, id);
        desconectar();
        return O;
    }*/
}
