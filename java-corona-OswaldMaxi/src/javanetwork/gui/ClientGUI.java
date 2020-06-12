/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetwork.gui;

import java.awt.Dimension;
import java.io.IOException;
import java.util.List;
import javanetwork.ConnectionWorker;
import javanetwork.Server.Response;
import javax.swing.JOptionPane;

/**
 *
 * @author maxio
 */
public class ClientGUI extends javax.swing.JFrame {
    
    ConnectionWorker worker;
    
    public ClientGUI() {
        initComponents();
        setTitle("Stopwatch");
        setMinimumSize(new Dimension(900, 390));
        jbutConnect.setEnabled(true);
        jbutDisconnet.setEnabled(false);
        jbutStart.setEnabled(false);
        jbutStop.setEnabled(false);
        jbutClear.setEnabled(false);
        jbutEnd.setEnabled(false);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpanCenter = new javax.swing.JPanel();
        jtabRefTime = new javax.swing.JLabel();
        jbutConnect = new javax.swing.JButton();
        jbutDisconnet = new javax.swing.JButton();
        jbutStart = new javax.swing.JButton();
        jbutStop = new javax.swing.JButton();
        jbutClear = new javax.swing.JButton();
        jbutEnd = new javax.swing.JButton();
        jsliRefresh = new javax.swing.JSlider();
        jlabTimer = new javax.swing.JLabel();
        jlabRefTimeBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanCenter.setLayout(new java.awt.GridBagLayout());

        jtabRefTime.setText("Refreshrate: 1s");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jpanCenter.add(jtabRefTime, gridBagConstraints);

        jbutConnect.setText("Connect");
        jbutConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutConnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpanCenter.add(jbutConnect, gridBagConstraints);

        jbutDisconnet.setText("Disconect");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpanCenter.add(jbutDisconnet, gridBagConstraints);

        jbutStart.setText("Start");
        jbutStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutStartActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpanCenter.add(jbutStart, gridBagConstraints);

        jbutStop.setText("Stop");
        jbutStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutStopActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpanCenter.add(jbutStop, gridBagConstraints);

        jbutClear.setText("Clear");
        jbutClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpanCenter.add(jbutClear, gridBagConstraints);

        jbutEnd.setText("End");
        jbutEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutEndActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpanCenter.add(jbutEnd, gridBagConstraints);

        jsliRefresh.setToolTipText("");
        jsliRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jpanCenter.add(jsliRefresh, gridBagConstraints);

        jlabTimer.setFont(new java.awt.Font("Tahoma", 1, 52)); // NOI18N
        jlabTimer.setText("0.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jpanCenter.add(jlabTimer, gridBagConstraints);

        jlabRefTimeBack.setText("1ms");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jpanCenter.add(jlabRefTimeBack, gridBagConstraints);

        getContentPane().add(jpanCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void showException(Exception ex) {
        JOptionPane.showMessageDialog(
                this,
                ex,
                "Warning...",
                JOptionPane.WARNING_MESSAGE
        );
    }
    
    /* Eigener Thread-----------------------------------------------------------
        private void upgradeTimer() {
            jlabTimer.setText(String.format("" + resp.getTime()));
        }
    */
    
    /* Eigener Thread-----------------------------------------------------------
        check refreshtime?!
    */

    
    private void jbutConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutConnectActionPerformed
        try {
            worker = new MyConnectionWorker(8080, this);
            worker.execute();
            jbutDisconnet.setEnabled(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbutConnectActionPerformed

    private void jbutStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutStartActionPerformed
        

//        if(resp.isRunning()) {
//            jbutStart.setEnabled(false);
//            jbutStop.setEnabled(true);
//            jbutClear.setEnabled(true);
//            jbutEnd.setEnabled(true);
//        }
        
    }//GEN-LAST:event_jbutStartActionPerformed

    private void jbutStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutStopActionPerformed
        
        
        
//        if(resp.isRunning()) {
//            jbutStart.setEnabled(true);
//            jbutStop.setEnabled(false);
//        }
        
    }//GEN-LAST:event_jbutStopActionPerformed

    private void jbutClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutClearActionPerformed
        
    }//GEN-LAST:event_jbutClearActionPerformed

    private void jbutEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutEndActionPerformed
        
        
        dispose();
    }//GEN-LAST:event_jbutEndActionPerformed

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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbutClear;
    private javax.swing.JButton jbutConnect;
    private javax.swing.JButton jbutDisconnet;
    private javax.swing.JButton jbutEnd;
    private javax.swing.JButton jbutStart;
    private javax.swing.JButton jbutStop;
    private javax.swing.JLabel jlabRefTimeBack;
    private javax.swing.JLabel jlabTimer;
    private javax.swing.JPanel jpanCenter;
    private javax.swing.JSlider jsliRefresh;
    private javax.swing.JLabel jtabRefTime;
    // End of variables declaration//GEN-END:variables

    public void handleResponse(Response resp) {
        
    }
    
    private class MyConnectionWorker extends ConnectionWorker {
        
        public MyConnectionWorker(int port, ClientGUI gui) throws IOException {
            super(port, gui);
        }

        @Override
        protected void process(List<Response> list) {
            super.process(list); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
