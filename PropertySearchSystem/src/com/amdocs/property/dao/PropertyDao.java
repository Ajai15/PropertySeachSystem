package com.amdocs.property.dao;
import java.util.List;

import com.amdocs.property.model.Property;

public interface PropertyDao {
	
	int addProperty(Property property);
	int deleteProperty(int id);
	boolean updatePropertyCost(int id,double cost);
	List<Property> ByCity(String city);
	List<Property> showAllProperties();
	List<Property> searchByCost(double min,double max);
	List<Property> searchByNoOfRoomsAndCity(String room ,String cost);


}
