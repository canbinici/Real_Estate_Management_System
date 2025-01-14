import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;

public class SystemHandler {
	//SystemHandler demonstrate the operations between system and customer..
	private static DatabaseHandler Database;
	private ArrayList<AbstractProperty> properties = new ArrayList<AbstractProperty>();
	
	public SystemHandler() throws SQLException{
		//DatabaseHandler initializes the Database operations..
		setDatabase(new DatabaseHandler());
		
		//After Agent object creation, Customer preferences can direct to the concrete observer to detect whether specific preferences have been..
		Agent agent = Agent.get_Agent();
		Customer customer = new Customer("property_observer","house","sale","TURKEY EGE IZMIR BALCOVA TELEFERIK",500000);
		ConcreteObserver o = agent.createObserver(customer);
		
		Properties properties2 = new Properties();
		
		//ConcreteObserver o = new ConcreteObserver("property_observer","house","sale","TURKEY EGE IZMIR BALCOVA TELEFERIK");
		
		ArrayList<Integer> IDS = GetAllPropertyIDs();
		
		//Factory Pattern enable us to create Property objects upon Property features which are stored in the database..
		for(Integer i : IDS){
			APropertyFactory factory = new PropertyFactory();
			properties.add(factory.createProperty(i));
			properties2.Add(factory.createProperty(i));
		}
		
		// All properties are displayed..
		properties.forEach(p-> System.out.println(p.getType() + ", " + p.getStatus()+ ", " + p.getTitle()+ ", " +p.getAddress()+", "+p.getPrice()));
		
		//Concrete Observer can notify changes in the property setting methods..
		for(int i=0 ; i<properties.size() ; i++){
			o.setProperty(properties.get(i));
			properties.get(i).Attach(o);
		}
		
		
		//In the beginning of the system all features of the properties are supplied from database,
		//so in order to observer detect whether the preferences have already met, all the features are refreshed.
		properties.forEach(p-> {
			try {
				refresh(p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		
		//Customer can give display order upon Agent(Facade) class..
		Customer customer2 = new Customer(properties.get(0).getID());
		agent.displayInformation(customer2);
		
		properties2.Accept(new DateVisitor());
		 
	}
	
	public DatabaseHandler getDatabase(){
		return Database;
	}
	public void setDatabase(DatabaseHandler database){
		Database = database;
	}
	
	public ArrayList<Integer> GetAllPropertyIDs() throws SQLException{
		
		ArrayList<Integer> property_ids = Database.GetAllPropertyIDs();
		
		return property_ids;
	}
	public void refresh(AbstractProperty property) throws SQLException{
		
		property.setType(new String(DatabaseHandler.GetTypeFromID(property.getID())));
		property.setStatus(new String(DatabaseHandler.GetStatusFromID(property.getID())));
		property.setAddress(new String(DatabaseHandler.GetAddressFromID(property.getID())));
		property.setTitle(new String(DatabaseHandler.GetTitleFromID(property.getID())));
		property.setPrice(new Integer(DatabaseHandler.GetPriceFromID(property.getID())));

	}
	
	
}
