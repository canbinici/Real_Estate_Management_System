import java.sql.SQLException;
import java.util.ArrayList;

public class SystemHandler {
	
	private static DatabaseHandler Database;
	private ArrayList<AbstractProperty> properties = new ArrayList<AbstractProperty>();
	
	public SystemHandler() throws SQLException{
		
		setDatabase(new DatabaseHandler());
		
		
		ConcreteObserver o = new ConcreteObserver("property_observer","house","sale","TURKEY EGE IZMIR BALCOVA TELEFERIK");
		
		ArrayList<Integer> IDS = GetAllPropertyIDs();
		for(Integer i : IDS){
			APropertyFactory factory = new PropertyFactory();
			properties.add(factory.createProperty(i));
			
		}
		properties.forEach(p-> System.out.println(p.getType() + ", " + p.getStatus()+ ", " + p.getTitle()+ ", " +p.getAddress()));
		for(int i=0 ; i<properties.size() ; i++){
			o.setProperty(properties.get(i));
			properties.get(i).Attach(o);
		}
		properties.get(0).setType("house");
		properties.get(0).setStatus("sale");
		properties.get(0).setAddress("TURKEY EGE IZMIR BALCOVA TELEFERIK");
		
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
	
	
}
