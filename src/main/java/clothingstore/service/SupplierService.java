package clothingstore.service;

import clothingstore.model.SupplierDTO;
import clothingstore.repository.MyEntityManager;
import clothingstore.repository.SupplierRepository;
import clothingstore.utils.TestOnly;
import java.util.List;

public class SupplierService {

    private final SupplierRepository supplierRepository = new SupplierRepository(MyEntityManager.getEntityManagerFactory());

    public List<SupplierDTO> getData() {
        return supplierRepository.getData();
    }

    public SupplierDTO getSupplierById(int id) {
        return supplierRepository.getSupplierById(id);
    }

    @TestOnly
    public void saveSupplier(SupplierDTO supplier) {
        supplierRepository.saveSupplier(supplier);
    }

}
