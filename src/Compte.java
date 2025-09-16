import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public abstract class Compte {

    protected String code;
    protected double solde;
    protected List<String> listeOperations;

    public Compte(double solde) {
        this.code = "CTA-"+(int)(Math.random() * 10011);
        this.solde = solde;
        this.listeOperations = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }
    public double getSolde() {
        return solde;
    }
    public List<String> getListeOperations() {
        return listeOperations;
    }

    public abstract void calculerInteret();
    public abstract void afficherDetails();
    public abstract void retirer(float montant);

}
