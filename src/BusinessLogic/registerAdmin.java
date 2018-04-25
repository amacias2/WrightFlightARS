package BusinessLogic;
import BusinessLogic.Admin;
import Database.AdminDB;
public interface registerAdmin {
	
	default void registerAdmin(Admin a) {
		try {
			if(!a.getFirstName().matches("\\w*")|| !a.getLastName().matches("\\w*")||!a.getMidName().matches("\\w*"))
				throw new Exception("Please enter a valid name.");
			}catch(Exception e) {
				//send to gui dialog box that prints exception message
			}
			//check for valid email
			try {
			if(!a.getEmail().matches("\\S+?\\w*?@\\D*.\\D{3}"))
				throw new Exception("Please enter a valid email.");
			}catch(Exception e) {
				//send to gui dialog box that prints exception message
			}
			//check for valid ssn
			try {
				if( a.getEmail().matches("\\d{3}\\-?\\d{2}\\-?\\d{4}"))
					throw new Exception("Please enter a valid ssn.");
				}catch(Exception e) {
					//send to gui dialog box that prints exception message
				}
			try {
			if(a.getAdminAns()== a.getAdminPW()) {
				AdminDB.addAdmin(a);
				return;
			}else if(a.getAdminAns() != null ) {
				throw new Exception("Admin password is invalid.");
			}}catch(Exception e) {
				//send to gui dialog box that prints exception message	
				}
			
		}
		}
	


