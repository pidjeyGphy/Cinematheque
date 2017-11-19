/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cinema;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jennifer
 */
public class ConnectionForm {
    
    private String resultat; 
    
    public void verifierIdentifiant(HttpServletRequest requete){
        String nom = requete.getParameter("nom");
        String mdp = requete.getParameter("mdp");
        
        if (mdp.equals(nom + "123")){
            resultat = "Vous êtes bien connectés"; 
        }
        else{
             resultat = " Identifiants incorrects";
        }
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    
   
    public String getResultat() {
        return resultat;
    }
    
    
}
