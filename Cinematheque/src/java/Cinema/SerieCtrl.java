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
    private SerieDAO dao; 
    private Serie selectedSer; 
    
    public SerieCtrl() {
    }
   
    
    public List<Serie> getSer() {
        return dao.allSer();
    }
    
    public void addSer(Serie s) {
        dao.add(s);
    }

    public SerieDAO getDao() {
        return dao;
    }

    public void setDao(SerieDAO dao) {
        this.dao = dao;
    }

    public Serie getSerie() {
        return selectedSer;
    }

    public void setSer(Serie selectedSer) {
        this.selectedSer = selectedSer;
    }
    
    public void deleteSerie(){
        int id = selectedSer.getIdserie();
        dao.removeSerie(id);
    }
    
    public void modifSerie(){
        dao.updateSerie(this.selectedSer);
    }
    
}
