import javax.crypto.spec.PSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConnectDB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try {
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Task","postgres","123");
            if(con==null)
            {
                System.out.println("db connection failed");
            }
            int ch;
            int q=0;

            do{
                System.out.println("Wrlcome back to Task manager");
                System.out.println("1.Add task\n 2.remove task\n3.Mark complete\n4.display all tasks\n5.exit");
                System.out.println("enter youer choice\n");
                ch=sc.nextInt();
                switch (ch) {
                    case 1:
                        add(con);
                        display(con);
                        break;
                    case 2:remove(con);
                    display(con);
                    break;
                    case 3:Mark(con);
                    display(con);
                    break;
                    case 4:display(con);
                    break;
                    case 5:q=1;
                    break;
                }

            }while(q==0);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void add(Connection con)
    {   Scanner sc=new Scanner(System.in);
        System.out.println("enter id of task");
        int id=sc.nextInt();
        System.out.println("Enter Task name");
        String name=sc.next();
//        sc.next();
        System.out.println("enter description ");
        String descr=sc.next();
        System.out.println("enter Status");
        boolean status=sc.nextBoolean();
        System.out.println("enter date (dd,mm,yy");
        String date=sc.next();

        try
        {

                    DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

// parse string
            LocalDate localDate = LocalDate.parse(date, formatter);

// convert to SQL Date
            Date sqlDate = Date.valueOf(localDate);
            PreparedStatement ps=con.prepareStatement("insert into task(id,name,descr,status,date) values(?,?,?,?,?)");
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,descr);
            ps.setBoolean(4,status);
            ps.setDate(5,sqlDate);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
   public static void remove(Connection con)
   {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter Task id to delete");
       int id=sc.nextInt();
       String sql="Delete from task where id=?";
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1,id);
           int res=ps.executeUpdate();
           if(res>0){
               System.out.println(" record with id= "+id+"deleted succesfully");
           }
           else
           {
               System.out.println("unable to delete");
           }
           ps.close();

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

   }
   public static void Mark(Connection con)
   {
       Scanner sc=new Scanner(System.in);
       System.out.println("enter task to mark ");
       String name=sc.next();
       System.out.println("enter status");
       boolean b=sc.nextBoolean();
       try
       {
           PreparedStatement s=con.prepareStatement("Update task set status=(?) where name=?");
           s.setBoolean(1,b);
           s.setString(2,name);
           s.executeUpdate();
           s.close();

       }catch (SQLException e)
       {
           System.out.println(e);
       }


    }
   public static void display(Connection con) {
       System.out.println("-------------Task Manager------------------");
       try {
           Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=s.executeQuery("select * from task");
           System.out.println("Id\tname\tdesc\tstatus\tdate\t");
           while(rs.next())
           {
               System.out.println(rs.getInt("id")+"\t"+
                       rs.getString("name")+"\t"+
                       rs.getString("descr")+"\t"+
                       rs.getBoolean("status")+"\t"+
                       rs.getDate("date"));

           }
           rs.close();

       } catch (SQLException e){
           System.out.println(e);
       }
   }
}
