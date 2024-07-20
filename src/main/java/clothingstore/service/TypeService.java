package clothingstore.service;

import clothingstore.model.TypeDTO;
import clothingstore.repository.TypeRepository;
import java.util.List;

public class TypeService {
    private TypeRepository tr = new TypeRepository();

    public List<TypeDTO> getAllType(){
        return tr.getAllType();
    }

    public TypeDTO getTypeById(int id){
        return tr.getTypeById(id);
    }

    public static void main(String[] args) {
        TypeService ts = new TypeService();
        System.out.println(ts.getTypeById(1).getName());
    }
}
