package practice;

import java.util.List;

public abstract class DataProvider {

    static List<Purchase> getData1() {
        return List.of(
                new Purchase("Apple", 50.0, 5),
                new Purchase("Laptop", 1200.0, 1),
                new Purchase("Headphones", 150.0, 2),
                new Purchase("Notebook", 20.0, 10)
        );
    }

    static List<Purchase> getData2() {
        return List.of(
                new Purchase("Apple", 50.0, 5),
                new Purchase("Laptop", 1200.0, 1),
                new Purchase("Headphones", 150.0, 2),
                new Purchase("Notebook", 20.0, 10),
                new Purchase("Apple", 50.0, 3),
                new Purchase("Headphones", 150.0, 1)
        );
    }

}
