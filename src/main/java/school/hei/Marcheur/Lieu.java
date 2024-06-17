package school.hei.Marcheur;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Lieu {
    private String nom;
    private List<Lieu> cheminsConnectes = new ArrayList<>();

    public Lieu(String nom) {
        this.nom = nom;
    }

    public void ajouterChemin(Lieu autreLieu) {
        this.cheminsConnectes.add(autreLieu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lieu lieu = (Lieu) o;

        return nom != null ? nom.equals(lieu.nom) : lieu.nom == null;
    }

    @Override
    public int hashCode() {
        return nom != null ? nom.hashCode() : 0;
    }
}
