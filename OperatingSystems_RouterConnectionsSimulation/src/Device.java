import java.util.concurrent.Semaphore;

public class Device extends Thread{
	private String mName;
	private String mType;
	private Network mConnection;
	private Router mRouter;
	private OutputForm mOut;
	
	public Device(String name, String type, Router router, OutputForm out) {
		this.mName = name;
		this.mType = type;
		this.mRouter = router;
		this.mOut = out;
	}
	
	public void setConnection(Network connection) {this.mConnection = connection;}
	public Network getConnection() {return this.mConnection;}
	
	public void run() {
		this.mRouter.reserve(this);
		System.out.println("[" + mType + "] " + mName + " arrived.");
		this.mOut.addUpdates("[" + mType + "] " + mName + " arrived."+"\n");
		try {
			this.mRouter.getSemaphore().acquire();
		} catch (InterruptedException exception) {
            System.out.println(exception.toString());
        }
		
		this.mRouter.connectToNetwork(this);           
		System.out.println("Connection " + mConnection.getConnection() + " : " + mName + " occupied");
		this.mOut.addUpdates("Connection " + mConnection.getConnection() + " : " + mName + " occupied"+"\n");
		delay();
		System.out.println("Connection " + mConnection.getConnection() + " : " + mName + " performs online activity");
		this.mOut.addUpdates("Connection " + mConnection.getConnection() + " : " + mName + " performs online activity"+"\n");
		delay();
		System.out.println("Connection " + mConnection.getConnection() + " : " + mName + " log out.");
		this.mOut.addUpdates("Connection " + mConnection.getConnection() + " : " + mName + " log out."+"\n");
		mRouter.logOut(this);
		this.mRouter.getSemaphore().release();
	}
	
	public void delay() {
		for (int i=0 ; i < 1000000 ; i++);
	}
}

