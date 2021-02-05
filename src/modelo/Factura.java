/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "tab_facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "Factura.findByPrecioPro", query = "SELECT f FROM Factura f WHERE f.precioPro = :precioPro")
    , @NamedQuery(name = "Factura.findByCantidadPro", query = "SELECT f FROM Factura f WHERE f.cantidadPro = :cantidadPro")
    , @NamedQuery(name = "Factura.findBySubtotal", query = "SELECT f FROM Factura f WHERE f.subtotal = :subtotal")
    , @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva")
    , @NamedQuery(name = "Factura.findByTotalPagar", query = "SELECT f FROM Factura f WHERE f.totalPagar = :totalPagar")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FACTURA")
    private Integer idFactura;
    @Column(name = "PRECIO_PRO")
    private Long precioPro;
    @Column(name = "CANTIDAD_PRO")
    private Long cantidadPro;
    @Column(name = "SUBTOTAL")
    private Long subtotal;
    @Column(name = "IVA")
    private Long iva;
    @Column(name = "TOTAL_PAGAR")
    private Long totalPagar;
    @JoinColumn(name = "ID_PRDUCTO", referencedColumnName = "ID_PRDUCTO")
    @ManyToOne
    private Producto idPrducto;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Long getPrecioPro() {
        return precioPro;
    }

    public void setPrecioPro(Long precioPro) {
        this.precioPro = precioPro;
    }

    public Long getCantidadPro() {
        return cantidadPro;
    }

    public void setCantidadPro(Long cantidadPro) {
        this.cantidadPro = cantidadPro;
    }

    public Long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Long subtotal) {
        this.subtotal = subtotal;
    }

    public Long getIva() {
        return iva;
    }

    public void setIva(Long iva) {
        this.iva = iva;
    }

    public Long getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Long totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Producto getIdPrducto() {
        return idPrducto;
    }

    public void setIdPrducto(Producto idPrducto) {
        this.idPrducto = idPrducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Factura[ idFactura=" + idFactura + " ]";
    }

}
