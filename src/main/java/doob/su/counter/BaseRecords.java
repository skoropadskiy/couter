package doob.su.counter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseRecords implements Records<Record> {
	
	private String name;
	private Set<Record> records;

	public BaseRecords(String name) {
		super();
		this.name = name;
		this.records = new HashSet<Record>();
	}

	@Override
	public void addRecord(double value, LocalDate date) {
		records.add(new Record(value, date));
	}

	@Override
	public Record getRecord(LocalDate date) {
		return records.parallelStream().filter(r -> r.getDate().equals(date)).findFirst().get();
	}

	@Override
	public int countRecords() {
		return records.size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Record> getAllRecords() {
		return records;
	}

	public void setAllRecords(Set<Record> records) {
		this.records = records;
	}

	
}
