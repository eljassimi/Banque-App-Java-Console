import Banque.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Compte> comptes = new HashMap<>();

    public static void main(String[] args) {
        int choix;
        do {
            System.out.println("\n=== MENU BANQUE ===");
            System.out.println("1. Créer un compte courant");
            System.out.println("2. Créer un compte épargne");
            System.out.println("3. Verser de l'argent");
            System.out.println("4. Retirer de l'argent");
            System.out.println("5. Effectuer un virement");
            System.out.println("6. Consulter un compte");
            System.out.println("7. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            try {
                switch (choix) {
                    case 1: creerCompteCourant(); break;
                    case 2: creerCompteEpargne(); break;
                    case 3: verser(); break;
                    case 4: retirer(); break;
                    case 5: virement(); break;
                    case 6: consulter(); break;
                }
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }

        } while (choix != 7);

        System.out.println("Merci d'avoir utilisé la banque !");
    }

    static void creerCompteCourant() {
        System.out.print("Solde initial : ");
        float solde = sc.nextFloat();
        System.out.print("Découvert autorisé : ");
        float decouvert = sc.nextFloat();
        Compte c = new CompteCourant(decouvert, solde);
        comptes.put(c.getCode(), c);
        System.out.println("Compte créé : " + c.getCode());
    }

    static void creerCompteEpargne() {
        System.out.print("Solde initial : ");
        float solde = sc.nextFloat();
        System.out.print("Taux d interet (ex 0.05 pour 5%) : ");
        float taux = sc.nextFloat();
        Compte c = new CompteEpargne(taux, solde);
        comptes.put(c.getCode(), c);
        System.out.println("Compte créé : " + c.getCode());
    }

    static void verser() {
        System.out.print("Code compte : ");
        String code = sc.nextLine();
        Compte c = comptes.get(code);
        if (c == null) throw new RuntimeException("Compte introuvable !");
        System.out.print("Montant : ");
        float m = sc.nextFloat(); sc.nextLine();
        System.out.print("Source : ");
        String src = sc.nextLine();
        c.verser(m, src);
        System.out.println("Versement effectué !");
    }

    static void retirer() throws Exception {
        System.out.print("Code compte : ");
        String code = sc.nextLine();
        Compte c = comptes.get(code);
        if (c == null) throw new RuntimeException("Compte introuvable !");
        System.out.print("Montant : ");
        float m = sc.nextFloat(); sc.nextLine();
        c.retirer(m);
        System.out.println("Retrait effectué !");
    }

    static void virement() throws Exception {
        System.out.print("Compte source : ");
        String src = sc.nextLine();
        System.out.print("Compte destination : ");
        String dest = sc.nextLine();
        Compte c1 = comptes.get(src);
        Compte c2 = comptes.get(dest);
        if (c1 == null || c2 == null) throw new RuntimeException("Compte introuvable !");
        System.out.print("Montant : ");
        float m = sc.nextFloat(); sc.nextLine();

        c1.retirer(m);
        c2.verser(m, "Virement de " + src);
        System.out.println("Virement effectué !");
    }

    static void consulter() {
        System.out.print("Code compte : ");
        String code = sc.nextLine();
        Compte c = comptes.get(code);
        if (c == null) throw new RuntimeException("Compte introuvable !");
        c.afficherDetails();
    }
}
