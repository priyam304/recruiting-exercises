import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Class presenting a single warehouse containing name and it's inventory
public class Warehouse {
	String wareHouseName;
	HashMap<String,Integer> inventory= new HashMap<String,Integer>();
	
	public Warehouse(String wareHouseName, HashMap<String,Integer> inventory) {
		this.wareHouseName=wareHouseName;
		this.inventory=inventory;
	}
	
	
	//Takes order and process it
	//Update the warehouse inventory accordingly
	public ShippedItem processOrder(HashMap<String,Item> order) {
		ShippedItem shipment= new ShippedItem(wareHouseName);
		for(Map.Entry<String, Item> o:order.entrySet()) {
			
			String itemName=o.getKey();
			int orderCount=o.getValue().getItemCount();
			if(inventory.containsKey(itemName)) {
			int currentItemCount=inventory.get(itemName);
			if(orderCount>=currentItemCount) {
				//add to shippedItem object
				//remove from inventory
				shipment.addItems(itemName, currentItemCount);
				inventory.remove(itemName);
				
			}else {
				currentItemCount-=orderCount;
				inventory.put(itemName, currentItemCount);
				shipment.addItems(itemName, orderCount);
				}
			}
		}
		
		return shipment;
	}
	
	
	
	
}
