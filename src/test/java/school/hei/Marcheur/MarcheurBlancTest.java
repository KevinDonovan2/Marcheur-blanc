package school.hei.Marcheur;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MarcheurBlancTest {

    @Test
    public void testMarcheAleatoire() {
        Carte carte = new Carte();

        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu balancoire = new Lieu("Balançoire");
        Lieu esti = new Lieu("ESTI");
        Lieu nexta = new Lieu("Nexta");
        Lieu boulevard = new Lieu("Boulevard");

        hei.ajouterChemin(pullman);
        hei.ajouterChemin(balancoire);

        pullman.ajouterChemin(hei);
        pullman.ajouterChemin(nexta);
        pullman.ajouterChemin(balancoire);

        balancoire.ajouterChemin(hei);
        balancoire.ajouterChemin(pullman);
        balancoire.ajouterChemin(boulevard);
        balancoire.ajouterChemin(esti);

        nexta.ajouterChemin(pullman);

        boulevard.ajouterChemin(balancoire);

        esti.ajouterChemin(balancoire);

        carte.ajouterLieu(hei);
        carte.ajouterLieu(pullman);
        carte.ajouterLieu(balancoire);
        carte.ajouterLieu(esti);
        carte.ajouterLieu(nexta);
        carte.ajouterLieu(boulevard);

        Marcheur marcheur = new Marcheur(hei, esti, carte);
        List<Lieu> marche = marcheur.marcherVers();

        assertEquals(hei, marche.get(0));
        assertEquals(esti, marche.get(marche.size() - 1));

        for (int i = 0; i < marche.size() - 1; i++) {
            Lieu actuel = marche.get(i);
            Lieu suivant = marche.get(i + 1);
            assertTrue(actuel.getCheminsConnectes().contains(suivant));
        }

        marche.forEach(lieu -> System.out.print(lieu.getNom() + " -> "));
        System.out.println("FIN");
    }
}
