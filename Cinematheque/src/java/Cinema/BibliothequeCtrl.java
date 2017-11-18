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
    private BibliothequeDAO dao; 
    private Bibliotheque selectedBiblio;
    
    public BibliothequeCtrl() {
    }
   
    
    public List<Bibliotheque> getBibliotheques() {
        return dao.allBiblio();
    }
    
    public void addBibliotheque(Bibliotheque b) {
        dao.add(b);
    }

    public BibliothequeDAO getDao() {
        return dao;
    }

    public void setDao(BibliothequeDAO dao) {
        this.dao = dao;
    }

    public Bibliotheque getBibliotheque() {
        return selectedBiblio;
    }

    public void setBibliotheque(Bibliotheque selectedBiblio) {
        this.selectedBiblio = selectedBiblio;
    }
    
    public void deleteBibliotheque(){
        int id = selectedBiblio.getIdbiblio();
        dao.removeBibliotheque(id);
    }
    
    public void modifBibliotheque(){
        dao.updateBibliotheque(this.selectedBiblio);
    }
    
}
