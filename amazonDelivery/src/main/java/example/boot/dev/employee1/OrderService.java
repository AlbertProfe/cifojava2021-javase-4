package example.boot.dev.employee1;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class OrderService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
	private int qty;
	private String deliveryType;
	private boolean done;
	
	@ManyToOne
	@JoinColumn(name = "FID_SHOP")
	private Shop shop;
	
	
	@ManyToOne
	@JoinColumn(name = "FID_EMPLOYEE")
	private Employee employee;
	
	public OrderService() {
		super();
	}


	public OrderService(Date date, int qty, String deliveryType, boolean done) {
		super();
		this.date = date;
		this.qty = qty;
		this.deliveryType = deliveryType;
		this.done = done;
		
	}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public String getDeliveryType() {
		return deliveryType;
	}


	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}


	public boolean isDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}


	public Shop getShop() {
		return shop;
	}


	public void setShop(Shop shop) {
		this.shop = shop;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", qty=" + qty + ", deliveryType=" + deliveryType + ", done="
				+ done + ", shop=" + shop + ", employee=" + employee + "]";
	}

	
	
}
