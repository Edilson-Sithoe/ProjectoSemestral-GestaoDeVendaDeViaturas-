/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.ac.uem.projecto.telas;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import mz.ac.uem.projecto.conexao.ConexaoM;

/**
 *
 * @author Edilson
 */
public class Login extends javax.swing.JFrame {

    private Point point = new Point();

    /**
     * Criacao da conexao com banco de dados.
     */
    Connection conectar = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Este Metodo é responsavel por perimitir a entrada ou autenticação dos
     * usuarios registrados no sistema.
     *
     * @author Edilson
     * @see Login
     */
    public void entrar() {
        String sql = "select * from tabelausuarios where login = ? and senha = ?";
        try {
            /**
             * As linhas a baixo preparam a consulta ao banco de dados em função
             * do que foi digitado nas caixas de texto O Interroga (?) é
             * sibstituido pelo conteudo das vaiaveis.
             */
            pst = conectar.prepareStatement(sql);
            pst.setString(1, txtUsuario.getText());
            pst.setString(2, txtSenha.getText());

            /**
             * A linha a baixo é responsavel pela execução da query.
             */
            rs = pst.executeQuery();

            if (rs.next()) {
                /**
                 * A linha abaixo obtem o conteúdo do campo perfil da tabela
                 * tabelausuarios.
                 */
                String perfil = rs.getString(5);

                /**
                 * a estrutura abaixo faz o tratamento do perfildo usuario e
                 * caso seja Administrador ele habilita algumas funcionadlidades
                 * que só o Administrador pode exercer.
                 */
                if (perfil.equals("Administrador")) {
                    MenuPrincipal principal = new MenuPrincipal();
                    principal.setVisible(true);
                    MenuPrincipal.jmRelatorio.setEnabled(true);
                    MenuPrincipal.jmiUsuario.setEnabled(true);
                    MenuPrincipal.jmiViaturas.setEnabled(true);
                    MenuPrincipal.lblUsuario.setText(rs.getString(2));
                    this.dispose();
                } else {
                    MenuPrincipal principal = new MenuPrincipal();
                    principal.setVisible(true);
                    MenuPrincipal.lblUsuario.setText(rs.getString(2));
                    this.dispose();
                }

            } else {
                //     JOptionPane.showMessageDialog(rootPane, "Usuario E/Ou Senha Invalido(s)!!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    /**
     * Criação do novo formulario Login.
     */
    public Login() {
        initComponents();
        conectar = ConexaoM.conection();
        /**
         * a linha a baixo serve de apoio para o estado de conexao
         */
        System.out.println(conectar);

        if (conectar != null) {
//            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mz/ac/uem/projecto/icones/conet.png")));
        } else {
//            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mz/ac/uem/projecto/icones/Nconeta.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPainelInferior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        lblStatus = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        jpPainelSuperior = new javax.swing.JPanel();
        lblTelaLogin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema De Aluguer De Viaturas");
        setAutoRequestFocus(false);
        setExtendedState(MAXIMIZED_BOTH);
        setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jpPainelInferior.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mz.ac.uem.projecto.icones/user_uknownr.png"))); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        txtSenha.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        lblStatus.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblStatus.setText("Estado");

        btnEntrar.setBackground(new java.awt.Color(0, 153, 153));
        btnEntrar.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarMouseExited(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(255, 0, 0));
        btnSair.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairMouseExited(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblUser.setText("Usuario:");

        lblSenha.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        lblSenha.setText("Senha:");

        javax.swing.GroupLayout jpPainelInferiorLayout = new javax.swing.GroupLayout(jpPainelInferior);
        jpPainelInferior.setLayout(jpPainelInferiorLayout);
        jpPainelInferiorLayout.setHorizontalGroup(
            jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelInferiorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelInferiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelInferiorLayout.createSequentialGroup()
                        .addGroup(jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSenha)
                            .addComponent(lblUser))
                        .addGap(18, 18, 18)
                        .addGroup(jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPainelInferiorLayout.createSequentialGroup()
                                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpPainelInferiorLayout.createSequentialGroup()
                                .addGroup(jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelInferiorLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273))))
        );
        jpPainelInferiorLayout.setVerticalGroup(
            jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainelInferiorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addGap(7, 7, 7)
                .addGroup(jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnEntrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jpPainelSuperior.setBackground(new java.awt.Color(0, 204, 204));
        jpPainelSuperior.setFocusCycleRoot(true);
        jpPainelSuperior.setFocusTraversalPolicyProvider(true);

        lblTelaLogin.setFont(new java.awt.Font("Baskerville Old Face", 0, 48)); // NOI18N
        lblTelaLogin.setText("Tela De Login");

        javax.swing.GroupLayout jpPainelSuperiorLayout = new javax.swing.GroupLayout(jpPainelSuperior);
        jpPainelSuperior.setLayout(jpPainelSuperiorLayout);
        jpPainelSuperiorLayout.setHorizontalGroup(
            jpPainelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelSuperiorLayout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(lblTelaLogin)
                .addGap(200, 200, 200))
        );
        jpPainelSuperiorLayout.setVerticalGroup(
            jpPainelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTelaLogin)
                .addGap(19, 19, 19))
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        lblHora.setBackground(new java.awt.Color(0, 0, 0));
        lblHora.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("Hora:");
        lblHora.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblData.setBackground(new java.awt.Color(0, 0, 0));
        lblData.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData.setText("Data:");
        lblData.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora)
                    .addComponent(lblData))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPainelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPainelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpPainelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPainelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 305, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(724, 470));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        int sair = JOptionPane.showConfirmDialog(rootPane, "Deseja Realmente Sair?", "Atencao", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
        btnEntrar.setBackground(new Color(235, 235, 235));
        btnEntrar.setForeground(new Color(58, 65, 84));
    }//GEN-LAST:event_btnEntrarMouseEntered

