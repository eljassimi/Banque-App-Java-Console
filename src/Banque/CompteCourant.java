package Banque;

import java.lang.*;

public class CompteCourant extends Compte{

    protected float decouvert;

    public CompteCourant(float decouvert, float solde) {
        super(solde);
        this.decouvert = decouvert;
    }

    public float calculerInteret(){
        return 0;
    }

    public  void afficherDetails(){
        System.out.println("Code du compte : "+code);
        System.out.println("Solde du compte : "+solde);
        System.out.println("Decouvert du compte : "+this.decouvert);
        System.out.println("Les Operation d compte : ");
        if (listeOperations.isEmpty()) {
            System.out.println("Aucune opération effectuée.");
        } else {
            for (String operation : listeOperations) {
                System.out.println("- " + operation);
            }
        }
    }

    public  void retirer(float montant) throws Exception{
        if(montant <= solde){
            solde = solde-montant;
            listeOperations.add("Montant retirer de "+montant+" Solde reste est "+solde);
        } else if (montant > solde) {
        if (montant <= solde + this.decouvert) {
            float montantRetirer = montant - solde;
            solde = 0;
            this.decouvert -= montantRetirer;
            listeOperations.add("Montant retire de " + montant +
                    " | Solde restant : " + solde +
                    " | Decouvert restant : " + this.decouvert);
        } else {
            throw new Exception("Solde insuffisant !");
        }
    }

}

}
