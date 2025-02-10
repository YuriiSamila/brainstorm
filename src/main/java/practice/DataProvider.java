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

    static List<Customer> getData3() {
        return List.of(
                new Customer("Alice", 22, List.of(
                        new Purchase("Beer", 5.0, 6),
                        new Purchase("Chips", 2.0, 3)
                )),
                new Customer("Bob", 35, List.of(
                        new Purchase("Beer", 5.0, 10),
                        new Purchase("Pizza", 12.0, 2)
                )),
                new Customer("Charlie", 45, List.of(
                        new Purchase("Whiskey", 40.0, 1),
                        new Purchase("Beer", 5.0, 5)
                )),
                new Customer("David", 28, List.of(
                        new Purchase("Whiskey", 40.0, 2),
                        new Purchase("Chips", 2.0, 5)
                )),
                new Customer("Eve", 50, List.of(
                        new Purchase("Beer", 5.0, 8),
                        new Purchase("Pizza", 12.0, 3)
                ))
        );

    }
}
