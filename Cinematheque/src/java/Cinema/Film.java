/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cinema;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jennifer
 */
@Entity
@Table(name = "Film")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
    , @NamedQuery(name = "Film.findByIdfilm", query = "SELECT f FROM Film f WHERE f.idfilm = :idfilm")
    , @NamedQuery(name = "Film.findByIdrealisateur", query = "SELECT f FROM Film f WHERE f.idrealisateur = :idrealisateur")
    , @NamedQuery(name = "Film.findByNomfilm", query = "SELECT f FROM Film f WHERE f.nomfilm = :nomfilm")
    , @NamedQuery(name = "Film.findByDatediffusion", query = "SELECT f FROM Film f WHERE f.datediffusion = :datediffusion")})
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFILM")
    private Integer idfilm;
    @Column(name = "IDREALISATEUR")
    private Integer idrealisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMFILM")
    private String nomfilm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEDIFFUSION")
    @Temporal(TemporalType.DATE)
    private Date datediffusion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "AFFICHEFILM")
    private String affichefilm;
    @OneToMany(mappedBy = "idfilm")
    private Collection<Bibliotheque> bibliothequeCollection;

    public Film() {
    }

    public Film(Integer idfilm) {
        this.idfilm = idfilm;
    }

    public Film(Integer idfilm, String nomfilm, Date datediffusion, String affichefilm) {
        this.idfilm = idfilm;
        this.nomfilm = nomfilm;
        this.datediffusion = datediffusion;
        this.affichefilm = affichefilm;
    }

    public Integer getIdfilm() {
        return idfilm;
    }

    public void setIdfilm(Integer idfilm) {
        this.idfilm = idfilm;
    }

    public Integer getIdrealisateur() {
        return idrealisateur;
    }

    public void setIdrealisateur(Integer idrealisateur) {
        this.idrealisateur = idrealisateur;
    }

    public String getNomfilm() {
        return nomfilm;
    }

    public void setNomfilm(String nomfilm) {
        this.nomfilm = nomfilm;
    }

    public Date getDatediffusion() {
        return datediffusion;
    }

    public void setDatediffusion(Date datediffusion) {
        this.datediffusion = datediffusion;
    }

    public String getAffichefilm() {
        return affichefilm;
    }

    public void setAffichefilm(String affichefilm) {
        this.affichefilm = affichefilm;
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
        hash += (idfilm != null ? idfilm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.idfilm == null && other.idfilm != null) || (this.idfilm != null && !this.idfilm.equals(other.idfilm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cinema.Film[ idfilm=" + idfilm + " ]";
    }
    
}
