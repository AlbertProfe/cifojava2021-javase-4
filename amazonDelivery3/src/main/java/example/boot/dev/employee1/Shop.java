package example.boot.dev.employee1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String direction;
	private String cif;
	private String timetable;

	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
	private List<OrderService> orders = new ArrayList<>();

	@ManyToMany()
	@JoinTable(name = "SHOP_PRODUCT",
			joinColumns = @JoinColumn(name = "FID_SHOP"),
			inverseJoinColumns = @JoinColumn(name = "FID_PRODUCT")
			)
	private List<Product> products = new ArrayList<Product>();
	
	public Shop() {
		super();
	}

	public Shop(String name, String direction, String cif, String timetable) {
		super();
		this.name = name;
		this.direction = direction;
		this.cif = cif;
		this.timetable = timetable;

	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void addProduct (Product product) {
		this.products.add(product);
		product.getShops().add(this);
	}

	public List<OrderService> getOrders() {
		return orders;
	}

	public void addOrder(OrderService order) {
		this.orders.add(order);
		order.setShop(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getTimetable() {
		return timetable;
	}

	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", direction=" + direction + ", cif=" + cif + ", timetable="
				+ timetable + ", orders=" + orders + "]";
	}

}
