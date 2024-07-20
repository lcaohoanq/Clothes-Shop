package clothingstore.repository;

import clothingstore.model.TypeDTO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class TypeRepository {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClothesShop");

    /*
    public List<TypeDTO> getAllType() throws SQLException {
        List<TypeDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GET_ALL_TYPE);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int typeid = rs.getInt("id");
                    String name = rs.getString("name");
                    TypeDTO type = new TypeDTO(typeid, name);
                    list.add(type);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
     */

    public List<TypeDTO> getAllType(){
        try{
            return emf.createEntityManager().createQuery("SELECT t FROM TypeDTO t", TypeDTO.class).getResultList();
        }finally {
            emf.close();
        }
    }

    public TypeDTO getTypeById(int id){
        try{
            return emf.createEntityManager().find(TypeDTO.class, id);
        }finally {
            emf.close();
        }
    }

}
