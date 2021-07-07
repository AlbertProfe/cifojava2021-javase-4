package example.boot.dev.employee1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String make;
	private String licensePlate;
	private String engine;
	private double capacity;
	private boolean available;

	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private List<OrderService> orders = new ArrayList<>();
	
	public Vehicle() {}
	
	public Vehicle(String name, String make, String licensePlate, String engine, double capacity, boolean available) {
		super();
		this.name = name;
		this.make = make;
		this.licensePlate = licensePlate;
		this.engine = engine;
		this.capacity = capacity;
		this.available = available;
		
	}

	public void addOrder(OrderService order) {
		this.orders.add(order);
		order.setVehicle(this);
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

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public List<OrderService> getOrders() {
		return orders;
	}

	
}
