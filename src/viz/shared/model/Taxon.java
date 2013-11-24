package viz.shared.model;

import java.util.HashMap;
import java.util.Map;

public class Taxon {

	private Map<String, String> characters = new HashMap<String, String>();
	
	public Taxon() { }	
	
	public Taxon(Map<String, String> characters) {
		this.characters = characters;
	}
	
	public String getCharacterState(String characterName) {
		return characters.get(characterName);
	}
	
	public void setCharacterState(String characterName, String characterState) {
		characters.put(characterName, characterState);
	}

	public int getId() {
		return -1;
	}

}
