package com.ST.serviceprovider;

import java.util.ArrayList;

public interface ISPProfile {
	
	public void setName(String first, String last);
	public String getName();
	public String getFirstName();
	public String getLastName();
	
	public void setDOB(int date, int month, int year);
	public String getDOB();
	public int getAge();
	
	public void setGovtID(String type, String ID);
	public String getGovtIDType();
	public String getGovtID();
	
	public void setAddress(String area, String city, String state, String country, int pin);
	public int getPinCode();
	public String getCity();
	public String getArea();
	public String getAddress();
	
	public void setStorePreferences(ArrayList<Integer> storeIDs);
	public void addStorePreference(int storeID);
	public boolean isStorePrefered(int id);
	public ArrayList<Integer> getStorePreferences();

}
