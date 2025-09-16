package Operations;

import java.util.UUID;
import java.time.LocalDate;

public abstract class Operation {
    protected UUID numero ;
    protected LocalDate date;
    protected float montant;


    public Operation(float montant) {
        this.numero  = UUID.randomUUID();
        this.date = LocalDate.now();
        this.montant = montant;
    }

    public abstract void afficheDetails();

}
