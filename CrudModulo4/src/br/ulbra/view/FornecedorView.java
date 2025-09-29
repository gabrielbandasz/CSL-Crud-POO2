package br.ulbra.view;

import br.ulbra.controller.FornecedorController;
import br.ulbra.model.Fornecedor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FornecedorView extends javax.swing.JFrame {

    public FornecedorView() {
        initComponents();
        controller = new FornecedorController();
        this.setLocationRelativeTo(null);
        initTableModel();
        atualizarTabela();
        setBotoes(0);
    }

    private void limparCampos() {
        TxtIdFor.setText("");
        TxtNomeRazaoFor.setText("");
        TxtNomeFantasiaFor.setText("");
        TxtTelefoneFor.setText("");
        TxtEmailFor.setText("");
        DefaultTableModel model = (DefaultTableModel) tbFornecedor.getModel();
        model.setRowCount(0);  // apaga todas as linhas;
    }

    private FornecedorController controller;

    private void atualizarTabela() {
        try {
            DefaultTableModel modelTbl = (DefaultTableModel) tbFornecedor.getModel();
            modelTbl.setRowCount(0);
            List<Fornecedor> lista = controller.listar();
            for (Fornecedor u : lista) {
                modelTbl.addRow(new Object[]{u.getIdFor(), u.getNomeRazao(), u.getNomeFantasia(), u.getTelefone(), u.getEmail()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "erro ao listar:" + ex.getMessage());
        }
    }

    public void setBotoes(int op) {
        switch (op) {
            case 1:
                BtnSalvarFor.setEnabled(false);
                BtnExcluirFor.setEnabled(true);
                BtnEditarFor.setEnabled(true);
                break;
            default:
                BtnSalvarFor.setEnabled(true);
                BtnExcluirFor.setEnabled(false);
                BtnEditarFor.setEnabled(false);
        }
    }

    private void initTableModel() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"id", "nome", "email", "telefone"}) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tbFornecedor.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtIdFor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtNomeRazaoFor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtNomeFantasiaFor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtTelefoneFor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtEmailFor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFornecedor = new javax.swing.JTable();
        BtnSalvarFor = new javax.swing.JButton();
        BtnLimparFor = new javax.swing.JButton();
        BtnEditarFor = new javax.swing.JButton();
        BtnExcluirFor = new javax.swing.JButton();
        BtnListarFor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("FORNECEDOR");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID");

        TxtIdFor.setBackground(new java.awt.Color(255, 255, 255));
        TxtIdFor.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nome (Razão)");

        TxtNomeRazaoFor.setBackground(new java.awt.Color(255, 255, 255));
        TxtNomeRazaoFor.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nome (Fantasia)");

        TxtNomeFantasiaFor.setBackground(new java.awt.Color(255, 255, 255));
        TxtNomeFantasiaFor.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefone");

        TxtTelefoneFor.setBackground(new java.awt.Color(255, 255, 255));
        TxtTelefoneFor.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("E-mail");

        TxtEmailFor.setBackground(new java.awt.Color(255, 255, 255));
        TxtEmailFor.setForeground(new java.awt.Color(0, 0, 0));

        tbFornecedor.setBackground(new java.awt.Color(255, 255, 255));
        tbFornecedor.setForeground(new java.awt.Color(0, 0, 0));
        tbFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbFornecedor);

        BtnSalvarFor.setBackground(new java.awt.Color(255, 255, 255));
        BtnSalvarFor.setForeground(new java.awt.Color(0, 0, 0));
        BtnSalvarFor.setText("SALVAR");
        BtnSalvarFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarForActionPerformed(evt);
            }
        });

        BtnLimparFor.setBackground(new java.awt.Color(255, 255, 255));
        BtnLimparFor.setForeground(new java.awt.Color(0, 0, 0));
        BtnLimparFor.setText("LIMPAR");
        BtnLimparFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparForActionPerformed(evt);
            }
        });

        BtnEditarFor.setBackground(new java.awt.Color(255, 255, 255));
        BtnEditarFor.setForeground(new java.awt.Color(0, 0, 0));
        BtnEditarFor.setText("EDITAR");
        BtnEditarFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarForActionPerformed(evt);
            }
        });

        BtnExcluirFor.setBackground(new java.awt.Color(255, 255, 255));
        BtnExcluirFor.setForeground(new java.awt.Color(0, 0, 0));
        BtnExcluirFor.setText("EXCLUIR");
        BtnExcluirFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirForActionPerformed(evt);
            }
        });

        BtnListarFor.setBackground(new java.awt.Color(255, 255, 255));
        BtnListarFor.setForeground(new java.awt.Color(0, 0, 0));
        BtnListarFor.setText("LISTAR");
        BtnListarFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnListarForActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2)
                    .addComponent(TxtIdFor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNomeRazaoFor, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TxtNomeFantasiaFor, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(TxtTelefoneFor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(TxtEmailFor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnSalvarFor)
                        .addGap(18, 18, 18)
                        .addComponent(BtnLimparFor)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEditarFor)
                        .addGap(18, 18, 18)
                        .addComponent(BtnExcluirFor)
                        .addGap(18, 18, 18)
                        .addComponent(BtnListarFor)))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtIdFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtNomeRazaoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtNomeFantasiaFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtTelefoneFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtEmailFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSalvarFor)
                    .addComponent(BtnLimparFor)
                    .addComponent(BtnEditarFor)
                    .addComponent(BtnExcluirFor)
                    .addComponent(BtnListarFor))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSalvarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarForActionPerformed
        try {
            String nomeRazao = TxtNomeRazaoFor.getText().trim();
            String nomeFantasia = TxtNomeFantasiaFor.getText().trim();
            String telefone = TxtTelefoneFor.getText().trim();
            String email = TxtEmailFor.getText().trim();
            if (nomeRazao.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Nome é obrigatório");
                return;
            }
            Fornecedor f = new Fornecedor(0, nomeRazao, nomeFantasia, telefone, email);
            controller.salvar(f);
            javax.swing.JOptionPane.showMessageDialog(this, "Fornecedor salvo (ID=" + f.getIdFor() + ")");
            atualizarTabela();
            limparCampos();
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());

        }    }//GEN-LAST:event_BtnSalvarForActionPerformed

    private void BtnLimparForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparForActionPerformed
        TxtIdFor.setText(null);
        TxtNomeFantasiaFor.setText(null);
        TxtNomeRazaoFor.setText(null);
        TxtEmailFor.setText(null);
        TxtTelefoneFor.setText(null);    }//GEN-LAST:event_BtnLimparForActionPerformed

    private void BtnEditarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarForActionPerformed
        try {
            int id = Integer.parseInt(TxtIdFor.getText());
            String nomeRazao = TxtNomeRazaoFor.getText().trim();
            String nomeFantasia = TxtNomeFantasiaFor.getText().trim();
            String email = TxtEmailFor.getText().trim();
            String tel = TxtTelefoneFor.getText().trim();
            Fornecedor f = new Fornecedor(id, nomeRazao, nomeFantasia, email, tel);
            controller.atualizar(f);
            javax.swing.JOptionPane.showMessageDialog(this, "Atualizado com sucesso");
            atualizarTabela();
            limparCampos();
        } catch (NumberFormatException nfe) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente para atualizar");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + ex.getMessage());
        }    }//GEN-LAST:event_BtnEditarForActionPerformed

    private void BtnListarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnListarForActionPerformed
        atualizarTabela();
        setBotoes(0);
    }//GEN-LAST:event_BtnListarForActionPerformed

    private void BtnExcluirForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirForActionPerformed
        try {
            int id = Integer.parseInt(TxtIdFor.getText());
            int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Remover cliente ID " + id + "?", "Confirma", javax.swing.JOptionPane.YES_NO_OPTION);
            if (confirm != javax.swing.JOptionPane.YES_OPTION) {
                return;
            }
            controller.excluir(id);
            javax.swing.JOptionPane.showMessageDialog(this, "Removido");
            atualizarTabela();
            limparCampos();
        } catch (NumberFormatException nfe) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente para remover");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao remover: " + ex.getMessage());
        }    }//GEN-LAST:event_BtnExcluirForActionPerformed

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
            java.util.logging.Logger.getLogger(FornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FornecedorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditarFor;
    private javax.swing.JButton BtnExcluirFor;
    private javax.swing.JButton BtnLimparFor;
    private javax.swing.JButton BtnListarFor;
    private javax.swing.JButton BtnSalvarFor;
    private javax.swing.JTextField TxtEmailFor;
    private javax.swing.JTextField TxtIdFor;
    private javax.swing.JTextField TxtNomeFantasiaFor;
    private javax.swing.JTextField TxtNomeRazaoFor;
    private javax.swing.JTextField TxtTelefoneFor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFornecedor;
    // End of variables declaration//GEN-END:variables
}
