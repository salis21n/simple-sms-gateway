/*
 * Copyright (C) 2018 SALIS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;



/**
 *
 * @author SALIS
 */
public class desktop extends javax.swing.JFrame {

    private int xMouse;
    private int yMouse;
    
    private void popup(){
        this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        panbg.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        
        for(double i=0.0;i<=1.0;i=i+0.1){
            String val=i+"F";
            float f=Float.valueOf(val);
            this.setOpacity(f);
            
            try{
                Thread.sleep(50);                
            }
            catch(Exception e){}
        }
         
        this.setExtendedState(0);
        ck_koneksi();
    }
    
    private void popdown(){
        for(double i=1.0;i>=0.0;i=i-0.1){
            String val=i+"F";
            float f=Float.valueOf(val);
            this.setOpacity(f);
            
            try{
                Thread.sleep(50);                
            }
            catch(Exception e){}                        
        }   
        this.setExtendedState(JFrame.ICONIFIED);
    }
    
    private void checkkeluar(){
    int tanya = JOptionPane.showConfirmDialog(null,"Are you sure want to exit ?");
        if(tanya==JOptionPane.YES_OPTION){
            popdown();
            System.exit(0);        
        }        
    }
    
    private void ck_koneksi(){
        boolean connectivity;
        try{
//            URL url = new URL("https://www.google.com");
            URL url = new URL("http://api.txtlocal.com/send/?");
            URLConnection conn= url.openConnection();
            conn.connect();
            connectivity =true;
            checkinternet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/g_connection.png")));
        }
        catch(Exception e){
            connectivity = false;
            checkinternet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/e_connection.png")));
        }
    
    }
    
    private void pesan(){

          try {
			// Construct data
                        String kotakpesan=smsbox.getText()+"\n"+"\nPowered by: PRIMEFORCE TECH.";
                        String nomer="+62"+numbox.getText();
                        String pengirim=senderbox.getText()+"";
                                                    
			String apiKey = "apikey=" + "oVGo2iCr1Kc-icqDTT6zexMzrvVN1JNBVHldLb1nH3";
			String message = "&message=" + kotakpesan;
			String sender = "&sender=" + pengirim;
			String numbers = "&numbers=" + nomer;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
                                                            stringBuffer.append(line);
                                                            System.out.println(line);
                                                            JOptionPane.showMessageDialog(null,"Status:"+"\n"+"Message Successfully Send.");
			}
			rd.close();

			
		} catch (Exception e) {
			System.out.println("Error SMS "+e);                        
                        JOptionPane.showMessageDialog(null,"Error:"+"\n"+"Please Check Your Connection !");
			
		}
        
    }
    
    /**
     * Creates new form desktop
     */
    public desktop() {
        initComponents();
        ck_koneksi();
//        smstopbar.setBackground(new java.awt.Color(1.0f,1.0f,1.0f,0.5f));

        min.setBackground(new java.awt.Color(1.0f,1.0f,1.0f,0.0f));
        cls.setBackground(new java.awt.Color(1.0f,1.0f,1.0f,0.0f));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon_logo.png")));
        senderbox.requestFocus(true);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panbg = new javax.swing.JPanel();
        tabcontrol1 = new javax.swing.JTabbedPane();
        tab_sms = new javax.swing.JPanel();
        senderbox = new javax.swing.JTextField();
        numbox1 = new javax.swing.JTextField();
        numbox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        smsbox = new javax.swing.JTextArea();
        btn_send = new javax.swing.JLabel();
        imgback = new javax.swing.JLabel();
        tab_about = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tab_credits = new javax.swing.JPanel();
        biodata = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        checkinternet = new javax.swing.JLabel();
        cls = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        smstopbar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SMS GATEWAY - PRIMEFORCE TECH");
        setUndecorated(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panbg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabcontrol1.setRequestFocusEnabled(false);
        tabcontrol1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabcontrol1MouseClicked(evt);
            }
        });

        tab_sms.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        senderbox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        senderbox.setForeground(new java.awt.Color(0, 51, 255));
        senderbox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        senderbox.setToolTipText("Fill Sender Box");
        senderbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senderboxActionPerformed(evt);
            }
        });
        senderbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senderboxKeyPressed(evt);
            }
        });
        tab_sms.add(senderbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 16, 227, 27));

        numbox1.setEditable(false);
        numbox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numbox1.setForeground(new java.awt.Color(0, 51, 255));
        numbox1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numbox1.setText("+62");
        numbox1.setToolTipText("Fill Number Box");
        numbox1.setFocusable(false);
        numbox1.setRequestFocusEnabled(false);
        numbox1.setVerifyInputWhenFocusTarget(false);
        numbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numbox1ActionPerformed(evt);
            }
        });
        numbox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numbox1KeyPressed(evt);
            }
        });
        tab_sms.add(numbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 53, 40, 27));

        numbox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numbox.setForeground(new java.awt.Color(0, 51, 255));
        numbox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        numbox.setToolTipText("Fill Number Box");
        numbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numboxActionPerformed(evt);
            }
        });
        numbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numboxKeyPressed(evt);
            }
        });
        tab_sms.add(numbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 53, 180, 27));

        smsbox.setColumns(20);
        smsbox.setRows(5);
        smsbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                smsboxKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(smsbox);

        tab_sms.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 90, 227, 125));

        btn_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send_default.png"))); // NOI18N
        btn_send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_sendMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_sendMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_sendMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_sendMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_sendMouseReleased(evt);
            }
        });
        tab_sms.add(btn_send, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 223, -1, -1));

        imgback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blur_bg_nothing.png"))); // NOI18N
        tab_sms.add(imgback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabcontrol1.addTab("SMS", tab_sms);

        tab_about.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blurgb_about.png"))); // NOI18N

        javax.swing.GroupLayout tab_aboutLayout = new javax.swing.GroupLayout(tab_about);
        tab_about.setLayout(tab_aboutLayout);
        tab_aboutLayout.setHorizontalGroup(
            tab_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_aboutLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tab_aboutLayout.setVerticalGroup(
            tab_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabcontrol1.addTab("About", tab_about);

        tab_credits.setBackground(new java.awt.Color(255, 255, 255));

        biodata.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        biodata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blurg_credits.png"))); // NOI18N

        javax.swing.GroupLayout tab_creditsLayout = new javax.swing.GroupLayout(tab_credits);
        tab_credits.setLayout(tab_creditsLayout);
        tab_creditsLayout.setHorizontalGroup(
            tab_creditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(biodata, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab_creditsLayout.setVerticalGroup(
            tab_creditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(biodata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabcontrol1.addTab("Credits", tab_credits);

        panbg.add(tabcontrol1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 400, 290));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        checkinternet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/g_connection.png"))); // NOI18N
        checkinternet.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(checkinternet)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkinternet)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        panbg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 390, 90));

        cls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_btn_close_d.png"))); // NOI18N
        cls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clsMouseReleased(evt);
            }
        });
        panbg.add(cls, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_btn_min_d.png"))); // NOI18N
        min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minMouseReleased(evt);
            }
        });
        panbg.add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        smstopbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_bar.png"))); // NOI18N
        smstopbar.setText("jLabel2");
        smstopbar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                smstopbarMouseDragged(evt);
            }
        });
        smstopbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                smstopbarMousePressed(evt);
            }
        });
        panbg.add(smstopbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 20));

        getContentPane().add(panbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void numboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numboxKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            checkkeluar();
        }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            smsbox.requestFocus();
        }
        if(evt.getKeyCode()==KeyEvent.VK_TAB){
            smsbox.requestFocus();
        }
    }//GEN-LAST:event_numboxKeyPressed

    private void numboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numboxActionPerformed

    private void smsboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_smsboxKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            checkkeluar();
        }
    }//GEN-LAST:event_smsboxKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        popup();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
    }//GEN-LAST:event_formWindowDeactivated

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

