package com.ST.shopper;

import java.util.ArrayList;

public interface ISProfile {
	
	public void setName(String first, String last);
	public String getName();
	public String getFirstName();
	public String getLastName();
	
	public void setDOB(int date, int month, int year);
	public String getDOB();
	public int getAge();
	
	public void setAddress(String area, String city, String state, String country, int pin);
	public int getPinCode();
	public String getCity();
	public String getArea();
	public String getAddress();
	
	public void setStorePreferences(ArrayList<Integer> storeIDs);
	public void addStorePreference(int storeID);
	public boolean isStorePrefered(int id);
	public ArrayList<Integer> getStorePreferences();
	
	public void setSPPreferences(ArrayList<Integer> SPIDs);
	public void addSPPreference(int SPID);
	public boolean isSPPrefered(int SPID);
	public ArrayList<Integer> getSPIDPreferences();

}
