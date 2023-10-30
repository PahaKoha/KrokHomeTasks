package Task5_Gerasimik_Pavel;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private final String name;
    private final String address;
    private final List<Appliance> productList;

    public Market(String name, String address) {
        this.name = name;
        this.address = address;
        this.productList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Appliance> getProductList() {
        return productList;
    }

    public void addNewProductInList(Appliance appliance) {
        productList.add(appliance);
    }

    public String showProductList() {
        StringBuilder products = new StringBuilder();
        for (Appliance appliance : productList) {
            products.append(appliance.toString()).append("\n");
        }
        return products.toString();
    }
}
