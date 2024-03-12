import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Double time = 0.0;
    public static void main(String[] args) {

        System.out.println("Hello and Welcome!");
        Coordinates deliveryPartner = new Coordinates(12.95,77.6);
        List<DeliveryDetails> pickup = new ArrayList<>();

        FilenameFilter filter = (dir, name) -> name.endsWith(".txt");
        File folder = new File("src/tests");
        File[] listOfFiles = folder.listFiles(filter);
        int c=0;
        assert listOfFiles != null;
        for (File file: listOfFiles) {
            System.out.println(file);

            AddDeliveryDetails aDD = new AddDeliveryDetails();
            int expResult = aDD.addDeliveryDetails(pickup, file);

            Delivery del = new Delivery();
            int result = (int) del.startDelivery(pickup, time, deliveryPartner);

            if (expResult == result)
                c++;

            System.out.println();
            System.out.println();
        }

        System.out.printf("Test passed: %d/%d%n", c, listOfFiles.length);
    }
}