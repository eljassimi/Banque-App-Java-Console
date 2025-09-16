package Operations;

import java.util.UUID;
import java.time.LocalDate;

public abstract class Operation {
    protected UUID UUID;
    protected LocalDate date;
    protected float montant;


    public Operation(float montant) {
        this.UUID = UUID.randomUUID();
        this.date = LocalDate.now();
        this.montant = montant;
    }

}
