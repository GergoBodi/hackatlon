package basics.impl;

public class RunPizza {

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        pizza.countTip(100);
        pizza.countTip(15000);
        pizza.countTip(1199);
        pizza.countTip(1999);
        pizza.countTip(6185);
        pizza.countTip(6288);
        pizza.countTip(2800);
        pizza.countTip(2500);
        pizza.countTip(800);
    }

}
