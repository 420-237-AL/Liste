public class Noeud {
    // La classe noeud n'étant qu'une simple conteneur de données, on peut laisser ses attributs 'public'.
    public char valeur;
    public Noeud suivant; // Chaque noeud contient un pointeur vers le prochain noeud de la liste.

    public Noeud(char valeur) {
        this.valeur = valeur;
        this.suivant = null;
    }
}
