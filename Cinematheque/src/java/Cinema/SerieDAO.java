/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cinema;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pierre-Joseph
 */
@Stateless
public class SerieDAO{

    @PersistenceContext(unitName = "CinemathequePU")
    private EntityManager em;
    
    public List<Serie> allSer() {
        Query query = em.createNamedQuery("Serie.findAll");
        return query.getResultList();
    }
    
    public Serie findSerie(int id){
        Query query = em.createNamedQuery("Serie.findByIdserie");
        query.setParameter("idserie", id);
        return (Serie) query.getSingleResult();
    }
    
    public void add(Serie s) {
        em.persist(s);
        em.flush();
    }
    
    public void removeSerie(int id){
        Serie s = findSerie(id);
        em.remove(s);
        em.flush();
    }
    
    public void updateSerie(Serie s){
        em.merge(s);
        em.flush();
    }
}
