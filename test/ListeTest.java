import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {
    Liste v1;

    @BeforeEach
    void setUp() {
        // Étape 1: Préparer les données du test
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
        v1.ajouter('B', 1);
        v1.ajouter('D', 3);

        assertEquals(5, v1.getNbElements());
        assertEquals("[A, B, C, D, E]", v1.toString());

        // Il faut aussi penser à tester les cas limites!
        v1.ajouter('^', 0); // Insérer au début de la liste
        v1.ajouter('$', 6); // Insérer à la fin de la liste

        assertEquals(7, v1.getNbElements());
        assertEquals("[^, A, B, C, D, E, $]", v1.toString());
    }

    @Test
    void ajouterListe() {
        // Étape 1: Préparer les données du test
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

    @Test
    void trouverElement() {
        assertEquals(0, v1.trouver('A')); // Trouver le premier élément
        assertEquals(1, v1.trouver('C')); // Trouver un élément au milieu
        assertEquals(2, v1.trouver('E')); // Trouver le dernier élément
        assertEquals(-1, v1.trouver('X')); // Trouver un élément inexistant

        // Variante avec la méthode trouverRapide()
        assertEquals(0, v1.trouverRapide('A')); // Trouver le premier élément
        assertEquals(1, v1.trouverRapide('C')); // Trouver un élément au milieu
        assertEquals(2, v1.trouverRapide('E')); // Trouver le dernier élément
        assertEquals(-1, v1.trouverRapide('X')); // Trouver un élément inexistant
    }

    @Test
    void trouverListe() {
        // Étape 1: Préparer les données du test
        v1 = new Liste(); // Cette fois, on préfère partir d'une nouvelle liste configurée sur mesure.
        v1.ajouter('A');
        v1.ajouter('B');
        v1.ajouter('C');
        v1.ajouter('D');
        v1.ajouter('E');

        Liste v2 = new Liste();
        v2.ajouter('A');
        v2.ajouter('C');
        v2.ajouter('E');

        // Étapes 2 et 3: Valider les résultats attendus vs. obtenus
        assertEquals(3, v1.trouverNbCommuns(v2));
        assertTrue(v1.trouverTout(v2));

        v2.ajouter('X');
        assertEquals(3, v1.trouverNbCommuns(v2));
        assertFalse(v1.trouverTout(v2));
    }
}
