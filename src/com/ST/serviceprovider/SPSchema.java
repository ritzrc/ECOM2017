package com.ST.serviceprovider;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class SPSchema {
	
	private static String ID = new String();
	private static SPSchema schema = new SPSchema();	
	
	private ISPTime time = new ISPTime() {
		
		boolean[] days = new boolean[7];
		int[][] time = new int[7][2];
		
		@Override
		public boolean worksToday(int day) {
			if(this.days[day])
				return true;
			return false;
		}
		
		@Override
		public boolean worksThisHour(int day, int[] hour) {
			if(this.getDays()[day])
				if(this.time[day][0] <= hour[0] && this.time[day][1] >= hour[1])
					return true;
			return false;
		}
		
		@Override
		public void setTime(int[][] time) {
			this.time = time; //For preexisting SP, set once during object creation from data fetched from database
		}
		
		@Override
		public void setDays(boolean[] days) {
			this.days = days; //For preexisting SP, set once during object creation from data fetched from database
		}
		
		@Override
		public int[][] getTime() {
			return this.time; //For preexisting SP, set once during object creation from data fetched from database
		}
		
		@Override
		public boolean[] getDays() {
			return this.days; //For preexisting SP, set once during object creation from data fetched from database
		}
	};
	
	private ISPSkills skills = new ISPSkills() {
		
		ArrayList<String> skills = new ArrayList<String>();
		
		@Override
		public void setSkills(ArrayList<String> skills) {
			this.skills.addAll(skills); //For preexisting SP, set once during object creation from data fetched from database
		}
		
		@Override
		public void setSkill(String skill) {
			if(!this.skills.contains(skill))
				this.skills.add(skill); //For preexisting SP, set once during object creation from data fetched from database
		}
		
		@Override
		public boolean hasSkill(String skill) {
			return this.skills.contains(skill);
		}
		
		@Override
		public ArrayList<String> getSkills() {
			return this.skills;
		}
	};
	
	private ISPProfile profile = new ISPProfile() {
		
		ArrayList<Integer> storeIDs = new ArrayList<Integer>();
		String first = new String(), last = new String(), name = new String(),
				gType = new String(), gID = new String(), dob = new String(),
				area = new String(), city = new String(), state = new String(), country = new String(), address = new String();
		int age = 0, pincode = 0;
		
		
		@Override
		public void setStorePreferences(ArrayList<Integer> storeIDs) {
			this.storeIDs.addAll(storeIDs);
		}
		
		@Override
		public void setName(String first, String last) {
			this.first = first;
			this.last = last;
			this.name = first + " " + last; //For preexisting SP, set once during object creation from data fetched from database
		}
		
		@Override
		public void setGovtID(String type, String ID) {
			this.gType = type;
			this.gID = ID; //For preexisting SP, set once during object creation from data fetched from database
		}
		
		@Override
		public void setDOB(int date, int month, int year) {
			this.dob = date + "-" + month + "-" + year;
			LocalDate dob = LocalDate.parse(year+"-"+month+"-"+date);
			LocalDate cur = LocalDate.now();
			this.age = Period.between(dob, cur).getYears(); //For preexisting SP, set once during object creation from data fetched from database
		}
		
		@Override
		public void setAddress(String area, String city, String state, String country, int pin) {
			this.area = area;
			this.city = city;
			this.state = state;
			this.country = country;
			this.pincode = pin;
			this.address = area + ",\n" + city + ",\n" + state + ",\n" + country + ",\n" + pin + "."; //For preexisting SP, set once during object creation from data fetched from database
		}
		
		@Override
		public boolean isStorePrefered(int id) {
			return this.storeIDs.contains(id);
		}
		
		@Override
		public ArrayList<Integer> getStorePreferences() {
			return this.storeIDs;
		}
		
		@Override
		public int getPinCode() {
			return this.pincode;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		@Override
		public String getLastName() {
			return last;
		}
		
		@Override
		public String getGovtIDType() {
			return this.gType;
		}
		
		@Override
		public String getGovtID() {
			return this.gID;
		}
		
		@Override
		public String getFirstName() {
			return this.first;
		}
		
		@Override
		public String getDOB() {
			return this.dob;
		}
		
		@Override
		public String getCity() {
			return this.city;
		}
		
		@Override
		public String getArea() {
			return this.area;
		}
		
		@Override
		public int getAge() {
			return this.age;
		}
		
		@Override
		public String getAddress() {
			return this.getAddress();
		}
		
		@Override
		public void addStorePreference(int storeID) {
			this.storeIDs.add(storeID);
		}
	};
	
	ISPTimesheet timesheet = new ISPTimesheet() {
		
		@Override
		public int getHoursWorked(int day, int month, int year) {
			// TODO Fetch from timesheet object
			return 0;
		}
		
		@Override
		public int getDaysWorked(int month1, int month2, int year) {
			// TODO Fetch from timesheet object
			return 0;
		}
		
		@Override
		public int getDaysWorked(int month, int year) {
			// TODO fetch data base
			return 0;
		}
		
		@Override
		public int getDaysWorked(int year) {
			// TODO Fetch from timesheet object
			return 0;
		}
	};
	
	private SPSchema() {
		
	}
	
	public static SPSchema getSchema(String id) {
		if(id != ID) {
			ID = id;
			schema = new SPSchema();
		}
		return schema;
	}
	
	ISPTime getSchedule() {
		return this.time;
	}
	
	ISPSkills getSkills() {
		return this.skills;
	}
	
	ISPProfile getProfile() {
		return this.profile;
	}
	
	ISPTimesheet getTimesheet() {
		return this.timesheet;
	}
}
