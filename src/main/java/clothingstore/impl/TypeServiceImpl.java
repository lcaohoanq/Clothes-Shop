package clothingstore.impl;

import clothingstore.model.TypeDTO;
import clothingstore.repository.MyEntityManager;
import clothingstore.repository.TypeRepository;
import clothingstore.service.TypeService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository = new TypeRepository(MyEntityManager.getEntityManagerFactory());

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
        TypeServiceImpl service = new TypeServiceImpl();
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
