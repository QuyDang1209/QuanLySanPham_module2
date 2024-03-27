import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProduct implements Serializable {
    private List<Product> products;


    public ManageProduct() {
        products = new ArrayList<>();
    }

    public static void writeFile(List<Product> products){
        File file = new File("listproduct.txt");
        try {
            OutputStream opt = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(opt);
            outputStream.writeObject(products);
            outputStream.close();
            opt.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void addProduct(List<Product> products){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Cost: ");
        int cost = Integer.parseInt(scanner.nextLine());
        System.out.print("Origin: ");
        String origin = scanner.nextLine();
        System.out.print("Describe: ");
        String describe = scanner.nextLine();
        products.add(new Product(id,name,cost,origin,describe));
    }
    public static List<Product> readFile(){
        File file = new File("listproduct.txt");
        try {
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream ipt = new ObjectInputStream(inputStream);
            Object object = ipt.readObject();
            return (List<Product>) object;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
