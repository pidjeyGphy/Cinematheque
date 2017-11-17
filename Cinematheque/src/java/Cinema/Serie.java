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
@Table(name = "Serie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serie.findAll", query = "SELECT s FROM Serie s")
    , @NamedQuery(name = "Serie.findByIdserie", query = "SELECT s FROM Serie s WHERE s.idserie = :idserie")
    , @NamedQuery(name = "Serie.findByNomserie", query = "SELECT s FROM Serie s WHERE s.nomserie = :nomserie")
    , @NamedQuery(name = "Serie.findByNbepisode", query = "SELECT s FROM Serie s WHERE s.nbepisode = :nbepisode")
    , @NamedQuery(name = "Serie.findByNbsaison", query = "SELECT s FROM Serie s WHERE s.nbsaison = :nbsaison")
    , @NamedQuery(name = "Serie.findByDatedebut", query = "SELECT s FROM Serie s WHERE s.datedebut = :datedebut")
    , @NamedQuery(name = "Serie.findByDatefin", query = "SELECT s FROM Serie s WHERE s.datefin = :datefin")
    , @NamedQuery(name = "Serie.findByResumeserie", query = "SELECT s FROM Serie s WHERE s.resumeserie = :resumeserie")})
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDSERIE")
    private Integer idserie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMSERIE")
    private String nomserie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NBEPISODE")
    private int nbepisode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NBSAISON")
    private int nbsaison;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEDEBUT")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "DATEFIN")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "AFFICHESERIE")
    private String afficheserie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "RESUMESERIE")
    private String resumeserie;
    @OneToMany(mappedBy = "idserie")
    private Collection<Bibliotheque> bibliothequeCollection;

    public Serie() {
    }

    public Serie(Integer idserie) {
        this.idserie = idserie;
    }

    public Serie(Integer idserie, String nomserie, int nbepisode, int nbsaison, Date datedebut, String afficheserie, String resumeserie) {
        this.idserie = idserie;
        this.nomserie = nomserie;
        this.nbepisode = nbepisode;
        this.nbsaison = nbsaison;
        this.datedebut = datedebut;
        this.afficheserie = afficheserie;
        this.resumeserie = resumeserie;
    }

    public Integer getIdserie() {
        return idserie;
    }

    public void setIdserie(Integer idserie) {
        this.idserie = idserie;
    }

    public String getNomserie() {
        return nomserie;
    }

    public void setNomserie(String nomserie) {
        this.nomserie = nomserie;
    }

    public int getNbepisode() {
        return nbepisode;
    }

    public void setNbepisode(int nbepisode) {
        this.nbepisode = nbepisode;
    }

    public int getNbsaison() {
        return nbsaison;
    }

    public void setNbsaison(int nbsaison) {
        this.nbsaison = nbsaison;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getAfficheserie() {
        return afficheserie;
    }

    public void setAfficheserie(String afficheserie) {
        this.afficheserie = afficheserie;
    }

    public String getResumeserie() {
        return resumeserie;
    }

    public void setResumeserie(String resumeserie) {
        this.resumeserie = resumeserie;
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
        hash += (idserie != null ? idserie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
        if ((this.idserie == null && other.idserie != null) || (this.idserie != null && !this.idserie.equals(other.idserie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cinema.Serie[ idserie=" + idserie + " ]";
    }
    
}
