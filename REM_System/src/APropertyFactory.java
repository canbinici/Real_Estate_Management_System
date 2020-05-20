import java.sql.SQLException;
//Abstract Factory for Factory Pattern
public abstract class APropertyFactory {
	
	abstract public Property createProperty(int id) throws SQLException;

}
