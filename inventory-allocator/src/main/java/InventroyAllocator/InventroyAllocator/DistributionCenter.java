import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

//class representing distribution center which contains list of warehouses
public class DistributionCenter {

	LinkedList<Warehouse> wareHouses= new LinkedList<Warehouse>();
	
	HashMap<String,Item> order= new HashMap<String,Item>();
	
	public void fillWareHouses(LinkedList<Warehouse> wareHouses) {
		this.wareHouses=wareHouses;
	}
	
	public void takeOrder(HashMap<String,Item> order) {
		this.order=order;
	}
	
	
	//Takers order and return shipment fulfilling the order from each warehouse
	public ArrayList<ShippedItem> processOrder() {
		ArrayList<ShippedItem> shipment= new ArrayList<ShippedItem>();
		
		for(Warehouse w: wareHouses) {
			ShippedItem s= w.processOrder(order);
			
			shipment.add(s);
			if(orderComplete(s)) {
				break;
			}
		}
		//if order is not fullfilled then return empty array
		if(!order.isEmpty()) return new ArrayList<ShippedItem>();
		return shipment;
	}

	
	//Checks if the order is fullfilled or not
	private boolean orderComplete(ShippedItem s) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> shippedItems=s.getItems();
		
		for(Map.Entry<String, Integer> entry: shippedItems.entrySet()) {
			String itemName=entry.getKey();
			int fullFilledOrder= entry.getValue();
			int remainingOrder=order.get(itemName).getItemCount();
			remainingOrder-=fullFilledOrder;
			
			if(remainingOrder==0) {
				order.remove(itemName);
			}
			if(remainingOrder>0) {
				Item item=order.get(itemName);
				item.setItemCount(remainingOrder);
				order.put(itemName, item);
			}
		}
		if(order.isEmpty()) return true;
		
		return false;
	}
	
}
