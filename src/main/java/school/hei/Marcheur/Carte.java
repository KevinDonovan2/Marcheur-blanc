package school.hei.Marcheur;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class Carte {
    private Map<String, Lieu> lieux = new HashMap<>();

    public void ajouterLieu(Lieu lieu) {
        this.lieux.put(lieu.getNom(), lieu);
    }

    public List<Lieu> obtenirCheminsPossibles(String lieu) {
        Lieu lieuObjet = lieux.get(lieu);
        return lieuObjet != null ? lieuObjet.getCheminsConnectes() : Collections.emptyList();
    }
}
