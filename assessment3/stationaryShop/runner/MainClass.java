package com.stationaryShop.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import com.mobile_application.NameNotFoundExeption;
import com.mobile_application.NotAddedException;
import com.mobile_application.NotDeletedException;
import com.stationaryShop.dao.StationaryShopDTO;
import com.stationaryShop.dto.StationaryShopDAO;

public class MainClass {
public static void main(String[] args) {
	StationaryShopDTO dto=new StationaryShopDTO();
	
	dto.setName("Faster");
	dto.setType("Pen");
	dto.setBrandName("Cello");
	dto.setPrice(10.00);
	dto.setQuantity(100);
	dto.setSerialNumber(101);
	
	String query="CREATE TABLE Items (name VARCHAR(20),type VARCHAR(20),brandName VARCHAR(20),price DOUBLE,quantity INT,serialNumber INT PRIMARY KEY)";
	Connection con = null;
	Statement statement =null;
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stationarydb","root","Avian@9483");
		if(con!=null) {
			System.out.println("Connection acquired successfully");
		}
		else {
			System.out.println("No connection established");
		}
		 statement=con.createStatement();
			statement.execute(query);
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	finally {
		try {
			if(statement!=null)
				statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
StationaryShopDAO dao=new StationaryShopDAO();
try {
//dao.add(dto);
}catch(NotAddedException e ) {
	System.out.println(e.getMessage());
}
dao.getAll();
try {
System.out.println(dao.getAllByName("Faster"));
}catch(NameNotFoundExeption e) {
	System.out.println(e.getMessage());
}
dao.updatePriceByBrandName(15.00, "Cello");
try{
	//dao.deleteBySerialNumber(101);
}catch(NotDeletedException e) {
	System.out.println(e.getMessage());
}
}
}
