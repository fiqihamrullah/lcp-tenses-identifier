/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 
package leftcornerparsingfortenses;


import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.Util;

/**
 *
 * @author Fiqih Amrullah
 */
public class FrmIndentifikasiPT extends javax.swing.JFrame 
{
    private String tableheader[]=new String[]{"No","Token","Symbol"};     
    public FrmIndentifikasiPT() 
    {
        initComponents();
        Util.TengahWindow(this);
        setResizable(false);
        setTitle("Tenses Pattern Identification");
        viewTable(new DefaultTableModel(tableheader, 0));
    }
    
   public static DefaultTableModel ConvertTokenListToTableModel(List<Token > listwords,String header[])
   {
       DefaultTableModel dtm=null;
       Object[][] data = new Object[listwords.size()][header.length];
       for(int i=0;i<listwords.size();i++)
       {
          data[i][0] = i+1;
          data[i][1] = listwords.get(i).getName();
          data[i][2] =  listwords.get(i).getSymbol().getName();       
       }

       dtm = new DefaultTableModel(data, header);       
       return dtm;       
   }
      
    
    private void viewTable(DefaultTableModel dtm)
    {
        jtblTagger.setModel(dtm);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtKalimat = new javax.swing.JTextField();
        jlblTenseResult = new javax.swing.JLabel();
        jbtnDoParsing = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtLogResult = new javax.swing.JTextArea();
        jbtnExit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblTagger = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Sentence:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTxtKalimat.setText("I have gone to Bali Island");
        getContentPane().add(jTxtKalimat, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 470, 30));

        jlblTenseResult.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlblTenseResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTenseResult.setText("??????????????????");
        getContentPane().add(jlblTenseResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 300, 40));

        jbtnDoParsing.setText("Check Tense");
        jbtnDoParsing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDoParsingActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnDoParsing, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 98, -1));

        jTxtLogResult.setColumns(20);
        jTxtLogResult.setRows(5);
        jScrollPane1.setViewportView(jTxtLogResult);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 350, 100));

        jbtnExit.setText("Exit");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 140, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 94, 530, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 392, 110, 0));

        jtblTagger.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtblTagger);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 470, 110));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Name of Tense");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 200, -1));

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(51, 153, 255));

        jLabel3.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tenses Identifier ");

        jLabel4.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("with Left-Corner Parsing");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel4)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Identitas Kata");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 189, 470, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Analisis Parsing :");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
// TODO add your handling code here:
    this.dispose();
    System.exit(0);
}//GEN-LAST:event_jbtnExitActionPerformed
private void showPeringatan(String msg) 
{
    JOptionPane.showMessageDialog(null, msg,"Peringatan",JOptionPane.OK_OPTION);
}

private void jbtnDoParsingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDoParsingActionPerformed
// TODO add your handling code here:
    Kalimat kalimat = new Kalimat();
    kalimat.setKalimat(jTxtKalimat.getText());
    
    Tagger tagger = new Tagger();
    tagger.tokenizeAndTagKalimat(kalimat);
    viewTable(ConvertTokenListToTableModel(kalimat.getTokens(), tableheader));
      
    LeftCornerParser lcp = new LeftCornerParser();
    lcp.setLogger(jTxtLogResult);
    jTxtLogResult.setText("");
    lcp.doLeftCornerParsing(kalimat);
    if (lcp.isSentence())
    {
       TensesIdentifier ti = new TensesIdentifier(kalimat);
       if (ti.IsTense()==TensesIdentifier.PAST_TENSE_VERBAL) 
       {
         jlblTenseResult.setText("Past Tense Verbal");    
       }else if (ti.IsTense()==TensesIdentifier.PAST_TENSE_NOMINAL) 
       {
         jlblTenseResult.setText("Past Tense Nominal");    
       }else if (ti.IsTense()==TensesIdentifier.PRESENT_TENSE_NOMINAL) 
       {
         jlblTenseResult.setText("Present Tense Nominal");    
       }else if (ti.IsTense()==TensesIdentifier.PRESENT_TENSE_VERBAL) 
       {
         jlblTenseResult.setText("Present Tense Verbal");    
       }else if (ti.IsTense()==TensesIdentifier.PRESENT_PERPECT_NOMINAL) 
       {
         jlblTenseResult.setText("Present Perfect Nominal");    
       }else if (ti.IsTense()==TensesIdentifier.PRESENT_PERPECT_VERBAL) 
       {
         jlblTenseResult.setText("Present Perfect Verbal");    
       }else if (ti.IsTense()==TensesIdentifier.FUTURE_TENSE_NOMINAL) 
       {
         jlblTenseResult.setText("Future Tense Nominal");    
       }else if (ti.IsTense()==TensesIdentifier.FUTURE_TENSE_VERBAL) 
       {
         jlblTenseResult.setText("Future Tense Verbal");    
       }else if (ti.IsTense()==TensesIdentifier.UNIDENTIFIED_TENSE) {
         jlblTenseResult.setText("UNKNOWN Tense");      
       }
    }else{
       jlblTenseResult.setText("?????????"); 
       showPeringatan("Bukan Kalimat!\nSehingga Tidak bisa dilanjutkan.");
    }
  
}//GEN-LAST:event_jbtnDoParsingActionPerformed

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
            java.util.logging.Logger.getLogger(FrmIndentifikasiPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmIndentifikasiPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmIndentifikasiPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIndentifikasiPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmIndentifikasiPT().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTxtKalimat;
    private javax.swing.JTextArea jTxtLogResult;
    private javax.swing.JButton jbtnDoParsing;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JLabel jlblTenseResult;
    private javax.swing.JTable jtblTagger;
    // End of variables declaration//GEN-END:variables
}
