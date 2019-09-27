package mz.ac.uem.projecto.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Edilson
 */
public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jpPainelInferior = new javax.swing.JPanel();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jmbBar = new javax.swing.JMenuBar();
        jmRegistro = new javax.swing.JMenu();
        jmiClientes = new javax.swing.JMenuItem();
        jmiAlDev = new javax.swing.JMenuItem();
        jmiUsuario = new javax.swing.JMenuItem();
        jmiViaturas = new javax.swing.JMenuItem();
        jmRelatorio = new javax.swing.JMenu();
        jmiReGeral = new javax.swing.JMenuItem();
        jmiReContas = new javax.swing.JMenuItem();
        jmiAluguer = new javax.swing.JMenuItem();
        jmAjuda = new javax.swing.JMenu();
        jmiSobre = new javax.swing.JMenuItem();
        jmOpcao = new javax.swing.JMenu();
        jmiSair = new javax.swing.JMenuItem();

        setExtendedState(MAXIMIZED_BOTH);
        setForeground(new java.awt.Color(0, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        desktop.setBackground(new java.awt.Color(0, 0, 0));
        desktop.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        jpPainelInferior.setBackground(new java.awt.Color(0, 153, 153));

        lblHora.setBackground(new java.awt.Color(0, 51, 51));
        lblHora.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("Hora:");
        lblHora.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblData.setBackground(new java.awt.Color(0, 51, 51));
        lblData.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData.setText("Data:");
        lblData.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUsuario.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario\n");
        lblUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpPainelInferiorLayout = new javax.swing.GroupLayout(jpPainelInferior);
        jpPainelInferior.setLayout(jpPainelInferiorLayout);
        jpPainelInferiorLayout.setHorizontalGroup(
            jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelInferiorLayout.createSequentialGroup()
                .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addGap(152, 152, 152)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jpPainelInferiorLayout.setVerticalGroup(
            jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainelInferiorLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jpPainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(lblHora)
                    .addComponent(lblUsuario))
                .addContainerGap())
        );

        jmbBar.setBackground(new java.awt.Color(0, 102, 102));
        jmbBar.setForeground(new java.awt.Color(255, 255, 255));

        jmRegistro.setText("Registro");
        jmRegistro.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        jmiClientes.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jmiClientes.setText("Clientes");
        jmiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClientesActionPerformed(evt);
            }
        });
        jmRegistro.add(jmiClientes);

        jmiAlDev.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jmiAlDev.setText("Aluguer/Devolução");
        jmRegistro.add(jmiAlDev);

        jmiUsuario.setBackground(new java.awt.Color(0, 102, 102));
        jmiUsuario.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jmiUsuario.setText("Usuarios");
        jmiUsuario.setEnabled(false);
        jmiUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuarioActionPerformed(evt);
            }
        });
        jmRegistro.add(jmiUsuario);

        jmiViaturas.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jmiViaturas.setText("Viaturas");
        jmiViaturas.setEnabled(false);
        jmiViaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViaturasActionPerformed(evt);
            }
        });
        jmRegistro.add(jmiViaturas);

        jmbBar.add(jmRegistro);

        jmRelatorio.setText("Relatório");
        jmRelatorio.setEnabled(false);
        jmRelatorio.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        jmiReGeral.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jmiReGeral.setText("Relatório Geral");
        jmRelatorio.add(jmiReGeral);

        jmiReContas.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jmiReContas.setText("Relatório De Contas");
        jmRelatorio.add(jmiReContas);

        jmiAluguer.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jmiAluguer.setText("Relatório Aluguer");
        jmRelatorio.add(jmiAluguer);

        jmbBar.add(jmRelatorio);

        jmAjuda.setText("Ajuda");
        jmAjuda.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        jmiSobre.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jmiSobre.setText("Sobre");
        jmAjuda.add(jmiSobre);

        jmbBar.add(jmAjuda);

        jmOpcao.setText("Opções");
        jmOpcao.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N

        jmiSair.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jmiSair.setText("Sair");
        jmOpcao.add(jmiSair);

        jmbBar.add(jmOpcao);

        setJMenuBar(jmbBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpPainelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(desktop)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPainelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jmiUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsuarioActionPerformed
        // TODO add your handling code here:
        MenuUsuario usuario = new MenuUsuario();
        usuario.setVisible(true);
        desktop.add(usuario);
    }//GEN-LAST:event_jmiUsuarioActionPerformed

    private void jmiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClientesActionPerformed
        // TODO add your handling code here:
        MenuCliente cliente = new MenuCliente();
        cliente.setVisible(true);
        desktop.add(cliente);
    }//GEN-LAST:event_jmiClientesActionPerformed

    private void jmiViaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViaturasActionPerformed
        MenuViatura viatura = new MenuViatura();
        viatura.setVisible(true);
        desktop.add(viatura);
    }//GEN-LAST:event_jmiViaturasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        lblData.setText(formato.format(dataSistema));

        Timer time = new Timer(1000, new hora());
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JMenu jmOpcao;
    javax.swing.JMenu jmRegistro;
    public static javax.swing.JMenu jmRelatorio;
    private javax.swing.JMenuBar jmbBar;
    private javax.swing.JMenuItem jmiAlDev;
    private javax.swing.JMenuItem jmiAluguer;
    private javax.swing.JMenuItem jmiClientes;
    private javax.swing.JMenuItem jmiReContas;
    private javax.swing.JMenuItem jmiReGeral;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiSobre;
    public static javax.swing.JMenuItem jmiUsuario;
    public static javax.swing.JMenuItem jmiViaturas;
    private javax.swing.JPanel jpPainelInferior;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblHora;
    public static javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Calendar now = Calendar.getInstance();
            lblHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }

}
