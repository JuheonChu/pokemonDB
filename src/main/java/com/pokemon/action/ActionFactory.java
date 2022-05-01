package com.pokemon.action;

public class ActionFactory {
	
	
	private static final ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		
	}
	
	static ActionFactory getInstance() {
		return instance;
	}
	
	Action getAction(String command) {
		Action action = null;
		
		switch(command) {
			case "pokemon":
				action = new PokemonAction();
				break;
			
			
		}
		return action;
	}
}