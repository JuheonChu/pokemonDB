package com.pokemon.dto;

public class PairsDTO {
	
	@Override
	public String toString() {
		return "PairsDTO [owner=" + owner + ", level=" + level + ", name=" + name + ", strength=" + strength
				+ ", num_pokemon=" + num_pokemon + ", img=" + img + ", image=" + image + ", type=" + type + ", type1="
				+ type1 + ", type2=" + type2 + ", color1=" + color1 + ", color2=" + color2 + "]";
	}



	String owner; 
	int level;
	String name;
	int strength;
	int num_pokemon;
	String img; //pokemon image
	String image; //trainer image
	String type; // trainer's type
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	String type1;
	String type2;
	String color1; 
	String color2;
	
	public String getType1() {
		return type1;
	}



	public void setType1(String type1) {
		this.type1 = type1;
	}



	public String getType2() {
		return type2;
	}



	public void setType2(String type2) {
		this.type2 = type2;
	}



	public String getColor1() {
		return color1;
	}



	public void setColor1(String color1) {
		this.color1 = color1;
	}



	public String getColor2() {
		return color2;
	}



	public void setColor2(String color2) {
		this.color2 = color2;
	}



	public int getStrength() {
		return strength;
	}



	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getOwner() {
		return owner;
	}



	public void setOwner(String owner) {
		this.owner = owner;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getNum_pokemon() {
		return num_pokemon;
	}



	public void setNum_pokemon(int num_pokemon) {
		this.num_pokemon = num_pokemon;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public int hashCode() {
		return 3;
	}
}
