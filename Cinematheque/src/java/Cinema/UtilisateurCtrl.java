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
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jennifer
 */
@Named(value = "UtilisateurCtrl")
@ViewScoped
public class UtilisateurCtrl implements Serializable {

    @EJB
    private UtilisateurDAO dao;
    private Utilisateur selectedUser;
    

    public UtilisateurCtrl() {
    }

    public List<Utilisateur> getAllUser() {
        return dao.allUser();
    }

    public void addUser(Utilisateur u) {
        dao.add(u);
    }

    public UtilisateurDAO getDao() {
        return dao;
    }

    public void setDao(UtilisateurDAO dao) {
        this.dao = dao;
    }

    public Utilisateur getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Utilisateur selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void deleteUtilisateur() {
        int id = selectedUser.getIduser();
        dao.removeUtilisateur(id);
    }

    public void modifUtilisateur() {
        dao.updateUtilisateur(this.selectedUser);
    }

    public Utilisateur connexion() throws ConnexionExecption {
        selectedUser = dao.connexionDao(selectedUser.getNomuser(),selectedUser.getMdpuser());
        if (selectedUser == null){
        throw new ConnexionExecption();
        }
        else {
                return (selectedUser);
                }

    }

}
