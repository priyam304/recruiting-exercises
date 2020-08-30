import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryAllocatorTest {
	DistributionCenter dc;
	
	@BeforeEach
	void setUp() throws Exception {
		
		dc= new DistributionCenter();
		}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void BaseTestCase() {
		dc= new DistributionCenter();
		HashMap<String,Integer> map1=new HashMap<String,Integer>();
		map1.put("apple",1);
		
	
		Warehouse w1= new Warehouse("owd",map1);
		
		
		LinkedList<Warehouse> wareHouseList = new LinkedList<Warehouse>();
		wareHouseList.add(w1);
		
		dc.fillWareHouses(wareHouseList);
		HashMap<String,Item> order= new HashMap<String,Item>();
		order.put("apple",new Item("apple",1));
		
		dc.takeOrder(order);
		ArrayList<ShippedItem> result= new ArrayList<ShippedItem>();
		ShippedItem s= new ShippedItem("owd");
		s.addItems("apple", 1);
		result.add(s);
		assertEquals(result,dc.processOrder());
	}
	
	@Test
	void OrderFullFilled_Warehouse_1() {
		
		dc= new DistributionCenter();
		HashMap<String,Integer> map1=new HashMap<String,Integer>();
		map1.put("apple",1);
		
	
		Warehouse w1= new Warehouse("owd",map1);
		
		
		
		LinkedList<Warehouse> wareHouseList = new LinkedList<Warehouse>();
		wareHouseList.add(w1);
		
		dc.fillWareHouses(wareHouseList);
		HashMap<String,Item> order= new HashMap<String,Item>();
		order.put("apple",new Item("apple",2));
		dc.takeOrder(order);
		
		ArrayList<ShippedItem> result= new ArrayList<ShippedItem>();
		
		
		assertEquals(result,dc.processOrder());
		
	}
	
	@Test
	void OrderFullFilled_WareHouse_2() {
		dc= new DistributionCenter();
		HashMap<String,Integer> map1=new HashMap<String,Integer>();
		map1.put("apple",5);
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
		dc.takeOrder(order);
		
		ArrayList<ShippedItem> result= new ArrayList<ShippedItem>();
		ShippedItem s1= new ShippedItem("owd");
		s1.addItems("apple", 5);
		ShippedItem s2= new ShippedItem("dm");
		s2.addItems("apple", 5);
		result.add(s1);
		result.add(s2);
		
		assertEquals(result,dc.processOrder());
	}
	
	
	
	
	@Test
	void OrderNotFullFilled_1() {
		
		dc= new DistributionCenter();
		HashMap<String,Integer> map1=new HashMap<String,Integer>();
		map1.put("apple",0);
		
	
		Warehouse w1= new Warehouse("owd",map1);
		
		
		
		LinkedList<Warehouse> wareHouseList = new LinkedList<Warehouse>();
		wareHouseList.add(w1);
		
		dc.fillWareHouses(wareHouseList);
		HashMap<String,Item> order= new HashMap<String,Item>();
		order.put("apple",new Item("apple",1));
		dc.takeOrder(order);
		
		ArrayList<ShippedItem> result= new ArrayList<ShippedItem>();
		
		
		assertEquals(result,dc.processOrder());
		
	}
	
	
	@Test
	void OrderNotFullFilled_2() {
		dc= new DistributionCenter();
		HashMap<String,Integer> map1=new HashMap<String,Integer>();
		map1.put("apple",2);
		map1.put("banana",1);
		
	
		Warehouse w1= new Warehouse("owd",map1);
		
		
		
		LinkedList<Warehouse> wareHouseList = new LinkedList<Warehouse>();
		wareHouseList.add(w1);
		
		dc.fillWareHouses(wareHouseList);
		HashMap<String,Item> order= new HashMap<String,Item>();
		order.put("apple",new Item("apple",2));
		order.put("banana",new Item("banana",2));
		dc.takeOrder(order);
		
		ArrayList<ShippedItem> result= new ArrayList<ShippedItem>();
		
		
		
		assertEquals(result,dc.processOrder());
	}
	
	@Test
	void Empty_Order() {
		dc= new DistributionCenter();
		HashMap<String,Integer> map1=new HashMap<String,Integer>();
		map1.put("apple",5);
		
		
	
		Warehouse w1= new Warehouse("owd",map1);
		
		
		
		LinkedList<Warehouse> wareHouseList = new LinkedList<Warehouse>();
		wareHouseList.add(w1);
		
		dc.fillWareHouses(wareHouseList);
		HashMap<String,Item> order= new HashMap<String,Item>();
		
		dc.takeOrder(order);
		
		ArrayList<ShippedItem> result= new ArrayList<ShippedItem>();
		
		
		assertEquals(result,dc.processOrder());
	}
	
	@Test
	void OrderFullfilled_Multiple_Items() {
		dc= new DistributionCenter();
		HashMap<String,Integer> map1=new HashMap<String,Integer>();
		map1.put("apple",5);
		map1.put("orange",5);
		HashMap<String,Integer> map2=new HashMap<String,Integer>();
		map2.put("apple",5);
		map2.put("orange",3);
		
	
		Warehouse w1= new Warehouse("owd",map1);
		Warehouse w2= new Warehouse("dm",map2);
		
		
		LinkedList<Warehouse> wareHouseList = new LinkedList<Warehouse>();
		wareHouseList.add(w1);
		wareHouseList.add(w2);
		dc.fillWareHouses(wareHouseList);
		HashMap<String,Item> order= new HashMap<String,Item>();
		order.put("apple",new Item("apple",10));
		order.put("orange",new Item("orange",7));

		dc.takeOrder(order);
		
		ArrayList<ShippedItem> result= new ArrayList<ShippedItem>();
		ShippedItem s1= new ShippedItem("owd");
		s1.addItems("apple", 5);
		s1.addItems("orange", 5);
		ShippedItem s2= new ShippedItem("dm");
		s2.addItems("apple", 5);
		s2.addItems("orange", 2);
		result.add(s1);
		result.add(s2);
		
		assertEquals(result,dc.processOrder());
	}
}

