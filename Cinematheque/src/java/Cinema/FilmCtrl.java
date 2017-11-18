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
    private Film selectedFilm= new Film(0,"",0,"",""); 
    
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

    public Film getFilm() {
        return selectedFilm;
    }

    public void setFilm(Film selectedFilm) {
        this.selectedFilm = selectedFilm;
    }
    
    public void deleteFilm(){
        int id = selectedFilm.getIdfilm();
        daof.removeFilm(id);
    }
    
    public void modifFilm(){
        daof.updateFilm(this.selectedFilm);
    }
    
}
