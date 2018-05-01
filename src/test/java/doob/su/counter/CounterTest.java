package doob.su.counter;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CounterTest {
	
	private Counter instance;
	private Price price;
	
	@Before
	public void setUpCounterTest()
	{
		instance = new Counter("Hot water");
		price = new Price("Hot water");
		price.addRecord(37.56, LocalDate.now());
	}
	
	@After
	public void tearDownCounterTest()
	{
		price = null;
		instance = null;
	}

	@Test
	public final void testSetGetPrice()
	{
		instance.setPrice(price);
		assertEquals(price, instance.getPrice());
	}

	@Test
	public final void testAddRecord() {
		instance.addRecord(50.5, LocalDate.now());
		assertEquals(1, instance.countRecords());
	}

}
