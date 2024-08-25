package clothingstore.services;

import clothingstore.dto.TypeDTO;
import clothingstore.repositories.BaseEntityManager;
import clothingstore.repositories.TypeRepository;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TypeService implements IType {

    private final TypeRepository typeRepository = new TypeRepository(BaseEntityManager.getEntityManagerFactory());

    @Override
    public TypeDTO getTypeById(int id) {
        return typeRepository.getTypeById(id);
    }

    @Override
    public List<TypeDTO> getAllTypes(){
        return typeRepository.getAllTypes();
    }

    @Override
    public void saveType(TypeDTO type) {
        typeRepository.saveType(type);
    }

    public static void main(String[] args) {
        TypeService service = new TypeService();
//        TypeDTO type = service.getTypeById(1);
//        System.out.println(type);

        List<TypeDTO> list = service.getAllTypes();

        for (TypeDTO typeDTO : list) {
            System.out.println(typeDTO);
        }

        TypeDTO newType = new TypeDTO();
        newType.setName("Test Type");
        service.saveType(newType);

        System.out.println("Saved new type: " + newType);
    }

}
