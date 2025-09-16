package Operations;

import java.util.Date;
import java.util.UUID;

public abstract class Operation {
    private UUID UUID;
    private Date date;
    private float montant;


    public Operation(String UUID, float montant) {
        this.UUID = UUID.randomUUID();
        this.date = LocalDate.now();
        this.montant = montant;
    }

}
