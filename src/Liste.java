
public class Liste<NimporteQuoi> {
    private Noeud<NimporteQuoi> premier; // Dans une liste, il n'y a pas de tableau, seulement un pointeur vers le premier Noeud.
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

    public NimporteQuoi get(int index) {
        if (index >= nbElements)
            throw new IndexOutOfBoundsException();
        return getNoeud(index).valeur;
    }

    // Trouve le noeud à "l'index" désiré
    private Noeud<NimporteQuoi> getNoeud(int index) {
        Noeud<NimporteQuoi> courant = premier;
        int i = 0;
        while (courant.suivant != null && i < index) {
            courant = courant.suivant;
            i++;
        }
        return courant; // Note: Si 'index' est plus grand que nbElements, retourne le dernier noeud.
    }

    public void ajouterDebut(NimporteQuoi element) {
        premier = new Noeud<>(element, premier);
        nbElements++;
    }

    public void ajouter(NimporteQuoi element) {
        ajouter(element, nbElements);
    }

    public void ajouter(NimporteQuoi element, int index) {
        Noeud<NimporteQuoi> nouveau = new Noeud<>(element);
        if (premier == null || index == 0) {
            nouveau.suivant = premier;
            premier = nouveau;
        }
        else {
            // Étape 1: Trouver le noeud précédent de celui à l'index cherché
            Noeud<NimporteQuoi> courant = getNoeud(index - 1);
            // Étape 2: Ajouter le nouveau noeud entre le noeud "courant" et le suivant
            nouveau.suivant = courant.suivant;
            courant.suivant = nouveau;
        }
        nbElements++;
    }

    public void ajouterTout(Liste<NimporteQuoi> autre) { // Équivalent à 'ArrayList.addAll(collection)'
        int stop = autre.getNbElements(); // Cette ligne permet d'éviter une boucle infinie si autre == this;
        for (int i = 0; i < stop; i++)
            this.ajouter(autre.get(i));
    }

    /*
    public void ajouterTout(Vecteur autre) { // Équivalent à 'ArrayList.addAll(collection)'
        int stop = autre.getNbElements(); // Cette ligne permet d'éviter une boucle infinie si autre == this;
        for (int i = 0; i < stop; i++)
            this.ajouter(autre.get(i));
    }
    */

    public int trouver(NimporteQuoi element) { // Équivalent à 'ArrayList.indexOf(element)'
        for (int i = 0; i < nbElements; i++)
            if (get(i) == element)
                return i;
        return -1;
    }

    public int trouverRapide(NimporteQuoi element) { // Équivalent à 'ArrayList.indexOf(element)'
        int i = 0;
        for (Noeud courant = premier; courant != null; courant = courant.suivant) {
            if (courant.valeur == element)
                return i;
            else
                i++;
        }
        return -1;
    }

    // Cette "surcharge" de trouverTout() retourne le nombre d'éléments communs entre les vecteurs.
    public int trouverNbCommuns(Liste<NimporteQuoi> autre) { // On ne peut pas l'appeler trouverTout() car seul le type de retour est différent :(
        int communs = 0;
        for (int i = 0; i < autre.getNbElements(); i++)
            if (this.trouver(autre.get(i)) != -1)
                communs++;
        return communs;
    }

    /*
    // Cette "surcharge" de trouverTout() retourne le nombre d'éléments communs entre les vecteurs.
    public int trouverNbCommuns(Vecteur autre) { // On ne peut pas l'appeler trouverTout() car seul le type de retour est différent :(
        int communs = 0;
        for (int i = 0; i < autre.getNbElements(); i++)
            if (this.trouver(autre.get(i)) != -1)
                communs++;
        return communs;
    }
    */

    public boolean trouverTout(Liste<NimporteQuoi> autre) {
        return (this.trouverNbCommuns(autre) == autre.getNbElements()); // Pas besoin d'un 'if' puisque l'opérateur '==' retourne déjà un booléen.
    }

    public String toString() {
        StringBuilder s = new StringBuilder("[");
        if (nbElements > 0) {
            s.append(premier.valeur); // Le premier élément est imprimé séparément pour éviter d'avoir une virgule de trop.
            // On commence ensuite la boucle à partir du deuxième noeud:
            for (Noeud<NimporteQuoi> courant = premier.suivant; courant != null; courant = courant.suivant)
                s.append(", ").append(courant.valeur);
        }
        return s + "]";
    }
}
