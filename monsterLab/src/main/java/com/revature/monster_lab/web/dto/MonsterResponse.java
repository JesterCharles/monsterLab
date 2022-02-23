package com.revature.monster_lab.web.dto;

import java.util.Objects;

import com.revature.monster_lab.models.Monster;

public class MonsterResponse {

	private String monsterId;
	private String monsterName;
	private String monsterType;
	private String dexterity;
	private String strength;
	private String intelligence;
	private ScientistResponse scientistInfo;

	public MonsterResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MonsterResponse(Monster monster) {
		this.monsterId = monster.getMonsterId();
		this.monsterName = monster.getMonsterName();
		this.monsterType = monster.getMonsterType();
		this.dexterity = monster.getDexterity();
		this.strength = monster.getStrength();
		this.intelligence = monster.getIntelligence();
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

	public String getDexterity() {
		return dexterity;
	}

	public void setDexterity(String dexterity) {
		this.dexterity = dexterity;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(String intelligence) {
		this.intelligence = intelligence;
	}

	public ScientistResponse getScientistInfo() {
		return scientistInfo;
	}

	public void setScientistInfo(ScientistResponse scientistInfo) {
		this.scientistInfo = scientistInfo;
	}

	@Override
	public String toString() {
		return "MonsterResponse [monsterName=" + monsterName + ", monsterType=" + monsterType + ", dexterity="
				+ dexterity + ", strength=" + strength + ", intelligence=" + intelligence + ", scientistInfo="
				+ scientistInfo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dexterity, intelligence, monsterName, monsterType, scientistInfo, strength);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonsterResponse other = (MonsterResponse) obj;
		return Objects.equals(dexterity, other.dexterity) && Objects.equals(intelligence, other.intelligence)
				&& Objects.equals(monsterName, other.monsterName) && Objects.equals(monsterType, other.monsterType)
				&& Objects.equals(scientistInfo, other.scientistInfo) && Objects.equals(strength, other.strength);
	}

}
