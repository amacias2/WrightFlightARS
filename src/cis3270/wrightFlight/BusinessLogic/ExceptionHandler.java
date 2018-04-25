
public class ExceptionHandler {
	public static void main(String[] args) {
		try {
			User.register();
		}catch(Exception e) {
			//name or email invalid 
		}
}
