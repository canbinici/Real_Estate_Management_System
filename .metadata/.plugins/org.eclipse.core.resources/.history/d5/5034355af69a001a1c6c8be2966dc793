import java.sql.SQLException;
import java.util.ArrayList;

public class SystemHandler {
	//SystemHandler demonstrate the operations between system and customer
	private static DatabaseHandler Database;
	private ArrayList<AbstractProperty> properties = new ArrayList<AbstractProperty>();
	
	public SystemHandler() throws SQLException{
		//DatabaseHandler initializes the Database operations
		setDatabase(new DatabaseHandler());
		
		Agent agent = Agent.get_Agent();
		Customer customer = new Customer("property_observer","house","sale","TURKEY EGE IZMIR BALCOVA TELEFERIK",500000);
		ConcreteObserver o = agent.createObserver(customer);
		
		//ConcreteObserver o = new ConcreteObserver("property_observer","house","sale","TURKEY EGE IZMIR BALCOVA TELEFERIK");
		
		ArrayList<Integer> IDS = GetAllPropertyIDs();
		for(Integer i : IDS){
			APropertyFactory factory = new PropertyFactory();
			properties.add(factory.createProperty(i));
			
		}
		properties.forEach(p-> System.out.println(p.getType() + ", " + p.getStatus()+ ", " + p.getTitle()+ ", " +p.getAddress()+", "+p.getPrice()));
		for(int i=0 ; i<properties.size() ; i++){
			o.setProperty(properties.get(i));
			properties.get(i).Attach(o);
		}
		
		properties.forEach(p-> {
			try {
				refresh(p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Customer customer2 = new Customer(properties.get(0).getID());
		agent.displayInformation(customer2);
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
