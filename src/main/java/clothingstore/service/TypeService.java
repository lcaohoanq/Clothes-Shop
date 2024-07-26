package clothingstore.service;

import clothingstore.model.TypeDTO;
import clothingstore.repository.TypeRepository;
import java.lang.reflect.Type;
import java.util.List;

public class TypeService {

    private final TypeRepository typeRepository = new TypeRepository();

    public TypeDTO getTypeById(int id) {
        return typeRepository.getTypeById(id);
    }

    public List<TypeDTO> getAllType(){
        return typeRepository.getAllType();
    }

    public void saveType(TypeDTO type) {
        typeRepository.saveType(type);
    }

    public static void main(String[] args) {
        TypeService service = new TypeService();
//        TypeDTO type = service.getTypeById(1);
//        System.out.println(type);

        List<TypeDTO> list = service.getAllType();

        for (TypeDTO typeDTO : list) {
            System.out.println(typeDTO);
        }

        TypeDTO newType = new TypeDTO();
        newType.setName("Test Type");
        service.saveType(newType);

        System.out.println("Saved new type: " + newType);
    }

}
