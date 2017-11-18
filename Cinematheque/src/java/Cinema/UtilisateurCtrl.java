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
 * @author Jennifer
 */

@Named(value = "UtilisateurCtrl")
@ViewScoped
public class UtilisateurCtrl implements Serializable{
    
    @EJB
    private UtilisateurDAO dao; 
    private Utilisateur selectedUser; 
    
    public UtilisateurCtrl() {
    }
   
    
    public List<Utilisateur> getUser() {
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

    public Utilisateur getUtilisateur() {
        return selectedUser;
    }

    public void setUser(Utilisateur selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    public void deleteUtilisateur(){
        int id = selectedUser.getIduser();
        dao.removeUtilisateur(id);
    }
    
    public void modifUtilisateur(){
        dao.updateUtilisateur(this.selectedUser);
    }
    
//    public void chercheUtilisateur(String nomu, String mdp){
//        try 
//        {
//            Utilisateur u = dao.findUtilisateurByNom(nomu);
//            try{
//                u.getMdpuser() = mdp;
//            } 
//            catch(ClassCastException e){
//                System.out.println("Ce mot de passe n'est pas connu de la base de données");
//            }
//                
//        }
//        catch(ClassCastException e)
//        {
//          System.out.println("Ce nom n'est pas connu de la base de données");
//        }
        
        
      
        // Catch sur l'utilisateur pour savoir si l'utilisateur existe
        // Vérification de la cohérence du mot de passe
      
   
      
    
    }
    

