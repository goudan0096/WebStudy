package com.personal.integral.test;

import java.sql.*;

public class JdbcClass {
    public static void main(String args[]){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/studyDb?useUnicode=true&characterEncoding=UTF-8";
        String username = "tj";
        String password = "tj_512184578";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1/studyDb?" +
                            "user=tj&password=tj_512184578");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from country");
            System.out.println("============================");
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
            }




            } catch (SQLException ex) {
            ex.printStackTrace();
            // handle any errors
            /*System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());*/
        }
        /*
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();            conn = (Connection) DriverManager.getConnection(url, username, password);
            String sql = "select * from student_tb";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }*/
    }
}
