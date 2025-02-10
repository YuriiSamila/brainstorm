package practice;

import java.util.List;

public record Customer(String name, int age, List<Purchase> purchases) {
}
