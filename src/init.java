import java.util.Scanner;

public class init {
    /*
    Todo:
    - Demander le fichier à la personne
    - Lecture du fichier
    - Boucler le fichier
    - Mettre les coordonées dans une map
    - Executer le mouvement
    - Afficher les coordonnées finales de la tondeuse
     */

    private static String MESSAGE_ACCUEIL = "Bienvenue dans le jeu fou du moment: la FOLIE de la tondeuse !!!";
    private static int[] taille = new int[2];


    public static void main(String[] args) {
        Welcome();
        readFile();
        BouclerLeFichier();
        Execute();

    }

    private static void Execute() {
    }

    private static void BouclerLeFichier() {
        
    }

    private static void readFile() {
        /*
        On initialise un scanner afin de demander le fichier du joueur
         */
        Scanner s = new Scanner(System.in);
        System.out.println("Fichier:");

        String folder = s.nextLine();

        /*
        On instancie la classe Reader et on passe le chemin renseigné de l'utilisateur
         */
        Reader file = new Reader(folder);
        taille = file.getTaille();
    }

    private static void Welcome() {
        // On affiche le message d'accueil
        System.out.println(MESSAGE_ACCUEIL);

    }
}
