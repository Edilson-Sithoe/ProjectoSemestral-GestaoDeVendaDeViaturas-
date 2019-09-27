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
public class MenuCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public MenuCliente() {
        initComponents();
        conexao = ConexaoM.conection();

        btnApagar.setEnabled(false);
        btnEditar.setEnabled(false);
    }

    // tabelaclientes
    private void adicionar() {

        String sql = "insert into tabelaclientes (nomeCliente, sexoCliente, dataNascimento ,biCliente, nuitCliente, emailCliente, telefoneCliente, enderecoCliente, provCliente) values (?, ?, ?, ?, ?,?,?,?,?) ";
        try {
            pst = conexao.prepareStatement(sql);
            //     pst.setString(1, txtCliId.getText());
            pst.setString(1, txtNome.getText());
            pst.setString(2, cboSexo.getSelectedItem().toString());
            pst.setString(3, txtDataNascimento.getText());
            pst.setString(4, txtBI.getText());
            pst.setString(5, txtNuit.getText());
            pst.setString(6, txtEmail.getText());
            pst.setString(7, txtTelefone.getText());
            pst.setString(8, txtEndereco.getText());
            pst.setString(9, cboProvincia.getSelectedItem().toString());

            if ((txtNome.getText().isEmpty()) || (txtBI.getText().isEmpty()) || (txtDataNascimento.getText().isEmpty()) || (txtEmail.getText().isEmpty() || (cboProvincia.getSelectedItem().toString().isEmpty())) || (txtEndereco.getText().isEmpty()) || (txtNuit.getText().isEmpty()) || (txtTelefone.getText().isEmpty()) || (cboSexo.getSelectedItem().toString().isEmpty())) {
                JOptionPane.showMessageDialog(rootPane, "Preencha Os Campos Obrigatorios");
            } else {

                int adicionado = pst.executeUpdate();
                //    System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Cliente Cadastrado");
                    txtBI.setText(null);
                    txtDataNascimento.setText(null);
                    txtEmail.setText(null);
                    txtEndereco.setText(null);
                    txtTelefone.setText(null);
                    txtIDCliente.setText(null);
                    txtNome.setText(null);
                    txtNuit.setText(null);
                    txtPesquisar.setText(null);

                    btnApagar.setEnabled(false);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private void pesquisar_cliente() {
        String sql = "select * from tabelaclientes where nomeCliente like ?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, txtPesquisar.getText() + "%");
            rs = pst.executeQuery();

            tabelaCliente.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
    }

    public void limpar_campos() {
        int limpar = tabelaCliente.getSelectedRow();
        txtBI.setText(null);
        txtDataNascimento.setText(null);
        txtEmail.setText(null);
        txtEndereco.setText(null);
        txtTelefone.setText(null);
        txtIDCliente.setText(null);
        txtNome.setText(null);
        txtNuit.setText(null);
        txtPesquisar.setText(null);

        btnAdicionar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnApagar.setEnabled(false);
    }

    public void setar_campos() {
        int setar = tabelaCliente.getSelectedRow();
        txtIDCliente.setText(tabelaCliente.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tabelaCliente.getModel().getValueAt(setar, 1).toString());
        cboSexo.setSelectedItem(tabelaCliente.getModel().getValueAt(setar, 2).toString());
        txtDataNascimento.setText(tabelaCliente.getModel().getValueAt(setar, 3).toString());
        txtBI.setText(tabelaCliente.getModel().getValueAt(setar, 4).toString());
        txtNuit.setText(tabelaCliente.getModel().getValueAt(setar, 5).toString());
        txtEmail.setText(tabelaCliente.getModel().getValueAt(setar, 6).toString());
        txtTelefone.setText(tabelaCliente.getModel().getValueAt(setar, 7).toString());
        txtEndereco.setText(tabelaCliente.getModel().getValueAt(setar, 8).toString());
        cboProvincia.setSelectedItem(tabelaCliente.getModel().getValueAt(setar, 9).toString());

        btnApagar.setEnabled(true);
        btnEditar.setEnabled(true);

        btnAdicionar.setEnabled(false);
    }

    private void alterar() {
        String sql = "update tabelaclientes set nomeCliente = ?, sexoCliente = ?, dataNascimento = ?, biCliente = ?, nuitCliente = ?, emailCliente = ?, telefoneCliente = ?, enderecoCliente = ?, provCliente = ? where idCliente = ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, cboSexo.getSelectedItem().toString());
            pst.setString(3, txtDataNascimento.getText());
            pst.setString(4, txtBI.getText());
            pst.setString(5, txtNuit.getText());
            pst.setString(6, txtEmail.getText());
            pst.setString(7, txtTelefone.getText());
            pst.setString(8, txtEndereco.getText());
            pst.setString(9, cboProvincia.getSelectedItem().toString());
            pst.setString(10, txtIDCliente.getText());

            if ((txtNome.getText().isEmpty()) || (txtBI.getText().isEmpty()) || (txtDataNascimento.getText().isEmpty()) || (txtEmail.getText().isEmpty() || (cboProvincia.getSelectedItem().toString().isEmpty())) || (txtEndereco.getText().isEmpty()) || (txtNuit.getText().isEmpty()) || (txtTelefone.getText().isEmpty()) || (cboSexo.getSelectedItem().toString().isEmpty())) {
                JOptionPane.showMessageDialog(rootPane, "Preencha Os Campos Obrigatorios");
            } else {

                int adicionado = pst.executeUpdate();
                //  System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Dados Do Cliente Alterados");
                    txtBI.setText(null);
                    txtDataNascimento.setText(null);
                    txtEmail.setText(null);
                    txtEndereco.setText(null);
                    txtTelefone.setText(null);
                    txtIDCliente.setText(null);
                    txtNome.setText(null);
                    txtNuit.setText(null);
                    txtPesquisar.setText(null);

                    btnAdicionar.setEnabled(true);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(rootPane, "Deseja Realmente Remover Este Usuario?", "Atencao!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_NO_OPTION) {
            String sql = "delete from tabelaclientes where idCliente = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtIDCliente.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Cliente Eliminado");
                    txtBI.setText(null);
                    txtDataNascimento.setText(null);
                    txtEmail.setText(null);
                    txtEndereco.setText(null);
                    txtTelefone.setText(null);
                    txtIDCliente.setText(null);
                    txtNome.setText(null);
                    txtNuit.setText(null);
                    txtPesquisar.setText(null);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblClienteId = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDCliente = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblBICliente = new javax.swing.JLabel();
        txtNuit = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtEndereco = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        lblProvincia = new javax.swing.JLabel();
        txtBI = new javax.swing.JTextField();
        cboSexo = new javax.swing.JComboBox();
        lblDataNascimento = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JTextField();
        lblNuit = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cboProvincia = new javax.swing.JComboBox();
        txtPesquisar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 0, 0));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");
        setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        btnAdicionar.setBackground(new java.awt.Color(0, 0, 0));
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mz.ac.uem.projecto.icones/create.png"))); // NOI18N
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mz.ac.uem.projecto.icones/update.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnApagar.setBackground(new java.awt.Color(0, 0, 0));
        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mz.ac.uem.projecto.icones/delete.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnApagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
            .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        lblClienteId.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblClienteId.setText("Id:");

        lblNomeCliente.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblNomeCliente.setText("*Nome:");

        lblSexo.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblSexo.setText("Sexo:");

        lblEndereco.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblEndereco.setText("*Endereco:");

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel5.setText("* Campos Obrigatorios");

        txtIDCliente.setEnabled(false);
        txtIDCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDClienteActionPerformed(evt);
            }
        });

        txtNome.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblTelefone.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblTelefone.setText("*Telefone::");

        lblEmail.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblEmail.setText("E-mail:");

        lblBICliente.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblBICliente.setText("B.I. n:");

        txtNuit.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        txtNuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuitActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        txtEndereco.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        lblProvincia.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblProvincia.setText("Provincia");

        txtBI.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        txtBI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBIActionPerformed(evt);
            }
        });

        cboSexo.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        cboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        lblDataNascimento.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblDataNascimento.setText("Data de Nascimento:");

        txtDataNascimento.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        txtDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascimentoActionPerformed(evt);
            }
        });

        lblNuit.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblNuit.setText("Nuit:");

        txtEmail.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        cboProvincia.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        cboProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Maputo-Cidade", "Maputo-Provincia", "Gaza", "Inhambane", "Manica", "Sofala", "Niassa", "Zambezia", "Tete", "Nampula", "Cabo Delgado" }));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNomeCliente)
                            .addComponent(lblClienteId)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblBICliente)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 197, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBI)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblNuit))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSexo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboSexo, 0, 197, Short.MAX_VALUE)
                            .addComponent(txtNuit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblDataNascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblEmail)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail)))))
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField17)
                        .addGap(193, 193, 193))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblProvincia)
                        .addGap(18, 18, 18)
                        .addComponent(cboProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClienteId))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeCliente)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDataNascimento)
                        .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSexo))
                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBICliente)
                        .addComponent(txtBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNuit))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNuit))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(lblEndereco)
                    .addComponent(lblProvincia)
                    .addComponent(cboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabelaCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabelaCliente.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Sexo", "Data deNascimento", "B.I.", "Nuit", "Email", "Telefone", "Endereco", "Provincia"
            }
        ));
        jScrollPane1.setViewportView(tabelaCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDClienteActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtNuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNuitActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void txtBIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBIActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        pesquisar_cliente();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        remover();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        limpar_campos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascimentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox cboProvincia;
    private javax.swing.JComboBox cboSexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JLabel lblBICliente;
    private javax.swing.JLabel lblClienteId;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNuit;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTextField txtBI;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNuit;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
