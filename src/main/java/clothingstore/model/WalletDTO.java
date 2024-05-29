package clothingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WalletDTO {

    private int walletID;
    private String userName;
    private double balance;
    
}
