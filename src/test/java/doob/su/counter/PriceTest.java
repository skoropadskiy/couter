package doob.su.counter;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PriceTest {
	
	private Price instance;
	private Set<Record> records;
	
	@Before
	public void setUpPriceTest()
	{
		instance = new Price("Hot water");
		records = new HashSet<Record>();		
		records.add(new Record(37.56, LocalDate.of(2018, Month.MARCH, 1)));
		records.add(new Record(35.14, LocalDate.of(2017, Month.SEPTEMBER, 1)));
		records.add(new Record(33.36, LocalDate.of(2017, Month.JANUARY, 1)));
	}
	
	@After
	public void tearDownPriceTest()
	{
		instance = null;
		records = null;
	}

	@Test
	public final void testGetName()
	{
		assertEquals("Hot water", instance.getName());
	}
	
	@Test
	public final void testSetName()
	{
		instance.setName("Cold water");
		assertEquals("Cold water", instance.getName());
	}
	
	@Test
	public final void testGetSetAllRecords()
	{
		instance.setAllRecords(records);
		assertEquals(3, instance.getAllRecords().size());
	}
	
	@Test
	public final void testAddCountRecords()
	{
		instance.addRecord(50.50, LocalDate.now());
		assertEquals(1, instance.countRecords());
	}
	
	@Test
	public final void testGetRecord()
	{
		instance.setAllRecords(records);
		LocalDate date = LocalDate.of(2017, Month.SEPTEMBER, 1);
		Record expected = new Record(35.14, date);
		assertEquals(expected, instance.getRecord(date));
	}
	
	@Test
	public final void testUniqueRecords()
	{
		instance.setAllRecords(records);
		LocalDate date = LocalDate.of(2018, Month.MARCH, 1);
		instance.addRecord(50.50, date);
		assertEquals(37.56, instance.getRecord(date).getValue(), 0.0001);
	}

}
