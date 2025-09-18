package Banque;

import Operations.Retrait;

public class CompteCourant extends Compte{

    protected float decouvert;

    public CompteCourant(float decouvert, float solde) {
        super(solde);
        this.decouvert = decouvert;
    }

    @Override
    public float calculerInteret(){
        return 0;
    }

    @Override
    public void afficherDetails(){
        System.out.println("=== Compte Courant ===");
        System.out.println("Code : "+code);
        System.out.println("Solde : "+solde);
        System.out.println("Decouvert : "+decouvert);
        System.out.println("Operations :");
        afficherOperations();
    }

    @Override
    public void retirer(float montant) throws Exception{
        if(montant <= 0) throw new IllegalArgumentException("Montant doit etre positif !");
        if(solde - montant < -decouvert){
            throw new Exception("Solde insuffisant depasse decouvert !");
        }
        solde -= montant;
        listeOperations.add(new Retrait("Retrait CompteCourant", montant));
    }
}
