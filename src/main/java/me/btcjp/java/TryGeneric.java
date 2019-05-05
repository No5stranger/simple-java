package me.btcjp.java;

public class TryGeneric {
    public static <T> T head(T food) {
        System.out.println(food + " is done");
        return food;
    }

    public static void main(String[] args) {
        Meat meat = new Meat();
        meat = TryGeneric.head(meat);
        Soup soup = new Soup();
        soup = TryGeneric.head(soup);
    }
}

class Meat {
    private String name = "meat";
}

class Soup {
    private String name = "soup";
}
