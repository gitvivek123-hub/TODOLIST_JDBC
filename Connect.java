
import java.sql.*;

public class Connect {
    public static void main(String[] args) throws ClassNotFoundException {
     Class.forName("org.postgresql.Driver");
    String url="jdbc:postgresql://localhost:5432/exam";
    String name="postgres";
    String pass="123";

    Connection con;


        try {
            con = DriverManager.getConnection(url, name, pass);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from student");
            while (rs.next()) {
                System.out.println(rs.getString("sid") +"\t"+rs.getString("sname")+"\t"+rs.getString("class"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
