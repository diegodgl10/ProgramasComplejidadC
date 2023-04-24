import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Programa2 {
    public static void main(String[] args) {
        List<String> elem = new ArrayList<String>(Arrays.asList("1", "2", "3", "4"));
        List<String> elem2 = new ArrayList<String>(Arrays.asList( "2", "3", "4"));
        Conjunto<String> cjt = new Conjunto<String>("E1", elem);
        Conjunto<String> cjt2 = new Conjunto<String>("E2", elem2);
        System.out.println(cjt.equals(cjt2));
    }
}