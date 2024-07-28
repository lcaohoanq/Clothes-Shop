package clothingstore.impl;

import clothingstore.model.SupplierDTO;
import clothingstore.repository.MyEntityManager;
import clothingstore.repository.SupplierRepository;
import clothingstore.service.SupplierService;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository = new SupplierRepository(MyEntityManager.getEntityManagerFactory());

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
