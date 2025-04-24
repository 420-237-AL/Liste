public class Pile<ParamType> {
    Vecteur<ParamType> vecteur;

    public Pile() { // Une pile (ou "Stack" en anglais) est une structure de données adaptée d'un vecteur.
        vecteur = new Vecteur<>();
    }

    public int getNbElements() {
        return vecteur.getNbElements();
    }

    public boolean estVide() {
        return vecteur.estVide();
    }

    public void ajouter(ParamType element) { // On ne peut ajouter des données qu'à la fin ("sur le dessus") de la pile.
        vecteur.ajouter(element);
    }

    public ParamType retirer() { // Et on retire toujours le dernier élément de la pile (le plus récent).
        if (estVide())
            return null;

        ParamType val = vecteur.get(vecteur.getNbElements() - 1);
        vecteur.retirer(vecteur.getNbElements() - 1);
        return val;
    }
}
