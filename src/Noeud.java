public class Noeud {
    // La classe Noeud n'étant qu'un simple conteneur de données, on peut laisser ses attributs 'public'.
    public char valeur;
    public Noeud suivant; // Chaque noeud contient un pointeur vers le prochain noeud de la liste.

    public Noeud(char valeur) {
        this.valeur = valeur;
        this.suivant = null;
    }

    public Noeud(char valeur, Noeud suivant) {
        this.valeur = valeur;
        this.suivant = suivant;
    }

    @Override
    public String toString() {
        if (suivant != null)
            return String.valueOf(valeur) + " -> " + String.valueOf(suivant.valeur);
        else
            return String.valueOf(valeur);
    }
}
