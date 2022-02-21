package com.revature.monster_lab.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "monsters")
public class Monster {
	@Id
	@Column(name="monster_id")
	private String monsterId;
	
	@Column(name = "monster_name", unique = true, nullable = false, columnDefinition = "VARCHAR CHECK (monster_name <> '')")
	private String monsterName;
	
	@Column(name = "monster_type", nullable = false, columnDefinition = "VARCHAR CHECK (monster_type <> '')")
	private String monsterType;
	
	@Column(nullable = false)
	private String strength;
	
	@Column(nullable = false)
	private String dexterity;
	
	@Column(nullable = false)
	private String intelligence;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "creator_id", nullable = false, columnDefinition = "VARCHAR CHECK (creator_id <> '')")
	private Scientist creator;
	
	
	// @ManyToMany
	// @JoinTable(name = "monster_fights", joinColumns = @JoinColumn(name = "creator_id"),
	// inverseJoinColumns = @JoinColumn(name = "monster_id")
	
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

	public Monster(String monsterName, String monsterType, String strength, String dexterity, String intelligence) {
		super();
		this.monsterName = monsterName;
		this.monsterType = monsterType;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
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
