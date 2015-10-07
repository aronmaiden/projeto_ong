/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.view;

import com.projeto.ong.control.OficinaController;
import com.projeto.ong.entity.Endereco;
import com.projeto.ong.entity.Oficina;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.model.OficinaModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author aron.oliveira
 */
public class OficinaView extends javax.swing.JFrame {

    private OficinaModel model = new OficinaModel();
    private OficinaController controller = new OficinaController(model);

    /**
     * Creates new form ManutencaoProdutoView
     */
    public OficinaView() {
        initComponents();
        controller.carregarOficinas();
        doBindings();
    }

    private void doBindings() {
        BindingGroup bindingGroup = new BindingGroup();

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, model,
                ELProperty.create("${oficinas}"), masterTable);

        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${id}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Long.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(Date.class);
        
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${horario}"));
        columnBinding.setColumnName("Horario");
        columnBinding.setColumnClass(Date.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${participantes}"));
        columnBinding.setColumnName("Participantes");
        columnBinding.setColumnClass(Integer.class);       

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${foto}"));
        columnBinding.setColumnName("Foto");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${bairro}"));
        columnBinding.setColumnName("Bairro");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${cep}"));
        columnBinding.setColumnName("CEP");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${cidade}"));
        columnBinding.setColumnName("Cidade");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${uf}"));
        columnBinding.setColumnName("UF");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${rua}"));
        columnBinding.setColumnName("Rua");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${numero}"));
        columnBinding.setColumnName("Número");
        columnBinding.setColumnClass(Integer.class);

        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, model,
                ELProperty.create("${registroSelecionado != null}"), updateButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, model,
                ELProperty.create("${registroSelecionado != null}"), removeButton, BeanProperty.create("enabled"));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Oficina");
        setPreferredSize(new java.awt.Dimension(980, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(980, 600));

        masterTable.setModel(new OficinaTableModel());
        masterTable.getSelectionModel().addListSelectionListener(new OficinaTableModelListener());
        jScrollPane1.setViewportView(masterTable);

        closeButton.setText("Fechar");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Alterar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remover");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(removeButton)
                    .addComponent(updateButton)
                    .addComponent(addButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        model.setBackupRegistro(model.getRegistroSelecionado());
        Oficina novo = new Oficina();
        novo.setEndereco(new Endereco());
        model.setRegistroEditado(novo);
        new Thread(() -> {
            OficinaForm form = new OficinaForm(this, true);
            form.setTitle("Adicionar Oficina");
            form.setController(controller);
            form.setVisible(true);
        }).start();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        model.setBackupRegistro(model.getRegistroSelecionado());
        model.setRegistroEditado(model.getRegistroSelecionado());
        new Thread(() -> {
            OficinaForm form = new OficinaForm(this, true);
            form.setTitle("Alterar Oficina");
            form.setController(controller);
            form.setVisible(true);
        }).start();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro selecionado?",
                "Confirmação de remoção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            try {
                controller.remove(model.getRegistroSelecionado());
            } catch (BusinessException ex) {
                Logger.getLogger(OficinaView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OficinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OficinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OficinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OficinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new OficinaView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private class OficinaTableModel extends AbstractTableModel {

        private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        private List<Oficina> oficinas;
        private final String[] columnNames = {"ID", "Nome", "Data", "Horário", "Participantes", "Foto", "Endereço"};
        private final int COLUMN_COUNT = columnNames.length;

        public OficinaTableModel() {
            oficinas = new ArrayList();
        }

        public OficinaTableModel(List<Oficina> oficinas) {
            this();
            this.oficinas.addAll(oficinas);
        }

        @Override
        public int getRowCount() {
            return oficinas.size();
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
            Oficina oficina = oficinas.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return oficina.getId();
                case 1:
                    return oficina.getNome();
                case 2:
                    return oficina.getDataOficina();
                case 3:
                    return oficina.getHorario();
                case 4:
                    return oficina.getQtdPessoas();
                case 5:
                    return oficina.getFoto();
                case 6:
                    return oficina.getEndereco();
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Oficina oficina = oficinas.get(rowIndex);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat hf = new SimpleDateFormat("HH:MM");

            switch (columnIndex) {
                case 0:
                    oficina.setId(Long.parseLong(aValue.toString()));
                    break;
                case 1:
                    oficina.setNome(aValue.toString());
                    break;
                case 2: {
                    try {
                        oficina.setDataOficina(df.parse(aValue.toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(OficinaView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 3: {
                    try {
                        oficina.setHorario(df.parse(aValue.toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(OficinaView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 4: {
                    oficina.setQtdPessoas(Integer.parseInt(aValue.toString()));
                    break;
                }
                case 5:
                    oficina.setFoto(aValue.toString());
                    break;
                case 6:
                    oficina.setEndereco((Endereco) aValue);
                    break;
            }
            fireTableDataChanged();
        }
    }

    private class OficinaTableModelListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int row = masterTable.getSelectedRow();
            if (row >= 0) {
                Oficina o = model.getOficinas().get(row);
                Oficina backup = new Oficina();
                backup.setDataOficina(o.getDataOficina());
                backup.setEndereco(o.getEndereco());
                backup.setFoto(o.getFoto());
                backup.setHorario(o.getHorario());
                backup.setId(o.getId());
                backup.setNome(o.getNome());
                backup.setQtdPessoas(o.getQtdPessoas());
                model.setBackupRegistro(backup);

                Oficina selecionado = new Oficina();
                selecionado.setDataOficina(o.getDataOficina());
                selecionado.setEndereco(o.getEndereco());
                selecionado.setFoto(o.getFoto());
                selecionado.setHorario(o.getHorario());
                selecionado.setId(o.getId());
                selecionado.setNome(o.getNome());
                selecionado.setQtdPessoas(o.getQtdPessoas());

                model.setRegistroSelecionado(selecionado);
            }
        }
    }

}