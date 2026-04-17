package maintanence;

public class Bucket {
	String key;
	Object value;
	int ticket;
	boolean status;
	
	Bucket(String key, Object value, boolean status){
		this.key = key;
		this.value = value;
		this.status = false;
		
	}
}
