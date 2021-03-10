package ext20180406;

public class Item {
	private String id;
	private String description;
	
	public Item(String id, String description) {
		this.id = id;
		this.description = description;
	}
	
	
	public String getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			return id.equals(((Item) obj).id);
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return id.hashCode();
	}
}