package Operations;

public class Retrait extends Operation{

    private String destination;

    public Retrait(String destination, float montant) {
        super(montant);
        this.destination = destination;
    }

    @Override
    public void afficheDetails() {
        System.out.println("[Retrait] Montant : " + montant + " | Destination : " + destination + " | Date : " + date);
    }
}
