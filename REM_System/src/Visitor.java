import java.sql.SQLException;

public interface Visitor {
	public void Visit(Property property) throws SQLException;
}
