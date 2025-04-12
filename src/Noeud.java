public class Noeud<NimporteQuoi> {
    // La classe Noeud n'étant qu'un simple conteneur de données, on peut laisser ses attributs 'public'.
    public NimporteQuoi valeur;
    public Noeud<NimporteQuoi> suivant; // Chaque noeud contient un pointeur vers le prochain noeud de la liste.

    public Noeud(NimporteQuoi valeur) {
        this.valeur = valeur;
        this.suivant = null;
    }

    public Noeud(NimporteQuoi valeur, Noeud<NimporteQuoi> suivant) {
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
