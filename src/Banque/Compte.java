package Banque;

import Operations.Operation;
import Operations.Versement;
import Utility.Helper;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {

    protected String code;
    protected float solde;
    protected List<Operation> listeOperations;

    public Compte(float solde) {
        this.code = Helper.generateUniqueCode("CPT");
        this.solde = solde;
        this.listeOperations = new ArrayList<>();
    }

    public String getCode() { return code; }
    public float getSolde() { return solde; }

    public void verser(float montant, String source){
        if (montant <= 0) throw new IllegalArgumentException("Montant doit être positif !");
        this.solde += montant;
        Versement v = new Versement(source, montant);
        this.listeOperations.add(v);
    }

    public void afficherOperations(){
        if (listeOperations.isEmpty()) {
            System.out.println("Aucune opération effectuée.");
        } else {
            for (Operation op : listeOperations) {
                op.afficheDetails();
            }
        }
    }

    public abstract float calculerInteret();
    public abstract void afficherDetails();
    public abstract void retirer(float montant) throws Exception;
}