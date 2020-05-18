import java.sql.SQLException;

public abstract class APropertyFactory {
	
	abstract public Property createProperty(int id) throws SQLException;

}
