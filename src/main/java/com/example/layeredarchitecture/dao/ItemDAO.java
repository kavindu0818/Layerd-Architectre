package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO extends CradeDAO{

   ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;


   boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
   boolean saveItem(ItemDTO it) throws SQLException, ClassNotFoundException;

   boolean updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;

   boolean exiteItem(String code) throws SQLException, ClassNotFoundException;

   String genrateID() throws SQLException, ClassNotFoundException;

}
