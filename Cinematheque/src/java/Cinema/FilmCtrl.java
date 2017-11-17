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
    private FilmDAO dao; 
    private Film selectedFilm; 
    
    public FilmCtrl() {
    }
   
    
    public List<Film> getAllFilm() {
        return dao.allFilm();
    }
    
    public void addFilm(Film u) {
        dao.add(u);
    }

    public FilmDAO getDao() {
        return dao;
    }

    public void setDao(FilmDAO dao) {
        this.dao = dao;
    }

    public Film getFilm() {
        return selectedFilm;
    }

    public void setFilm(Film selectedFilm) {
        this.selectedFilm = selectedFilm;
    }
    
    public void deleteFilm(){
        int id = selectedFilm.getIdfilm();
        dao.removeFilm(id);
    }
    
    public void modifFilm(){
        dao.updateFilm(this.selectedFilm);
    }
    
}
