import java.sql.SQLException;
//One of the subsystem class for Facade Pattern
public class Information {
	
	private int _id;

	
	public Information(Customer c){
		this._id = c.getId();
	}
	
	public void searchProperty(int id) throws SQLException{
		System.out.println(id +", " + DatabaseHandler.GetTypeFromID(this._id) + ", " 
				+ DatabaseHandler.GetStatusFromID(this._id)+ ", " 
					+ DatabaseHandler.GetTitleFromID(this._id)+ ", " 
						+ DatabaseHandler.GetAddressFromID(this._id)+ ", "
							+ DatabaseHandler.GetPriceFromID(this._id));
	}

}
