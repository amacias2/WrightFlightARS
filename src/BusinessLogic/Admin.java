package BusinessLogic;

import Database.AdminDB;
import Database.CustomerDB;

public class Admin extends Customer implements User {
		private  static String  adminPW="Admin123";
	
		

		public Admin(String firstName, String midName, String lastName, String username, String password, String street,
				String state, String country, String email, String securityQ, String securityA, String ssn,
				String zipCode) {
			super(firstName, midName, lastName, username, password, street, state, country, email, securityQ, securityA, ssn,
					zipCode);
			this.firstName = firstName;
			this.midName= midName;
			this.lastName = lastName;
			this.username = username;
			this.password = password;
			this.street = street;
			this.state = state;
			this.country = country;
			this.email = email;
			this.securityQ = securityQ;
			this.securityA = securityA;
			this.ssn = ssn;
			this.zipCode= zipCode;
			}


		public static String getAdminPW() {
			return getAdminPW();
		}


		
		public void createFlight() {
			

		
		

	}

	
	}

