  package ilem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSQL {

    public static User getUser(String username, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = testcon.getmyConnection().prepareStatement(
                "select u.*,r.typerole \n"
                + "from utilisateur u,role r\n"
                + "where (u.idrole=r.idrole)\n"
                + "and username=?\n"
                + "and password=?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet res = ps.executeQuery();
        if (res.next()){
            return new User(res.getLong(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(7));
        }
        return null;
    }
 

  
}
