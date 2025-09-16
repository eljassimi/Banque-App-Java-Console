package Operations;

public class Retrait extends Operation{

    protected String destination;

    public Retrait(String destination, float montant) {
        super(montant);
        this.destination = destination;
    }

    @Override
    public void afficheDetails() {
        System.out.println("Montant Retrait de " + montant + " |  destination : " +  this.destination);
    }
}
