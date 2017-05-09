package com.ST.serviceprovider;

public interface ISPTime {
	
	public void setDays(boolean[] days);
	public boolean[] getDays();
	public boolean worksToday(int day);
	
	public void setTime(int[][] time);
	public int[][] getTime();
	public boolean worksThisHour(int day, int[] hour);

}
