package doob.su.counter;

public class Counter extends BaseRecords {

	private Price price;
	
	public Counter(String name) {
		super(name);
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

}
