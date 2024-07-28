package clothingstore.service;

import clothingstore.model.TypeDTO;
import clothingstore.repository.MyEntityManager;
import clothingstore.repository.TypeRepository;
import java.util.List;

public interface TypeService {
    public TypeDTO getTypeById(int id);
    public List<TypeDTO> getAllTypes();
    public void saveType(TypeDTO type);
}
