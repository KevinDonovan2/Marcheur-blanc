package school.hei.Marcheur;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class Marcheur {
    private Lieu lieuDepart;
    private Lieu lieuArrive;
    private Carte carte;

    public Marcheur(Lieu lieuDepart, Lieu lieuArrive, Carte carte) {
        this.lieuDepart = lieuDepart;
        this.lieuArrive = lieuArrive;
        this.carte = carte;
    }

    public List<Lieu> marcherVers() {
        List<Lieu> parcours = new ArrayList<>();
        Set<Lieu> visites = new HashSet<>();
        Random random = new Random();
        Lieu actuel = lieuDepart;

        while (!actuel.equals(lieuArrive)) {
            parcours.add(actuel);
            visites.add(actuel);

            List<Lieu> voisinsNonVisites = new ArrayList<>();
            for (Lieu voisin : actuel.getCheminsConnectes()) {
                if (!visites.contains(voisin)) {
                    voisinsNonVisites.add(voisin);
                }
            }

            if (voisinsNonVisites.isEmpty()) {
                voisinsNonVisites = new ArrayList<>(actuel.getCheminsConnectes());
            }

            actuel = voisinsNonVisites.get(random.nextInt(voisinsNonVisites.size()));
        }

        parcours.add(lieuArrive);
        return parcours;
    }
}
