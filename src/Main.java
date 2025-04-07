public class Main {
    public static void main(String[] args) {
        Liste v1 = new Liste();
        System.out.println(v1.getNbElements() + ": " + v1);

        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');
        System.out.println(v1.getNbElements() + ": " + v1);
    }
}
