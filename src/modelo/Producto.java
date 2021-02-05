/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "tab_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdPrducto", query = "SELECT p FROM Producto p WHERE p.idPrducto = :idPrducto")
    , @NamedQuery(name = "Producto.findByNombrePr", query = "SELECT p FROM Producto p WHERE p.nombrePr = :nombrePr")
    , @NamedQuery(name = "Producto.findByTallaPr", query = "SELECT p FROM Producto p WHERE p.tallaPr = :tallaPr")
    , @NamedQuery(name = "Producto.findByColorPr", query = "SELECT p FROM Producto p WHERE p.colorPr = :colorPr")
    , @NamedQuery(name = "Producto.findByPrecioPr", query = "SELECT p FROM Producto p WHERE p.precioPr = :precioPr")})
public class Producto implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRDUCTO")
    private Integer idPrducto;
    @Column(name = "NOMBRE_PR")
    private String nombrePr;
    @Column(name = "TALLA_PR")
    private String tallaPr;
    @Column(name = "COLOR_PR")
    private String colorPr;
    @Column(name = "PRECIO_PR")
    private Long precioPr;
    @OneToMany(mappedBy = "idPrducto")
    private List<Factura> facturaList;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne
    private Proveedore idProveedor;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne
    private Categoria idCategoria;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne
    private Marca idMarca;

    public Producto() {
    }

    public Producto(Integer idPrducto) {
        this.idPrducto = idPrducto;
    }

    public Integer getIdPrducto() {
        return idPrducto;
    }

    public void setIdPrducto(Integer idPrducto) {
        Integer oldIdPrducto = this.idPrducto;
        this.idPrducto = idPrducto;
        changeSupport.firePropertyChange("idPrducto", oldIdPrducto, idPrducto);
    }

    public String getNombrePr() {
        return nombrePr;
    }

    public void setNombrePr(String nombrePr) {
        String oldNombrePr = this.nombrePr;
        this.nombrePr = nombrePr;
        changeSupport.firePropertyChange("nombrePr", oldNombrePr, nombrePr);
    }

    public String getTallaPr() {
        return tallaPr;
    }

    public void setTallaPr(String tallaPr) {
        String oldTallaPr = this.tallaPr;
        this.tallaPr = tallaPr;
        changeSupport.firePropertyChange("tallaPr", oldTallaPr, tallaPr);
    }

    public String getColorPr() {
        return colorPr;
    }

    public void setColorPr(String colorPr) {
        String oldColorPr = this.colorPr;
        this.colorPr = colorPr;
        changeSupport.firePropertyChange("colorPr", oldColorPr, colorPr);
    }

    public Long getPrecioPr() {
        return precioPr;
    }

    public void setPrecioPr(Long precioPr) {
        Long oldPrecioPr = this.precioPr;
        this.precioPr = precioPr;
        changeSupport.firePropertyChange("precioPr", oldPrecioPr, precioPr);
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public Proveedore getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedore idProveedor) {
        Proveedore oldIdProveedor = this.idProveedor;
        this.idProveedor = idProveedor;
        changeSupport.firePropertyChange("idProveedor", oldIdProveedor, idProveedor);
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        Categoria oldIdCategoria = this.idCategoria;
        this.idCategoria = idCategoria;
        changeSupport.firePropertyChange("idCategoria", oldIdCategoria, idCategoria);
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        Marca oldIdMarca = this.idMarca;
        this.idMarca = idMarca;
        changeSupport.firePropertyChange("idMarca", oldIdMarca, idMarca);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrducto != null ? idPrducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idPrducto == null && other.idPrducto != null) || (this.idPrducto != null && !this.idPrducto.equals(other.idPrducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombrePr();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
