
package login_page;

import java.awt.Color;
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class MainPg extends javax.swing.JFrame {

   private Animator animate;
   private Animator animator;
   private boolean isStart;
   
    public MainPg() {
        initComponents();
          // for the backgroud colour and the image and title 
        getContentPane().setBackground(new Color(255,255,255));
        setIconImage(new ImageIcon(getClass().getResource("/icon/page/ict.png")).getImage());
        setTitle("Standard Login with Animation");
        
        
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                if (isStart) {
                     slider1.setMinate(fraction);
                }else{
                     slider1.setMinate(1f-fraction);
                }
                
            }

            @Override
            public void end() {
            if (isStart) {
            login.setVisible(false);
            slider1.setSetpaint(false);
            panel_Transparent1.setAlpha(0);
            panel_Transparent1.setVisible(true);
            animator.start();
           
                }else{
                    userText.grabFocus();
                    commandAction(true);
                }
          
            }
        };
          TimingTarget targ = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                if (isStart) {
                     panel_Transparent1.setAlpha(fraction);
                }else{
                      panel_Transparent1.setAlpha(1f-fraction);
                }
         
          
            }

            @Override
            public void end() {
                if (isStart==false) {
                    slider1.setVisible(true);
                    slider1.setSetpaint(false);
                    panel_Transparent1.setAlpha(1);
                    login.setVisible(true);
                    panel_Transparent1.setVisible(false);
                    animate.start();
                }
            
            }

                
        
        };
    animate = new Animator(2000, target);
    animator = new Animator(1000, targ);
    animator.setResolution(0);
    animator.setAcceleration(0.5f);
    animator.setDeceleration(0.5f);
    animate.setResolution(0);
    animate.setAcceleration(0.5f);
    animate.setDeceleration(0.5f);
     
    }

    private void commandAction (boolean action){
        userText.setEditable(action);
        passWord.setEditable(action);
        cmdButton.setEnabled(action);
    }
    
    private void Texted(){
        userText.setText(" ");
        userText.setHelperText(" ");
        passWord.setText("");
        passWord.setHelperText("");
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slider1 = new Component.slider();
        login = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        imageAvatar1 = new Swing.ImageAvatar();
        userText = new Swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        passWord = new Swing.PasswordField();
        cmdButton = new Swing.Button();
        panel_Transparent1 = new Swing.Panel_Transparent();
        paneltra = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        header1 = new Component.header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        slider1.setLayout(new java.awt.CardLayout());

        login.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);

        imageAvatar1.setBorderSize(1);
        imageAvatar1.setBorderSpace(1);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/page/icons8-user-60.png"))); // NOI18N

        userText.setLabelText("Enter username");
        userText.setLineColor(new java.awt.Color(88, 11, 88));
        userText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User");

        passWord.setLabelText("Enter password");
        passWord.setLineColor(new java.awt.Color(88, 11, 88));
        passWord.setSelectionColor(new java.awt.Color(153, 0, 153));

        cmdButton.setBackground(new java.awt.Color(88, 11, 88));
        cmdButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmdButton.setForeground(new java.awt.Color(255, 255, 255));
        cmdButton.setText("Login");
        cmdButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(cmdButton, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGap(80, 80, 80))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(passWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(userText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        slider1.add(login, "card2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        paneltra.setViewportView(jTable1);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_Transparent1Layout = new javax.swing.GroupLayout(panel_Transparent1);
        panel_Transparent1.setLayout(panel_Transparent1Layout);
        panel_Transparent1Layout.setHorizontalGroup(
            panel_Transparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Transparent1Layout.createSequentialGroup()
                .addContainerGap(812, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addComponent(header1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paneltra)
        );
        panel_Transparent1Layout.setVerticalGroup(
            panel_Transparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Transparent1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneltra, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        slider1.add(panel_Transparent1, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdButtonActionPerformed
        if (!animate.isRunning()) {
            isStart = true;
            String user = userText.getText().trim();
            String pass = String.valueOf(passWord.getPassword());
            boolean cmButton =true;
            if (user.equals("")) {
                userText.setHelperText("enter username");
                userText.grabFocus();
                cmButton = false;
            }
            if (pass.equals("")) {
                passWord.setHelperText("enter password");
                if (cmButton) {
                    passWord.grabFocus();
                }
                cmButton =false;
                }
            if (cmButton) {
                animate.start();
                commandAction(false);
               
                         }
              
        }
       
    }//GEN-LAST:event_cmdButtonActionPerformed

    private void userTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           isStart = false;
           Texted();
           animator.start();
           
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.Button cmdButton;
    private Component.header header1;
    private Swing.ImageAvatar imageAvatar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel login;
    private Swing.Panel_Transparent panel_Transparent1;
    private javax.swing.JScrollPane paneltra;
    private Swing.PasswordField passWord;
    private Component.slider slider1;
    private Swing.TextField userText;
    // End of variables declaration//GEN-END:variables
}
