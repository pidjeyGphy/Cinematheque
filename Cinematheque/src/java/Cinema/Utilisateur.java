/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cinema;

import java.io.Serializable;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
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
@ManagedBean
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
    @Column(name = "iduser")
    private Integer iduser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nomuser")
    private String nomuser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "prenomuser")
    private String prenomuser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "mdpuser")
    private String mdpuser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private Collection<Bibliotheque> bibliothequeCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer iduser) {
        this.iduser = iduser;
    }

    public Utilisateur(Integer iduser, String nomuser, String prenomuser, String mdpuser) {
        this.iduser = iduser;
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.mdpuser = mdpuser;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public String getPrenomuser() {
        return prenomuser;
    }

    public void setPrenomuser(String prenomuser) {
        this.prenomuser = prenomuser;
    }

    public String getMdpuser() {
        return mdpuser;
    }

    public void setMdpuser(String mdpuser) {
        this.mdpuser = mdpuser;
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
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cinema.Utilisateur[ iduser=" + iduser + " ]";
    }
   
    
}