//          popup();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
        popup();
    }//GEN-LAST:event_formWindowDeiconified

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
 
    }//GEN-LAST:event_formMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
       
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
       
    }//GEN-LAST:event_formMouseReleased

    private void btn_sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sendMouseClicked
        pesan();
    }//GEN-LAST:event_btn_sendMouseClicked

    private void btn_sendMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sendMouseEntered
       btn_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send_hover.png")));
    }//GEN-LAST:event_btn_sendMouseEntered

    private void btn_sendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sendMouseExited
        btn_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send_default.png")));
    }//GEN-LAST:event_btn_sendMouseExited

    private void btn_sendMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sendMousePressed
        btn_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send_click.png")));
    }//GEN-LAST:event_btn_sendMousePressed

    private void btn_sendMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sendMouseReleased
        btn_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send_hover.png")));
    }//GEN-LAST:event_btn_sendMouseReleased

    private void smstopbarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smstopbarMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_smstopbarMousePressed

    private void smstopbarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smstopbarMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_smstopbarMouseDragged

    private void clsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clsMouseEntered
        cls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_btn_close_h.png")));
    }//GEN-LAST:event_clsMouseEntered

    private void clsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clsMouseExited
        cls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_btn_close_d.png")));
    }//GEN-LAST:event_clsMouseExited

    private void clsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clsMousePressed
        cls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_btn_close_c.png")));
    }//GEN-LAST:event_clsMousePressed

    private void clsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clsMouseReleased
        cls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_btn_close_h.png")));
    }//GEN-LAST:event_clsMouseReleased

    private void clsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clsMouseClicked
        checkkeluar();
    }//GEN-LAST:event_clsMouseClicked

    private void minMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseEntered
        min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_btn_min_h.png")));
    }//GEN-LAST:event_minMouseEntered

    private void minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseExited
        min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_btn_min_d.png")));
    }//GEN-LAST:event_minMouseExited

    private void minMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMousePressed
        min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_btn_min_c.png")));
    }//GEN-LAST:event_minMousePressed

    private void minMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseReleased
        min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_btn_min_h.png")));
    }//GEN-LAST:event_minMouseReleased

    private void minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseClicked
        popdown();
    }//GEN-LAST:event_minMouseClicked

    private void numbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numbox1ActionPerformed

    private void numbox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numbox1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_numbox1KeyPressed

    private void tabcontrol1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabcontrol1MouseClicked
        senderbox.requestFocus();
        
    }//GEN-LAST:event_tabcontrol1MouseClicked

    private void senderboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senderboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senderboxActionPerformed

    private void senderboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senderboxKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_TAB){
            numbox.requestFocus(true);
        }
        else if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            checkkeluar();
        }
    }//GEN-LAST:event_senderboxKeyPressed

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
            java.util.logging.Logger.getLogger(desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new desktop().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel biodata;
    private javax.swing.JLabel btn_send;
    private javax.swing.JLabel checkinternet;
    private javax.swing.JLabel cls;
    private javax.swing.JLabel imgback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel min;
    private javax.swing.JTextField numbox;
    private javax.swing.JTextField numbox1;
    private javax.swing.JPanel panbg;
    private javax.swing.JTextField senderbox;
    private javax.swing.JTextArea smsbox;
    private javax.swing.JLabel smstopbar;
    private javax.swing.JPanel tab_about;
    private javax.swing.JPanel tab_credits;
    private javax.swing.JPanel tab_sms;
    private javax.swing.JTabbedPane tabcontrol1;
    // End of variables declaration//GEN-END:variables
}
