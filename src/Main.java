import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and Welcome!");
        System.out.println();
        System.out.println();

        Coordinates deliveryPartner = new Coordinates(12.95, 77.6); //Coordinates of Delivery Partner

        //get all the tests
        FilenameFilter filter = (dir, name) -> name.endsWith(".txt");
        File folder = new File("src/tests");
        File[] listOfFiles = folder.listFiles(filter);

        int c = 0, i = 1;
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            System.out.println("Test Number: " + i++);
            System.out.println();

            //Add all the delivery details
            AddDeliveryDetails aDD = new AddDeliveryDetails();
            List<DeliveryDetails> pickup = new ArrayList<>();
            int expResult = aDD.addDeliveryDetails(pickup, file);

            //calculate Delivery Time
            Delivery del = new Delivery();
            int result = (int) del.startDelivery(pickup, 0.0, deliveryPartner);

            if (expResult == result)
                c++;

            System.out.println();
            System.out.println();
        }

        System.out.printf("Test passed: %d/%d%n", c, listOfFiles.length);
    }
}