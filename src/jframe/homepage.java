/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Alok Kumar
 */
public class homepage extends javax.swing.JFrame {

    /**
     * Creates new form homepage
     */
    Color mouseEnColor = new Color(51, 51, 51);
    Color mouseExiColor = new Color(0, 0, 0);

    public homepage() {
        initComponents();
//        showPieChart();
        setBookDetailsToTable();
        setStudentDetailsToTable();
        setDataToCards();
    }

    
//    public void showPieChart() {
//
//        //create dataset
//        DefaultPieDataset barDataset = new DefaultPieDataset();
//        try {
//            Connection con = DBconnection.getConnection();
//            String sql = "select book_name, count(*) as issue_count from issue_book_details full group by book_id";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                barDataset .setValue(rs.getString("book_name"),new Double (rs.getDouble("issue_count")));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //create chart
//        JFreeChart piechart = ChartFactory.createPieChart("mobile sales", barDataset, false, true, false);//explain
//
//        PiePlot piePlot = (PiePlot) piechart.getPlot();
//
//        //changing pie chart blocks colors
//        piePlot.setSectionPaint("IPhone 5s", new Color(255, 255, 102));
//        piePlot.setSectionPaint("SamSung Grand", new Color(102, 255, 102));
//        piePlot.setSectionPaint("MotoG", new Color(255, 102, 153));
//        piePlot.setSectionPaint("Nokia Lumia", new Color(0, 204, 204));
//
//        piePlot.setBackgroundPaint(Color.white);
//
//        //create chartPanel to display chart(graph)
//        ChartPanel barChartPanel = new ChartPanel(piechart);
//        panelPieChart.removeAll();
//        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
//        panelPieChart.validate();
//    }

