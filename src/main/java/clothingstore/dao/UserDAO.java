package clothingstore.dao;

import clothingstore.constant.DatabaseQueries;
import clothingstore.utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import clothingstore.model.UserDTO;

@Deprecated
public class UserDAO extends DatabaseUtil {

    public List<UserDTO> getData() throws SQLException {
        List<UserDTO> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GET_DATA_USER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String email = rs.getString("email");
                    String avatar = rs.getString("avatar");
                    String userName = rs.getString("userName");
                    String password = rs.getString("password");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    int roleId = rs.getInt("roleId");
                    boolean status = rs.getBoolean("status");
                    users.add(new UserDTO(id, firstName, lastName, email, avatar, userName, password, address, phone, roleId, status));
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
        return users;
    }

    public UserDTO checkLogin(String userName, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.LOGIN);
                ptm.setString(1, userName);
                ptm.setString(2, userName);
                ptm.setString(3, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");                    
                    String userNamee = rs.getString("userName");
                    String avatar = rs.getString("avatar");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    int roleid = rs.getInt("roleID");
                    boolean roleID = rs.getBoolean("roleID");
                    user = new UserDTO(id, firstname, lastname, email, avatar, userNamee, password, address, phone, roleid, roleID);
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
        return user;
    }

    public int getTotalUsers() throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GET_TOTAL_USERS);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    result = rs.getInt("Total");
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
        return result;
    }

    public void updateUser(String firstName, String lastName, String email, String address, String phone, String userName, String avatar, int roleId) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.UPDATE_USER);
                ptm.setString(1, firstName);
                ptm.setString(2, lastName);
                ptm.setString(3, email);
                ptm.setString(4, address);
                ptm.setString(5, phone);
                ptm.setString(6, avatar);
                ptm.setInt(7, roleId);
                ptm.setString(8, userName);
                ptm.executeUpdate();
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
    }

    public boolean updatePasswordUser(UserDTO user, String pass) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.UPDATE_PASSWORD_FOR_USER);
                ptm.setString(1, pass);
                ptm.setString(2, user.getUserName());
                ptm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public UserDTO getUserByName(String userName) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GET_USER_BY_NAME);
                ptm.setString(1, userName);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");
                    String avatar = rs.getString("avatar");
                    String address = rs.getString("address");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    int roleid = rs.getInt("roleID");
                    boolean roleID = rs.getBoolean("roleID");
                    user = new UserDTO(id, firstname, lastname, email, avatar, userName, password, address, phone, roleid, roleID);
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
        return user;
    }

    public UserDTO getUserByEmail(String email) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GET_USER_BY_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstname = rs.getString("firstname");
                    String userName = rs.getString("userName");
                    String lastname = rs.getString("lastname");
                    String avatar = rs.getString("avatar");
                    String address = rs.getString("address");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    int roleid = rs.getInt("roleID");
                    boolean status = rs.getBoolean("status");
                    user = new UserDTO(id, firstname, lastname, email, avatar, userName, password, address, phone, roleid, status);
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
        return user;
    }

    public boolean checkUserNameDuplicate(String username) throws SQLException {
        boolean ok = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.CHECK_USERNAME_DUPLICATE);
                ptm.setString(1, username);
                ptm.setString(2, username);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    ok = true;
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
        return ok;
    }

    public void registerUser(UserDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.REGISTER_USER);
                ptm.setString(1, user.getFirstName());
                ptm.setString(2, user.getLastName());
                ptm.setString(3, user.getEmail());
                ptm.setString(4, user.getAvatar());
                ptm.setString(5, user.getUserName());
                ptm.setString(6, user.getPassword());
                ptm.setString(7, user.getAddress());
                ptm.setString(8, user.getPhone());
                ptm.setInt(9, user.getRoleID());
                ptm.setBoolean(10, user.isStatus());
                ptm.executeUpdate();
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
    }

    public void deleteUser(String uid) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.DELETE_USER);
                ptm.setString(1, uid);
                ptm.executeUpdate();
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
    }

    public static void main(String[] args) throws SQLException {
        UserDAO dao = new UserDAO();
//        UserDTO user = dao.checkLogin("phuuthanh2003", "1231231231");
//        List<UserDTO> list = dao.getData();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getAvatar());
//        }
//        System.out.println(new UserDAO().getPassword("hoang"));
    }
}
