package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDAO {
    public boolean orderSelect(String oId, LocalDate lo, String cusIdd) throws SQLException, ClassNotFoundException;
    public String genarateOrderID() throws SQLException, ClassNotFoundException;

}
