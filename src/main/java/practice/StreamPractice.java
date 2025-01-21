package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.stream.Collectors.*;

public class StreamPractice {

    public static void main(String[] args) {
/* 1)
    1. Filter out products where the price exceeds 100.
    2. Convert each product to its total cost (price * quantity).
    3. Calculate the total cost of all filtered products.
    4. Output the names of these products as a single comma-separated string.
 */
        List<Purchase> purchases = List.of(
                new Purchase("Apple", 50.0, 5),
                new Purchase("Laptop", 1200.0, 1),
                new Purchase("Headphones", 150.0, 2),
                new Purchase("Notebook", 20.0, 10)
        );
        String result = purchases.stream()
                .filter(purchase -> purchase.price() > 100)
                .collect(teeing(
                        summingDouble(purchase -> purchase.price() * purchase.quantity()),
                        mapping(Purchase::name, joining(", ")),
                        (sum, names) -> format("Total cost: %.2f, Products: %s", sum, names)
                ));
        System.out.println(result);


    }


}
