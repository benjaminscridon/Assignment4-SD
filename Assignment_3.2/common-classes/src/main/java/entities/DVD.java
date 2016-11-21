package entities;
import java.io.Serializable;

/**
 * 
 * @author Beniamin Scridon
 * @since 11/21/2016
 */
public class DVD implements Serializable{
	private static final long serialVersionUID = 1L;

	private String title;
	private int year;
	private double price;
	
	public DVD() {
	}

	public DVD(String title, int year, double price) {
		this.title = title;
		this.year = year;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "DVD [title=" + title + ", year=" + year + ", price=" + price + "]";
	}
}
