import java.sql.*;

public class Property extends AbstractProperty{
	
	public Property(int id) throws SQLException{
		this.id = id;
		setType(new String(DatabaseHandler.GetTypeFromID(this.id)));
		setStatus(new String(DatabaseHandler.GetStatusFromID(this.id)));
		//setDate(new Long(DatabaseHandler.GetDateFromID(this.id)));
		setTitle(new String(DatabaseHandler.GetTitleFromID(this.id)));
		setAddress(new String(DatabaseHandler.GetAddressFromID(this.id)));
		
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


}
