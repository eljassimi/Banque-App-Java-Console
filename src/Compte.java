import java.util.ArrayList;
import java.util.List;

public abstract class Compte {

    protected String code;
    protected double solde;
    protected List<String> listeOperations;

    public Compte(String code, double solde) {
        this.code = code;
        this.solde = solde;
        this.listeOperations = new ArrayList<>();
    }
}
