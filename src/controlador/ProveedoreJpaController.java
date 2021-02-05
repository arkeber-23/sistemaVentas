/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Proveedore;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProveedoreJpaController implements Serializable {

    public ProveedoreJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedore proveedore) {
        if (proveedore.getProductoList() == null) {
            proveedore.setProductoList(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Producto> attachedProductoList = new ArrayList<Producto>();
            for (Producto productoListProductoToAttach : proveedore.getProductoList()) {
                productoListProductoToAttach = em.getReference(productoListProductoToAttach.getClass(), productoListProductoToAttach.getIdPrducto());
                attachedProductoList.add(productoListProductoToAttach);
            }
            proveedore.setProductoList(attachedProductoList);
            em.persist(proveedore);
            for (Producto productoListProducto : proveedore.getProductoList()) {
                Proveedore oldIdProveedorOfProductoListProducto = productoListProducto.getIdProveedor();
                productoListProducto.setIdProveedor(proveedore);
                productoListProducto = em.merge(productoListProducto);
                if (oldIdProveedorOfProductoListProducto != null) {
                    oldIdProveedorOfProductoListProducto.getProductoList().remove(productoListProducto);
                    oldIdProveedorOfProductoListProducto = em.merge(oldIdProveedorOfProductoListProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedore proveedore) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedore persistentProveedore = em.find(Proveedore.class, proveedore.getIdProveedor());
            List<Producto> productoListOld = persistentProveedore.getProductoList();
            List<Producto> productoListNew = proveedore.getProductoList();
            List<Producto> attachedProductoListNew = new ArrayList<Producto>();
            for (Producto productoListNewProductoToAttach : productoListNew) {
                productoListNewProductoToAttach = em.getReference(productoListNewProductoToAttach.getClass(), productoListNewProductoToAttach.getIdPrducto());
                attachedProductoListNew.add(productoListNewProductoToAttach);
            }
            productoListNew = attachedProductoListNew;
            proveedore.setProductoList(productoListNew);
            proveedore = em.merge(proveedore);
            for (Producto productoListOldProducto : productoListOld) {
                if (!productoListNew.contains(productoListOldProducto)) {
                    productoListOldProducto.setIdProveedor(null);
                    productoListOldProducto = em.merge(productoListOldProducto);
                }
            }
            for (Producto productoListNewProducto : productoListNew) {
                if (!productoListOld.contains(productoListNewProducto)) {
                    Proveedore oldIdProveedorOfProductoListNewProducto = productoListNewProducto.getIdProveedor();
                    productoListNewProducto.setIdProveedor(proveedore);
                    productoListNewProducto = em.merge(productoListNewProducto);
                    if (oldIdProveedorOfProductoListNewProducto != null && !oldIdProveedorOfProductoListNewProducto.equals(proveedore)) {
                        oldIdProveedorOfProductoListNewProducto.getProductoList().remove(productoListNewProducto);
                        oldIdProveedorOfProductoListNewProducto = em.merge(oldIdProveedorOfProductoListNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = proveedore.getIdProveedor();
                if (findProveedore(id) == null) {
                    throw new NonexistentEntityException("The proveedore with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedore proveedore;
            try {
                proveedore = em.getReference(Proveedore.class, id);
                proveedore.getIdProveedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedore with id " + id + " no longer exists.", enfe);
            }
            List<Producto> productoList = proveedore.getProductoList();
            for (Producto productoListProducto : productoList) {
                productoListProducto.setIdProveedor(null);
                productoListProducto = em.merge(productoListProducto);
            }
            em.remove(proveedore);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedore> findProveedoreEntities() {
        return findProveedoreEntities(true, -1, -1);
    }

    public List<Proveedore> findProveedoreEntities(int maxResults, int firstResult) {
        return findProveedoreEntities(false, maxResults, firstResult);
    }

    private List<Proveedore> findProveedoreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedore.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Proveedore findProveedore(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedore.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedoreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedore> rt = cq.from(Proveedore.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Proveedore> getProvedores(String buscar) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Proveedore.findByAnyWord");
            q.setParameter("nombre", "%" + buscar + "%");
            q.setParameter("apellido", "%" + buscar + "%");
            q.setParameter("direccion", "%" + buscar + "%");
            q.setParameter("telefono", "%" + buscar + "%");
            q.setParameter("email", "%" + buscar + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
