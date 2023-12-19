package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlUtill {
    public static <T>T test(String sql,Object...ob) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i=0;i< ob.length;i++){
            pstm.setObject((i+1) ,ob[i]);

        }

        if (sql.startsWith("SELECT") || sql.startsWith("select")){
            return ((T)pstm.executeQuery());

        }else {
            return ((T)(Boolean) (pstm.executeUpdate() > 0));

        }

    }
}
