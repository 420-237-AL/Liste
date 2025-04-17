public class Liste<ParamType> {
    private Noeud premier; // Dans une liste, il n'y a pas de tableau, seulement un pointeur vers le premier Noeud.
    private int nbElements; // L'attribut nbElements n'est pas essentiel, mais il demeure utile.

    // Lorsqu'une classe est seulement utile comme "partie" d'une autre, on peut la déclarer à l'intérieur de sa parente.
    private class Noeud {
        // La classe Noeud n'étant qu'un simple conteneur de données, on peut laisser ses attributs 'public'.
        public ParamType valeur;
        public Noeud suivant; // Chaque noeud contient un pointeur vers le prochain noeud de la liste.

        public Noeud(ParamType valeur) {
            this.valeur = valeur;
            this.suivant = null;
        }

        public Noeud(ParamType valeur, Noeud suivant) {
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

    public ParamType get(int index) {
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

    public void ajouterDebut(ParamType element) { // Cette méthode n'est pas nécessaire, mais elle est super simple.
        premier = new Noeud(element, premier);
        // La ligne ci-dessus est équivalente à:
        // Noeud nouveau = new Noeud(element);
        // nouveau.suivant = premier;
        // premier = nouveau;
        nbElements++;
    }

    public void ajouter(ParamType element) {
        ajouter(element, nbElements); // C'est moins de travail de déléguer à ajouter(element, index) que de tout réécrire.
    }

    public void ajouter(ParamType element, int index) {
        Noeud nouveau = new Noeud(element);
        if (premier == null || index == 0) {
            nouveau.suivant = premier;
            premier = nouveau;
        }
        else {
            // Étape 1: Trouver le noeud précédent celui à l'index recherché.
            Noeud precedent = getNoeud(index - 1);

            // Étape 2: Ajouter le nouveau noeud entre le noeud précédent l'index cherché et son noeud suivant actuel.
            nouveau.suivant = precedent.suivant;
            precedent.suivant = nouveau;
        }
        nbElements++;
    }

    public void ajouterTout(Liste<ParamType> autre) { // Équivalent à 'LinkedList.addAll(collection)'
        int stop = autre.getNbElements(); // Cette ligne permet d'éviter une boucle infinie si autre == this;
        for (int i = 0; i < stop; i++)
            this.ajouter(autre.get(i));
    }

    // En utilisant seulement des méthodes publiques, on peut réutiliser le même code mais avec un Vecteur en paramètre.
    public void ajouterTout(Vecteur<ParamType> autre) {
        int stop = autre.getNbElements();
        for (int i = 0; i < stop; i++)
            this.ajouter(autre.get(i));
    }

    // On peut reprendre la méthode trouver(element) de la classe Vecteur presque sans changements.
    public int trouver(ParamType element) {
        for (int i = 0; i < nbElements; i++)
            if (get(i) == element) // On utilise get(i) au lieu de tab[i]; En fait le même code marcherait dans Vecteur aussi.
                return i;
        return -1;
    }

    // Cette variante de 'trouver()' est sensiblement plus rapide que la précédente pour obtenir son résultat.
    public int trouverRapide(ParamType element) {
        int i = 0;
        for (Noeud courant = premier; courant != null; courant = courant.suivant) {
            if (courant.valeur == element)
                return i;
            else
                i++;
        }
        return -1;
    }

    public int trouverNbCommuns(Liste<ParamType> autre) { // Ici aussi on pourrait recopier cette méthode avec un paramètre de type Vecteur.
        int communs = 0;
        for (int i = 0; i < autre.getNbElements(); i++)
            if (this.trouver(autre.get(i)) != -1)
                communs++;
        return communs;
    }

    public boolean trouverTout(Liste<ParamType> autre) {
        return (this.trouverNbCommuns(autre) == autre.getNbElements()); // Pas besoin d'un 'if' puisque l'opérateur '==' retourne déjà un booléen.
    }

    public boolean retirer(int index) { // N'est pas exigé dans les notes de cours, mais est plutôt utile.
        if (index >= nbElements)
            return false;

        if (index == 0) {
            // Retirer le premier élément de la liste est super simple:
            premier = premier.suivant;
        }
        else {
            // Dans le cas général, on retire le noeud à l'index cible en liant son noeud précédent à son noeud suivant.
            Noeud precedent = getNoeud(index - 1);
            precedent.suivant = precedent.suivant.suivant;
        }
        nbElements--;
        return true;
    }

    public boolean retirer(ParamType element) {
        int index = trouver(element);
        return index != -1 ? retirer(index) : false;
    }

    public boolean retirerTout(Liste<ParamType> autre) {
        boolean reussite = true;
        // Version 1: On peut reprendre le même code que pour la classe Vecteur, mais c'est un peu inefficace.
        //for (int i = 0; i < autre.nbElements; i++)
        //    reussite &= retirer(autre.get(i));
        // Version 2: On fait une boucle directement sur les noeuds de l'autre Liste, évitant ainsi la double boucle de get().
        for (Noeud courant = autre.premier; courant != null; courant = courant.suivant)
            reussite &= retirer(courant.valeur);
        return reussite;
    }

    public void retirerTout() {
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
