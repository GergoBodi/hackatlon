package basics.impl;

public class Pizza {

    /**
     * The tip according to the cost of the pizza.
     */
    private int tip;
    /**
     * The total cost, sum of the tip and the cost of the pizza.
     */
    private int amount;
    /**
     * A temporary variable to calculate the tip.
     */
    private double temp;

    /**
     * Constructor
     */
    public Pizza() {
        this.tip = 0;
        this.amount = 0;
        this.temp = 0;
    }

    /**
     * Calculates the tip according to the cost of the pizza.
     *
     * @param cost
     *            the cost of the pizza
     */
    public void countTip(int cost) {

        if (cost > 5000) {
            setTemp(0.1 * cost);
            setTip((int) temp);
            setAmount(cost + tip);
            roundUpTip(cost);
        } else if (cost < 2000) {
            if (cost % 100 == 0) {
                setTip(0);
            } else {
                setTip(100 - (cost - ((cost / 100) * 100)));
            }
        } else {
            roundUpTip(cost);
        }
        setAmount(cost + tip);
        answerToTheDeliveryGuy();
    }

    /**
     * Rounds up the tip to the nearest five hundred or thousand.
     *
     * @param currentCost
     *            the current cost of the pizza.
     */
    public void roundUpTip(int currentCost) {

        if ((currentCost % 500) != 0) {
            setTemp(currentCost - ((currentCost / 1000) * 1000));
            if (temp < 500) {
                tip += 500 - temp;
            } else {
                tip += 1000 - temp;
            }
        }
    }

    /**
     * Prints out an answer to the delivery guy according to the tip. Sets the tip to zero because of the multiple calls.
     */
    public void answerToTheDeliveryGuy() {

        if (getTip() == 0 || getTip() > 1500) {
            System.out.println(PizzaConstants.TOO_BIG_TIP);
            setTip(0);
        } else if ((getTip() % 100) != 0) {
            System.out.println(PizzaConstants.TOO_SMALL_TIP);
            setTip(0);
        } else {
            System.out.println(PizzaConstants.COST_WITH_TIP + amount);
            setTip(0);
        }
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

}
