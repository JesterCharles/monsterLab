package com.revature.monster_lab.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.monster_lab.models.Scientist;

public class MonsterRequest {

	private String monsterName;
	private String mosnterType;
	private String dexterity;
	private String strength;
	private String intelligence;

	@JsonIgnore
	private Scientist creator;

	public Scientist getCreator() {
		return creator;
	}

	public void setCreator(Scientist creator) {
		this.creator = creator;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public String getMosnterType() {
		return mosnterType;
	}

	public void setMosnterType(String mosnterType) {
		this.mosnterType = mosnterType;
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

	@Override
	public String toString() {
		return "MonsterRequest [monsterName=" + monsterName + ", mosnterType=" + mosnterType + ", dexterity="
				+ dexterity + ", strength=" + strength + ", intelligence=" + intelligence + ", creator=" + creator
				+ "]";
	}

}