    public void setStudentDetailsToTable() {
        DefaultTableModel model;
        try {
            Connection con = DBconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            String studentName, course, branch;
            int studentId;
            while (rs.next()) {
                studentId = rs.getInt("student_id");
                studentName = rs.getString("student_name");
                course = rs.getString("course");
                branch = rs.getString("branch");

                Object[] obj = {studentId, studentName, course, branch};
                model = (DefaultTableModel) tbl_studentDetails.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBookDetailsToTable() {
        DefaultTableModel model;
        try {
            Connection con = DBconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book_details");
            String bookId, bookName, author;

            int quantity;
            while (rs.next()) {
                bookId = rs.getString("book_id");
                bookName = rs.getString("book_name");
                author = rs.getString("author");
                quantity = rs.getInt("quantity");

                Object[] obj = {bookId, bookName, author, quantity};
                model = (DefaultTableModel) tbl_bookDetails.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setDataToCards(){
        Statement st = null;
        ResultSet rs = null;
       long l = System.currentTimeMillis();
         Date todaysDate = new Date(l);
         try {
            Connection con = DBconnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from book_details");
            rs.last();
            lbl_nrOfBooks.setText(Integer.toString(rs.getRow()));
            rs = st.executeQuery("select * from student_details");
            rs.last();
            lbl_nrOfStudents.setText(Integer.toString(rs.getRow()));
            rs = st.executeQuery("select * from issue_book_details where status ='"+"pending"+"'");
            rs.last();
            lbl_nrofIssuedBooks.setText(Integer.toString(rs.getRow()));
            rs = st.executeQuery("select * from issue_book_details where due_date < '"+todaysDate+"'and status ='pending'");
            rs.last();
            jLabel245.setText(Integer.toString(rs.getRow()));
            
                   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel113 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jPanel114 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jPanel115 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jPanel116 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jPanel78 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jPanel79 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jPanel84 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jPanel89 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jPanel90 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jPanel92 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jPanel94 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jPanel96 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jPanel97 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jPanel98 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jPanel99 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jPanel100 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jPanel101 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jPanel103 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jPanel104 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jPanel105 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jPanel110 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jPanel111 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jPanel112 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jPanel117 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jPanel118 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jPanel119 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jPanel121 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jPanel122 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jPanel123 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jPanel124 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jPanel125 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jPanel126 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jPanel127 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        jPanel128 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        jPanel129 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jPanel130 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jPanel131 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jPanel132 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        jPanel133 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jPanel134 = new javax.swing.JPanel();
        jLabel138 = new javax.swing.JLabel();
        jPanel135 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jPanel136 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jPanel137 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jPanel138 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        jPanel139 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jPanel140 = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        jPanel141 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jPanel142 = new javax.swing.JPanel();
        jLabel146 = new javax.swing.JLabel();
        jPanel143 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        jPanel144 = new javax.swing.JPanel();
        jLabel148 = new javax.swing.JLabel();
        jPanel145 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jPanel146 = new javax.swing.JPanel();
        jLabel150 = new javax.swing.JLabel();
        jPanel147 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jPanel148 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jPanel149 = new javax.swing.JPanel();
        jLabel153 = new javax.swing.JLabel();
        jPanel150 = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        jPanel151 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        jPanel152 = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jPanel153 = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jPanel154 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jPanel155 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jPanel156 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        jPanel157 = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        jPanel158 = new javax.swing.JPanel();
        jLabel162 = new javax.swing.JLabel();
        jPanel159 = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        jPanel160 = new javax.swing.JPanel();
        jLabel164 = new javax.swing.JLabel();
        jPanel161 = new javax.swing.JPanel();
        jLabel165 = new javax.swing.JLabel();
        jPanel162 = new javax.swing.JPanel();
        jLabel166 = new javax.swing.JLabel();
        jPanel163 = new javax.swing.JPanel();
        jLabel167 = new javax.swing.JLabel();
        jPanel164 = new javax.swing.JPanel();
        jLabel168 = new javax.swing.JLabel();
        jPanel165 = new javax.swing.JPanel();
        jLabel169 = new javax.swing.JLabel();
        jPanel166 = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        jPanel167 = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        jPanel168 = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        jPanel169 = new javax.swing.JPanel();
        jLabel173 = new javax.swing.JLabel();
        jPanel170 = new javax.swing.JPanel();
        jLabel174 = new javax.swing.JLabel();
        jPanel171 = new javax.swing.JPanel();
        jLabel175 = new javax.swing.JLabel();
        jPanel172 = new javax.swing.JPanel();
        jLabel176 = new javax.swing.JLabel();
        jPanel173 = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jPanel174 = new javax.swing.JPanel();
        jLabel178 = new javax.swing.JLabel();
        jPanel175 = new javax.swing.JPanel();
        jLabel179 = new javax.swing.JLabel();
        jPanel176 = new javax.swing.JPanel();
        jLabel180 = new javax.swing.JLabel();
        jPanel177 = new javax.swing.JPanel();
        jLabel181 = new javax.swing.JLabel();
        jPanel178 = new javax.swing.JPanel();
        jLabel182 = new javax.swing.JLabel();
        jPanel179 = new javax.swing.JPanel();
        jLabel183 = new javax.swing.JLabel();
        jPanel180 = new javax.swing.JPanel();
        jLabel184 = new javax.swing.JLabel();
        jPanel181 = new javax.swing.JPanel();
        jLabel185 = new javax.swing.JLabel();
        jPanel182 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        jPanel183 = new javax.swing.JPanel();
        jLabel187 = new javax.swing.JLabel();
        jPanel184 = new javax.swing.JPanel();
        jLabel188 = new javax.swing.JLabel();
        jPanel185 = new javax.swing.JPanel();
        jLabel189 = new javax.swing.JLabel();
        jPanel186 = new javax.swing.JPanel();
        jLabel190 = new javax.swing.JLabel();
        jPanel187 = new javax.swing.JPanel();
        jLabel191 = new javax.swing.JLabel();
        jPanel188 = new javax.swing.JPanel();
        jLabel192 = new javax.swing.JLabel();
        jPanel189 = new javax.swing.JPanel();
        jLabel193 = new javax.swing.JLabel();
        jPanel190 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        jPanel191 = new javax.swing.JPanel();
        jLabel195 = new javax.swing.JLabel();
        jPanel192 = new javax.swing.JPanel();
        jLabel196 = new javax.swing.JLabel();
        jPanel193 = new javax.swing.JPanel();
        jLabel197 = new javax.swing.JLabel();
        jPanel194 = new javax.swing.JPanel();
        jLabel198 = new javax.swing.JLabel();
        jPanel195 = new javax.swing.JPanel();
        jLabel199 = new javax.swing.JLabel();
        jPanel196 = new javax.swing.JPanel();
        jLabel200 = new javax.swing.JLabel();
        jPanel197 = new javax.swing.JPanel();
        jLabel201 = new javax.swing.JLabel();
        jPanel198 = new javax.swing.JPanel();
        jLabel202 = new javax.swing.JLabel();
        jPanel199 = new javax.swing.JPanel();
        jLabel203 = new javax.swing.JLabel();
        jPanel200 = new javax.swing.JPanel();
        jLabel204 = new javax.swing.JLabel();
        jPanel201 = new javax.swing.JPanel();
        jLabel205 = new javax.swing.JLabel();
        jPanel202 = new javax.swing.JPanel();
        jLabel206 = new javax.swing.JLabel();
        jPanel203 = new javax.swing.JPanel();
        jLabel207 = new javax.swing.JLabel();
        jPanel204 = new javax.swing.JPanel();
        jLabel208 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel205 = new javax.swing.JPanel();
        jLabel209 = new javax.swing.JLabel();
        jPanel206 = new javax.swing.JPanel();
        jLabel210 = new javax.swing.JLabel();
        jPanel207 = new javax.swing.JPanel();
        jLabel211 = new javax.swing.JLabel();
        jPanel208 = new javax.swing.JPanel();
        jLabel212 = new javax.swing.JLabel();
        jPanel209 = new javax.swing.JPanel();
        jLabel213 = new javax.swing.JLabel();
        jPanel210 = new javax.swing.JPanel();
        jLabel214 = new javax.swing.JLabel();
        jPanel211 = new javax.swing.JPanel();
        jLabel215 = new javax.swing.JLabel();
        jPanel212 = new javax.swing.JPanel();
        jLabel216 = new javax.swing.JLabel();
        jPanel213 = new javax.swing.JPanel();
        jLabel217 = new javax.swing.JLabel();
        jPanel214 = new javax.swing.JPanel();
        jLabel218 = new javax.swing.JLabel();
        jPanel215 = new javax.swing.JPanel();
        jLabel219 = new javax.swing.JLabel();
        jPanel216 = new javax.swing.JPanel();
        jLabel220 = new javax.swing.JLabel();
        jPanel217 = new javax.swing.JPanel();
        jLabel221 = new javax.swing.JLabel();
        jPanel218 = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        jPanel219 = new javax.swing.JPanel();
        jLabel223 = new javax.swing.JLabel();
        jPanel220 = new javax.swing.JPanel();
        jLabel224 = new javax.swing.JLabel();
        jPanel221 = new javax.swing.JPanel();
        jLabel225 = new javax.swing.JLabel();
        jPanel222 = new javax.swing.JPanel();
        jLabel226 = new javax.swing.JLabel();
        jPanel223 = new javax.swing.JPanel();
        jLabel227 = new javax.swing.JLabel();
        jPanel224 = new javax.swing.JPanel();
        jLabel228 = new javax.swing.JLabel();
        jPanel225 = new javax.swing.JPanel();
        jLabel229 = new javax.swing.JLabel();
        jPanel226 = new javax.swing.JPanel();
        jLabel230 = new javax.swing.JLabel();
        jPanel227 = new javax.swing.JPanel();
        jLabel231 = new javax.swing.JLabel();
        jPanel228 = new javax.swing.JPanel();
        jLabel232 = new javax.swing.JLabel();
        jPanel229 = new javax.swing.JPanel();
        jLabel233 = new javax.swing.JLabel();
        jPanel230 = new javax.swing.JPanel();
        jLabel234 = new javax.swing.JLabel();
        jPanel231 = new javax.swing.JPanel();
        jLabel235 = new javax.swing.JLabel();
        jPanel232 = new javax.swing.JPanel();
        jLabel236 = new javax.swing.JLabel();
        jPanel233 = new javax.swing.JPanel();
        jLabel237 = new javax.swing.JLabel();
        jPanel234 = new javax.swing.JPanel();
        jLabel238 = new javax.swing.JLabel();
        jPanel235 = new javax.swing.JPanel();
        jLabel239 = new javax.swing.JLabel();
        jPanel236 = new javax.swing.JPanel();
        jLabel240 = new javax.swing.JLabel();
        jPanel237 = new javax.swing.JPanel();
        jPanel238 = new javax.swing.JPanel();
        jPanel239 = new javax.swing.JPanel();
        jPanel240 = new javax.swing.JPanel();
        lbl_nrOfBooks = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel241 = new javax.swing.JPanel();
        lbl_nrOfStudents = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        jPanel242 = new javax.swing.JPanel();
        lbl_nrofIssuedBooks = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        jPanel243 = new javax.swing.JPanel();
        jLabel245 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel247 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel248 = new javax.swing.JLabel();

        jPanel113.setBackground(new java.awt.Color(255, 0, 51));
        jPanel113.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel117.setText("  Home");
        jPanel113.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel114.setBackground(new java.awt.Color(255, 0, 51));
        jPanel114.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel118.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel118.setText("Home");
        jPanel114.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel113.add(jPanel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel115.setBackground(new java.awt.Color(255, 0, 51));
        jPanel115.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel119.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel119.setText("  Home");
        jPanel115.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel116.setBackground(new java.awt.Color(255, 0, 51));
        jPanel116.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel120.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel120.setText("Home");
        jPanel116.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel115.add(jPanel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel113.add(jPanel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, 50, 60));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LIBRARY MANAGEMENT SYSTEM");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, 60));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel5.setText("Welcome, Admin");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, -1, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1361, 70));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel11.setText("  LMS Dashboard");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 60));

        jPanel6.setBackground(new java.awt.Color(255, 0, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel8.setText("  Home");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 0, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel12.setText("  Home");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 0, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel13.setText("Home");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel10.setBackground(new java.awt.Color(255, 0, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel14.setText("  Home");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 0, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel15.setText("Home");
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel12.setBackground(new java.awt.Color(255, 0, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel16.setText("  Home");
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel13.setBackground(new java.awt.Color(255, 0, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel17.setText("Home");
        jPanel13.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 50));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel7.setText("  Manage Books");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 340, 50));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(255, 0, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel18.setText("  Home");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel15.setBackground(new java.awt.Color(255, 0, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel19.setText("  Home");
        jPanel15.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel16.setBackground(new java.awt.Color(255, 0, 51));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel20.setText("Home");
        jPanel16.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel17.setBackground(new java.awt.Color(255, 0, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel21.setText("  Home");
        jPanel17.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel18.setBackground(new java.awt.Color(255, 0, 51));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel22.setText("Home");
        jPanel18.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel19.setBackground(new java.awt.Color(255, 0, 51));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel23.setText("  Home");
        jPanel19.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel20.setBackground(new java.awt.Color(255, 0, 51));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel24.setText("Home");
        jPanel20.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel14.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel7.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel21.setBackground(new java.awt.Color(255, 0, 51));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel25.setText("Home");
        jPanel21.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel22.setBackground(new java.awt.Color(255, 0, 51));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel26.setText("  Home");
        jPanel22.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel23.setBackground(new java.awt.Color(255, 0, 51));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel27.setText("  Home");
        jPanel23.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel24.setBackground(new java.awt.Color(255, 0, 51));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel28.setText("Home");
        jPanel24.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel25.setBackground(new java.awt.Color(255, 0, 51));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel29.setText("  Home");
        jPanel25.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel26.setBackground(new java.awt.Color(255, 0, 51));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel30.setText("Home");
        jPanel26.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel25.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel27.setBackground(new java.awt.Color(255, 0, 51));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel31.setText("  Home");
        jPanel27.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel28.setBackground(new java.awt.Color(255, 0, 51));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel32.setText("Home");
        jPanel28.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel27.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel25.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel22.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel7.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel29.setBackground(new java.awt.Color(255, 0, 51));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel33.setText("Home");
        jPanel29.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel30.setBackground(new java.awt.Color(255, 0, 51));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel34.setText("  Home");
        jPanel30.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel31.setBackground(new java.awt.Color(255, 0, 51));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel35.setText("  Home");
        jPanel31.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel32.setBackground(new java.awt.Color(255, 0, 51));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel36.setText("Home");
        jPanel32.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel31.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel33.setBackground(new java.awt.Color(255, 0, 51));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel37.setText("  Home");
        jPanel33.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel34.setBackground(new java.awt.Color(255, 0, 51));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel38.setText("Home");
        jPanel34.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel33.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel35.setBackground(new java.awt.Color(255, 0, 51));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel39.setText("  Home");
        jPanel35.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel36.setBackground(new java.awt.Color(255, 0, 51));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel40.setText("Home");
        jPanel36.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel35.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel33.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel30.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel29.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel37.setBackground(new java.awt.Color(255, 0, 51));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel41.setText("Home");
        jPanel37.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel38.setBackground(new java.awt.Color(255, 0, 51));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel42.setText("  Home");
        jPanel38.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel39.setBackground(new java.awt.Color(255, 0, 51));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel43.setText("  Home");
        jPanel39.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel40.setBackground(new java.awt.Color(255, 0, 51));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel44.setText("Home");
        jPanel40.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel39.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel38.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel41.setBackground(new java.awt.Color(255, 0, 51));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel45.setText("  Home");
        jPanel41.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel42.setBackground(new java.awt.Color(255, 0, 51));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel46.setText("Home");
        jPanel42.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel41.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel43.setBackground(new java.awt.Color(255, 0, 51));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel47.setText("  Home");
        jPanel43.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel44.setBackground(new java.awt.Color(255, 0, 51));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel48.setText("Home");
        jPanel44.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel43.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel41.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel38.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel37.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel29.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel7.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Exit_26px.png"))); // NOI18N
        jLabel9.setText("  Log Out");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 340, 40));

        jPanel45.setBackground(new java.awt.Color(0, 0, 0));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(153, 153, 153));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel49.setText("  Manage Students");
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel49MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel49MouseExited(evt);
            }
        });
        jPanel45.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel46.setBackground(new java.awt.Color(255, 0, 51));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel50.setText("  Home");
        jPanel46.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel47.setBackground(new java.awt.Color(255, 0, 51));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel51.setText("  Home");
        jPanel47.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel48.setBackground(new java.awt.Color(255, 0, 51));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel52.setText("Home");
        jPanel48.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel47.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel46.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel49.setBackground(new java.awt.Color(255, 0, 51));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel53.setText("  Home");
        jPanel49.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel50.setBackground(new java.awt.Color(255, 0, 51));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel54.setText("Home");
        jPanel50.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel49.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel51.setBackground(new java.awt.Color(255, 0, 51));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel55.setText("  Home");
        jPanel51.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel52.setBackground(new java.awt.Color(255, 0, 51));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel56.setText("Home");
        jPanel52.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel51.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel49.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel46.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel45.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel53.setBackground(new java.awt.Color(255, 0, 51));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel57.setText("Home");
        jPanel53.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel54.setBackground(new java.awt.Color(255, 0, 51));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel58.setText("  Home");
        jPanel54.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel55.setBackground(new java.awt.Color(255, 0, 51));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel59.setText("  Home");
        jPanel55.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel56.setBackground(new java.awt.Color(255, 0, 51));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel60.setText("Home");
        jPanel56.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel55.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel54.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel57.setBackground(new java.awt.Color(255, 0, 51));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel61.setText("  Home");
        jPanel57.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel58.setBackground(new java.awt.Color(255, 0, 51));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel62.setText("Home");
        jPanel58.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel57.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel59.setBackground(new java.awt.Color(255, 0, 51));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel63.setText("  Home");
        jPanel59.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel60.setBackground(new java.awt.Color(255, 0, 51));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel64.setText("Home");
        jPanel60.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel59.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel57.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel54.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel53.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel45.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel61.setBackground(new java.awt.Color(255, 0, 51));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel65.setText("Home");
        jPanel61.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel62.setBackground(new java.awt.Color(255, 0, 51));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel66.setText("  Home");
        jPanel62.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel63.setBackground(new java.awt.Color(255, 0, 51));
        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel67.setText("  Home");
        jPanel63.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel64.setBackground(new java.awt.Color(255, 0, 51));
        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel68.setText("Home");
        jPanel64.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel63.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel62.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel65.setBackground(new java.awt.Color(255, 0, 51));
        jPanel65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel69.setText("  Home");
        jPanel65.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel66.setBackground(new java.awt.Color(255, 0, 51));
        jPanel66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel70.setText("Home");
        jPanel66.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel65.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel67.setBackground(new java.awt.Color(255, 0, 51));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel71.setText("  Home");
        jPanel67.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel68.setBackground(new java.awt.Color(255, 0, 51));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel72.setText("Home");
        jPanel68.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel67.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel65.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel62.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel61.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel69.setBackground(new java.awt.Color(255, 0, 51));
        jPanel69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel73.setText("Home");
        jPanel69.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel70.setBackground(new java.awt.Color(255, 0, 51));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel74.setText("  Home");
        jPanel70.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel71.setBackground(new java.awt.Color(255, 0, 51));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel75.setText("  Home");
        jPanel71.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel72.setBackground(new java.awt.Color(255, 0, 51));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel76.setText("Home");
        jPanel72.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel71.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel70.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel73.setBackground(new java.awt.Color(255, 0, 51));
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel77.setText("  Home");
        jPanel73.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel74.setBackground(new java.awt.Color(255, 0, 51));
        jPanel74.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel78.setText("Home");
        jPanel74.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel73.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel75.setBackground(new java.awt.Color(255, 0, 51));
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel79.setText("  Home");
        jPanel75.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel76.setBackground(new java.awt.Color(255, 0, 51));
        jPanel76.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel80.setText("Home");
        jPanel76.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel75.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel73.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel70.add(jPanel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel69.add(jPanel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel61.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel45.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel3.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 340, 50));

        jPanel77.setBackground(new java.awt.Color(0, 0, 0));
        jPanel77.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(153, 153, 153));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        jLabel81.setText("  Issue Books");
        jLabel81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel81MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel81MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel81MouseExited(evt);
            }
        });
        jPanel77.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        jPanel78.setBackground(new java.awt.Color(255, 0, 51));
        jPanel78.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel82.setText("  Home");
        jPanel78.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel79.setBackground(new java.awt.Color(255, 0, 51));
        jPanel79.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel83.setText("  Home");
        jPanel79.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel80.setBackground(new java.awt.Color(255, 0, 51));
        jPanel80.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel84.setText("Home");
        jPanel80.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel79.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel78.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel81.setBackground(new java.awt.Color(255, 0, 51));
        jPanel81.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel85.setText("  Home");
        jPanel81.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel82.setBackground(new java.awt.Color(255, 0, 51));
        jPanel82.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel86.setText("Home");
        jPanel82.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel81.add(jPanel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel83.setBackground(new java.awt.Color(255, 0, 51));
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel87.setText("  Home");
        jPanel83.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel84.setBackground(new java.awt.Color(255, 0, 51));
        jPanel84.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel88.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel88.setText("Home");
        jPanel84.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel83.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel81.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel78.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel77.add(jPanel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel85.setBackground(new java.awt.Color(255, 0, 51));
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel89.setText("Home");
        jPanel85.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel86.setBackground(new java.awt.Color(255, 0, 51));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel90.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel90.setText("  Home");
        jPanel86.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel87.setBackground(new java.awt.Color(255, 0, 51));
        jPanel87.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel91.setText("  Home");
        jPanel87.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel88.setBackground(new java.awt.Color(255, 0, 51));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel92.setText("Home");
        jPanel88.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel87.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel86.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel89.setBackground(new java.awt.Color(255, 0, 51));
        jPanel89.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel93.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel93.setText("  Home");
        jPanel89.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel90.setBackground(new java.awt.Color(255, 0, 51));
        jPanel90.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel94.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel94.setText("Home");
        jPanel90.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel89.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel91.setBackground(new java.awt.Color(255, 0, 51));
        jPanel91.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel95.setText("  Home");
        jPanel91.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel92.setBackground(new java.awt.Color(255, 0, 51));
        jPanel92.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel96.setText("Home");
        jPanel92.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel91.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel89.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel86.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel85.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel77.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel93.setBackground(new java.awt.Color(255, 0, 51));
        jPanel93.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel97.setText("Home");
        jPanel93.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel94.setBackground(new java.awt.Color(255, 0, 51));
        jPanel94.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel98.setText("  Home");
        jPanel94.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel95.setBackground(new java.awt.Color(255, 0, 51));
        jPanel95.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel99.setText("  Home");
        jPanel95.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel96.setBackground(new java.awt.Color(255, 0, 51));
        jPanel96.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel100.setText("Home");
        jPanel96.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel95.add(jPanel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel94.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel97.setBackground(new java.awt.Color(255, 0, 51));
        jPanel97.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel101.setText("  Home");
        jPanel97.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel98.setBackground(new java.awt.Color(255, 0, 51));
        jPanel98.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel102.setText("Home");
        jPanel98.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel97.add(jPanel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel99.setBackground(new java.awt.Color(255, 0, 51));
        jPanel99.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel103.setText("  Home");
        jPanel99.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel100.setBackground(new java.awt.Color(255, 0, 51));
        jPanel100.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel104.setText("Home");
        jPanel100.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel99.add(jPanel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel97.add(jPanel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel94.add(jPanel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel93.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel101.setBackground(new java.awt.Color(255, 0, 51));
        jPanel101.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel105.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel105.setText("Home");
        jPanel101.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel102.setBackground(new java.awt.Color(255, 0, 51));
        jPanel102.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel106.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel106.setText("  Home");
        jPanel102.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel103.setBackground(new java.awt.Color(255, 0, 51));
        jPanel103.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel107.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel107.setText("  Home");
        jPanel103.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel104.setBackground(new java.awt.Color(255, 0, 51));
        jPanel104.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel108.setText("Home");
        jPanel104.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel103.add(jPanel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel102.add(jPanel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel105.setBackground(new java.awt.Color(255, 0, 51));
        jPanel105.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel109.setText("  Home");
        jPanel105.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel106.setBackground(new java.awt.Color(255, 0, 51));
        jPanel106.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel110.setText("Home");
        jPanel106.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel105.add(jPanel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel107.setBackground(new java.awt.Color(255, 0, 51));
        jPanel107.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel111.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel111.setText("  Home");
        jPanel107.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel108.setBackground(new java.awt.Color(255, 0, 51));
        jPanel108.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel112.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel112.setText("Home");
        jPanel108.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel107.add(jPanel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel105.add(jPanel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel102.add(jPanel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel101.add(jPanel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel93.add(jPanel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel77.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel3.add(jPanel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 340, 40));

        jPanel109.setBackground(new java.awt.Color(0, 0, 0));
        jPanel109.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel113.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(153, 153, 153));
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel113.setText("  Return book");
        jLabel113.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel113MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel113MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel113MouseExited(evt);
            }
        });
        jPanel109.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel110.setBackground(new java.awt.Color(255, 0, 51));
        jPanel110.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel114.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel114.setText("  Home");
        jPanel110.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel111.setBackground(new java.awt.Color(255, 0, 51));
        jPanel111.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel115.setText("  Home");
        jPanel111.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel112.setBackground(new java.awt.Color(255, 0, 51));
        jPanel112.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 255, 255));
        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel116.setText("Home");
        jPanel112.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel111.add(jPanel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel110.add(jPanel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel109.add(jPanel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel117.setBackground(new java.awt.Color(255, 0, 51));
        jPanel117.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel121.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel121.setText("Home");
        jPanel117.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel118.setBackground(new java.awt.Color(255, 0, 51));
        jPanel118.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel122.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel122.setText("  Home");
        jPanel118.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel119.setBackground(new java.awt.Color(255, 0, 51));
        jPanel119.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel123.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel123.setText("  Home");
        jPanel119.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel120.setBackground(new java.awt.Color(255, 0, 51));
        jPanel120.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel124.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel124.setText("Home");
        jPanel120.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel119.add(jPanel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel118.add(jPanel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel121.setBackground(new java.awt.Color(255, 0, 51));
        jPanel121.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel125.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel125.setText("  Home");
        jPanel121.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel122.setBackground(new java.awt.Color(255, 0, 51));
        jPanel122.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel126.setText("Home");
        jPanel122.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel121.add(jPanel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel123.setBackground(new java.awt.Color(255, 0, 51));
        jPanel123.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel127.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel127.setText("  Home");
        jPanel123.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel124.setBackground(new java.awt.Color(255, 0, 51));
        jPanel124.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel128.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel128.setText("Home");
        jPanel124.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel123.add(jPanel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel121.add(jPanel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel118.add(jPanel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel117.add(jPanel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel109.add(jPanel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel125.setBackground(new java.awt.Color(255, 0, 51));
        jPanel125.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel129.setText("Home");
        jPanel125.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel126.setBackground(new java.awt.Color(255, 0, 51));
        jPanel126.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel130.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(255, 255, 255));
        jLabel130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel130.setText("  Home");
        jPanel126.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel127.setBackground(new java.awt.Color(255, 0, 51));
        jPanel127.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel131.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(255, 255, 255));
        jLabel131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel131.setText("  Home");
        jPanel127.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel128.setBackground(new java.awt.Color(255, 0, 51));
        jPanel128.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel132.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 255, 255));
        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel132.setText("Home");
        jPanel128.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel127.add(jPanel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel126.add(jPanel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel129.setBackground(new java.awt.Color(255, 0, 51));
        jPanel129.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel133.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel133.setText("  Home");
        jPanel129.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel130.setBackground(new java.awt.Color(255, 0, 51));
        jPanel130.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel134.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 255, 255));
        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel134.setText("Home");
        jPanel130.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel129.add(jPanel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel131.setBackground(new java.awt.Color(255, 0, 51));
        jPanel131.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel135.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel135.setText("  Home");
        jPanel131.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel132.setBackground(new java.awt.Color(255, 0, 51));
        jPanel132.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel136.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel136.setText("Home");
        jPanel132.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel131.add(jPanel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel129.add(jPanel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel126.add(jPanel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel125.add(jPanel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel133.setBackground(new java.awt.Color(255, 0, 51));
        jPanel133.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel137.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 255, 255));
        jLabel137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel137.setText("Home");
        jPanel133.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel134.setBackground(new java.awt.Color(255, 0, 51));
        jPanel134.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel138.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel138.setText("  Home");
        jPanel134.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel135.setBackground(new java.awt.Color(255, 0, 51));
        jPanel135.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel139.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 255, 255));
        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel139.setText("  Home");
        jPanel135.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel136.setBackground(new java.awt.Color(255, 0, 51));
        jPanel136.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel140.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(255, 255, 255));
        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel140.setText("Home");
        jPanel136.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel135.add(jPanel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel134.add(jPanel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel137.setBackground(new java.awt.Color(255, 0, 51));
        jPanel137.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel141.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(255, 255, 255));
        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel141.setText("  Home");
        jPanel137.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel138.setBackground(new java.awt.Color(255, 0, 51));
        jPanel138.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel142.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(255, 255, 255));
        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel142.setText("Home");
        jPanel138.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel137.add(jPanel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel139.setBackground(new java.awt.Color(255, 0, 51));
        jPanel139.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel143.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(255, 255, 255));
        jLabel143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel143.setText("  Home");
        jPanel139.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel140.setBackground(new java.awt.Color(255, 0, 51));
        jPanel140.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel144.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(255, 255, 255));
        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel144.setText("Home");
        jPanel140.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel139.add(jPanel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel137.add(jPanel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel134.add(jPanel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel133.add(jPanel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel125.add(jPanel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel109.add(jPanel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel3.add(jPanel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 340, 50));

        jPanel141.setBackground(new java.awt.Color(0, 0, 0));
        jPanel141.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel145.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(153, 153, 153));
        jLabel145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel145.setText("  View Records");
        jLabel145.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel145MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel145MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel145MouseExited(evt);
            }
        });
        jPanel141.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        jPanel142.setBackground(new java.awt.Color(255, 0, 51));
        jPanel142.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel146.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(255, 255, 255));
        jLabel146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel146.setText("  Home");
        jPanel142.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel143.setBackground(new java.awt.Color(255, 0, 51));
        jPanel143.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel147.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(255, 255, 255));
        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel147.setText("  Home");
        jPanel143.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel144.setBackground(new java.awt.Color(255, 0, 51));
        jPanel144.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel148.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(255, 255, 255));
        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel148.setText("Home");
        jPanel144.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel143.add(jPanel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel142.add(jPanel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel145.setBackground(new java.awt.Color(255, 0, 51));
        jPanel145.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel149.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(255, 255, 255));
        jLabel149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel149.setText("  Home");
        jPanel145.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel146.setBackground(new java.awt.Color(255, 0, 51));
        jPanel146.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel150.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(255, 255, 255));
        jLabel150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel150.setText("Home");
        jPanel146.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel145.add(jPanel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel147.setBackground(new java.awt.Color(255, 0, 51));
        jPanel147.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel151.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 255, 255));
        jLabel151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel151.setText("  Home");
        jPanel147.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel148.setBackground(new java.awt.Color(255, 0, 51));
        jPanel148.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel152.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(255, 255, 255));
        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel152.setText("Home");
        jPanel148.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel147.add(jPanel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel145.add(jPanel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel142.add(jPanel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel141.add(jPanel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel149.setBackground(new java.awt.Color(255, 0, 51));
        jPanel149.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel153.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(255, 255, 255));
        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel153.setText("Home");
        jPanel149.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel150.setBackground(new java.awt.Color(255, 0, 51));
        jPanel150.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel154.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(255, 255, 255));
        jLabel154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel154.setText("  Home");
        jPanel150.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel151.setBackground(new java.awt.Color(255, 0, 51));
        jPanel151.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel155.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(255, 255, 255));
        jLabel155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel155.setText("  Home");
        jPanel151.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel152.setBackground(new java.awt.Color(255, 0, 51));
        jPanel152.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel156.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(255, 255, 255));
        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel156.setText("Home");
        jPanel152.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel151.add(jPanel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel150.add(jPanel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel153.setBackground(new java.awt.Color(255, 0, 51));
        jPanel153.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel157.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(255, 255, 255));
        jLabel157.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel157.setText("  Home");
        jPanel153.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel154.setBackground(new java.awt.Color(255, 0, 51));
        jPanel154.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel158.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(255, 255, 255));
        jLabel158.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel158.setText("Home");
        jPanel154.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel153.add(jPanel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel155.setBackground(new java.awt.Color(255, 0, 51));
        jPanel155.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel159.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(255, 255, 255));
        jLabel159.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel159.setText("  Home");
        jPanel155.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel156.setBackground(new java.awt.Color(255, 0, 51));
        jPanel156.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel160.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 255, 255));
        jLabel160.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel160.setText("Home");
        jPanel156.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel155.add(jPanel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel153.add(jPanel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel150.add(jPanel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel149.add(jPanel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel141.add(jPanel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel157.setBackground(new java.awt.Color(255, 0, 51));
        jPanel157.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel161.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 255, 255));
        jLabel161.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel161.setText("Home");
        jPanel157.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel158.setBackground(new java.awt.Color(255, 0, 51));
        jPanel158.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel162.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(255, 255, 255));
        jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel162.setText("  Home");
        jPanel158.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel159.setBackground(new java.awt.Color(255, 0, 51));
        jPanel159.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel163.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(255, 255, 255));
        jLabel163.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel163.setText("  Home");
        jPanel159.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel160.setBackground(new java.awt.Color(255, 0, 51));
        jPanel160.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel164.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(255, 255, 255));
        jLabel164.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel164.setText("Home");
        jPanel160.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel159.add(jPanel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel158.add(jPanel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel161.setBackground(new java.awt.Color(255, 0, 51));
        jPanel161.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel165.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(255, 255, 255));
        jLabel165.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel165.setText("  Home");
        jPanel161.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel162.setBackground(new java.awt.Color(255, 0, 51));
        jPanel162.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel166.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(255, 255, 255));
        jLabel166.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel166.setText("Home");
        jPanel162.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel161.add(jPanel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel163.setBackground(new java.awt.Color(255, 0, 51));
        jPanel163.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel167.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(255, 255, 255));
        jLabel167.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel167.setText("  Home");
        jPanel163.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel164.setBackground(new java.awt.Color(255, 0, 51));
        jPanel164.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel168.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(255, 255, 255));
        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel168.setText("Home");
        jPanel164.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel163.add(jPanel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel161.add(jPanel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel158.add(jPanel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel157.add(jPanel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel165.setBackground(new java.awt.Color(255, 0, 51));
        jPanel165.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel169.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(255, 255, 255));
        jLabel169.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel169.setText("Home");
        jPanel165.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel166.setBackground(new java.awt.Color(255, 0, 51));
        jPanel166.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel170.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel170.setText("  Home");
        jPanel166.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel167.setBackground(new java.awt.Color(255, 0, 51));
        jPanel167.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel171.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 255, 255));
        jLabel171.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel171.setText("  Home");
        jPanel167.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel168.setBackground(new java.awt.Color(255, 0, 51));
        jPanel168.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel172.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel172.setText("Home");
        jPanel168.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel167.add(jPanel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel166.add(jPanel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel169.setBackground(new java.awt.Color(255, 0, 51));
        jPanel169.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel173.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(255, 255, 255));
        jLabel173.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel173.setText("  Home");
        jPanel169.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel170.setBackground(new java.awt.Color(255, 0, 51));
        jPanel170.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel174.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(255, 255, 255));
        jLabel174.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel174.setText("Home");
        jPanel170.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel169.add(jPanel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel171.setBackground(new java.awt.Color(255, 0, 51));
        jPanel171.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel175.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(255, 255, 255));
        jLabel175.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel175.setText("  Home");
        jPanel171.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel172.setBackground(new java.awt.Color(255, 0, 51));
        jPanel172.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel176.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(255, 255, 255));
        jLabel176.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel176.setText("Home");
        jPanel172.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel171.add(jPanel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel169.add(jPanel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel166.add(jPanel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel165.add(jPanel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel157.add(jPanel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel141.add(jPanel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel3.add(jPanel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 340, 40));

        jPanel173.setBackground(new java.awt.Color(0, 0, 0));
        jPanel173.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel177.setBackground(new java.awt.Color(0, 0, 0));
        jLabel177.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(153, 153, 153));
        jLabel177.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel177.setText("  View Issued Books");
        jLabel177.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel177MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel177MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel177MouseExited(evt);
            }
        });
        jPanel173.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel174.setBackground(new java.awt.Color(255, 0, 51));
        jPanel174.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel178.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(255, 255, 255));
        jLabel178.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel178.setText("  Home");
        jPanel174.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel175.setBackground(new java.awt.Color(255, 0, 51));
        jPanel175.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel179.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(255, 255, 255));
        jLabel179.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel179.setText("  Home");
        jPanel175.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel176.setBackground(new java.awt.Color(255, 0, 51));
        jPanel176.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel180.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(255, 255, 255));
        jLabel180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel180.setText("Home");
        jPanel176.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel175.add(jPanel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel174.add(jPanel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel177.setBackground(new java.awt.Color(255, 0, 51));
        jPanel177.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel181.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(255, 255, 255));
        jLabel181.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel181.setText("  Home");
        jPanel177.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel178.setBackground(new java.awt.Color(255, 0, 51));
        jPanel178.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel182.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(255, 255, 255));
        jLabel182.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel182.setText("Home");
        jPanel178.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel177.add(jPanel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel179.setBackground(new java.awt.Color(255, 0, 51));
        jPanel179.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel183.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(255, 255, 255));
        jLabel183.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel183.setText("  Home");
        jPanel179.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel180.setBackground(new java.awt.Color(255, 0, 51));
        jPanel180.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel184.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(255, 255, 255));
        jLabel184.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel184.setText("Home");
        jPanel180.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel179.add(jPanel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel177.add(jPanel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel174.add(jPanel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel173.add(jPanel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel181.setBackground(new java.awt.Color(255, 0, 51));
        jPanel181.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel185.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(255, 255, 255));
        jLabel185.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel185.setText("Home");
        jPanel181.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel182.setBackground(new java.awt.Color(255, 0, 51));
        jPanel182.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel186.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(255, 255, 255));
        jLabel186.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel186.setText("  Home");
        jPanel182.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel183.setBackground(new java.awt.Color(255, 0, 51));
        jPanel183.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel187.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(255, 255, 255));
        jLabel187.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel187.setText("  Home");
        jPanel183.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel184.setBackground(new java.awt.Color(255, 0, 51));
        jPanel184.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel188.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(255, 255, 255));
        jLabel188.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel188.setText("Home");
        jPanel184.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel183.add(jPanel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel182.add(jPanel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel185.setBackground(new java.awt.Color(255, 0, 51));
        jPanel185.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel189.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(255, 255, 255));
        jLabel189.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel189.setText("  Home");
        jPanel185.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel186.setBackground(new java.awt.Color(255, 0, 51));
        jPanel186.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel190.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(255, 255, 255));
        jLabel190.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel190.setText("Home");
        jPanel186.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel185.add(jPanel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel187.setBackground(new java.awt.Color(255, 0, 51));
        jPanel187.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel191.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(255, 255, 255));
        jLabel191.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel191.setText("  Home");
        jPanel187.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel188.setBackground(new java.awt.Color(255, 0, 51));
        jPanel188.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel192.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(255, 255, 255));
        jLabel192.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel192.setText("Home");
        jPanel188.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel187.add(jPanel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel185.add(jPanel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel182.add(jPanel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel181.add(jPanel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel173.add(jPanel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel189.setBackground(new java.awt.Color(255, 0, 51));
        jPanel189.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel193.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(255, 255, 255));
        jLabel193.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel193.setText("Home");
        jPanel189.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel190.setBackground(new java.awt.Color(255, 0, 51));
        jPanel190.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel194.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(255, 255, 255));
        jLabel194.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel194.setText("  Home");
        jPanel190.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel191.setBackground(new java.awt.Color(255, 0, 51));
        jPanel191.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel195.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(255, 255, 255));
        jLabel195.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel195.setText("  Home");
        jPanel191.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel192.setBackground(new java.awt.Color(255, 0, 51));
        jPanel192.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel196.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(255, 255, 255));
        jLabel196.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel196.setText("Home");
        jPanel192.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel191.add(jPanel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel190.add(jPanel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel193.setBackground(new java.awt.Color(255, 0, 51));
        jPanel193.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel197.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(255, 255, 255));
        jLabel197.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel197.setText("  Home");
        jPanel193.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel194.setBackground(new java.awt.Color(255, 0, 51));
        jPanel194.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel198.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(255, 255, 255));
        jLabel198.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel198.setText("Home");
        jPanel194.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel193.add(jPanel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel195.setBackground(new java.awt.Color(255, 0, 51));
        jPanel195.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel199.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(255, 255, 255));
        jLabel199.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel199.setText("  Home");
        jPanel195.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel196.setBackground(new java.awt.Color(255, 0, 51));
        jPanel196.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel200.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(255, 255, 255));
        jLabel200.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel200.setText("Home");
        jPanel196.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel195.add(jPanel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel193.add(jPanel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel190.add(jPanel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel189.add(jPanel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel197.setBackground(new java.awt.Color(255, 0, 51));
        jPanel197.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel201.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(255, 255, 255));
        jLabel201.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel201.setText("Home");
        jPanel197.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel198.setBackground(new java.awt.Color(255, 0, 51));
        jPanel198.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel202.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(255, 255, 255));
        jLabel202.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel202.setText("  Home");
        jPanel198.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel199.setBackground(new java.awt.Color(255, 0, 51));
        jPanel199.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel203.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(255, 255, 255));
        jLabel203.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel203.setText("  Home");
        jPanel199.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel200.setBackground(new java.awt.Color(255, 0, 51));
        jPanel200.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel204.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(255, 255, 255));
        jLabel204.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel204.setText("Home");
        jPanel200.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel199.add(jPanel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel198.add(jPanel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel201.setBackground(new java.awt.Color(255, 0, 51));
        jPanel201.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel205.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(255, 255, 255));
        jLabel205.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel205.setText("  Home");
        jPanel201.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel202.setBackground(new java.awt.Color(255, 0, 51));
        jPanel202.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel206.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(255, 255, 255));
        jLabel206.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel206.setText("Home");
        jPanel202.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel201.add(jPanel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel203.setBackground(new java.awt.Color(255, 0, 51));
        jPanel203.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel207.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(255, 255, 255));
        jLabel207.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel207.setText("  Home");
        jPanel203.add(jLabel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel204.setBackground(new java.awt.Color(255, 0, 51));
        jPanel204.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel208.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(255, 255, 255));
        jLabel208.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel208.setText("Home");
        jPanel204.add(jLabel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel203.add(jPanel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel201.add(jPanel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel198.add(jPanel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel197.add(jPanel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel189.add(jPanel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel173.add(jPanel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel3.add(jPanel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 340, 50));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText(" Features");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        jPanel205.setBackground(new java.awt.Color(0, 0, 0));
        jPanel205.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel209.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(153, 153, 153));
        jLabel209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel209.setText("  Defaulter List");
        jLabel209.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel209MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel209MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel209MouseExited(evt);
            }
        });
        jPanel205.add(jLabel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        jPanel206.setBackground(new java.awt.Color(255, 0, 51));
        jPanel206.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel210.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(255, 255, 255));
        jLabel210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel210.setText("  Home");
        jPanel206.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel207.setBackground(new java.awt.Color(255, 0, 51));
        jPanel207.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel211.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(255, 255, 255));
        jLabel211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel211.setText("  Home");
        jPanel207.add(jLabel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel208.setBackground(new java.awt.Color(255, 0, 51));
        jPanel208.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel212.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(255, 255, 255));
        jLabel212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel212.setText("Home");
        jPanel208.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel207.add(jPanel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel206.add(jPanel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel209.setBackground(new java.awt.Color(255, 0, 51));
        jPanel209.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel213.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(255, 255, 255));
        jLabel213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel213.setText("  Home");
        jPanel209.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel210.setBackground(new java.awt.Color(255, 0, 51));
        jPanel210.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel214.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(255, 255, 255));
        jLabel214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel214.setText("Home");
        jPanel210.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel209.add(jPanel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel211.setBackground(new java.awt.Color(255, 0, 51));
        jPanel211.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel215.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(255, 255, 255));
        jLabel215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel215.setText("  Home");
        jPanel211.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel212.setBackground(new java.awt.Color(255, 0, 51));
        jPanel212.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel216.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(255, 255, 255));
        jLabel216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel216.setText("Home");
        jPanel212.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel211.add(jPanel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel209.add(jPanel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel206.add(jPanel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel205.add(jPanel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel213.setBackground(new java.awt.Color(255, 0, 51));
        jPanel213.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel217.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(255, 255, 255));
        jLabel217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel217.setText("Home");
        jPanel213.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel214.setBackground(new java.awt.Color(255, 0, 51));
        jPanel214.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel218.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(255, 255, 255));
        jLabel218.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel218.setText("  Home");
        jPanel214.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel215.setBackground(new java.awt.Color(255, 0, 51));
        jPanel215.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel219.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(255, 255, 255));
        jLabel219.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel219.setText("  Home");
        jPanel215.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel216.setBackground(new java.awt.Color(255, 0, 51));
        jPanel216.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel220.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(255, 255, 255));
        jLabel220.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel220.setText("Home");
        jPanel216.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel215.add(jPanel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel214.add(jPanel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel217.setBackground(new java.awt.Color(255, 0, 51));
        jPanel217.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel221.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(255, 255, 255));
        jLabel221.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel221.setText("  Home");
        jPanel217.add(jLabel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel218.setBackground(new java.awt.Color(255, 0, 51));
        jPanel218.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel222.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(255, 255, 255));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel222.setText("Home");
        jPanel218.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel217.add(jPanel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel219.setBackground(new java.awt.Color(255, 0, 51));
        jPanel219.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel223.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(255, 255, 255));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel223.setText("  Home");
        jPanel219.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel220.setBackground(new java.awt.Color(255, 0, 51));
        jPanel220.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel224.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(255, 255, 255));
        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel224.setText("Home");
        jPanel220.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel219.add(jPanel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel217.add(jPanel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel214.add(jPanel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel213.add(jPanel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel205.add(jPanel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel221.setBackground(new java.awt.Color(255, 0, 51));
        jPanel221.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel225.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(255, 255, 255));
        jLabel225.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel225.setText("Home");
        jPanel221.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel222.setBackground(new java.awt.Color(255, 0, 51));
        jPanel222.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel226.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(255, 255, 255));
        jLabel226.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel226.setText("  Home");
        jPanel222.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel223.setBackground(new java.awt.Color(255, 0, 51));
        jPanel223.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel227.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(255, 255, 255));
        jLabel227.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel227.setText("  Home");
        jPanel223.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel224.setBackground(new java.awt.Color(255, 0, 51));
        jPanel224.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel228.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(255, 255, 255));
        jLabel228.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel228.setText("Home");
        jPanel224.add(jLabel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel223.add(jPanel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel222.add(jPanel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel225.setBackground(new java.awt.Color(255, 0, 51));
        jPanel225.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel229.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(255, 255, 255));
        jLabel229.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel229.setText("  Home");
        jPanel225.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel226.setBackground(new java.awt.Color(255, 0, 51));
        jPanel226.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel230.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(255, 255, 255));
        jLabel230.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel230.setText("Home");
        jPanel226.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel225.add(jPanel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel227.setBackground(new java.awt.Color(255, 0, 51));
        jPanel227.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel231.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(255, 255, 255));
        jLabel231.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel231.setText("  Home");
        jPanel227.add(jLabel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel228.setBackground(new java.awt.Color(255, 0, 51));
        jPanel228.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel232.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(255, 255, 255));
        jLabel232.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel232.setText("Home");
        jPanel228.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel227.add(jPanel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel225.add(jPanel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel222.add(jPanel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel221.add(jPanel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel229.setBackground(new java.awt.Color(255, 0, 51));
        jPanel229.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel233.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(255, 255, 255));
        jLabel233.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel233.setText("Home");
        jPanel229.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel230.setBackground(new java.awt.Color(255, 0, 51));
        jPanel230.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel234.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(255, 255, 255));
        jLabel234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel234.setText("  Home");
        jPanel230.add(jLabel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel231.setBackground(new java.awt.Color(255, 0, 51));
        jPanel231.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel235.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(255, 255, 255));
        jLabel235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel235.setText("  Home");
        jPanel231.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel232.setBackground(new java.awt.Color(255, 0, 51));
        jPanel232.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel236.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel236.setForeground(new java.awt.Color(255, 255, 255));
        jLabel236.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel236.setText("Home");
        jPanel232.add(jLabel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel231.add(jPanel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel230.add(jPanel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel233.setBackground(new java.awt.Color(255, 0, 51));
        jPanel233.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel237.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel237.setForeground(new java.awt.Color(255, 255, 255));
        jLabel237.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel237.setText("  Home");
        jPanel233.add(jLabel237, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel234.setBackground(new java.awt.Color(255, 0, 51));
        jPanel234.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel238.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(255, 255, 255));
        jLabel238.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel238.setText("Home");
        jPanel234.add(jLabel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel233.add(jPanel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel235.setBackground(new java.awt.Color(255, 0, 51));
        jPanel235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel239.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel239.setForeground(new java.awt.Color(255, 255, 255));
        jLabel239.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel239.setText("  Home");
        jPanel235.add(jLabel239, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel236.setBackground(new java.awt.Color(255, 0, 51));
        jPanel236.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel240.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel240.setForeground(new java.awt.Color(255, 255, 255));
        jLabel240.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel240.setText("Home");
        jPanel236.add(jLabel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel235.add(jPanel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel233.add(jPanel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 70));

        jPanel230.add(jPanel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 70));

        jPanel229.add(jPanel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 70));

        jPanel221.add(jPanel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel205.add(jPanel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 70));

        jPanel3.add(jPanel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 340, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 670));

        jPanel237.setBackground(new java.awt.Color(255, 255, 255));
        jPanel237.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel237.add(jPanel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 5, -1, -1));
        jPanel237.add(jPanel239, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 5, -1, -1));

        jPanel240.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 0, 51)));
        jPanel240.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nrOfBooks.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_nrOfBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_nrOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_nrOfBooks.setText("10");
        jPanel240.add(lbl_nrOfBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel237.add(jPanel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 90));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Book Details");
        jPanel237.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, -1, -1));

        jPanel241.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 0, 255)));
        jPanel241.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nrOfStudents.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_nrOfStudents.setForeground(new java.awt.Color(102, 102, 102));
        lbl_nrOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_nrOfStudents.setText("10");
        jPanel241.add(lbl_nrOfStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel237.add(jPanel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 210, 90));

        jLabel242.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel242.setForeground(new java.awt.Color(102, 102, 102));
        jLabel242.setText("No Of Students");
        jPanel237.add(jLabel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        jPanel242.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 0, 51)));
        jPanel242.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nrofIssuedBooks.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_nrofIssuedBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_nrofIssuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_nrofIssuedBooks.setText("10");
        jPanel242.add(lbl_nrofIssuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel237.add(jPanel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 210, 90));

        jLabel244.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel244.setForeground(new java.awt.Color(102, 102, 102));
        jLabel244.setText("Issued Books");
        jPanel237.add(jLabel244, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        jPanel243.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 0, 255)));
        jPanel243.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel245.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        jLabel245.setForeground(new java.awt.Color(102, 102, 102));
        jLabel245.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        jLabel245.setText("10");
        jPanel243.add(jLabel245, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel237.add(jPanel243, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 210, 80));

        jLabel246.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel246.setForeground(new java.awt.Color(102, 102, 102));
        jLabel246.setText("Defaulter List");
        jPanel237.add(jLabel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(0, 0, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(0, 0, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 0, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setRowHeight(35);
        jScrollPane1.setViewportView(tbl_bookDetails);

        jPanel237.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 960, 220));

        jLabel247.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel247.setForeground(new java.awt.Color(102, 102, 102));
        jLabel247.setText("No Of Books");
        jPanel237.add(jLabel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(0, 0, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(0, 0, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 0, 51));
        tbl_studentDetails.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setRowHeight(35);
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel237.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 940, 220));

        jLabel248.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel248.setForeground(new java.awt.Color(102, 102, 102));
        jLabel248.setText("Student Details");
        jPanel237.add(jLabel248, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        getContentPane().add(jPanel237, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 1020, 680));

        setSize(new java.awt.Dimension(1347, 741));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        ManageBooks mb = new ManageBooks();
        mb.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
        jPanel5.setBackground(mouseEnColor);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        // TODO add your handling code here:
        jPanel5.setBackground(mouseExiColor);
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel49MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseEntered
        // TODO add your handling code here:
        jPanel45.setBackground(mouseEnColor);
    }//GEN-LAST:event_jLabel49MouseEntered

    private void jLabel49MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseExited
        // TODO add your handling code here:
        jPanel45.setBackground(mouseExiColor);
    }//GEN-LAST:event_jLabel49MouseExited

    private void jLabel81MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MouseEntered
        // TODO add your handling code here:
        jPanel77.setBackground(mouseEnColor);
    }//GEN-LAST:event_jLabel81MouseEntered

    private void jLabel81MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MouseExited
        // TODO add your handling code here:
        jPanel77.setBackground(mouseExiColor);
    }//GEN-LAST:event_jLabel81MouseExited

    private void jLabel113MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel113MouseEntered

        jPanel109.setBackground(mouseEnColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel113MouseEntered

    private void jLabel113MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel113MouseExited
        jPanel109.setBackground(mouseExiColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel113MouseExited

    private void jLabel145MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel145MouseEntered
        jPanel141.setBackground(mouseEnColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel145MouseEntered

    private void jLabel145MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel145MouseExited
        jPanel141.setBackground(mouseExiColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel145MouseExited

    private void jLabel177MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel177MouseEntered
        jPanel173.setBackground(mouseEnColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel177MouseEntered

    private void jLabel177MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel177MouseExited
        jPanel173.setBackground(mouseExiColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel177MouseExited

    private void jLabel209MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel209MouseEntered
        jPanel205.setBackground(mouseEnColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel209MouseEntered

    private void jLabel209MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel209MouseExited
        jPanel205.setBackground(mouseExiColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel209MouseExited

    private void jLabel81MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MouseClicked
        // TODO add your handling code here:
        IssuedBook book = new IssuedBook();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel81MouseClicked

    private void jLabel113MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel113MouseClicked
        ReturnBook book = new ReturnBook();
        book.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel113MouseClicked

    private void jLabel145MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel145MouseClicked
        ViewAllRecords book = new ViewAllRecords();
        book.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel145MouseClicked

    private void jLabel177MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel177MouseClicked
        IssuedBookDetails book = new IssuedBookDetails();
        book.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel177MouseClicked

    private void jLabel209MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel209MouseClicked
        DefaulterList list = new DefaulterList();
        list.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel209MouseClicked

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        ManageStudents st = new ManageStudents();
        st.setVisible(true);// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel49MouseClicked

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
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel148;
    private javax.swing.JPanel jPanel149;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel150;
    private javax.swing.JPanel jPanel151;
    private javax.swing.JPanel jPanel152;
    private javax.swing.JPanel jPanel153;
    private javax.swing.JPanel jPanel154;
    private javax.swing.JPanel jPanel155;
    private javax.swing.JPanel jPanel156;
    private javax.swing.JPanel jPanel157;
    private javax.swing.JPanel jPanel158;
    private javax.swing.JPanel jPanel159;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel160;
    private javax.swing.JPanel jPanel161;
    private javax.swing.JPanel jPanel162;
    private javax.swing.JPanel jPanel163;
    private javax.swing.JPanel jPanel164;
    private javax.swing.JPanel jPanel165;
    private javax.swing.JPanel jPanel166;
    private javax.swing.JPanel jPanel167;
    private javax.swing.JPanel jPanel168;
    private javax.swing.JPanel jPanel169;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel170;
    private javax.swing.JPanel jPanel171;
    private javax.swing.JPanel jPanel172;
    private javax.swing.JPanel jPanel173;
    private javax.swing.JPanel jPanel174;
    private javax.swing.JPanel jPanel175;
    private javax.swing.JPanel jPanel176;
    private javax.swing.JPanel jPanel177;
    private javax.swing.JPanel jPanel178;
    private javax.swing.JPanel jPanel179;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel180;
    private javax.swing.JPanel jPanel181;
    private javax.swing.JPanel jPanel182;
    private javax.swing.JPanel jPanel183;
    private javax.swing.JPanel jPanel184;
    private javax.swing.JPanel jPanel185;
    private javax.swing.JPanel jPanel186;
    private javax.swing.JPanel jPanel187;
    private javax.swing.JPanel jPanel188;
    private javax.swing.JPanel jPanel189;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel190;
    private javax.swing.JPanel jPanel191;
    private javax.swing.JPanel jPanel192;
    private javax.swing.JPanel jPanel193;
    private javax.swing.JPanel jPanel194;
    private javax.swing.JPanel jPanel195;
    private javax.swing.JPanel jPanel196;
    private javax.swing.JPanel jPanel197;
    private javax.swing.JPanel jPanel198;
    private javax.swing.JPanel jPanel199;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel200;
    private javax.swing.JPanel jPanel201;
    private javax.swing.JPanel jPanel202;
    private javax.swing.JPanel jPanel203;
    private javax.swing.JPanel jPanel204;
    private javax.swing.JPanel jPanel205;
    private javax.swing.JPanel jPanel206;
    private javax.swing.JPanel jPanel207;
    private javax.swing.JPanel jPanel208;
    private javax.swing.JPanel jPanel209;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel210;
    private javax.swing.JPanel jPanel211;
    private javax.swing.JPanel jPanel212;
    private javax.swing.JPanel jPanel213;
    private javax.swing.JPanel jPanel214;
    private javax.swing.JPanel jPanel215;
    private javax.swing.JPanel jPanel216;
    private javax.swing.JPanel jPanel217;
    private javax.swing.JPanel jPanel218;
    private javax.swing.JPanel jPanel219;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel220;
    private javax.swing.JPanel jPanel221;
    private javax.swing.JPanel jPanel222;
    private javax.swing.JPanel jPanel223;
    private javax.swing.JPanel jPanel224;
    private javax.swing.JPanel jPanel225;
    private javax.swing.JPanel jPanel226;
    private javax.swing.JPanel jPanel227;
    private javax.swing.JPanel jPanel228;
    private javax.swing.JPanel jPanel229;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel230;
    private javax.swing.JPanel jPanel231;
    private javax.swing.JPanel jPanel232;
    private javax.swing.JPanel jPanel233;
    private javax.swing.JPanel jPanel234;
    private javax.swing.JPanel jPanel235;
    private javax.swing.JPanel jPanel236;
    private javax.swing.JPanel jPanel237;
    private javax.swing.JPanel jPanel238;
    private javax.swing.JPanel jPanel239;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel240;
    private javax.swing.JPanel jPanel241;
    private javax.swing.JPanel jPanel242;
    private javax.swing.JPanel jPanel243;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_nrOfBooks;
    private javax.swing.JLabel lbl_nrOfStudents;
    private javax.swing.JLabel lbl_nrofIssuedBooks;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
