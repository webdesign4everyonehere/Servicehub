package application;

import java.sql.Date;

public class clientDatabase {
   private String clientNum;
   private String firstName;
   private String lastName;
   private String gender;
   private String email;
   private String tel;
   private String service;
   private String description;
   private Date registration_date;
   
   public clientDatabase(String clientNum,String firstName,String lastName, String gender,String email,String tel,String service,String description,Date registration_date){
	   this.clientNum = clientNum;
	   this.firstName = firstName;
	   this.lastName = lastName;
	   this.gender = gender;
	   this.email = email;
	   this.tel = tel;
	   this.service = service;
	   this.description = description;
	   this.registration_date = registration_date;
	   
   }
   
   public String getClinetNum() {
	   return clientNum;
   }
   
   public String getFirstName() {
	   return firstName;
   }
   
   public String getLastName() {
	   return lastName;
   }
   
   public String getGender() {
	   return gender;
   }
   
   public String getEmail() {
	   return email;
   }
   
   public String getTel() {
	   return tel;
   }
   
   public String getService() {
	   return service;
   }
   
   public String getDescription() {
	   return description;
   }
   
   public Date getRegistration_Date() {
	   return registration_date;
   }
   
   
   
}
