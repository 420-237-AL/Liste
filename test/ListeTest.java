import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {
    Liste v1;

    @BeforeEach
    void setUp() { //
        v1 = new Liste();
        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');
    }

    @Test
    void getIndex() {
        assertEquals('A', v1.get(0)); // Trouver le premier élément
        assertEquals('C', v1.get(1)); // Trouver un élément au milieu
        assertEquals('E', v1.get(2)); // Trouver le dernier élément

        // Comment tester qu'une Exception est lancée lorsqu'on accède à un index invalide?
        assertThrows(IndexOutOfBoundsException.class, () -> v1.get(3)); // Trouver un élément inexistant
    }

    @Test
    void ajouterElement() {
        assertEquals(3, v1.getNbElements());
        assertEquals("[A, C, E]", v1.toString());
    }

    @Test
    void ajouterIndex() {
        // Étape 2: Utiliser la ou les méthodes à tester
        v1.ajouter('B', 1);
        v1.ajouter('D', 3);

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(5, v1.getNbElements());
        assertEquals("[A, B, C, D, E]", v1.toString());

        v1.ajouter('0', 0);
        v1.ajouter('6', 6);

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(7, v1.getNbElements());
        assertEquals("[0, A, B, C, D, E, 6]", v1.toString());
    }

    @Test
    void ajouterListe() {
        // Étape 1: Préparer les données du test
        // Pas besoin de préparer une tonne de données, souvent quelques-unes suffisent.
        Liste v2 = new Liste();
        v2.ajouter('F');
        v2.ajouter('G');
        v2.ajouter('H');

        // Étape 2: Utiliser la ou les méthodes à tester
        v1.ajouterTout(v2);

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(6, v1.getNbElements());
        assertEquals("[A, C, E, F, G, H]", v1.toString());
    }

    @Test
    void ajouterVecteur() {
        // Étape 1: Préparer les données du test
        // Pas besoin de préparer une tonne de données, souvent quelques-unes suffisent.
        Vecteur v2 = new Vecteur();
        v2.ajouter('F');
        v2.ajouter('G');
        v2.ajouter('H');

        // Étape 2: Utiliser la ou les méthodes à tester
        v1.ajouterTout(v2);

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(6, v1.getNbElements());
        assertEquals("[A, C, E, F, G, H]", v1.toString());
    }
}
