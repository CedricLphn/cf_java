import java.util.Map;
import java.util.Scanner;

public class init {

    private static final String MESSAGE_ACCUEIL = "Bienvenue dans le jeu fou du moment: la FOLIE de la tondeuse !!!";
    private static int[] taille = new int[2];
    private static Map table;


    public static void main(String[] args) {
        Welcome();
        readFile();
        try {
            Tondeuse maTondeuse = new Tondeuse(table);
            maTondeuse.run();
        }catch(Exception e){
            System.out.println("Impossible de démarrer le jeu :(");
        }

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
        table = file.render();
    }

    private static void Welcome() {
        // On affiche le message d'accueil
        System.out.println(
                "  ___ _____ ____ ____ _  _ ___    ____ __   ___ ____ _____ ____ _  _ \n" +
                " / __(  _  (  _ (_  _( \\( / __)  ( ___/__\\ / __(_  _(  _  (  _ ( \\/ )\n" +
                "( (__ )(_)( )(_) _)(_ )  ( (_-.   )__/(__)( (__  )(  )(_)( )   /\\  / \n" +
                " \\___(_____(____(____(_)\\_\\___/  (__(__)(__\\___)(__)(_____(_)\\_)(__) \n" +
                "\n");
        System.out.println(MESSAGE_ACCUEIL);

    }
}
