/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.bioskop;

import java.awt.Color;
import formadmin.login;
import formpembeli.loginpem;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ilham Bayu Sabdani
 */
public class COVER extends javax.swing.JFrame {

    /**
     * Creates new form COVER
     */
    int dragx,dragy;
    public COVER() {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(560, 288));
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Geometr415 Blk BT", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("PEMBELI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(470, 240, 270, 50);

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Geometr415 Blk BT", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ADMIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(470, 160, 270, 50);

        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 410);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/LOGO.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 110, 290, 190);

        jLabel4.setFont(new java.awt.Font("Geometr415 Blk BT", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TIKET BIOSKOP ONLINE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(460, 30, 310, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/COVER.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 410);

        setBounds(0, 0, 800, 414);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            new loginpem().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(COVER.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new login().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - dragx,y - dragy);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        dragx = evt.getX();
        dragy = evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

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
            java.util.logging.Logger.getLogger(COVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(COVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(COVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(COVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new COVER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
