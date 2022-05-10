package com.pokemon.dto;

public class TrainerDTO {
	
	private int id;
	private String name;
	private int num_pokemon;
	String type;
	String image;
	
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}



	@Override
	public int hashCode() {
		return 2;
	}
}
