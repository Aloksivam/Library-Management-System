/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.ResultSet;
//import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.Date;
//import javax.swing.table.TableModel;

/**
 *
 * @author Alok Kumar
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssuedBook
     */
    public ReturnBook() {
        initComponents();
    }
//to fetch the issued book details from the database and display it to issued books panel;

    public void getIssueBookDetails() {
//        boolean success = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DBconnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookId);
            ps.setInt(2, studentId);
            ps.setString(3, "pending");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
//                sucess = true;
                lbl_book_id.setText(rs.getString("id"));
                lbl_book_name.setText(rs.getString("book_name"));
                lbl_student_name.setText(rs.getString("student_name"));
                lbl_issue_date.setText(rs.getString("issue_date"));
                lbl_due_date.setText(rs.getString("due_date"));
                lbl_bookError.setText(" ");
            } else {
                lbl_bookError.setText("No record found");
                lbl_book_id.setText("");
                lbl_book_name.setText("");
                lbl_student_name.setText("");
                lbl_issue_date.setText("");
                lbl_due_date.setText("");
//                lbl_bookError.setText(" ");
//                success = false;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//    return success;
    }

    public void updateBookCount() {
        int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            Connection con = DBconnection.getConnection();
            String sql = "update  book_details set quantity = quantity+1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "book updated");
            } else {
                JOptionPane.showMessageDialog(this, "can't update book count");
            }
        } catch (Exception e) {
        }

    }
    public boolean returnBook(){
        boolean isReturned = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DBconnection.getConnection();
            String sql = "update issue_book_details set status = ? where student_id = ? and book_id = ? and status = ?";
            PreparedStatement ps = con.prepareStatement(sql);
             
            ps.setString(1, "returned");
            ps.setInt(2, studentId);
             
            ps.setInt(3, bookId);
            ps.setString(4, "pending");
            int rowCount = ps.executeUpdate();
            isReturned = rowCount>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReturned;
        
    }

    //checking whether book is already allocated 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_issue_date = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_book_id = new javax.swing.JLabel();
        lbl_book_name = new javax.swing.JLabel();
        lbl_student_name = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        lbl_due_date = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 260, 5));

        jPanel6.setBackground(new java.awt.Color(255, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 0, 51));
        jLabel9.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 60));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 60, 60));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 260, 5));

        jPanel20.setBackground(new java.awt.Color(255, 0, 0));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setBackground(new java.awt.Color(255, 0, 51));
        jLabel31.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 255));
        jLabel31.setText("X");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        jPanel20.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 60));

        jPanel11.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 60, 60));

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 51));
        jLabel32.setText("Book Id:");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, -1, 20));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 51));
        jLabel33.setText("Student Id:");
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, -1, 20));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel27.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel21.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 260, 5));

        jPanel30.setBackground(new java.awt.Color(255, 0, 0));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setBackground(new java.awt.Color(255, 0, 51));
        jLabel48.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 255));
        jLabel48.setText("X");
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        jPanel30.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 60));

        jPanel21.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 60, 60));

        jLabel49.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 0, 51));
        jLabel49.setText("Book Id:");
        jPanel21.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, -1, 20));

        jLabel51.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 0, 51));
        jLabel51.setText("Student Id:");
        jPanel21.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, -1, 20));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 260, 5));

        jPanel40.setBackground(new java.awt.Color(255, 0, 0));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setBackground(new java.awt.Color(255, 0, 51));
        jLabel66.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 255));
        jLabel66.setText("X");
        jLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel66MouseClicked(evt);
            }
        });
        jPanel40.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 60));

        jPanel31.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 60, 60));

        jLabel67.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 0, 51));
        jLabel67.setText("Book Id:");
        jPanel31.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, -1, 20));

        jLabel69.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 0, 51));
        jLabel69.setText("Student Id:");
        jPanel31.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, -1, 20));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel47.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel41.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 260, 5));

        jPanel50.setBackground(new java.awt.Color(255, 0, 0));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setBackground(new java.awt.Color(255, 0, 51));
        jLabel84.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 0, 255));
        jLabel84.setText("X");
        jLabel84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel84MouseClicked(evt);
            }
        });
        jPanel50.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 60));

        jPanel41.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 60, 60));

        jLabel85.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 0, 51));
        jLabel85.setText("Book Id:");
        jPanel41.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, -1, 20));

        jLabel86.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 0, 51));
        jPanel41.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, -1, 20));

        jLabel87.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 0, 51));
        jLabel87.setText("Student Id:");
        jPanel41.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, -1, 20));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 0, 51));
        rSMaterialButtonCircle1.setText("Return Book");
        rSMaterialButtonCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel41.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 470, 330, 70));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 51)));
        txt_bookId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel41.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, 280, 30));

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(102, 204, 0));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("Book Details");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 320, 5));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 51));
        jPanel2.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 260, 60));

        lbl_issue_date.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_issue_date.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_issue_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 210, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book name:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Student Name:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Issue Id:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        lbl_book_id.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_book_id.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_book_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 210, 30));

        lbl_book_name.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_book_name.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_book_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 210, 30));

        lbl_student_name.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_student_name.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 210, 30));

        jLabel88.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Due Date:");
        jPanel2.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        jLabel89.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Issue Date:");
        jPanel2.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        lbl_due_date.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_due_date.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_due_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 210, 40));

        jPanel41.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 366, 710));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 51)));
        txt_studentId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel41.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 280, 280, 30));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 0, 255));
        rSMaterialButtonCircle2.setText("Find");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel41.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 370, 330, 70));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel12.setText("Return Book");
        jPanel41.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/library-2.png"))); // NOI18N
        jLabel8.setText("Issue Id:");
        jPanel41.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 80, 480, 580));

        jPanel31.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1361, 744));

        jPanel21.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1361, 744));

        jPanel11.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1361, 744));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1361, 744));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1361, 744));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
        homepage home = new homepage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        homepage home = new homepage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
        if(returnBook()==true)
        {JOptionPane.showMessageDialog(this, "book returned successfully");
        updateBookCount();}
        else{
                JOptionPane.showMessageDialog(this, "error occured");
                }

    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_rSMaterialButtonCircle1MouseClicked

    private void jLabel84MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel84MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel84MouseClicked

    private void jLabel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel66MouseClicked

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel48MouseClicked

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        // TODO add your handling code here:
        //if((txt_bookId.getText()!=""))

    }//GEN-LAST:event_txt_bookIdFocusLost

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        getIssueBookDetails();        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_book_id;
    private javax.swing.JLabel lbl_book_name;
    private javax.swing.JLabel lbl_due_date;
    private javax.swing.JLabel lbl_issue_date;
    private javax.swing.JLabel lbl_student_name;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
