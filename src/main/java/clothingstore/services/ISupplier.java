package clothingstore.services;

import clothingstore.dto.SupplierDTO;
import clothingstore.utils.TestOnly;
import java.util.List;

public interface ISupplier {
    List<SupplierDTO> getData();
    SupplierDTO getSupplierById(int id);
    @TestOnly
    void saveSupplier(SupplierDTO supplier);

}
