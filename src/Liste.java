public class Liste {
    private Noeud premier; // Dans une liste, il n'y a pas de tableau, seulement un pointeur vers le premier Noeud.
    private int nbElements;

    public Liste() {
        this.premier = null;
        this.nbElements = 0;
    }

    public int getNbElements() { // Équivalent à 'LinkedList.size()'
        return nbElements;
    }

    public boolean estVide() { // Équivalent à 'LinkedList.isEmpty()'
        return nbElements == 0;
    }

    public void ajouterDebut(char element) {
        premier = new Noeud(element, premier);
        nbElements++;
    }

    public void ajouter(char element) {
        Noeud nouveau = new Noeud(element);
        if (premier == null)
            premier = nouveau;
        else {
            Noeud courant = premier;
            while (courant.suivant != null)
                courant = courant.suivant;
            courant.suivant = nouveau;
        }
        nbElements++;
    }

    public String toString() {
        StringBuilder s = new StringBuilder("[");
        if (nbElements > 0) {
            s.append(premier.valeur); // Le premier élément est imprimé séparément pour éviter d'avoir une virgule de trop.
            // On commence ensuite la boucle à partir du deuxième noeud:
            for (Noeud courant = premier.suivant; courant != null; courant = courant.suivant)
                s.append(", ").append(courant.valeur);
        }
        return s + "]";
    }
}
