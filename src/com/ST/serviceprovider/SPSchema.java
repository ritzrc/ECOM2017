package com.ST.serviceprovider;

import java.util.ArrayList;

public class SPSchema {
	
	ISPTime time = new ISPTime() {
		
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
			this.time = time;
		}
		
		@Override
		public void setDays(boolean[] days) {
			this.days = days;
		}
		
		@Override
		public int[][] getTime() {
			return this.time;
		}
		
		@Override
		public boolean[] getDays() {
			return this.days;
		}
	};
	
	ISPSkills skills = new ISPSkills() {
		
		ArrayList<String> skills = new ArrayList<String>();
		
		@Override
		public void setSkills(ArrayList<String> skills) {
			this.skills.addAll(skills);
		}
		
		@Override
		public void setSkill(String skill) {
			if(!this.skills.contains(skill))
				this.skills.add(skill);
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

	SPSchema(boolean[] days) {
		this.time.setDays(days);
	}
	
	SPSchema(int[][] time) {
		this.time.setTime(time);
	}
	
	SPSchema(boolean[] days, int[][] time) {
		this.time.setDays(days);
		this.time.setTime(time);
	}
	
	SPSchema(String skill) {
		this.skills.setSkill(skill);
	}
	
	SPSchema(ArrayList<String> skills) {
		this.skills.setSkills(skills);
	}
	
	SPSchema(boolean[] days, int[][] time, String skill) {
		this.time.setDays(days);
		this.time.setTime(time);
		this.skills.setSkill(skill);
	}
	
	SPSchema(boolean[] days, int[][] time, ArrayList<String> skills) {
		this.time.setDays(days);
		this.time.setTime(time);
		this.skills.setSkills(skills);
	}
	
	public int[][] getTime() {
		return this.time.getTime();
	}
	
	public boolean[] getDays() {
		return this.time.getDays();
	}
	
	public boolean worksToday(int day) {
		return this.time.worksToday(day);
	}
	
	public boolean worksThisHour(int day, int[] hour) {
		return this.time.worksThisHour(day, hour);
	}
	
	public ArrayList<String> getSkills() {
		return this.skills.getSkills();
	}
	
	public boolean hasSkill(String skill) {
		return this.skills.hasSkill(skill);
	}
}
