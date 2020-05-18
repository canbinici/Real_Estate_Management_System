import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractProperty {

	protected int id;
	protected String type;
	protected String status;
	protected Long date;
	protected String title;
	protected String address;
	
	abstract public String getType();
	abstract public String getStatus();
	abstract public Long getDate();
	abstract public String getTitle();
	abstract public String getAddress();
	abstract public void setType(String type);
	abstract public void setStatus(String status);
	abstract public void setAddress(String address);

	
	protected ArrayList<ConcreteObserver> observers = new ArrayList<ConcreteObserver>();
	
	
	public void Attach(ConcreteObserver observer){
		observers.add(observer);
	}
	public void Detach(ConcreteObserver observer){
		for(int i=0; i< observers.size(); i++){
			if (observers.get(i).getName() == observer.getName()) {
				observers.remove(i);
				return;
			}
		}
	}
	public void Notify(){
		for(int i=0 ; i < observers.size(); i++){
			observers.get(i).Update(this);
		}
	}
	
	
	
}
