/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.view;

import com.projeto.ong.dao.UsuarioDAO;
import com.projeto.ong.dao.UsuarioDAO;
import com.projeto.ong.entity.Usuario;
import com.projeto.ong.exception.BusinessException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author aron.oliveira
 */
public class UsuarioView extends javax.swing.JFrame {

    private List<Usuario> usuarioList = Collections.emptyList();
    private BindingGroup bindingGroup;
    private Usuario usuarioSelecionado;

    /**
     * Creates new form UsuarioView
     */
    public UsuarioView() {
        initComponents();
        myInitComponets();

    }

    private void myInitComponets() {
        bindingGroup = new BindingGroup();

        UsuarioDAO dao = new UsuarioDAO();
        usuarioList = ObservableCollections.observableList(dao.findAll());
        masterTable.setModel(new UsuarioView.UsuarioTableModel(usuarioList));

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, usuarioList, masterTable);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${login}"));
        columnBinding.setColumnName("Login");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${senha}"));
        columnBinding.setColumnName("Senha");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement.id}"), idField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, masterTable, ELProperty.create("${selectedElement.login}"), loginField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), loginField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, masterTable, ELProperty.create("${selectedElement.senha}"), senhaField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), senhaField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), deleteButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        bindingGroup.bind();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idField = new javax.swing.JTextField();
        loginField = new javax.swing.JTextField();
        senhaField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setText("Id:");

        jLabel3.setText("Login:");

        jLabel4.setText("Senha:");

        newButton.setText("Novo");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Excluir");

        saveButton.setText("Salvar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");

        masterTable.setModel(new UsuarioTableModel());
        masterTable.getSelectionModel().addListSelectionListener(new UsuarioMasterTableListSelectionListener());
        jScrollPane2.setViewportView(masterTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(newButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(saveButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cancelButton))
                                    .addComponent(senhaField)
                                    .addComponent(idField)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loginField)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(saveButton)
                    .addComponent(deleteButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginFieldActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
        Usuario u = new Usuario();
        usuarioList.add(u);
        int row = usuarioList.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
//        Usuario u = new Usuario();
//        Long id = 0L;
//
//        try {
//            id = Long.parseLong(idField.getText());
//
//        } catch (NumberFormatException e) {
//
//        }
//
//        u.setId(id);
//        u.setLogin(loginField.getText());
//        u.setSenha(senhaField.getText());
//
//        UsuarioDAO dao = new UsuarioDAO();
//
//        try {
//            dao.salvar(u);
//        } catch (BusinessException e) {
//            int selectedRow = masterTable.getSelectedRow();
//            usuarioList.remove(selectedRow);
//            int row = usuarioList.size() - 1;
//            if (row >= 0) {
//                masterTable.setRowSelectionInterval(row, row);
//                masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
//            }
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UsuarioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField loginField;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField senhaField;
    // End of variables declaration//GEN-END:variables

    private class UsuarioTableModel extends AbstractTableModel {

        private List<Usuario> usuarios;
        private final int COLUMN_COUNT = 3;
        private final String[] columnNames = {"ID", "Login", "Senha"};

        public UsuarioTableModel() {
            usuarios = new ArrayList();
        }

        public UsuarioTableModel(List<Usuario> usuarios) {
            this();
            this.usuarios.addAll(usuarios);
        }

        @Override
        public int getRowCount() {
            return usuarios.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_COUNT;
        }

        @Override
        public String getColumnName(int i) {
            return columnNames[i];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Usuario usuario = usuarios.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return usuario.getId();
                case 1:
                    return usuario.getLogin();
                case 2:
                    return usuario.getSenha();
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Usuario usuario = usuarios.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    usuario.setId(Long.parseLong(aValue.toString()));
                    break;
                case 1:
                    usuario.setLogin(aValue.toString());
                    break;
                case 2:
                    usuario.setSenha(aValue.toString());
                    break;
            }
            fireTableDataChanged();
        }
    }

    private class UsuarioMasterTableListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int row = masterTable.getSelectedRow();
            if (row >= 0) {
                Usuario u = usuarioList.get(row);
                usuarioSelecionado = new Usuario(u.getId(), u.getLogin(), u.getSenha());
            }
        }
    }
}