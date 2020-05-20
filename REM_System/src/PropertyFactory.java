import java.sql.SQLException;
//Concrete Factory for Factory Pattern
public class PropertyFactory extends APropertyFactory{
	
	public Property createProperty(int id) throws SQLException{
		return new Property(id);
	}
	
	

}
