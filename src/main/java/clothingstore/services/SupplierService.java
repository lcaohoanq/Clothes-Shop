package clothingstore.service;

import clothingstore.model.SupplierDTO;
import clothingstore.utils.TestOnly;
import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getData();
    SupplierDTO getSupplierById(int id);
    @TestOnly
    void saveSupplier(SupplierDTO supplier);

}
