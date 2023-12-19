package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDAO {

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genarateID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {

        SqlUtill.test("SELECT * FROM Item");

        ResultSet rst = SqlUtill.test("SELECT * FROM Item");

        ArrayList<ItemDTO> getAllItem = new ArrayList<>();

        while (rst.next()) {

            ItemDTO customerDtO = new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
            getAllItem.add(customerDtO);
        }

        return getAllItem;

    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {

       return SqlUtill.test("DELETE FROM Item WHERE code=?",code);

    }

    @Override
    public boolean saveItem(ItemDTO it) throws SQLException, ClassNotFoundException {

       return SqlUtill.test("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",it.getCode(),it.getDescription(),it.getQtyOnHand(),it.getUnitPrice());

    }

    @Override
    public boolean updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException {

     return SqlUtill.test("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",description,unitPrice,qtyOnHand);
    }

    @Override
    public boolean exiteItem(String code) throws SQLException, ClassNotFoundException {

       return SqlUtill.test("SELECT code FROM Item WHERE code=?",code);

    }

    @Override
    public String genrateID() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtill.test("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public boolean addOrderDetails(String oId, List<OrderDetailDTO> od) throws SQLException, ClassNotFoundException {
        return false;
    }

    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtill.test("SELECT * FROM Item WHERE code=?", newItemCode);

        ItemDTO itemDTO = null;

        while (rst.next()) {
             itemDTO = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));

        }
        return itemDTO;
    }
    public boolean exitItem(String code) throws SQLException, ClassNotFoundException {

        return SqlUtill.test("SELECT code FROM Item WHERE code=?", code);
    }

    public ArrayList<ItemDTO> loadAllItemIds() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtill.test("SELECT * FROM Item");;

        ArrayList<ItemDTO> dtoList = new ArrayList<>();
        // ClassDto dto = null;

        while(rst.next()) {
            dtoList.add(
                    new ItemDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getBigDecimal(3),
                            rst.getInt(4)
                    )
            );
        }
        return dtoList;
    }

    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException {

        return SqlUtill.test("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(), item.getCode());

    }
}
