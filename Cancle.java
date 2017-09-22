

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cancel extends javax.swing.JFrame {
int row,click1;
String click;
    public Cancel() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Your booked flights are:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight Number", "Flight Name", "Departure Time", "Arrival Time", "Seats booked", "Origin City", "Destination City"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Cancel Selected booking");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(263, 263, 263)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton1)
                .addGap(45, 45, 45)
                .addComponent(jButton2)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>                        

    private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     
        String query="select * from booking";
        String fnum=null;
        
        
        
        
        try{
                            Class.forName("org.h2.Driver");
          Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa", "");

             Statement st=con.createStatement();
             ResultSet rs= st.executeQuery(query);
             
Class.forName("org.h2.Driver");
          Connection con1 = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa", "");
                        
             
             
             DefaultTableModel t=(DefaultTableModel) jTable1.getModel();
         
         while(rs.next())
         {   fnum=rs.getString("fnumber");  
             int ffnum=Integer.parseInt(fnum);
             String seat=rs.getString("seatnum");
         String query1="select * from flight where fnumber='"+ffnum+"'";
             Statement st1=con1.createStatement();
             ResultSet rs1= st1.executeQuery(query1);
         
         while(rs1.next())
         {
             String fname=rs1.getString("fname");
             String dtime=rs1.getString("dtime");
             String atime=rs1.getString("atime");
             String dcity=rs1.getString("dcity");
             String ocity=rs1.getString("ocity");
             t.addRow(new Object[]{fnum,fname,dtime,atime,seat,ocity,dcity});
             
             
         }
         }
         
         
         con.close(); 
      }
        
      
      catch(Exception e)
      {
          e.printStackTrace();
      };
    }                                    

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
      try{
        row=jTable1.getSelectedRow();
        click=(jTable1.getModel().getValueAt(row, 0).toString());
        String click01=(jTable1.getModel().getValueAt(row, 4).toString());
        click1=Integer.parseInt(click01);
        
        
        
       }
       
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }                                    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       int remseat,newseat;
       String rem;
        String query="Select seatnum from flight where fnumber='"+click+"'";
        String query1="delete from booking where fnumber='"+click+"'";
        
        try{
         Class.forName("org.h2.Driver");
          Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa", "");
            Statement  st=con.createStatement();
          Statement  st1=con.createStatement();
          
         Class.forName("org.h2.Driver");
          Connection con1 = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa", "");
             
          ResultSet rs= st.executeQuery(query);
          while(rs.next())
          {
             rem= rs.getString("seatnum");
                remseat=Integer.parseInt(rem);
          newseat=remseat+click1;
          String query2="update flight set seatnum='"+newseat+"' where fnumber='"+click+"'";
          Statement  st2=con1.createStatement();
          st2.executeUpdate(query2);
          }
          st1.executeUpdate(query1);
          
            JOptionPane.showMessageDialog(null, "Booking Cancelled!");
          
          
          
          con.close();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
        this.dispose();
        new UserPanel().setVisible(true);
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
this.dispose();
new UserPanel().setVisible(true);
    }                                        

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
            java.util.logging.Logger.getLogger(Cancel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cancel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cancel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cancel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cancel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
