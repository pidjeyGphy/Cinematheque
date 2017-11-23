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

@Named(value = "SerieCtrl")
@ViewScoped
public class SerieCtrl implements Serializable{
    
    @EJB
    private SerieDAO daoSerie;
    
    @EJB
    private StockageDAO daoStock;
    
    @EJB
    private UtilisateurDAO daouser;
    
    @EJB
    private BibliothequeDAO daoBiblio;
    private Serie selectedSer; 
    
    public SerieCtrl() {
    }
   
    
    public List<Serie> getAllSerie() {
        return daoSerie.allSer();
    }
    
    public void addSerie(Serie s) {
        daoSerie.add(s);
    }

    public SerieDAO getDao() {
        return daoSerie;
    }

    public void setDao(SerieDAO dao) {
        this.daoSerie = dao;
    }

    public Serie getSelectedSerie() {
        return selectedSer;
    }

    public void setSelectedSerie(Serie selectedSer) {
        this.selectedSer = selectedSer;
    }
    
//    public void deleteSerie(){
//        int id = selectedSer.getIdserie();
//        daoSerie.removeSerie(id);
//    }
    
    public void modifSerie(){
        daoSerie.updateSerie(this.selectedSer);
    }
    
    public void serieRecupBiblio(Serie s) {
        Stockage stock= daoStock.oneStock();
        Integer into= stock.getIdstock();
        Utilisateur user =daouser.findUtilisateur(into);
        Bibliotheque b =daoBiblio.serieVersBiblio(user, s);
        if(b.getVu()==false){
            b.setVu(true);
        }
        else{
            b.setVu(false);
        }
        daoBiblio.updateBibliotheque(b);
    }
        
    public String affichevubis(Serie s) {
        Stockage stock= daoStock.oneStock();
        Integer into= stock.getIdstock();
        Utilisateur user =daouser.findUtilisateur(into);
        Bibliotheque b =daoBiblio.serieVersBiblio(user, s);
        if(b.getVu()==false){
            return ("Pas vu");
        }
        else{
            return ("Vu");
        }
    }
    
}
