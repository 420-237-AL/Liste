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

    // Trouve le noeud à "l'index" désiré
    private Noeud getNoeud(int index) {
        Noeud courant = premier;
        int i = 0;
        while (courant.suivant != null && i < index - 1) {
            courant = courant.suivant;
            i++;
        }
        return courant; // Note: Si 'index' est plus grand que nbElements, retourne le dernier noeud.
    }

    public void ajouterDebut(char element) {
        premier = new Noeud(element, premier);
        nbElements++;
    }

    public void ajouter(char element) {
        ajouter(element, nbElements);
    }

    public void ajouter(char element, int index) {
        Noeud nouveau = new Noeud(element);
        if (premier == null)
            premier = nouveau;
        else {
            // Étape 1: Trouver le noeud précédent de celui à l'index cherché
            Noeud courant = getNoeud(index);
            // Étape 2: Ajouter le nouveau noeud entre le noeud "courant" et le suivant
            nouveau.suivant = courant.suivant;
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
