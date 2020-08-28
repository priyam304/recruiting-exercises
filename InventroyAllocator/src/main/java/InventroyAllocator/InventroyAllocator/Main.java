import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistributionCenter dc= new DistributionCenter();
		HashMap<String,Integer> map1=new HashMap<String,Integer>();
		map1.put("apple",5);
		map1.put("banana", 2);
		HashMap<String,Integer> map2=new HashMap<String,Integer>();
		map2.put("apple",5);
		
		Warehouse w1= new Warehouse("owd",map1);
		Warehouse w2= new Warehouse("dm",map2);
		
		LinkedList<Warehouse> wareHouseList = new LinkedList<Warehouse>();
		wareHouseList.add(w1);
		wareHouseList.add(w2);
		dc.fillWareHouses(wareHouseList);
		HashMap<String,Item> order= new HashMap<String,Item>();
		order.put("apple",new Item("apple",10));
		order.put("banana", new Item("banana",2));
		dc.takeOrder(order);
		ArrayList<ShippedItem> shipment=dc.processOrder();
		
		for(ShippedItem s:shipment) {
			System.out.println(s.shippedFrom);
			for(Map.Entry<String, Integer> e:s.shippedItems.entrySet()) {
				System.out.println(e.getKey()+":"+e.getValue());
			}
		}
		
	}

}
