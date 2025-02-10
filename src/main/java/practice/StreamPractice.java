package practice;

import java.util.*;

import static java.lang.String.format;
import static java.util.stream.Collectors.*;
import static practice.DataProvider.*;

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
        //System.out.print(taskString(2));
        //resultMap.entrySet().forEach(System.out::println);

    /* 3)
    1. Find the top 3 customers who spent the most money in total.
    2. Group customers by age range:
    "Under 25" (age < 25)
    "25-40" (25 ≤ age ≤ 40)
    "Above 40" (age > 40)
    3. Find the most popular purchased item (the item that was bought the most across all customers).
     */
// 1.
        Map<String, Double> topCustomersBySpending = getData3().stream()
                .map(customer -> Map.entry(customer.name(), customer.purchases()
                        .stream()
                        .mapToDouble(purchase -> purchase.price() * purchase.quantity())
                        .sum()))
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, _) -> v1, LinkedHashMap::new));
        //topCustomersBySpending.forEach((k, v) -> System.out.println(k + ": " + v));
// 2.
        HashMap<String, ArrayList<String>> customersMyAgeGroup = getData3().stream()
                .collect(toMap(customer -> {
                    if (customer.age() < 25) {
                        return "Under 25";
                    }
                    if (customer.age() <= 40) {
                        return "25-40";
                    }
                    return "40+";
                }, customer -> new ArrayList<>(List.of(customer.name())), (v1, v2) -> {
                    v1.addAll(v2);
                    return v1;
                }, LinkedHashMap::new));

        customersMyAgeGroup.forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v.toArray())));

    }
    private static String taskString(int taskNumber) {
        return format(TASK_STRING, taskNumber);
    }

}
