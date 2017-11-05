/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cinema;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jennifer
 */
@Named(value = "UtilisateurCtrl")
@ViewScoped
public class UtilisateurCtrl implements Serializable{
    
    private UtilisateurDAO dao; 
    private Utilisateur selectedUser; 
    
    public UtilisateurCtrl() {
        this.selectedUser = new Utilisateur();
    }
    
    public List<Utilisateur> getUser() {
        return dao.allUser();
    }
    
    public void addUser() {
        dao.add(this.selectedUser);
        this.selectedUser = new Utilisateur();
    }

    public UtilisateurDAO getDao() {
        return dao;
    }

    public void setDao(UtilisateurDAO dao) {
        this.dao = dao;
    }

    public Utilisateur getUtilisateur() {
        return selectedUser;
    }

    public void setUser(Utilisateur selectedUser) {
        this.selectedUser = selectedUser;
    }
    
}
