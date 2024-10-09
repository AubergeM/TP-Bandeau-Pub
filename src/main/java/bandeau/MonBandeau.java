package bandeau;

public class MonBandeau extends Bandeau{
    private boolean iAmFree = true;
    private static int bandeauCount = 0;
    private final int nb;


    public MonBandeau() {
        nb = ++bandeauCount;
    }

    synchronized public void start() throws InterruptedException{
        while (!iAmFree) {
            wait();
        }
        iAmFree = false;
        System.out.println("Le Bandeau " + nb + "est pris");
    }

    synchronized public void end(){
        iAmFree = true;
        System.out.println("Le Bandeau " + nb + " est disponible");
        notifyAll();
    }
}
