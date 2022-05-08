package com.pokemon.dto;

public class PokemonDTO {

	int idx;
	String name;
	String type1;
	String type2;
	int strength;
	String img;
	String color1;
	String color2;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType1() {
		return type1;
	}
	
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	@Override
	public String toString() {
		return "PokemonDTO [idx=" + idx + ", name=" + name + ", type1=" + type1 + ", type2=" + type2 + ", strength="
				+ strength + ", img=" + img + ", color1=" + color1 + ", color2=" + color2 + "]";
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
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
}
