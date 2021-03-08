package frequency;

public class Bird {
	private String genus; // släkte
	private String specificEpithet; // artepitet
	
	public Bird(String genus, String specificEpithet) {
		this.genus = genus;
		this.specificEpithet = specificEpithet;
	}
	
	@Override
	public int hashCode() {
		return (getName()).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Bird) {
			return getName().equals(((Bird) obj).getName());
		} else {
			return false;
		}
	}
	
	public String getName() {
		return genus + " " + specificEpithet;
	}

}
