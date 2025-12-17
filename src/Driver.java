import java.util.*;
import java.text.SimpleDateFormat;

public class Driver {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Tasks> task = new ArrayList<>(List.of(
                new Tasks(1, "Complete_project", "cli_bank", "not done", sdf.parse("03/11/2025")),
                new Tasks(2, "go to mandir", "cli_bank", "not done", sdf.parse("03/11/2025"))
        ));

        System.out.println(task);
    }
}
