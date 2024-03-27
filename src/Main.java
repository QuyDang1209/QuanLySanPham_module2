import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> list = ManageProduct.readFile();
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean check = true;
        while (check) {
            System.out.println("Nhập tác vụ muốn chon");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm ");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Sửa sản phẩm");
            System.out.println("0. Thoát");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    showProducts(list);
                    break;
                case 2:
                    ManageProduct.addProduct(list);
                    ManageProduct.writeFile(list);
                    break;
                case 3:
                    searchProducts(list);
                    break;
                case 4:
                    deleteProducts(list);
                    break;
                case 5:
                    changeProducts(list);
                    break;
                case 0:
                    check = false;
                    break;
            }
        }

    }

    private static void showProducts(List<Product> list) {
        for (Product p : list) {
            System.out.println(p);
        }
    }

    private static void searchProducts(List<Product> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập sản phẩm muốn tìm");
        String kw = scanner.nextLine();
        List<Product> resuls = new ArrayList<>();
        for (Product p : list) {
            if (p.getName().equals(kw)) {
                resuls.add(p);
            }
        }
        if (resuls.size() == 0) {
            System.out.println("Không tìm thấy sản phẩm" + "\n");
        } else {
            showProducts(resuls);
        }
    }
    private static void deleteProducts(List<Product> products){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập sản phẩm muốn xóa");
        String deleteName = scanner.nextLine();
        for(Product p : products){
            if(p.getName().equals(deleteName)){
                products.remove(p);
                break;
            }
        }
    }
    private static void changeProducts(List<Product> products){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm muốn sửa");
        String changename = scanner.nextLine();
        for(Product p : products){
            if (p.getName().equals(changename)){
                System.out.println("ID mới của "+p.getName());
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Name mới của "+p.getName());
                String name = scanner.nextLine();
                System.out.println("Cost mới của "+p.getName());
                int cost = Integer.parseInt(scanner.nextLine());
                System.out.println("Origin mới của "+p.getName());
                String origin = scanner.nextLine();
                System.out.println("Describe mới của "+p.getName());
                String describe = scanner.nextLine();
                p.setId(id);
                p.setName(name);
                p.setCost(cost);
                p.setOrigin(origin);
                p.setDescribe(describe);
                break;
            }

        }
        showProducts(products);
    }
}
