//Customer for the system.
public class Customer {
	
	private int id;
	private String name;
	private String desired_type;
	private String desired_status;
	private String desired_address;
	private int desired_price;
	
	public Customer(String name, String desired_type, String desired_status, String desired_address, int desired_price){
		this.name = name;
		this.desired_type = desired_type;
		this.desired_status = desired_status;
		this.desired_address = desired_address;
		this.setDesired_price(desired_price);
		
	}
	public Customer(int id){
		this.setId(id) ;
	}
	
	public String getName(){
		return name;
	}
	public String getDesired_status() {
		return desired_status;
	}
	public void setDesired_status(String desired_status) {
		this.desired_status = desired_status;
	}
	public String getDesired_type() {
		return desired_type;
	}
	public void setDesired_type(String desired_type) {
		this.desired_type = desired_type;
	}
	public String getDesired_address() {
		return desired_address;
	}
	public void setDesired_address(String desired_address) {
		this.desired_address = desired_address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDesired_price() {
		return desired_price;
	}
	public void setDesired_price(int desired_price) {
		this.desired_price = desired_price;
	}
	
}
