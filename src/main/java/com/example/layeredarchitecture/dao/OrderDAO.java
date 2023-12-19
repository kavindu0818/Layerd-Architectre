package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDAO extends CradeDAO {
    boolean orderSelect(String oId, LocalDate lo, String cusIdd) throws SQLException, ClassNotFoundException;
    String genarateOrderID() throws SQLException, ClassNotFoundException;

}
