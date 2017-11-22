/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cinema;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Pierre-Joseph
 */

@Named(value = "FilmCtrl")
@ViewScoped
public class FilmCtrl implements Serializable{
    
    @EJB
    private FilmDAO daof; 
    
    @EJB
    private StockageDAO daoStock;
    
    @EJB
    private UtilisateurDAO daouser;
    
    @EJB
    private BibliothequeDAO daoBiblio;
    
    private Film selectedFilm;
    
    public FilmCtrl() {
    }
   
    
    public List<Film> getAllFilm() {
        return daof.AllFilm();
    }
    
    public void addFilm(Film u) {
        daof.add(u);
    }

    public FilmDAO getDao() {
        return daof;
    }

    public void setDao(FilmDAO dao) {
        this.daof = dao;
    }

    public Film getSelectedFilm() {
        return selectedFilm;
    }
    
    public void setSelectedFilm(Film selecteFilm) {
        this.selectedFilm = selecteFilm;
    }
    
    public void modifFilm(){
        daof.updateFilm(this.selectedFilm);
    }
    
        public void filmRecupBiblio(Film f) {
        Stockage stock= daoStock.oneStock();
        Integer into= stock.getIdstock();
        Utilisateur user =daouser.findUtilisateur(into);
        Bibliotheque b =daoBiblio.filmVersBiblio(user, f);
        if(b.getVu()==false){
            b.setVu(true);
        }
        else{
            b.setVu(false);
        }
        daoBiblio.updateBibliotheque(b);
    }
    
}
