package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.stream.Collectors.*;
import static practice.DataProvider.getData1;
import static practice.DataProvider.getData2;

public class StreamPractice {

    private static final String TASK_STRING = "----------------------Task %s result:\n";


    public static void main(String[] args) {
/*  1)
    1. Filter out products where the price exceeds 100.
    2. Convert each product to its total cost (price * quantity).
    3. Calculate the total cost of all filtered products.
    4. Output the names of these products as a single comma-separated string.*/

        String result = getData1().stream()
                .filter(purchase -> purchase.price() > 100)
                .collect(teeing(
                        summingDouble(purchase -> purchase.price() * purchase.quantity()),
                        mapping(Purchase::name, joining(", ")),
                        (sum, names) -> format("Total cost: %.2f; Products: %s", sum, names)
                ));
        //System.out.println(taskString(1) + result);

/* 2)
    1. Group purchases by product name.
    2. Calculate the total quantity purchased for each product.
    3. Calculate the total revenue for each product.*/

        Map<String, String> resultMap = getData2().stream()
                .collect(teeing(
                        groupingBy(Purchase::name, summingInt(Purchase::quantity)),
                        groupingBy(Purchase::name, summingDouble(purchase -> purchase.price() * purchase.quantity())),
                        (map1, map2) ->
                                map1.entrySet().stream()
                                        .collect(toMap(Map.Entry::getKey,
                                                entry -> "Quantity: " + entry.getValue() + "; Revenue: " + map2.get(entry.getKey())))
                ));
        System.out.print(taskString(2));
        resultMap.entrySet().forEach(System.out::println);

    }

    private static String taskString(int taskNumber) {
        return format(TASK_STRING, taskNumber);
    }

}
