import java.util.HashMap;

//Data class to store shipment-output of order
public class ShippedItem {
	

	public String shippedFrom;
	public HashMap<String,Integer> shippedItems;
	
	
	public ShippedItem(String shippedFrom){
		this.shippedFrom= shippedFrom;
		shippedItems=new HashMap<String,Integer>();
	}
	
	
	public void addItems(String item,int itemCount) {
		shippedItems.put(item, itemCount);
	}
	
	public HashMap<String, Integer> getItems(){
		return shippedItems;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		ShippedItem s= (ShippedItem)obj;
		
		
		if(this.shippedFrom.equals(s.shippedFrom) && this.shippedItems.equals(s.shippedItems)) {
			return true;
		}
		
		return false;
	}

}
