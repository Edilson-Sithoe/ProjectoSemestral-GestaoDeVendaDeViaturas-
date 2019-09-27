/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.ac.uem.projecto.telas;

/**
 *
 * @author Edilson Mahumane
 */
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ProgressoBar extends JFrame implements ActionListener {

    private int count = 0;
    private Timer Tempo = null;
    JProgressBar progresso;
    JPanel painel;
    JFrame janela;

    public ProgressoBar() throws InterruptedException {

        /*     ImageIcon background_image = new ImageIcon(getClass().getResource("..\\Imagens\\FundoVO.jpg"));
         Image img = background_image.getImage();
         Image temo_img = img.getScaledInstance(2000, 1100, Image.SCALE_SMOOTH);
         background_image = new ImageIcon(temo_img);
         JLabel painel = new JLabel("", background_image, JLabel.CENTER);*/
        Tempo = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                progresso.setValue(count);
                if (progresso.getValue() < 100) {
                    progresso.setValue(progresso.getValue() + 1);
                }
                if (progresso.getValue() == 100) {
                    Tempo.stop();
                    dispose();
                    new MenuPrincipal();
                    dispose();
                }
            }
        });

        Tempo.start();
        progresso = new JProgressBar();
        progresso.setBounds(100, 250, 750, 30);
        progresso.setBackground(Color.WHITE);
        progresso.setForeground(Color.BLACK);
        painel.setBounds(0, 0, 1010, 610);
        painel.add(progresso);
        janela = new JFrame();
        janela.setSize(1000, 700);
    //    janela.setExtendedState(MAXIMIZED_BOTH);
        janela.setUndecorated(true);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.add(painel);
    }

    public static void main(String[] args) throws InterruptedException {
        new ProgressoBar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
