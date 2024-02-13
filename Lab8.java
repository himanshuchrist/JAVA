/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author himanshugulechha
 */
public class Lab8 extends javax.swing.JFrame {

    /**
     * Creates new form Lab8
     */
    public Lab8() {
        initComponents();
        connect();
        Load();
    }
    Connection con;
    PreparedStatement pat;
    DefaultTableModel def;
    
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/Christ","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Load(){
        try {
            pat=con.prepareStatement("select * from Attendee");
            ResultSet rs=pat.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            int c;
            c=rss.getColumnCount();
            def=(DefaultTableModel)jTable1.getModel();
            def.setRowCount(0);
            while(rs.next()){
                Vector v=new Vector();
                for(int i=0;i<c;i++){
                    v.add(rs.getString("ID"));
                    v.add(rs.getString("name"));
                    v.add(rs.getString("email"));
                    v.add(rs.getString("contact"));
                    v.add(rs.getString("country"));
                }
                def.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        contactTF = new javax.swing.JTextField();
        countryCB = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        statsButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultTB = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Christ (Deemed to be University)");

        jButton1.setBackground(new java.awt.Color(255, 51, 0));
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setText("Full Name:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 204));
        jLabel3.setText("Please enter you details");

        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });

        emailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTFActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("Contact No.:");

        contactTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactTFActionPerformed(evt);
            }
        });

        countryCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "India", "Canada", "UK", "USA", "UAE" }));
        countryCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryCBActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel6.setText("Country:");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Update");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "name", "email", "contact", "country"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        statsButton.setText("Stats");
        statsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsButtonActionPerformed(evt);
            }
        });

        resultTB.setColumns(20);
        resultTB.setRows(5);
        jScrollPane2.setViewportView(resultTB);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(18, 18, 18)
                                .addComponent(editButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton)
                                .addGap(18, 18, 18)
                                .addComponent(statsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameTF))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailTF))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(contactTF))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(countryCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(jButton1)
                    .addComponent(searchButton)
                    .addComponent(statsButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        System.exit(0);
    }                                        

    private void countryCBActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void contactTFActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void emailTFActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        String name,email,country;
        name=nameTF.getText();
        email=emailTF.getText();
        int contact=Integer.parseInt(contactTF.getText());
        country=countryCB.getSelectedItem().toString();
        try {
            pat=con.prepareStatement("insert into Attendee(name,email,contact,country) values(?,?,?,?)");
            pat.setString(1,name);
            pat.setString(2,email);
            pat.setInt(3,contact);
            pat.setString(4,country);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this,"Records Added");
            Load();
            nameTF.setText("");
            emailTF.setText("");
            contactTF.setText("");
            countryCB.setSelectedIndex(0);
            nameTF.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                         

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            // TODO add your handling code here:
            def=(DefaultTableModel)jTable1.getModel();
            int selected=jTable1.getSelectedRow();
            int id=Integer.parseInt(def.getValueAt(selected,0).toString());
            String name,email,country;
            name=nameTF.getText();
            email=emailTF.getText();
            int contact=Integer.parseInt(contactTF.getText());
            country=countryCB.getSelectedItem().toString();
            pat=con.prepareStatement("update Attendee set name=?,email=?,contact=?,country=? where ID=?");
            pat.setString(1,name);
            pat.setString(2,email);
            pat.setInt(3,contact);
            pat.setString(4, country);
            pat.setInt(5, id);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this,"Records Updated");
            Load();
            nameTF.setText("");
            emailTF.setText("");
            contactTF.setText("");
            countryCB.setSelectedIndex(0);
            nameTF.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                          

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        def=(DefaultTableModel)jTable1.getModel();
        int selected=jTable1.getSelectedRow();
        int id=Integer.parseInt(def.getValueAt(selected, 0).toString());
        nameTF.setText(def.getValueAt(selected, 1).toString());
        emailTF.setText(def.getValueAt(selected, 2).toString());
        contactTF.setText(def.getValueAt(selected, 3).toString());
        countryCB.setSelectedIndex(0);
    }                                    

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            // TODO add your handling code here:
            def=(DefaultTableModel)jTable1.getModel();
            int selected=jTable1.getSelectedRow();
            int id=Integer.parseInt(def.getValueAt(selected, 0).toString());
            pat=con.prepareStatement("delete from Attendee where id=?");
            pat.setInt(1, id);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this,"Records Deleted");
            Load();
            nameTF.setText("");
            emailTF.setText("");
            contactTF.setText("");
            countryCB.setSelectedIndex(0);
            nameTF.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                            

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            String name,country;
            name=nameTF.getText();
            country=countryCB.getSelectedItem().toString();
            if(country==" "){
               
               pat=con.prepareStatement("select * from Attendee where name=?");
                pat.setString(1, name);
            }
            else{
               pat=con.prepareStatement("select * from Attendee where country=?"); 
               pat.setString(1, country);
            }
            ResultSet rs=pat.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            int c;
            c=rss.getColumnCount();
            def=(DefaultTableModel)jTable1.getModel();
            def.setRowCount(0);
            while(rs.next()){
                Vector v=new Vector();
                for(int i=0;i<c;i++){
                    v.add(rs.getString("ID"));
                    v.add(rs.getString("name"));
                    v.add(rs.getString("email"));
                    v.add(rs.getString("contact"));
                    v.add(rs.getString("country"));
                }
                def.addRow(v);
            }
            countryCB.setSelectedIndex(0);
            nameTF.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }                                            

    private void statsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            // TODO add your handling code here:
            CallableStatement stmt=con.prepareCall("call getStats()");
            ResultSet rs=stmt.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            int c;
            c=rss.getColumnCount();
            while(rs.next()){
                Vector v=new Vector();
                for(int i=0;i<=c;i++){
                   resultTB.append(rs.getString(i));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(Lab8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lab8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lab8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lab8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lab8().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addButton;
    private javax.swing.JTextField contactTF;
    private javax.swing.JComboBox<String> countryCB;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField emailTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextArea resultTB;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton statsButton;
    // End of variables declaration                   
}