package example.boot.dev.employee1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table	
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String family;
	private int hours;
	private int level;
	private boolean active;
		
	@ManyToMany(mappedBy = "courses",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	private List<Employee> employees = new ArrayList<Employee>();
	
	
	public Course() {
		super();
	}
	
	public Course(String name, String family, int hours, int level, boolean active) {
		super();
		this.name = name;
		this.family = family;
		this.hours = hours;
		this.level = level;
		this.active = active;
	}
	
	public void addEmployee (Employee employee) {
		employees.add(employee);
		employee.getCourses().add(this);
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", family=" + family + ", hours=" + hours + ", level=" + level
				+ ", active=" + active + "]";
	}

	
}
