package BusinessLogic;

import Database.UserDB;

public interface registerUser {
	default void registerUser(User a) {
		try {
			if(!a.getFirstName().matches("\\w*")|| !a.getLastName().matches("\\w*")||!a.getMidName().matches("\\w*"))
				throw new Exception("Please enter a valid name.");
			}catch(Exception e) {
				//send to gui dialog box that prints exception message
			}
			//check for valid email
			try {
			if(!a.email.matches("\\S+?\\w*?@\\D*.\\D{3}"))
				throw new Exception("Please enter a valid email.");
			}catch(Exception e) {
				//send to gui dialog box that prints exception message
			}
			//check for valid ssn
			try {
				if( a.email.matches("\\d{3}\\-?\\d{2}\\-?\\d{4}"))
					throw new Exception("Please enter a valid ssn.");
				}catch(Exception e) {
					//send to gui dialog box that prints exception message
				}
			try {
			}
			catch(Exception e) {
				//send to gui dialog box that prints exception message	
				}
			
		
		}


}

