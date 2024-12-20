package application;

public class serviceDatabase {
	
	private String service;
	private String description;
	
	public serviceDatabase(String service, String description) {
		this.service = service;
		this.description = description;
		
	}
	
	public String getService(){
		return service;
	}
	
	public String  getDescription() {
		return description;
	}
	

}
