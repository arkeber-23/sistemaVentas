/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.formularios;

import controlador.FacturaJpaController;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Factura;
import modelo.Producto;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class frmVenta extends javax.swing.JInternalFrame {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SitemaVenta_EberCabezasPU");
    FacturaJpaController daoFActura = new FacturaJpaController(emf);
    Factura factura = new Factura();
    Producto p = new Producto();
    public frmVenta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        SitemaVenta_EberCabezasPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SitemaVenta_EberCabezasPU").createEntityManager();
        productoQuery = java.beans.Beans.isDesignTime() ? null : SitemaVenta_EberCabezasPUEntityManager.createQuery("SELECT p FROM Producto p");
        productoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : productoQuery.getResultList();
        productoQuery1 = java.beans.Beans.isDesignTime() ? null : SitemaVenta_EberCabezasPUEntityManager.createQuery("SELECT p FROM Producto p");
        productoList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : productoQuery1.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        lblPrecioPro = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        btnGurdar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/principal/imagen.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 2, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Producto:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Precio:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Cantidad:");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productoList1, cmbProducto);
        bindingGroup.addBinding(jComboBoxBinding);

        cmbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductoActionPerformed(evt);
            }
        });

        lblPrecioPro.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        lblPrecioPro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        txtCantidad.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/principal/carrito.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setToolTipText("Añadir al carrito");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPrecioPro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecioPro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 2, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel4.setLayout(new java.awt.BorderLayout());

        tblListaProductos.setBackground(new java.awt.Color(255, 255, 255));
        tblListaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Producto", "Producto", "Precio U", "Cantidad", "Precio Total"
            }
        ));
        tblListaProductos.setGridColor(new java.awt.Color(255, 255, 255));
        tblListaProductos.setSelectionBackground(new java.awt.Color(204, 51, 255));
        tblListaProductos.setSelectionForeground(new java.awt.Color(0, 204, 204));
        jScrollPane1.setViewportView(tblListaProductos);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("SubTotal:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Iva:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Total Pagar:");

        lblSubtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSubtotal.setForeground(new java.awt.Color(51, 51, 51));
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotal.setText("0");

        lblTotalPagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotalPagar.setForeground(new java.awt.Color(51, 51, 51));
        lblTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalPagar.setText("0");

        lblIva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIva.setForeground(new java.awt.Color(51, 51, 51));
        lblIva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIva.setText("0");

        btnGurdar.setBackground(new java.awt.Color(255, 255, 255));
        btnGurdar.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        btnGurdar.setForeground(new java.awt.Color(51, 51, 51));
        btnGurdar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/principal/save.png"))); // NOI18N
        btnGurdar.setText("Guardar");
        btnGurdar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGurdarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/principal/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(btnGurdar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                        .addComponent(btnEliminar)
                                        .addGap(35, 35, 35)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblIva, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addComponent(lblSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGurdar)
                            .addComponent(btnEliminar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSubtotal))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblIva))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTotalPagar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductoActionPerformed

        if (cmbProducto.getSelectedItem() != null) {
            lblPrecioPro.setText(cmbProducto.getItemAt(cmbProducto.getSelectedIndex()).getPrecioPr().toString());

        }
    }//GEN-LAST:event_cmbProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblListaProductos.getModel();
        int idProducto = cmbProducto.getItemAt(cmbProducto.getSelectedIndex()).getIdPrducto();
        String nombreP = cmbProducto.getItemAt(cmbProducto.getSelectedIndex()).getNombrePr();
        double precio = Double.parseDouble(lblPrecioPro.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        double pTotal = precio * cantidad;
        Object[] fila = new Object[]{
            idProducto, nombreP, precio, cantidad, pTotal};
        dtm.addRow(fila);
        calcular();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tblListaProductos.getModel();
        if (tblListaProductos.getSelectedRow() >= 0) {
            dtm.removeRow(tblListaProductos.getSelectedRow());
        }
        if (tblListaProductos.getRowCount() == 0) {
            lblSubtotal.setText("0");
            lblIva.setText("0");
            lblTotalPagar.setText("0");
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGurdarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGurdarActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < tblListaProductos.getRowCount(); i++) {
            int idProducto = (int) tblListaProductos.getValueAt(i, 0);
            p.setIdPrducto(idProducto);
            double precio = (double)(tblListaProductos.getValueAt(i, 2));
            int cantidad = (int)(tblListaProductos.getValueAt(i, 3));
            double subt = Double.parseDouble(lblSubtotal.getText());
            double iva = Double.parseDouble(lblIva.getText());
            double totalP =Double.parseDouble(lblTotalPagar.getText());
            factura.setIdPrducto(p);
            factura.setPrecioPro(new BigDecimal(precio).longValue());
            factura.setCantidadPro(new BigDecimal(cantidad).longValue());
            factura.setSubtotal(new BigDecimal(subt).longValue());
            factura.setIva(new BigDecimal(iva).longValue());
            factura.setTotalPagar(new BigDecimal(totalP).longValue());
            daoFActura.create(factura);
            JOptionPane.showMessageDialog(this, "Factura Generada..");
        }

        String nombreP = cmbProducto.getItemAt(cmbProducto.getSelectedIndex()).getNombrePr();
        double precio = Double.parseDouble(lblPrecioPro.getText());
        double cantidad = Double.parseDouble(txtCantidad.getText());

    }//GEN-LAST:event_btnGurdarActionPerformed

    private void calcular() {
        DefaultTableModel dtm = (DefaultTableModel) tblListaProductos.getModel();
        double subTotal = 0;
        for (int i = 0; i < tblListaProductos.getRowCount(); i++) {
            subTotal += (double) tblListaProductos.getValueAt(i, 4);
            lblSubtotal.setText("" + subTotal);
        }

        double iva = subTotal * 0.12;
        double totalPagar = subTotal + iva;

        lblIva.setText("" + iva);
        lblTotalPagar.setText("" + totalPagar);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager SitemaVenta_EberCabezasPUEntityManager;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGurdar;
    private javax.swing.JComboBox<Producto> cmbProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblPrecioPro;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotalPagar;
    private java.util.List<modelo.Producto> productoList;
    private java.util.List<modelo.Producto> productoList1;
    private javax.persistence.Query productoQuery;
    private javax.persistence.Query productoQuery1;
    private javax.swing.JTable tblListaProductos;
    private javax.swing.JTextField txtCantidad;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
