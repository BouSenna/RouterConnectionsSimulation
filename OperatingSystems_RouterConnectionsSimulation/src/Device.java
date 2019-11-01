import java.util.concurrent.Semaphore;

public class Device extends Thread{
	private String mName;
	private String mType;
	private Network mConnection;
	private Router mRouter;
	
	public Device(String name, String type, Router router) {
		this.mName = name;
		this.mType = type;
		this.mRouter = router;
	}
	
	public void setConnection(Network connection) {this.mConnection = connection;}
	public Network getConnection() {return this.mConnection;}
	
	public void run() {
		this.mRouter.reserve(this);
		System.out.println("(" + mType + ") " + mName + " arrived.");
		
		try {
			this.mRouter.getSemaphore().acquire();
		} catch (InterruptedException exception) {
            System.out.println(exception.toString());
        }
		
		this.mRouter.connectToNetwork(this);           
		System.out.println("Connection " + mConnection.getConnection() + " : " + mName + " occupied");
		delay();
		System.out.println("Connection " + mConnection.getConnection() + " : " + mName + " performs online activity");
		delay();
		System.out.println("Connection " + mConnection.getConnection() + " : " + mName + " log out.");
		mRouter.logOut(this)
		;
		this.mRouter.getSemaphore().release();
	}
	
	public void delay() {
		for (int i=0 ; i < 1000000 ; i++);
	}
}

