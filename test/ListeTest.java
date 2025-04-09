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
        // Un test unitaire "vide" (ou tout simplement sans assertions) passe toujours,
        // donc il faut toujours s'assurer d'en ajouter au moins une pour qu'il serve à quelque chose.
        assertEquals(3, v1.getNbElements());
        assertEquals("[A, C, E]", v1.toString());
    }
}
