import java.sql.SQLException;

public interface Element {
	public void Accept(Visitor visitor) throws SQLException;
}
