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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pierre-Joseph
 */
@Entity
@Table(name = "stockage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stockage.findAll", query = "SELECT s FROM Stockage s")
    , @NamedQuery(name = "Stockage.findByIdstock", query = "SELECT s FROM Stockage s WHERE s.idstock = :idstock")})
public class Stockage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstock")
    private Integer idstock;

    public Stockage() {
    }

    public Stockage(Integer idstock) {
        this.idstock = idstock;
    }

    public Integer getIdstock() {
        return idstock;
    }

    public void setIdstock(Integer idstock) {
        this.idstock = idstock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstock != null ? idstock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockage)) {
            return false;
        }
        Stockage other = (Stockage) object;
        if ((this.idstock == null && other.idstock != null) || (this.idstock != null && !this.idstock.equals(other.idstock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cinema.Stockage[ idstock=" + idstock + " ]";
    }
    
}