    /**
     * Chamada do metodo entrar O Codigo a baixo é responsavel pelo evento ou
     * pela vibracação que a tela de login da no caso de introduizer dados
     * incorectos.
     */
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        Point p = this.getLocation();
        Login login = this;
        new Thread() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 6; i++) {
                        login.setLocation(p.x - 10, p.y);
                        sleep(200);
                        login.setLocation(p.x - 10, p.y);
                        sleep(200);
                    }
                    login.setLocation(p.x, p.y);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.start();
        entrar();

    }//GEN-LAST:event_btnEntrarActionPerformed

    /**
     * A instrução a baixo é responsavel pela mudança de cor no botao sair, ao
     * passar o mouse pelo btnSair ele muda de cor.
     */
    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered

        btnSair.setBackground(new Color(235, 235, 235));
        btnSair.setForeground(new Color(217, 81, 51));
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseExited
        /**
         * A instrução a baixo é responsavel pela mudança de cor no botao
         * entrar, ao passar o mouse pelo btnEntrar ele muda de cor.
         */
        btnEntrar.setBackground(new Color(58, 65, 84));
        btnEntrar.setForeground(Color.white);
    }//GEN-LAST:event_btnEntrarMouseExited

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        /**
         * A instrução a baixo é responsavel pela mudança de cor no botao sair,
         * ao passar o mouse pelo btnSair ele muda de cor.
         */
        btnSair.setBackground(new Color(217, 81, 51));
        btnSair.setForeground(Color.white);
    }//GEN-LAST:event_btnSairMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        /**
         *
         */
        point.x = evt.getX();
        point.y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        /**
         * Chamada e aplicaçáo do metodo responsavel pela vibraçáo da tela
         * Login.
         */
        Point p = this.getLocation();
        this.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }//GEN-LAST:event_formMouseDragged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        /**
         * Este formWindowOpened é responsavel por chamar a data logo ao
         * inicializar a tela principal.
         */
        java.util.Date dataSistema = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        lblData.setText(formato.format(dataSistema));

        Timer time = new Timer(1000, new Login.hora());
        time.start();

    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpPainelInferior;
    private javax.swing.JPanel jpPainelSuperior;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTelaLogin;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    /**
     * Esta classe é responsavel por pegar a hora do sistema e colar na tela ao
     * inicilizar, também é responsavel por definir como deve mostrar a hora.
     */
    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Calendar now = Calendar.getInstance();
            lblHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }

}
