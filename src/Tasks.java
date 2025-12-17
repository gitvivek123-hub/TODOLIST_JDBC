import java.util.Date;

public class Tasks {
    int id;
    String task_name;
    String desc;
    String status;
    Date date;
    public Tasks(int id, String task_name, String desc, String status, Date date)
    {
        this.id=id;
        this.task_name=task_name;
        this.desc=desc;
        this.status=status;
        this.date=date;


    }
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task_name='" + task_name + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}'+'\n';
    }


}
