//Data class for storing item
public class Item {

	String itemName;
	int itemCount;
	
	public Item (String itemName, int itemCount) {
		this.itemName=itemName;
		this.itemCount=itemCount;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public int getItemCount() {
		return this.itemCount;
	}
	
	
	public void setItemName(String itemName) {
		this.itemName=itemName;
	}
	
	
	public void setItemCount(int itemCount) {
		this.itemCount=itemCount;
	}
}
