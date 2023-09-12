package com.amdocs.property.dao;

import java.sql.*;
import java.util.*;
import com.amdocs.property.model.Property;

public class PropertyDaoImp implements PropertyDao{

	Connection connection=DbConnect.getConnection();
	
	private static final String INSERT_PROPERTY="insert into propertylist(property_id,no_rooms,area_in_sqft,floor_no,city,state_name,price,owner_name,owner_number) values(?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_PROPERTY="update propertylist set price=? where property_id=?";
	private static final String DELETE_PROPERTY="delete from propertylist where property_id=?";
	private static final String SEARCH_CITY="Select * from propertylist where city=?";
	private static final String DISPLAY_ALL="Select * from propertylist";
	private static final String SEARCH_BY_COST="select * from propertylist where price between ? and ?";
	private static final String CITY_ROOM="select * from propertylist where city=? and no_rooms=? ";
	private static final String NEXTVAL ="select seq.nextval from dual";
	

	

	@Override
	public int addProperty(Property property) {
		 try {
			 PreparedStatement pst=connection.prepareStatement(NEXTVAL);
			 ResultSet rs=pst.executeQuery();
			 int property_id=0;
			 while(rs.next()) {
				  property_id =rs.getInt(1);
			    }

			 pst=connection.prepareStatement(INSERT_PROPERTY);
			
			 pst.setInt(1, property_id);
			 pst.setString(2, property.getNoOfRooms());
			 pst.setDouble(3,property.getAreaInSqft());
			 pst.setInt(4, property.getFloorNo());//
			 pst.setString(5,property.getCity() );
			 pst.setString(6, property.getState());
			 pst.setDouble(7, property.getCost());
			 pst.setString(8, property.getOwnerName());
			 pst.setString(9, property.getOwnerContactNo());
			 pst.executeUpdate();
			 
			 property.setPropertyId(property_id);
			 
			
		 }catch(Exception e) {
			 System.out.println("error");
		 }
		 return property.getPropertyId();
	}

	@Override
	public int deleteProperty(int id) {
		int c=0;
		try {
//			PreparedStatement pst=connection.prepareStatement(ID);
//			pst.setInt(1, id);
//			 ResultSet rs=pst.executeQuery();
//			 while(rs.next()) {
//				  c =rs.getInt(1);
//			    }
//			 
			PreparedStatement pst=connection.prepareStatement(DELETE_PROPERTY);
			 pst.setInt(1, id);
			 c=pst.executeUpdate();
			
		 }catch(Exception e) {
			 System.out.println("error");
		 }
		return c;
	}

	@Override
	public boolean updatePropertyCost(int id, double cost) {
		int c=0;
		try {
//			 PreparedStatement pst=connection.prepareStatement(ID);
//			 pst.setInt(1, id);
//			 ResultSet rs=pst.executeQuery();
//			 while(rs.next()) {
//				  c =rs.getInt(1);
//			    }
			
			 PreparedStatement pst=connection.prepareStatement(UPDATE_PROPERTY);
			 pst.setDouble(1,cost);
			 pst.setInt(2,id);
			 c=pst.executeUpdate();
			
		 }catch(Exception e) {
			 System.out.println("error");
		 }
		if(c>0)
			return true;
		else
			return false;
	}

	@Override
	public List<Property> ByCity(String city) 
	{
		List<Property> list1 = new ArrayList<Property>();
		ResultSet rs;
		try{
			PreparedStatement pst=connection.prepareStatement(SEARCH_CITY);
		    pst.setString(1,city);
		    rs=pst.executeQuery();
		    while(rs.next()) {
			  Property prop = 
					new Property(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
			  list1.add(prop);
		    }
		}
		catch(Exception e){e.printStackTrace();}
		return list1;
		}

	@Override
	public List<Property> showAllProperties() {
		List<Property> list1 = new ArrayList<Property>();
		ResultSet rs;
		try{
			PreparedStatement pst=connection.prepareStatement(DISPLAY_ALL);
		    rs=pst.executeQuery();
		    while(rs.next()) {
			   Property prop = new Property(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
			   list1.add(prop);
			}
		}
		catch(Exception e){e.printStackTrace();}
		return list1;
	}

	@Override
	public List<Property> searchByCost(double min, double max) {
		List<Property> list1 = new ArrayList<Property>();
		ResultSet rs;
		try{
			PreparedStatement pst=connection.prepareStatement(SEARCH_BY_COST);
		    pst.setDouble(1,min);
		    pst.setDouble(2,max);
		    rs=pst.executeQuery();
		    while(rs.next()) {
			  Property prop = new Property(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
			  list1.add(prop);
			}
		}
		catch(Exception e){e.printStackTrace();}
		return list1;
	}

	@Override
	public List<Property> searchByNoOfRoomsAndCity(String room, String city) {
		List<Property> list1 = new ArrayList<Property>();
		ResultSet rs;
		try{
			PreparedStatement pst=connection.prepareStatement(CITY_ROOM);
		    pst.setString(1,room);
		    pst.setString(2,city);
		    rs=pst.executeQuery();
		    while(rs.next()) {
		    	Property prop = new Property(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
			list1.add(prop);
			}
		}
		catch(Exception e){e.printStackTrace();}
		return list1;
	}

}
