package Banque;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public abstract class Compte {

    protected String code;
    protected float solde;
    protected List<String> listeOperations;

    public Compte(float solde) {
        this.code = "CPT-" + String.format("%05d", (int)(Math.random() * 100000));
        this.solde = solde;
        this.listeOperations = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }
    public float getSolde() {
        return solde;
    }
    public List<String> getListeOperations() {
        return listeOperations;
    }

    public abstract float calculerInteret();
    public abstract void afficherDetails();
    public abstract void retirer(float montant)throws Exception;

}
