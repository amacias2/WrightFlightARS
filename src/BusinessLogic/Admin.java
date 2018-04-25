package BusinessLogic;

import Database.AdminDB;
import Database.UserDB;

public class Admin extends User implements registerAdmin, Login {
		private String adminPW="Admin123";
		private String adminAns;

		
		

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
			this.adminAns= adminAns;		}


		public String getAdminPW() {
			return adminPW;
		}

		public void setAdminPW(String adminPW) {
			this.adminPW = adminPW;
		}

		public String getAdminAns() {
			return adminAns;
		}

		public void setAdminAns(String adminAns) {
			this.adminAns = adminAns;
		}

		public void login(String username, String password) {
				try {
					if(!password.equals(AdminDB.getAdminPW(username))) 
					throw new Exception("Invalid password");
				} catch (Exception e) {
					//gui error dialog box 
				}
			}
		
		public void createFlight() {
			

		
		

	}

	
	}

