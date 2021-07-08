package example.boot.dev.employee1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;
	private int stock;
	private boolean available;
	
	@ManyToMany(mappedBy = "products",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	private List<Shop> shops = new ArrayList<Shop>();
	
	public Product() {};
	
	public Product(String name, double price, int stock, boolean available) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.available = available;
	}
	
	public List<Shop> getShops() {
		return shops;
	}

	public void addShop (Shop shop) {
		this.shops.add(shop);
		shop.getProducts().add(this);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", available="
				+ available + ", shops=" + shops + "]";
	}

	
	
	
	

}
