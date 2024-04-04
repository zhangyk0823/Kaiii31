import java.io.BufferedReader;
import java.io.BufferedWriter;  
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    public static final int ID_WIDTH = 13; 
    public static final int ITEM_NAME_WIDTH = 15;
    public static final int QUANTITY_WIDTH = 15; 
    public static final int PRICE_WIDTH = 15;
    public static void main(String[] args)  throws Exception{ 
    String filePath = "D:\\Groceries.txt";
    String fileToWriter = "D:\\GroceriesFormatted.txt";

    String [] array = new String[4];
    int id;
    String itemName;
    String quantity;
    double price;
    String separator = ",";
    double total = 0;

    FileReader fileReader = new FileReader(filePath);
    FileWriter fileWriter = new FileWriter(fileToWriter);
    BufferedReader reader = new BufferedReader(fileReader);
    BufferedWriter writer = new BufferedWriter(fileWriter);

    writer.write( "*******************************************************");
    String heading = formatLine("ID#", ID_WIDTH)
                   + formatLine("Item", ITEM_NAME_WIDTH)
                   + formatLine("Quantity", QUANTITY_WIDTH)
                   + formatLine("Price (€)", PRICE_WIDTH);
    System.out.println(heading); 
    writer.newLine();
    writer.write(heading);
    writer.newLine();
    String line;

    while((line = reader.readLine()) != null){
        array = line.split(separator);

        id = Integer.parseInt(array[0]);

        itemName = array[1];

        quantity = array[2];

        price = Double.parseDouble(array[3]);

        total += price;

        line = formatLine(id, ID_WIDTH)
             + formatLine(itemName, ITEM_NAME_WIDTH)
             + formatLine(quantity, QUANTITY_WIDTH)
             + formatLine(price, PRICE_WIDTH);
       
        System.out.println(line);
        writer.write(line);
        writer.newLine();
       
     
       }

    System.out.println(  "The grocery shopping total is: " + Math.round(total) + "€");
    writer.write( "*******************************************************");
    writer.newLine();
    writer.write( "The grocery shopping total is: " + Math.round(total)+ "€");
    writer.newLine();
    writer.write( "*******************************************************");
    writer.newLine();

    reader.close();

    writer.flush();

    writer.close();}
    private static String formatLine(Object value, int width) {
        return String.format("%1$-" + width + "s", value.toString());
    }

}
