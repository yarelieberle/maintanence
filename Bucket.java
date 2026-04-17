package maintanence;

public class Bucket {
	String key;
	Object value;
	int ticket;
	boolean status;
	
	Bucket(String key, Object value){
		this.key = key;
		this.value = value;
		this.status = false;
		
	}
}
