import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("===== MENU BANQUE =====");
            System.out.println("1. Creer un compte");
            System.out.println("2. Effectuer un versement");
            System.out.println("3. Effectuer un retrait");
            System.out.println("4. Effectuer un virement");
            System.out.println("5. Consulter le solde");
            System.out.println("6. Consulter la liste des operations");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Creation d'un compte...");

                    break;
                default:
                    System.out.println("Choix invalide, veuillez reessayer.");
            }
        } while (choix != 0);

        scanner.close();
    }
}