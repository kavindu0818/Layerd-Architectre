package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDAO {
   @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {

        ResultSet rst =  SqlUtill.test("SELECT * FROM Customer");
        ArrayList<CustomerDTO> getAllCstomer = new ArrayList<>();

        while (rst.next()) {

            CustomerDTO customerDtO = new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            getAllCstomer.add(customerDtO);
        }

        return getAllCstomer;

    }

    @Override
    public boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException {

       return SqlUtill.test("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",id,name,address);

    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {

      return SqlUtill.test("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());

    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {

     return SqlUtill.test("DELETE FROM Customer WHERE id=?",id);

    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {

      ResultSet rst = SqlUtill.test("SELECT id FROM Customer WHERE id=?",id);
      return rst.next();
    }

    @Override
    public String genarateID() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtill.test("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    public  CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtill.test("SELECT * FROM Customer WHERE id=?",newValue);

        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));

        return customerDTO;
    }

    public boolean exitCustomer(String id) throws SQLException, ClassNotFoundException {

     ResultSet rsst = SqlUtill.test("SELECT id FROM Customer WHERE id=?",id);
     return rsst.next();

    }

    public ArrayList<CustomerDTO> loadAllCustomerIds() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtill.test("SELECT * FROM Customer");

        ArrayList<CustomerDTO> dtoList = new ArrayList<>();
        // ClassDto dto = null;

        while(rst.next()) {
            dtoList.add(
                    new CustomerDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3)

                    )
            );
        }
        return dtoList;

    }


    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, newItemCode + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        ItemDTO item = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));

        return item;
    }
}
