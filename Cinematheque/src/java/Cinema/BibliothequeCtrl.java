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

@Named(value = "BibliothequeCtrl")
@ViewScoped
public class BibliothequeCtrl implements Serializable{
    
    @EJB
    private BibliothequeDAO daoBiblio;
    @EJB
    private FilmDAO daoFilm;
    @EJB
    private SerieDAO daoSerie;
    @EJB
    private UtilisateurDAO daouser;
    @EJB
    private StockageDAO daoStock;
    private Bibliotheque selectedBiblio;
    
    public BibliothequeCtrl() {
    }
   
    
    public List<Bibliotheque> getAllBibliotheque() {
        return daoBiblio.allBiblio();
    }
    
    public List<Film> getFilmBibliotheque() {
        Stockage stock= daoStock.oneStock();
        Integer into= stock.getIdstock();
        Utilisateur util=daouser.findUtilisateur(into);
        return daoBiblio.filmBiblio(util);
    }
    
    public List<Serie> getSerieBibliotheque() {
        Stockage stock= daoStock.oneStock();
        Integer into= stock.getIdstock();
        Utilisateur util=daouser.findUtilisateur(into);
        return daoBiblio.serieBiblio(util);
    }
    
    public void addBibliotheque(Bibliotheque b) {
        daoBiblio.add(b);
    }

    public BibliothequeDAO getDao() {
        return daoBiblio;
    }

    public void setDao(BibliothequeDAO dao) {
        this.daoBiblio = dao;
    }

    public Bibliotheque getSelectedBiblio() {
        return selectedBiblio;
    }

    public void setSelectedBiblio(Bibliotheque selectedBiblio) {
        this.selectedBiblio = selectedBiblio;
    }
    
    public void deleteBibliotheque(){
        int id = selectedBiblio.getIdbiblio();
        daoBiblio.removeBibliotheque(id);
    }
    
    public void modifBibliotheque(){
        daoBiblio.updateBibliotheque(this.selectedBiblio);
    }
    
    public void addFilmBibliotheque(Film film){
        Bibliotheque selectBiblio = new Bibliotheque(Integer.MIN_VALUE, false);
        selectBiblio.setIdfilm(film);
        Stockage stock= daoStock.oneStock();
        Integer into= stock.getIdstock();
        selectBiblio.setIduser(daouser.findUtilisateur(into));
        daoBiblio.add(selectBiblio);        
    }
    
    public void addSerieBibliotheque(Serie serie){
        Bibliotheque selectBiblio = new Bibliotheque(Integer.MIN_VALUE, false);
        selectBiblio.setIdserie(serie);
        Stockage stock= daoStock.oneStock();
        Integer into= stock.getIdstock();
        selectBiblio.setIduser(daouser.findUtilisateur(into));
        daoBiblio.add(selectBiblio);
    }
    
}
