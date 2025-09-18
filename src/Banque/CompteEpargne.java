package Banque;

import Operations.Retrait;

public class CompteEpargne extends Compte {

    protected float tauxInteret;

    public CompteEpargne(float tauxInteret, float solde) {
        super(solde);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public float calculerInteret(){
        return solde * this.tauxInteret;
    }

    @Override
    public void afficherDetails(){
        System.out.println("=== Compte Epargne ===");
        System.out.println("Code : "+code);
        System.out.println("Solde : "+solde);
        System.out.println("Taux d interet : "+tauxInteret);
        System.out.println("Operations :");
        afficherOperations();
    }

    @Override
    public void retirer(float montant) throws Exception{
        if(montant <= 0) throw new IllegalArgumentException("Montant doit être positif !");
        if(montant > solde){
            throw new Exception("Solde insuffisant !");
        }
        solde -= montant;
        listeOperations.add(new Retrait("Retrait CompteEpargne", montant));
    }
}
