import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private int cost;
    private String origin;
    private String describe;

//    public Product() {
//    }

    public Product(int id, String name, int cost, String origin, String describe) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.origin = origin;
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", origin='" + origin + '\'' +
                ", describe='" + describe + '\'' +
                '}' +"\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
