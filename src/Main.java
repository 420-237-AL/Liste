public class Main {
    public static void main(String[] args) {
        Liste v1 = new Liste(); // J'ai gardé le nom "v1" pour pouvoir réutiliser le Main de Vecteur.
        System.out.println(v1.getNbElements() + ": " + v1);

        // Test de ajouter(element) et ajouter(index)
        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');
        System.out.println(v1.getNbElements() + ": " + v1);

        // Test de ajouter(index) et getNoeud()
        v1.ajouter('B', 1);
        v1.ajouter('D', 3);
        System.out.println(v1.getNbElements() + ": " + v1);

        // Test de ajouterTout(vecteur)
        Vecteur v2 = new Vecteur();
        v2.ajouter('F');
        v2.ajouter('G');
        v2.ajouter('H');
        System.out.println("v2=" + v2);

        v1.ajouterTout(v2);
        System.out.println(v1.getNbElements() + ": " + v1);

        v1.ajouterTout(v1); // BONUS
        System.out.println(v1.getNbElements() + ": " + v1);

        // Test de trouver(element)
        System.out.print("i= " + v1.trouver('D'));
        System.out.print(", " + v1.trouver('A'));
        System.out.print(", " + v1.trouver('H'));
        System.out.println(", " + v1.trouver('X'));
    }
}
