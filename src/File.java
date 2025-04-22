public class File <ParamType> {
    Liste<ParamType> liste;

    public File() {
        liste = new Liste<>();
    }

    public void ajouter(ParamType element) {
        liste.ajouter(element);
    }

    public boolean retirer(int index) {
        return liste.retirer(0);
    }
}
