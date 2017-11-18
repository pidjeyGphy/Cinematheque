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
public class FilmDAO {
    @PersistenceContext(unitName = "CinemathequePU")
    private EntityManager em;
    
    public List<Film> AllFilm() {
        Query query = em.createNamedQuery("Film.findAll");
        return query.getResultList();
    }
    
    public Film findFilm(int id){
        Query query = em.createNamedQuery("Film.findByIdfilm");
        query.setParameter("idfilm", id);
        return (Film) query.getSingleResult();
    }
    
    public void add(Film f) {
        em.persist(f);
        em.flush();
    }
    
    public void removeFilm(int id){
        Film f = findFilm(id);
        em.remove(f);
        em.flush();
    }
    
    public void updateFilm(Film f){
        em.merge(f);
        em.flush();
    }
}
