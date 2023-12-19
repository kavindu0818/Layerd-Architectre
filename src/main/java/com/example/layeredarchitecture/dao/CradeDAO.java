package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CradeDAO {

    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    String genarateID() throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;


    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    boolean saveItem(ItemDTO it) throws SQLException, ClassNotFoundException;

    boolean updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;

    boolean exiteItem(String code) throws SQLException, ClassNotFoundException;

    String genrateID() throws SQLException, ClassNotFoundException;

    boolean addOrderDetails(String oId, List<OrderDetailDTO> od) throws SQLException, ClassNotFoundException;




}
