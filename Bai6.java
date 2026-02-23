import java.util.Arrays;
import java.util.Comparator;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}

public class Bai6 {
    public static void main(String[] args) {
        Product[] products = {new Product("Laptop", 1500),new Product("Phone", 800),new Product("Tablet", 600),new Product("Camera", 1200)};

        System.out.println("=== Danh sách ban đầu ===");
        print(products);

        Arrays.sort(products, new Comparator<Product>() {
             //Bắt buộc dùng Anonymous Class thay vì Lambda khi:
             //- Cần khai báo thêm thuộc tính nội bộ (biến instance)
             //- Cần viết nhiều phương thức (interface không phải Functional Interface)
             //- Cần logic phức tạp, nhiều dòng xử lý
             //Lambda KHÔNG cho phép khai báo biến thành viên như bên dưới:
            private int compareCount = 0; // Lambda không thể có biến này

            @Override
            public int compare(Product p1, Product p2) {
                compareCount++;
                return Double.compare(p1.price, p2.price);
            }
        });

        System.out.println("\n=== Sắp xếp theo giá tăng dần ===");
        print(products);

        Arrays.sort(products,(p1, p2) -> p1.name.compareTo(p2.name));

        System.out.println("\n=== Sắp xếp theo tên A-Z ===");
        print(products);
    }

    public static void print(Product[] products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }
}