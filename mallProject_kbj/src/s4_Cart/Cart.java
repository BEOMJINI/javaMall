package s4_Cart;

public class Cart {
	private int num;
	private String id;
	private String itemName;
	private int itemPrice;

	public Cart() {
	}

	public Cart(int num, String id, String itemName, int itemPrice) {
		super();
		this.num = num;
		this.id = id;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		String s = String.format("[%-6d] [%10s] [%10s] [%10d]", num, id, itemName, itemPrice);
		return s;
	}

}
