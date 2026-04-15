package maintanence;

public class Bucket {
	String key;
	Object value;
	int ticket;
	String status;
	
	Bucket(String key, Object value){
		this.key = key;
		this.value = value;
		this.status = "Pending";
		
	}
}
