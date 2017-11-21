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
    private Bibliotheque selectedBiblio;
    
    public BibliothequeCtrl() {
    }
   
    
    public List<Bibliotheque> getAllBibliotheque() {
        return daoBiblio.allBiblio();
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
        Film idFilm = daoFilm.findFilm(film);
        Bibliotheque selectBiblio = new Bibliotheque(Integer.MIN_VALUE, false);
        selectBiblio.setIdfilm(idFilm);        
    }
    
    public void addSerieBibliotheque(Serie serie){
        Serie idSerie = daoSerie.findSerie(serie);
        Bibliotheque selectBiblio = new Bibliotheque(Integer.MIN_VALUE, false);
        selectBiblio.setIdserie(idSerie);    
    }
    
}
