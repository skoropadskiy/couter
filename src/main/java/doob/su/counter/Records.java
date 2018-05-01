package doob.su.counter;

import java.time.LocalDate;

public interface Records<T> {
	public void addRecord(double value, LocalDate date);
	public T getRecord(LocalDate date);
	public int countRecords();
}
