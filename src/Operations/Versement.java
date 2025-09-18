package Operations;

public class Versement extends Operation{
    private String source;

    public Versement(String source , float montant) {
        super(montant);
        this.source = source;
    }

    @Override
    public void afficheDetails(){
        System.out.println("[Versement] Montant : " + montant + " | Source : " + source + " | Date : " + date);
    }
}
