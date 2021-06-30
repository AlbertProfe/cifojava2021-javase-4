package example.boot.dev.employee1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table
public class Holidays {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int year;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ElementCollection
	private List<Date> daysHolidays = new ArrayList<Date>();
	private int daysHolidaysQty;
	private int officialYearHolidaysQty;
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_FID")
	private Employee employee;
	
	
	public Holidays() {
		super();
	}
	public Holidays(int year, int officialYearHolidaysQty) {
		super();
		this.year = year;
		this.officialYearHolidaysQty = officialYearHolidaysQty;
		
		
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public List<Date> getDaysHolidays() {
		return daysHolidays;
	}
	
	public void addHolidays(Date dateToAdd) {
		this.getDaysHolidays().add(dateToAdd);
		this.setDaysHolidaysQty();
	}
	public int getDaysHolidaysQty() {
		return daysHolidaysQty;
	}
	public void setDaysHolidaysQty() {
		this.daysHolidaysQty = this.getDaysHolidays().size();
	}
		
	public int getOfficialYearHolidaysQty() {
		return officialYearHolidaysQty;
	}
	public void setOfficialYearHolidaysQty(int officialYearHolidaysQty) {
		this.officialYearHolidaysQty = officialYearHolidaysQty;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public String toString() {
		return "Holidays [id=" + id + ", year=" + year + ", daysHolidays=" + daysHolidays + ", daysHolidaysQty="
				+ daysHolidaysQty + ", employee=" + employee + "]";
	}
	
}
