package GUI_Convesor;

import Classes.*;
import java.awt.Component;
import java.awt.PopupMenu;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class form_Gui extends javax.swing.JFrame {
    
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    TipoCambio tipoCambio = new TipoCambio();
    DecimalFormat df = new DecimalFormat();

    public form_Gui() throws IOException {
        initComponents();  
        listCbx();
        txtCantidad.setText("1");
    }

    //Llenamos los CBX con los datos de la api...
    public void listCbx(){
        
        ArrayList<TipoCambio> list = ApiTipoCambio.obtenerCambios();
        
        cbxDivisa1.removeAllItems();

        for (TipoCambio tipoCambio : list) {
            cbxDivisa1.addItem(tipoCambio.toString());
            cbxDivisa2.addItem(tipoCambio.toString());
        }
    }
    
    public double getCantidad(){
        
        return Double.parseDouble(txtCantidad.getText());
    
    }
    
    public String getDivisa1(){
        return (String) cbxDivisa1.getSelectedItem();
    }
    
    public String getDivisa2(){
        return (String) cbxDivisa2.getSelectedItem();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblValor1 = new javax.swing.JLabel();
        lblValor2 = new javax.swing.JLabel();
        lblValor3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        cbxDivisa1 = new javax.swing.JComboBox<>();
        cbxDivisa2 = new javax.swing.JComboBox<>();
        btnConvert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CONVESOR DE MONEDAS");

        lblValor1.setText("1 PES DOMINICANO ES : ");

        lblValor2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        lblValor2.setText("0.0001");

        lblValor3.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lblValor3.setText("DOLAR ESTADO UNIDENCE");

        cbxDivisa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDivisa1ActionPerformed(evt);
            }
        });

        cbxDivisa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDivisa2ActionPerformed(evt);
            }
        });

        btnConvert.setText("CONVERT");
        btnConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConvert)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblValor2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblValor3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblValor1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCambio, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxDivisa2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxDivisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel1)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(lblValor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor2)
                    .addComponent(lblValor3))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDivisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDivisa2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConvert)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxDivisa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDivisa1ActionPerformed
       lblValor1.setText("1" + " " + getDivisa1() + " " + "es");
    }//GEN-LAST:event_cbxDivisa1ActionPerformed

    private void cbxDivisa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDivisa2ActionPerformed
        lblValor3.setText(getDivisa2());
    }//GEN-LAST:event_cbxDivisa2ActionPerformed

    private void btnConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertActionPerformed
          if (txtCantidad.getText() != "") {

            double amount = getCantidad();
            String fromCurrency = getDivisa1();
            String toCurrenccy = getDivisa2();

            double converCurrency = tipoCambio.convertCurrency(fromCurrency, toCurrenccy, amount);
        
            
            txtCambio.setText(df.format(converCurrency));
            lblValor2.setText(df.format(tipoCambio.getValor()));
        }
        else{
            JOptionPane.showMessageDialog(null, "Campos vacios...");
        }
    }//GEN-LAST:event_btnConvertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConvert;
    private javax.swing.JComboBox<String> cbxDivisa1;
    private javax.swing.JComboBox<String> cbxDivisa2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblValor1;
    private javax.swing.JLabel lblValor2;
    private javax.swing.JLabel lblValor3;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
