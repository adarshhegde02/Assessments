package com.stationaryShop.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobile_application.NameNotFoundExeption;
import com.mobile_application.NotAddedException;
import com.mobile_application.NotDeletedException;
import com.stationaryShop.dao.StationaryShopDTO;

public class StationaryShopDAO {
 public boolean add(StationaryShopDTO dto) {
	 Connection con = null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stationarydb","root","Avian@9483");
			if(con!=null) {
				System.out.println("Connection acquired successfully");
			}
			else {
				System.out.println("No connection established");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement= con.prepareStatement("INSERT INTO Items VALUES(?,?,?,?,?,?)");
			
			preparedStatement.setString(1,dto.getName());
			preparedStatement.setString(2,dto.getType());
			preparedStatement.setString(3, dto.getBrandName());
			preparedStatement.setDouble(4, dto.getPrice());
			preparedStatement.setInt(5, dto.getQuantity());
			preparedStatement.setInt(6, dto.getSerialNumber());
			
			preparedStatement.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	 throw new NotAddedException();
 }
 
 public void getAll() {
	 Connection con = null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stationarydb","root","Avian@9483");
			if(con!=null) {
				System.out.println("Connection acquired successfully");
			}
			else {
				System.out.println("No connection established");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			preparedStatement=con.prepareStatement("SELECT * FROM Items");
			
			 resultSet=preparedStatement.executeQuery();
			 boolean flag=false;
			 while(resultSet.next()) {
				 flag=true;
	
				 System.out.println("Name: "+resultSet.getString("name"));
				 System.out.println("Type: "+resultSet.getString("type"));
				 System.out.println("Brand Name: "+resultSet.getString("brandName"));
				 System.out.println("Price: "+resultSet.getDouble("price"));
				 System.out.println("Quantity: "+resultSet.getInt("quantity"));
				 System.out.println("Serial Number: "+resultSet.getInt("serialNumber"));
				 System.out.println();
			 }if(flag==false) {
				 System.out.println("No result found");
				 System.out.println();
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
				resultSet.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
 }
 
 public StationaryShopDTO deleteBySerialNumber(int serialNumber) {
	 Connection con = null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stationarydb","root","Avian@9483");
			if(con!=null) {
				System.out.println("Connection acquired successfully");
			}
			else {
				System.out.println("No connection established");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement preparedStatement =null;
		try{
			preparedStatement=con.prepareStatement("DELETE FROM Items WHERE serialNumber=?");
			preparedStatement.setInt(1, serialNumber);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	throw new NotDeletedException();
 }
 
 public StationaryShopDTO updatePriceByBrandName(double price,String brandName) {
	 Connection con = null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stationarydb","root","Avian@9483");
			if(con!=null) {
				System.out.println("Connection acquired successfully");
			}
			else {
				System.out.println("No connection established");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement preparedStatement =null;
		try {
			 preparedStatement=con.prepareStatement("UPDATE Items SET price=? WHERE brandName=?");
			preparedStatement.setDouble(1, price);
			preparedStatement.setString(2, brandName);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	 
 }
 
 public List<StationaryShopDTO> getAllByName(String name){
	 List<StationaryShopDTO> list=new ArrayList<>();
	 Connection con = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stationarydb","root","Avian@9483");
			if(con!=null) {
				System.out.println("Connection acquired successfully");
			}
			else {
				System.out.println("No connection established");
			}
			preparedStatement=con.prepareStatement("SELECT * FROM Items WHERE name=?");
			
			 preparedStatement.setString(1, name);
			 resultSet=preparedStatement.executeQuery();
			 StationaryShopDTO dto=new StationaryShopDTO();
				list.add(dto);
			 dto.setName(resultSet.getString("name"));
			 dto.setType(resultSet.getString("type"));
			 dto.setBrandName(resultSet.getString("brandName"));
			 dto.setPrice(resultSet.getDouble("price"));
			 dto.setQuantity(resultSet.getInt("quantity"));
			 dto.setSerialNumber(resultSet.getInt("serialNumber"));
			 return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		try {
			if(resultSet!=null)
			resultSet.close();
			if(preparedStatement!=null)
				preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
throw new NameNotFoundExeption();

	 
 }
}
