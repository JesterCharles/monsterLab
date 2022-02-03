package com.revature.monster_lab.models;

public class Monster {
	private String monsterId;
	private String monsterName;
	private String monsterType;
	private String strength;
	private String dexterity;
	private String intelligence;
	private Scientist creator;
	
	
	// Boilerplate 
	public Monster() {
		super();
	}

	public Monster(String monsterId, String monsterName, String monsterType, String strength, String dexterity,
			String intelligence, Scientist creator) {
		super();
		this.monsterId = monsterId;
		this.monsterName = monsterName;
		this.monsterType = monsterType;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.creator = creator;
	}

	public Monster(String monsterName, String monsterType, String strength, String dexterity, String intelligence,
			Scientist creator) {
		super();
		this.monsterName = monsterName;
		this.monsterType = monsterType;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.creator = creator;
	}

	public String getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(String monsterId) {
		this.monsterId = monsterId;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public String getMonsterType() {
		return monsterType;
	}

	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getDexterity() {
		return dexterity;
	}

	public void setDexterity(String dexterity) {
		this.dexterity = dexterity;
	}

	public String getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(String intelligence) {
		this.intelligence = intelligence;
	}

	public Scientist getCreator() {
		return creator;
	}

	public void setCreator(Scientist creator) {
		this.creator = creator;
	}
	
	

	
	
	
}
