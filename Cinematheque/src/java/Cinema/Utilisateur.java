/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cinema;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jennifer
 */
@Entity
@Table(name = "Utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIduser", query = "SELECT u FROM Utilisateur u WHERE u.iduser = :iduser")
    , @NamedQuery(name = "Utilisateur.findByNomuser", query = "SELECT u FROM Utilisateur u WHERE u.nomuser = :nomuser")
    , @NamedQuery(name = "Utilisateur.findByPrenomuser", query = "SELECT u FROM Utilisateur u WHERE u.prenomuser = :prenomuser")
    , @NamedQuery(name = "Utilisateur.findByMdpuser", query = "SELECT u FROM Utilisateur u WHERE u.mdpuser = :mdpuser")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUSER")
    private Integer IDUSER;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMUSER")
    private String NOMUSER;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PRENOMUSER")
    private String PRENOMUSER;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "MDPUSER")
    private String MDPUSER;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private Collection<Bibliotheque> bibliothequeCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer iduser) {
        this.IDUSER = iduser;
    }

    public Utilisateur(Integer iduser, String nomuser, String prenomuser, String mdpuser) {
        this.IDUSER = iduser;
        this.NOMUSER = nomuser;
        this.PRENOMUSER = prenomuser;
        this.MDPUSER = mdpuser;
    }

    public Integer getIduser() {
        return IDUSER;
    }

    public void setIduser(Integer iduser) {
        this.IDUSER = iduser;
    }

    public String getNomuser() {
        return NOMUSER;
    }

    public void setNomuser(String nomuser) {
        this.NOMUSER = nomuser;
    }

    public String getPrenomuser() {
        return PRENOMUSER;
    }

    public void setPrenomuser(String prenomuser) {
        this.PRENOMUSER = prenomuser;
    }

    public String getMdpuser() {
        return MDPUSER;
    }

    public void setMdpuser(String mdpuser) {
        this.MDPUSER = mdpuser;
    }

    @XmlTransient
    public Collection<Bibliotheque> getBibliothequeCollection() {
        return bibliothequeCollection;
    }

    public void setBibliothequeCollection(Collection<Bibliotheque> bibliothequeCollection) {
        this.bibliothequeCollection = bibliothequeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDUSER != null ? IDUSER.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.IDUSER == null && other.IDUSER != null) || (this.IDUSER != null && !this.IDUSER.equals(other.IDUSER))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cinema.Utilisateur[ iduser=" + IDUSER + " ]";
    }
   
    
}
