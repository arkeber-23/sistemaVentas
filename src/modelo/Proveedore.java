/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "tab_proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedore.findAll", query = "SELECT p FROM Proveedore p")
    , @NamedQuery(name = "Proveedore.findByIdProveedor", query = "SELECT p FROM Proveedore p WHERE p.idProveedor = :idProveedor")
    , @NamedQuery(name = "Proveedore.findByNombre", query = "SELECT p FROM Proveedore p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedore.findByApellido", query = "SELECT p FROM Proveedore p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Proveedore.findByDireccion", query = "SELECT p FROM Proveedore p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Proveedore.findByTelefono", query = "SELECT p FROM Proveedore p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Proveedore.findByEmail", query = "SELECT p FROM Proveedore p WHERE p.email = :email")
    , @NamedQuery(name = "Proveedore.findByAnyWord", query = "SELECT p FROM Proveedore p WHERE p.email LIKE :email OR p.nombre LIKE :nombre OR p.apellido like :apellido or p.direccion like :direccion or p.telefono like :telefono")})
public class Proveedore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR")
    private Integer idProveedor;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "idProveedor")
    private List<Producto> productoList;

    public Proveedore() {
    }

    public Proveedore(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedore)) {
            return false;
        }
        Proveedore other = (Proveedore) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
