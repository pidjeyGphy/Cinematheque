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
public class BibliothequeDAO {
    @PersistenceContext(unitName = "CinemathequePU")
    private EntityManager em;
    
    public List<Bibliotheque> allBiblio() {
        Query query = em.createNamedQuery("Bibliotheque.findAll");
        return query.getResultList();
    }
    
    public Bibliotheque findBibliotheque(int id){
        Query query = em.createNamedQuery("Bibliotheque.findByIduser");
        query.setParameter("idBiblio", id);
        return (Bibliotheque) query.getSingleResult();
    }
    
    public void add(Bibliotheque b) {
        em.persist(b);
        em.flush();
    }
    
    public void removeBibliotheque(int id){
        Bibliotheque b = findBibliotheque(id);
        em.remove(b);
        em.flush();
    }
    
    public void updateBibliotheque(Bibliotheque b){
        em.merge(b);
        em.flush();
    }
}
