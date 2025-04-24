public class File <ParamType> {
    Liste<ParamType> liste;

    public File() { // Une "file" (ou Queue en anglais) est une structure adaptée d'une liste (typiquement).
        liste = new Liste<>();
    }

    public int getNbElements() {
        return liste.getNbElements();
    }

    public boolean estVide() {
        return liste.estVide();
    }

    public void ajouter(ParamType element) { // On ne peut ajouter des données qu'à la fin de la file.
        liste.ajouter(element);
    }

    public boolean retirer(int index) { // Et on retire toujours le premier élément de la file (le plus ancien).
        return liste.retirer(0);
    }
}
