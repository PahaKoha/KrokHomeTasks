package Task11_Gerasimik_Pavel;

import java.util.HashSet;
import java.util.Set;

public class Kitchen {
    private final Set<String> productsWitchNotOnKitchen = new HashSet<>();
    {
        productsWitchNotOnKitchen.add("помидоры");
        productsWitchNotOnKitchen.add("картошка");
        productsWitchNotOnKitchen.add("лёд");
    }

    public Set<String> getProductsWitchNotOnKitchen() {
        return productsWitchNotOnKitchen;
    }
}
