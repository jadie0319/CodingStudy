package examples.MiniWAS;

public class MiniWAS extends Thread{
    public MiniWAS() {

    }
    @Override
    public void run() {
        Connector connector = new Connector(1472);
        connector.run();
    }
}
