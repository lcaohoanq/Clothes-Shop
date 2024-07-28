package clothingstore.service;

import clothingstore.model.TypeDTO;
import java.util.List;

public interface TypeService {
    TypeDTO getTypeById(int id);
    List<TypeDTO> getAllTypes();
    void saveType(TypeDTO type);
}
