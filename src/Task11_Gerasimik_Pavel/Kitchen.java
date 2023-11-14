package Task11_Gerasimik_Pavel;

import java.util.HashSet;
import java.util.Set;

public class Kitchen {
    private final Set<String> productsOnKitchen = new HashSet<>();

    {
        productsOnKitchen.add("помидоры");
        productsOnKitchen.add("картошка");
        productsOnKitchen.add("вода");
        productsOnKitchen.add("рис");
        productsOnKitchen.add("укроп");
        productsOnKitchen.add("чеснок");
        productsOnKitchen.add("перец");
        productsOnKitchen.add("курица");
        productsOnKitchen.add("соль");
        productsOnKitchen.add("мука");
        productsOnKitchen.add("бананы");
        productsOnKitchen.add("шоколад");
        productsOnKitchen.add("сахар");
        productsOnKitchen.add("орехи");
        productsOnKitchen.add("свинина");
        productsOnKitchen.add("говядина");
        productsOnKitchen.add("сок");
        productsOnKitchen.add("лёд");
        productsOnKitchen.add("молоко");
        productsOnKitchen.add("яблоки");
        productsOnKitchen.add("карамель");
        productsOnKitchen.add("мёд");
        productsOnKitchen.add("тесто");

    }

    public Set<String> getProductsOnKitchen() {
        return productsOnKitchen;
    }
}
