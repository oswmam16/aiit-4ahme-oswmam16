/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetwork.gui;

import com.google.gson.Gson;
import javanetwork.worker.ConnectionWorker;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import javanetwork.Server;
import javanetwork.Server.Response;

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
        jlabTimer = new javax.swing.JLabel();
        jpanNorth = new javax.swing.JPanel();
        jtabRefTime = new javax.swing.JLabel();
        jsliRefresh = new javax.swing.JSlider();
        jlabRefTimeBack = new javax.swing.JLabel();
        jpanEast = new javax.swing.JPanel();
        jbutEnd = new javax.swing.JButton();
        jbutClear = new javax.swing.JButton();
        jbutStart = new javax.swing.JButton();
        jbutStop = new javax.swing.JButton();
        jbutDisconnet = new javax.swing.JButton();
        jbutConnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanCenter.setLayout(new java.awt.GridBagLayout());

        jlabTimer.setFont(new java.awt.Font("Tahoma", 1, 52)); // NOI18N
        jlabTimer.setText("0.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jpanCenter.add(jlabTimer, gridBagConstraints);

        getContentPane().add(jpanCenter, java.awt.BorderLayout.CENTER);

        jtabRefTime.setText("Refreshrate: 1s");
        jpanNorth.add(jtabRefTime);

        jsliRefresh.setToolTipText("");
        jsliRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jpanNorth.add(jsliRefresh);

        jlabRefTimeBack.setText("1ms");
        jpanNorth.add(jlabRefTimeBack);

        getContentPane().add(jpanNorth, java.awt.BorderLayout.NORTH);

        jpanEast.setLayout(new java.awt.GridBagLayout());

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
        jpanEast.add(jbutEnd, gridBagConstraints);

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
        jpanEast.add(jbutClear, gridBagConstraints);

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
        jpanEast.add(jbutStart, gridBagConstraints);

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
        jpanEast.add(jbutStop, gridBagConstraints);

        jbutDisconnet.setText("Disconect");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpanEast.add(jbutDisconnet, gridBagConstraints);

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
        jpanEast.add(jbutConnect, gridBagConstraints);

        getContentPane().add(jpanEast, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jbutConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutConnectActionPerformed
        try {
            System.out.println("Button pressed" + Thread.currentThread().getId());
            ConnectionWorker worker = new MyConnectionWorker(8080, "127.0.0.1");
            worker.execute();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbutConnectActionPerformed

    private void jbutStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutStartActionPerformed
        jbutStart.setEnabled(false);
        jbutStop.setEnabled(true);
        jbutClear.setEnabled(true);
        jbutEnd.setEnabled(true);
    }//GEN-LAST:event_jbutStartActionPerformed

    private void jbutStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutStopActionPerformed
        jbutStart.setEnabled(true);
        jbutStop.setEnabled(false);
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
    private javax.swing.JPanel jpanEast;
    private javax.swing.JPanel jpanNorth;
    private javax.swing.JSlider jsliRefresh;
    private javax.swing.JLabel jtabRefTime;
    // End of variables declaration//GEN-END:variables

    public void handleResponse(Response resp) {
        
    }
    
    private class MyConnectionWorker extends ConnectionWorker {
        private Response resp;
        private Socket socket;

        public MyConnectionWorker(int port, String host) throws IOException {
            super(port, host);
        }
        
        @Override
        protected String doInBackground() throws Exception {
        
            final Gson g = new Gson();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            while(true) {
                try {
                    final Server s = new Server();
                    final Server.Request req = s.new Request();
                    final String reqString = g.toJson(req);
                    writer.write(reqString);
                    writer.flush();

                    final String respString = reader.readLine();
                    final Response resp = g.fromJson(respString, Response.class);
                    publish(resp);
                    
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        
        }

        @Override
        protected void process(List<Response> list) {
            Response resp = list.get(0);
            
            if(resp.isMaster()) {
                jbutConnect.setEnabled(false);
                jbutDisconnet.setEnabled(true);
                jbutStart.setEnabled(true);
                jbutStop.setEnabled(true);
                jbutClear.setEnabled(true);
                jbutEnd.setEnabled(true);
            }
            
            if(resp.isRunning()) {
                jlabTimer.setText(String.format("%.3f", resp.getTime()));
            }
        }
    }
}
