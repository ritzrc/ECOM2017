package com.ST.serviceprovider;

public interface ISPTimesheet {
	
	public int getDaysWorked(int year);
	public int getDaysWorked(int month, int year);
	public int getDaysWorked(int month1, int month2, int year);
	public int getHoursWorked(int day, int month, int year);

}
