import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import javax.swing.JFrame;

public class Router {
    private Queue<Network> mConnections;
    private Queue<Device> mDevices;
    private int mNumofConnections;
    private Semaphore mSemaphore;
    private OutputForm mOut;
    
    public Router(int numOfconnections) {
        this.mConnections = new LinkedList<>();
        this.mDevices = new LinkedList<>();
        this.mNumofConnections = numOfconnections;
        initializaNetwork();
        this.mSemaphore = new Semaphore (mNumofConnections);
        this.mOut = new OutputForm();
        
    }
    
    public Semaphore getSemaphore(){return this.mSemaphore;}

    public synchronized boolean connectToNetwork(Device CurrentDevice) {
        if (this.mConnections.size() > 0) {
        	CurrentDevice.setConnection(this.mConnections.poll());
            this.mDevices.poll();
            return true;
        }
        return false;
    }

    public synchronized void logOut(Device CurrentDevice) {
        this.mConnections.add(CurrentDevice.getConnection());
        CurrentDevice.setConnection(null);
    }

    public void initializaNetwork() {
        for (int i = 0; i < mNumofConnections; i++) {
            this.mConnections.add(new Network(i));
        }
    }

    public void reserve(Device newDevice) {
        mDevices.add(newDevice);
    }

    public void addDevices(String[] str, String[] type, int size) {
        for (int i = 0; i < size; i++) 
            new Device(str[i], type[i], this, mOut).start();
    }
}