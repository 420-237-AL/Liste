public class Noeud {
    // La classe noeud n'étant qu'une simple conteneur de données, on peut laisser ses attributs 'public'.
    public char valeur;
    public Noeud suivant;

    public Noeud(char valeur) {
        this.valeur = valeur;
        this.suivant = null;
    }
}
