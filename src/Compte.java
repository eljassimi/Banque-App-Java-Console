import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public abstract class Compte {

    protected String code;
    protected float solde;
    protected List<String> listeOperations;

    public Compte(float solde) {
        this.code = "CTA-"+(int)(Math.random() * 10001);
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
    public abstract void retirer(float montant)throws Exception;

}
