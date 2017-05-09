package com.ST.serviceprovider;

import java.util.ArrayList;

public interface ISPSkills {

	public void setSkills(ArrayList<String> skills);
	public ArrayList<String> getSkills();
	public void setSkill(String skill);
	public boolean hasSkill(String skill);
	
}
