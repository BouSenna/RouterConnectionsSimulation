
public class Main {
    public static void main(String[] args){
		int numOfConnections = 2;
		Router router = new Router (numOfConnections);
		
		String [] str = new String [3];
		String [] type = new String [3];
		str[0] = "x";
		type[0] = "mobile";
		str[1] = "y";
		type[1] = "laptop";
		str[2] = "z";
		type[2] = "pc";
		router.addDevices(str, type, 3) ;
    }
}
