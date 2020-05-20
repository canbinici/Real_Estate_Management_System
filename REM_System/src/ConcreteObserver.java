//Concrete Observer for Observer Pattern
public class ConcreteObserver implements Observer {
	
	private AbstractProperty _property;
	private Customer _customer;
	private String _customer_name;
	private int _price;
	private String _type;
	private String _status;
	private String _address;
	private int _desired_price;
	private String _desired_type;
	private String _desired_status;
	private String _desired_address;
	
	//Constructor takes the customer's preferences
	public ConcreteObserver(Customer c){
		_customer = c;
		_customer_name = c.getName();
		_desired_type = c.getDesired_type();
		_desired_status = c.getDesired_status();
		_desired_address = c.getDesired_address();
		_desired_price = c.getDesired_price();
	}
	//This method checks whether customer's preferences are met.
	public void Update(AbstractProperty property){
		_property = property;
		_type = property.getType();
		_status = property.getStatus();
		_address = property.getAddress();
		_price = property.getPrice();
		
		if(_desired_type.equals(_type) && _desired_status.equals(_status) && _desired_address.equals(_address) && _desired_price == _price){
			
				System.out.println("Notified " + _customer_name + ", " + _type + ", " + _status + ", " +_address+ ", " +_price+" for " + property.getID());
				
		}
		else{

			System.out.println("Not matched");
		}
	}
	
	public AbstractProperty getProperty(){
		return _property;
	}
	public void setProperty(AbstractProperty value){
		_property = value;
	}
	public String getName(){
		return _customer_name;
	}
}
