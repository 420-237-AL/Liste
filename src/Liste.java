public class Liste {
    private Noeud premier; // Dans une liste, il n'y a pas de tableau, seulement un pointeur vers le premier Noeud.
    private int nbElements; // L'attribut nbElements n'est pas essentiel, mais il demeure utile.

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

    public char get(int index) {
        if (index >= nbElements)
            throw new IndexOutOfBoundsException(); // Nous verrons les Exceptions plus tard dans le cours.
        return getNoeud(index).valeur;
    }

    // Trouve le noeud à "l'index" désiré
    private Noeud getNoeud(int index) {
        if (index < 0)
            return null;

        Noeud courant = premier;
        int i = 0;
        while (courant.suivant != null && i < index) {
            courant = courant.suivant;
            i++;
        }
        return courant; // Note: Si 'index' est plus grand que nbElements, retourne le dernier noeud.
    }

    public void ajouterDebut(char element) { // Cette méthode n'est pas nécessaire, mais elle est super simple.
        premier = new Noeud(element, premier);
        // La ligne ci-dessus est équivalente à:
        // Noeud nouveau = new Noeud(element);
        // nouveau.suivant = premier;
        // premier = nouveau;
        nbElements++;
    }

    public void ajouter(char element) {
        ajouter(element, nbElements); // C'est moins de travail de déléguer à ajouter(element, index) que de tout réécrire.
    }

    public void ajouter(char element, int index) {
        Noeud nouveau = new Noeud(element);
        if (premier == null || index == 0) {
            nouveau.suivant = premier;
            premier = nouveau;
        }
        else {
            // Étape 1: Trouver le noeud précédent celui à l'index recherché.
            Noeud courant = getNoeud(index - 1);

            // Étape 2: Ajouter le nouveau noeud entre le noeud "courant" et le suivant.
            nouveau.suivant = courant.suivant;
            courant.suivant = nouveau;
        }
        nbElements++;
    }

    public void ajouterTout(Liste autre) { // Équivalent à 'LinkedList.addAll(collection)'
        int stop = autre.getNbElements(); // Cette ligne permet d'éviter une boucle infinie si autre == this;
        for (int i = 0; i < stop; i++)
            this.ajouter(autre.get(i));
    }

    // En utilisant seulement des méthodes publiques, on peut réutiliser le même code mais avec un Vecteur en paramètre.
    public void ajouterTout(Vecteur autre) {
        int stop = autre.getNbElements();
        for (int i = 0; i < stop; i++)
            this.ajouter(autre.get(i));
    }

    // On peut reprendre la méthode trouver(element) de la classe Vecteur presque sans changements.
    public int trouver(char element) {
        for (int i = 0; i < nbElements; i++)
            if (get(i) == element) // On utilise get(i) au lieu de tab[i]; En fait le même code marcherait dans Vecteur aussi.
                return i;
        return -1;
    }

    // Cette variante de 'trouver()' est sensiblement plus rapide que la précédente pour obtenir son résultat.
    public int trouverRapide(char element) {
        int i = 0;
        for (Noeud courant = premier; courant != null; courant = courant.suivant) {
            if (courant.valeur == element)
                return i;
            else
                i++;
        }
        return -1;
    }

    public int trouverNbCommuns(Liste autre) { // Ici aussi on pourrait recopier cette méthode avec un paramètre de type Vecteur.
        int communs = 0;
        for (int i = 0; i < autre.getNbElements(); i++)
            if (this.trouver(autre.get(i)) != -1)
                communs++;
        return communs;
    }

    public boolean trouverTout(Liste autre) {
        return (this.trouverNbCommuns(autre) == autre.getNbElements()); // Pas besoin d'un 'if' puisque l'opérateur '==' retourne déjà un booléen.
    }

    public boolean retirer(int index) { // N'est pas exigé dans les notes de cours, mais est plutôt utile.
        if (index >= nbElements)
            return false;

        if (index == 0) {
            premier = premier.suivant;
        }
        else {
            Noeud precedent = getNoeud(index - 1);
            precedent.suivant = precedent.suivant.suivant;
        }
        nbElements--;
        return true;
    }

    public boolean retirer(char element) {
        int index = trouver(element);
        return index != -1 ? retirer(index) : false;
    }

    public boolean retirerTout(Liste autre) {
        boolean reussite = true;
        //for (int i = 0; i < autre.nbElements; i++)
        //    reussite &= retirer(autre.get(i));
        for (Noeud courant = autre.premier; courant != null; courant = courant.suivant)
            reussite &= retirer(courant.valeur);
        return reussite;
    }

    public void retirerTout() { // Équivalent à 'ArrayList.clear()'
        this.premier = null;
        this.nbElements = 0;
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
