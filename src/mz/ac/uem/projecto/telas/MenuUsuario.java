/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.ac.uem.projecto.telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import mz.ac.uem.projecto.conexao.ConexaoM;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Edilson
 */
public class MenuUsuario extends javax.swing.JInternalFrame {

    /**
     * Criacao da conexao com banco de dados.
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public MenuUsuario() {
        initComponents();
        conexao = ConexaoM.conection();

        btnApagar.setEnabled(false);
        btnEditar.setEnabled(false);
    }

    private void adicionar() {

        String sql = "insert into tabelausuarios (usuario, tefelone, login ,pefil, senha) values (?, ?, ?, ?, ?) ";
        try {
            pst = conexao.prepareStatement(sql);
            //     pst.setString(1, txtCliId.getText());
            pst.setString(1, txtNomeUser.getText());
            pst.setString(2, txtTelefone.getText());
            pst.setString(3, txtLogin.getText());
            pst.setString(4, cboPerfil.getSelectedItem().toString());
            pst.setString(5, txtSenha.getText());

            /**
             * validacao dos campos obrigatorios.
             */
            if ((txtLogin.getText().isEmpty()) || (txtSenha.getText().isEmpty()) || (txtNomeUser.getText().isEmpty()) || (txtTelefone.getText().isEmpty() || (cboPerfil.getSelectedItem().toString().isEmpty()))) {
                JOptionPane.showMessageDialog(rootPane, "Preencha Os Campos Obrigatorios");
            } else {

                /**
                 * a linha abaixo atualiza a tabela de usuario comando para
                 * confirmar a inseecao.
                 */
                int adicionado = pst.executeUpdate();
                //    System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Usuario Cadastrado");
                    txtIDsuario.setText(null);
                    txtLogin.setText(null);
                    txtNomeUser.setText(null);
                    txtSenha.setText(null);
                    txtTelefone.setText(null);

                    btnApagar.setEnabled(false);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private void pesquisar_usuario() {
        String sql = "select * from tabelausuarios where usuario like ?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, txtPesquisar.getText() + "%");
            rs = pst.executeQuery();

            tabelaUsuario.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
    }

    public void limpar_campos() {
        int limpar = tabelaUsuario.getSelectedRow();
        txtIDsuario.setText(null);
        txtLogin.setText(null);
        txtNomeUser.setText(null);
        txtTelefone.setText(null);
        txtSenha.setText(null);

        btnAdicionar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnApagar.setEnabled(false);
    }

    public void setar_campos() {
        int setar = tabelaUsuario.getSelectedRow();
        txtIDsuario.setText(tabelaUsuario.getModel().getValueAt(setar, 0).toString());
        txtNomeUser.setText(tabelaUsuario.getModel().getValueAt(setar, 1).toString());
        txtTelefone.setText(tabelaUsuario.getModel().getValueAt(setar, 2).toString());
        txtLogin.setText(tabelaUsuario.getModel().getValueAt(setar, 3).toString());
        cboPerfil.setSelectedItem(tabelaUsuario.getModel().getValueAt(setar, 4).toString());
        txtSenha.setText(tabelaUsuario.getModel().getValueAt(setar, 5).toString());

        btnApagar.setEnabled(true);
        btnEditar.setEnabled(true);

        btnAdicionar.setEnabled(false);
    }

       /**
     * metodo para alterar dados *
     */
    private void alterar() {
        String sql = "update tabelausuarios set usuario = ?, tefelone = ?, login = ?, pefil = ?, senha = ? where iduser = ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeUser.getText());
            pst.setString(2, txtTelefone.getText());
            pst.setString(3, txtLogin.getText());
            pst.setString(4, cboPerfil.getSelectedItem().toString());
            pst.setString(5, txtSenha.getText());
            pst.setString(6, txtIDsuario.getText());

            if ((txtLogin.getText().isEmpty()) || (txtSenha.getText().isEmpty()) || (txtNomeUser.getText().isEmpty()) || (txtTelefone.getText().isEmpty() || (cboPerfil.getSelectedItem().toString().isEmpty()))) {
                JOptionPane.showMessageDialog(rootPane, "Preencha Os Campos Obrigatorios");
            } else {
                 /**
                 * a linha abixo atualiza a tabela de usuario comando para
                 * confirmar a inseecao *
                 */

                int adicionado = pst.executeUpdate();
                //  System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Dados Do Usuario Alterados");
                    txtIDsuario.setText(null);
                    txtLogin.setText(null);
                    txtNomeUser.setText(null);
                    txtSenha.setText(null);
                    txtTelefone.setText(null);

                    btnAdicionar.setEnabled(true);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
   /**
     * metodo para remover *
     */
    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(rootPane, "Deseja Realmente Remover Este Usuario?", "Atencao!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_NO_OPTION) {
            String sql = "delete from tabelausuarios where iduser = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtIDsuario.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Usuario Eliminado");
                    txtLogin.setText(null);
                    txtNomeUser.setText(null);
                    txtSenha.setText(null);
                    txtTelefone.setText(null);
                    txtPesquisar.setText(null);

                    btnAdicionar.setEnabled(true);;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIdCliente = new javax.swing.JLabel();
        lblNomeUser = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIDsuario = new javax.swing.JTextField();
        txtNomeUser = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        cboPerfil = new javax.swing.JComboBox();
        txtPesquisar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tabelaCliente = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuarios");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        lblIdCliente.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblIdCliente.setText("Id:");

        lblNomeUser.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblNomeUser.setText("*Nome:");

        lblLogin.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblLogin.setText("*Login:");

        lblSenha.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblSenha.setText("*Senha:");

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel5.setText("Telefone:");

        lblPerfil.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblPerfil.setText("Perfil:");

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel7.setText("* Campos Obrigatorios");

        txtIDsuario.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        txtIDsuario.setEnabled(false);

        txtNomeUser.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        txtLogin.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        txtTelefone.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        txtSenha.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        cboPerfil.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        cboPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuario", "Administrador" }));

        txtPesquisar.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mz.ac.uem.projecto.icones/pes.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIdCliente)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNomeUser)
                                .addComponent(lblLogin)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIDsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtLogin)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblPerfil)
                                        .addGap(10, 10, 10))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNomeUser)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTelefone))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(cboPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                        .addGap(461, 461, 461)))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdCliente)
                            .addComponent(jLabel7)
                            .addComponent(txtIDsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeUser)
                            .addComponent(txtNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLogin)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        btnAdicionar.setBackground(new java.awt.Color(0, 0, 0));
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mz.ac.uem.projecto.icones/create.png"))); // NOI18N
        btnAdicionar.setToolTipText("Salvar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mz.ac.uem.projecto.icones/update.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnApagar.setBackground(new java.awt.Color(0, 0, 0));
        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mz.ac.uem.projecto.icones/delete.png"))); // NOI18N
        btnApagar.setToolTipText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(0, 0, 0));
        btnLimpar.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(0, 204, 204));
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar Formulario");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );

        tabelaUsuario.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Telefone", "Login", "Perfil"
            }
        ));
        tabelaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUsuarioMouseClicked(evt);
            }
        });
        tabelaCliente.setViewportView(tabelaUsuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabelaCliente)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed

    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        limpar_campos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased

        pesquisar_usuario();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuarioMouseClicked

        setar_campos();
    }//GEN-LAST:event_tabelaUsuarioMouseClicked

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed

        remover();
    }//GEN-LAST:event_btnApagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox cboPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNomeUser;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JScrollPane tabelaCliente;
    private javax.swing.JTable tabelaUsuario;
    private javax.swing.JTextField txtIDsuario;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNomeUser;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
