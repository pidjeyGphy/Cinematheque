/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.




 */
package Cinema;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jennifer
 */
@Entity
@Table(name = "Bibliotheque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliotheque.findAll", query = "SELECT b FROM Bibliotheque b")
    , @NamedQuery(name = "Bibliotheque.findByIdbiblio", query = "SELECT b FROM Bibliotheque b WHERE b.idbiblio = :idbiblio")
    , @NamedQuery(name = "Bibliotheque.findByVu", query = "SELECT b FROM Bibliotheque b WHERE b.vu = :vu")})
public class Bibliotheque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDBIBLIO")
    private Integer idbiblio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VU")
    private boolean vu;
    @JoinColumn(name = "IDFILM", referencedColumnName = "IDFILM")
    @ManyToOne
    private Film idfilm;
    @JoinColumn(name = "IDSERIE", referencedColumnName = "IDSERIE")
    @ManyToOne
    private Serie idserie;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Utilisateur iduser;

    public Bibliotheque() {
    }

    public Bibliotheque(Integer idbiblio) {
        this.idbiblio = idbiblio;
    }

    public Bibliotheque(Integer idbiblio, boolean vu) {
        this.idbiblio = idbiblio;
        this.vu = vu;
    }

    public Integer getIdbiblio() {
        return idbiblio;
    }

    public void setIdbiblio(Integer idbiblio) {
        this.idbiblio = idbiblio;
    }

    public boolean getVu() {
        return vu;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }

    public Film getIdfilm() {
        return idfilm;
    }

    public void setIdfilm(Film idfilm) {
        this.idfilm = idfilm;
    }

    public Serie getIdserie() {
        return idserie;
    }

    public void setIdserie(Serie idserie) {
        this.idserie = idserie;
    }

    public Utilisateur getIduser() {
        return iduser;
    }

    public void setIduser(Utilisateur iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbiblio != null ? idbiblio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliotheque)) {
            return false;
        }
        Bibliotheque other = (Bibliotheque) object;
        if ((this.idbiblio == null && other.idbiblio != null) || (this.idbiblio != null && !this.idbiblio.equals(other.idbiblio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cinema.Bibliotheque[ idbiblio=" + idbiblio + " ]";
    }
    
}
