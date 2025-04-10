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
    void ajouterElement() {
        assertEquals(3, v1.getNbElements());
        assertEquals("[A, C, E]", v1.toString());
    }

    @Test
    void ajouterIndex() {
        // Étape 1: Préparer les données du test
        // Ici, on se fie sur la méthode setUp() pour mettre les 3 premiers éléments dans v1.

        // Étape 2: Utiliser la ou les méthodes à tester
        v1.ajouter('B', 1);
        v1.ajouter('D', 3);

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(5, v1.getNbElements());
        assertEquals("[A, B, C, D, E]", v1.toString());
    }
}
