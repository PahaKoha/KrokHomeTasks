package Task5;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private String name;
    private String address;
    private List<Appliance> productList;

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
        String products = "";
        for (Appliance appliance : productList) {
            products += appliance.toString() + "\n";
        }
        return products;
    }
}
