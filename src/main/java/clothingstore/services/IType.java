package clothingstore.services;

import clothingstore.dto.TypeDTO;
import java.util.List;

public interface IType {
    TypeDTO getTypeById(int id);
    List<TypeDTO> getAllTypes();
    void saveType(TypeDTO type);
}
