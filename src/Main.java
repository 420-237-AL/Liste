import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Character> example = new ArrayList<>();

        Liste<Integer> v1 = new Liste(); // J'ai gardé le nom "v1" pour pouvoir réutiliser le Main de Vecteur.
        System.out.println(v1.getNbElements() + ": " + v1);

        // Test de ajouter(element) et ajouter(index)
        v1.ajouter((int)'A');
        v1.ajouter((int)'C');
        v1.ajouter((int)'E');
        System.out.println(v1.getNbElements() + ": " + v1);

        // Test de ajouter(index) et getNoeud()
        v1.ajouter((int)'B', 1);
        v1.ajouter((int)'D', 3);
        System.out.println(v1.getNbElements() + ": " + v1);

        // Test de ajouterTout(vecteur)
        Liste<Integer> v2 = new Liste<>();
        v2.ajouter((int)'F');
        v2.ajouter((int)'G');
        v2.ajouter((int)'H');
        System.out.println("v2=" + v2);

        v1.ajouterTout(v2);
        System.out.println(v1.getNbElements() + ": " + v1);

        v1.ajouterTout(v1); // BONUS
        System.out.println(v1.getNbElements() + ": " + v1);

        // Test de trouver(element)
        System.out.print("i= " + v1.trouver((int)'D'));
        System.out.print(", " + v1.trouver((int)'A'));
        System.out.print(", " + v1.trouver((int)'H'));
        System.out.println(", " + v1.trouver((int)'X'));
    }
}
