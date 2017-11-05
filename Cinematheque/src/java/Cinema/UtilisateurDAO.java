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
 * @author Jennifer
 */
@Stateless
public class UtilisateurDAO {
    @PersistenceContext(unitName = "CinemathequePU")
    private EntityManager em;
    
    public List<Utilisateur> allUser() {
        Query query = em.createNamedQuery("Utilisateur.findAll");
        return query.getResultList();
    }
    
    public void add(Utilisateur u) {
        em.persist(u);
        em.flush();
    }
}
