package bandeau;

public class ExempleAvecThreads{
    public static void main(String[] args) {
        ExempleAvecThreads instance = new ExempleAvecThreads();
        instance.exemple();
    }

    public void exemple() {
        //on crée un scénario 
        Scenario s1 = makeScenario();
        Scenario s2 = makeScenario();

        //on crée un/des bandeau(x)
        MonBandeau b1 = new MonBandeau(); 
        MonBandeau b2 = new MonBandeau(); 
        //Bandeau b3 = new Bandeau(); 

    // Créez des threads pour jouer les scénarios en même temps
        Thread thread1 = new Thread(() -> s1.playOn(b1));
        Thread thread2 = new Thread(() -> s2.playOn(b2));

        // Démarrez les threads
        thread1.start();
        thread2.start();

        /*try {
            // Attendre que tous les threads se terminent
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // On rejoue le scénario sur b1 quand le premier jeu est fini
        s1.playOn(b1);
    }

    private Scenario makeScenario() {
        // On crée un scenario
        Scenario s = new Scenario();
        //on crée les effets du scénario 
        s.addEffect(new RandomEffect("Avec Threads", 700), 1);
        s.addEffect(new TeleType("Je m'affiche caractère par caractère", 100), 1);
        s.addEffect(new Blink("Je clignote 10x", 100), 10);
        s.addEffect(new Zoom("Je zoome", 50), 1);
        s.addEffect(new FontEnumerator(10), 1);
        s.addEffect(new Rainbow("Une jolie fleur !", 30), 1);
        s.addEffect(new Rotate("3 tours à droite", 180, 4000, true), 3);

        return s;
    }
}
