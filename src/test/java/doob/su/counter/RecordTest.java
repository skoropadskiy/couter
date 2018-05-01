package doob.su.counter;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecordTest {
	
	private Record instance;
	
	@Before
	public void setUpRecordTest()
	{
		this.instance = new Record(101, LocalDate.of(2018, Month.AUGUST, 29));			
	}
	
	@After
	public void tearDownRecordTest()
	{
		this.instance = null;
	}

	@Test
	public final void testGetValue()
	{
		assertEquals(101, instance.getValue(), 0.0001);
	}

	@Test
	public final void testSetValue()
	{
		instance.setValue(202);
		assertEquals(202, instance.getValue(), 0.0001);
	}

	@Test
	public final void testGetDate() 
	{
		assertEquals(LocalDate.of(2018, Month.AUGUST, 29), instance.getDate());
	}

	@Test
	public final void testSetDate()
	{
		instance.setDate(LocalDate.of(2018, Month.AUGUST, 14));
		assertEquals(LocalDate.of(2018, Month.AUGUST, 14), instance.getDate());
	}

}
