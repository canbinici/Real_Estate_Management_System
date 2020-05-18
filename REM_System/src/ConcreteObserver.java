
public class ConcreteObserver implements Observer {
	
	private AbstractProperty _property;
	private String _observer_name;
	private String _type;
	private String _status;
	private String _address;
	private String _desired_type;
	private String _desired_status;
	private String _desired_address;
	
	
	public ConcreteObserver(String name, String desired_type, String desired_status, String desired_address){
		_observer_name = name;
		_desired_type = desired_type;
		_desired_status = desired_status;
		_desired_address = desired_address;
	}
	
	public void Update(AbstractProperty property){
		_property = property;
		_type = property.getType();
		_status = property.getStatus();
		_address = property.getAddress();
		
		if(_desired_type == _type && _desired_status == _status && _desired_address == _address){
			System.out.println("Notified " + _observer_name + ", " + _type + ", " + _status + ", " +_address);
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
		return _observer_name;
	}
}
