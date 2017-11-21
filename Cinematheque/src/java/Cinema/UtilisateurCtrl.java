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
//@SessionScoped
public class UtilisateurCtrl implements Serializable {

    @EJB
    private UtilisateurDAO dao;
    
    @EJB
    private StockageDAO stdao;
    
    @EJB
    private BibliothequeDAO daobiblio;
    
    private Utilisateur selectedUser;
    private String selectedNom;
    private String selectedMdp;
    

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

    public String getSelectedNom() {
        return selectedNom;
    }

    public String getSelectedMdp() {
        return selectedMdp;
    }

    public void setSelectedNom(String selectedNom) {
        this.selectedNom = selectedNom;
    }

    public void setSelectedMdp(String selectedMdp) {
        this.selectedMdp = selectedMdp;
    }
    
    public void setSelectedUser(Utilisateur selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void deleteUtilisateur() {
        int id = selectedUser.getIduser();
        daobiblio.removeBibliotheque(id);
        dao.removeUtilisateur(id);
    }

    public void modifUtilisateur() {
        dao.updateUtilisateur(this.selectedUser);
    }

    public Utilisateur connexion() throws ConnexionExecption {
        selectedUser = dao.connexionDao(selectedNom,selectedMdp);
        Stockage st = new Stockage(selectedUser.getIduser());
        stdao.addStockage(st);
        if (selectedUser == null){
        throw new ConnexionExecption();
        }
        else {
                return (selectedUser);
                }

    }

}
