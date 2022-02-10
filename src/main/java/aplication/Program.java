package aplication;

import entities.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        String path = "E:\\Pos Java\\in.txt";
        File pathOut = new File(path);
        boolean success = new File(pathOut.getParent() + "\\out").mkdir();
        Product product;
        List<Product> list = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] productIn = line.split(",");
                product = new Product(productIn[0], Double.parseDouble(productIn[1]), Integer.parseInt(productIn[2]));
                line = br.readLine();
                list.add(product);
            }
      
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut.getParent()+"\\Out\\summary.csv")))  {
                for (Product prod : list) {
                bw.write(prod.toString());
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
 
    }

  
}
