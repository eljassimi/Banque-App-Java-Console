package Banque;

public class CompteEpargne extends Compte {

    protected float tauxInteret;

    public CompteEpargne(float tauxInteret, float solde) {
        super(solde);
        this.tauxInteret = tauxInteret;
    }

    public float calculerInteret(){
        return solde * this.tauxInteret;
    }

    public  void afficherDetails(){
        System.out.println("Code du compte : "+code);
        System.out.println("Solde du compte : "+solde);
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
        } else {
                throw new Exception("Solde insuffisant !");
            }
    }
}
