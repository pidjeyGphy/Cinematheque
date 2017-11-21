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
public class StockageDAO {
    
    @PersistenceContext(unitName = "CinemathequePU")
    private EntityManager em;
    
    public List<Stockage> allStock(){
        Query query=em.createNamedQuery("Stockage.findAll");
        return query.getResultList();
    }
    
    public Stockage findStockage(int id){
        Query query = em.createNamedQuery("Stockage.findByIdstock");
        query.setParameter("idstock", id);
        return (Stockage) query.getSingleResult();
    }
    
    public void addStockage(Stockage st) {
        em.persist(st);
        em.flush();
    }
    
    public void removeStockage(int id){
        Stockage st = findStockage(id);
        em.remove(st);
        em.flush();
    }
}
