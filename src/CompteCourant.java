import java.lang.*;
import java.rmi.server.ExportException;

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
        for(String operation : listeOperations){
            System.out.println(operation);
        }
    }

    public  void retirer(float montant) throws Exception{
        if(montant <= solde){
            solde = solde-montant;
            listeOperations.add("Montant retirer de "+montant+" Solde reste est "+solde);
        }else if(montant > solde){
            if(montant <= solde + this.decouvert) {
                float montantRetirer = montant - solde;
                this.decouvert = this.decouvert - montantRetirer;
                listeOperations.add("Montant retirer de "+montant+" Solde reste est "+solde+" Decouvert est "+this.decouvert);
            }else if (montant > solde + this.decouvert){
                throw new Exception("Solde Insuffusant");
            }
        }
    }

}
