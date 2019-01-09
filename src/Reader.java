import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
Permet de lire et de parser le fichier
 */
public class Reader {

    private String filename;
    private Map<String, String> map = new HashMap<>();


    Reader(String filename) {

        // On sauvegarde le nom du fichier
        this.filename = filename;
        int[] taille = new int[2];

        // On tente de lire le fichier
        try {
            // On instancie le fichier via la classe native FileReader
            FileReader file = new FileReader(this.filename);
            // On commence à ouvrir le fichier
            BufferedReader buffer = new BufferedReader(file);
            /* On initialise deux variable, une contenant les données à splitter, une autre avec les données splittées.
            Par défaut: la première variable est nulle, on va remplir avec une boucle
             */
            String line = "";
            String[] split;
            // Variable permettant de compter les nombres de ligne et à définir la position actuelle du buffer
            int count = 0;

            do {
                // On met le contenue de la Xème ligne dans la variable
                line = buffer.readLine();

                // On ne veux pas lire la dernière ligne qui est forcément null
                if(line != null) {
                    // On split la ligne par des espaces et on le sauvegarde dans une autre variable
                    split = line.split(" ");

                    // On souhaite savoir si on se trouve à la première ligne
                    if(count == 0) {
                        // Oui ? Alors c'est forcément la taille de la map
                        taille[0] = Integer.parseInt(split[0]);
                        taille[1] = Integer.parseInt(split[1]);


                        System.out.println("Taille détecté : " + split[0]+"x"+split[1]);
                        System.out.println("x = " + taille[0]);
                        System.out.println("y = " + taille[1]);


                     }else {
                        // Non c'est autre chose
                        System.out.println(line);
                        System.out.println(line.indexOf("M"));
                    }

                    // on incrémente
                    count++;
                }

            }while (line != null); // On boucle jusqu'à qu'on rencontre une valeur nulle à la fin.

            // On affiche le nbr total de ligne
            System.out.println("Nombre total de ligne : " + count);

        }catch (IOException io) {
            // On arrive pas à lire le fichier.
            System.out.println("Erreur lors de la lecture du fichier");
        }
    }
}
