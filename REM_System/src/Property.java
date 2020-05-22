import java.sql.*;

//Concrete Product for Factory Pattern
public class Property extends AbstractProperty{
	
	public Property(int id) throws SQLException{
		this.id = id;
		this.type = new String(DatabaseHandler.GetTypeFromID(this.id));
		this.status = new String(DatabaseHandler.GetStatusFromID(this.id));
		this.title = new String(DatabaseHandler.GetTitleFromID(this.id));
		this.address = new String(DatabaseHandler.GetAddressFromID(this.id));
		this.price = new Integer(DatabaseHandler.GetPriceFromID(this.id));		
		this.year = new Integer(DatabaseHandler.GetYearFromID(this.id));
		this.month = new Integer(DatabaseHandler.GetMonthFromID(this.id));
	}
	
	public void setType(String type){
		this.type = type ;
		Notify();
	}
	public void setStatus(String status){
		this.status = status ;
		Notify();
	}
	public void setDate(Long date){
		this.date =  date ;
		
	}
	public void setTitle(String title){
		this.title = title ;
		
	}
	public void setAddress(String address){
		this.address = address ;
		Notify();
	}
	public String getType(){
		return this.type;
	}
	public String getStatus(){
		return this.status;
	}
	public Long getDate(){
		return this.date;
	}
	public String getTitle(){
		return this.title;
	}
	public String getAddress(){
		return this.address;
	}
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		 this.id = id;
	}
	public int getPrice(){
		return this.price;
	}
	public void setPrice(int price){
		 this.price = price;
		 Notify();
	}
	
	public void Accept(Visitor visitor) throws SQLException{
		visitor.Visit(this);
	}
	public int getMonth(){
		return this.month;
	}
	public void setMonth(int month){
		 this.month = month;
	}
	public int getYear(){
		return this.year;
	}
	public void setYear(int year){
		 this.year = year;
	}
}
