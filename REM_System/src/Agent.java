import java.sql.SQLException;
//Facade for the Facade Pattern
public class Agent {
	
	private static Agent instance = null;
	
	private Agent(){
		
	}
	public static Agent get_Agent(){
		if(instance==null){
			instance = new Agent();
		}
		return instance;
	}
	//Create Concrete Observer object
	public ConcreteObserver createObserver(Customer c){
		
			return new ConcreteObserver(c);
	}
	//Displays information for Property
	public void displayInformation(Customer c) throws SQLException{
			
			Information i = new Information(c);
			i.searchProperty(c.getId());
	}

}
