package clothingstore.services;

import clothingstore.dto.SupplierDTO;
import clothingstore.repositories.BaseEntityManager;
import clothingstore.repositories.SupplierRepository;
import java.util.List;

public class SupplierService implements ISupplier {

    private final SupplierRepository supplierRepository = new SupplierRepository(BaseEntityManager.getEntityManagerFactory());

    @Override
    public List<SupplierDTO> getData() {
        return supplierRepository.getData();
    }

    @Override
    public SupplierDTO getSupplierById(int id) {
        return supplierRepository.getSupplierById(id);
    }

    @Override
    public void saveSupplier(SupplierDTO supplier) {
        supplierRepository.saveSupplier(supplier);
    }

}
