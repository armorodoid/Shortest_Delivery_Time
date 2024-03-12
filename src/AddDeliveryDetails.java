import java.io.*;
import java.util.List;
import java.util.Scanner;

public class AddDeliveryDetails {
    public int addDeliveryDetails(List<DeliveryDetails> pickup, File file) {
        int result = 0, i=0;
        try {
            Scanner myReader = new Scanner(file);
            int n = Integer.parseInt(myReader.nextLine());
            while (i<n) {
                i++;
                String str = myReader.nextLine();
                String[] data = str.split(" ");
                pickup.add(new DeliveryDetails(
                        new Coordinates(Double.parseDouble(data[0]),
                        Double.parseDouble(data[1])),
                        new Coordinates(Double.parseDouble(data[2]),
                                Double.parseDouble(data[3])),
                        i, Integer.parseInt(data[4])));
                System.out.println(str);
            }
            result = Integer.parseInt(myReader.nextLine());
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return result;
    }
}
