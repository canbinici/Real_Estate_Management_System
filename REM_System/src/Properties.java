import java.sql.SQLException;
import java.util.ArrayList;

public class Properties {
	public void Add(Property property){
		properties.add(property);
	}
	public void Remove(Property property){
		for(int i = 0 ; i<properties.size() ; i++){
			if(properties.get(i).getID() == property.getID()){
				properties.remove(i);
				return;
			}
		}
	}
	public void Accept(Visitor visitor) throws SQLException{
		
		for(int i = 0; i< properties.size(); i++){
			properties.get(i).Accept(visitor);
		}
	}
	
	
	private ArrayList<Property> properties = new ArrayList<Property>();
}
