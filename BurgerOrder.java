public class BurgerOrder {

    private int numHamburgers;
    private int numCheeseburgers;
    private int numVeggieburgers;
    private int numSodas;
    private boolean orderToGo;
    private int orderNum;
    private String customerName;
    private String customerPhone;

    public BurgerOrder(int numHamburgers, int numCheeseburgers, int numVeggieburgers, int numSodas, boolean orderToGo, int orderNum, String customerName, String customerPhone) {
        this.numHamburgers = Math.max(0, numHamburgers);
        this.numCheeseburgers = Math.max(0, numCheeseburgers);
        this.numVeggieburgers = Math.max(0, numVeggieburgers);
        this.numSodas = Math.max(0, numSodas);
        this.orderToGo = orderToGo;
        this.orderNum = orderNum;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    public int getNumHamburger() {
        return numHamburgers;
    }

    public void setNumHamburger(int numHamburgers) {
        this.numHamburgers = Math.max(0, numHamburgers);
    }

    public int getNumCheeseburgers() {
        return numCheeseburgers;
    }

    public void setNumCheeseburgers(int numCheeseburgers) {
        this.numCheeseburgers = Math.max(0, numCheeseburgers);
    }

    public int getNumVeggieburgers() {
        return numVeggieburgers;
    }

    public void setNumVeggieburgers(int numVeggieburgers) {
        this.numVeggieburgers = Math.max(0, numVeggieburgers);
    }

    public int getNumSodas() {
        return numSodas;
    }

    public void setNumSodas(int numSodas) {
        this.numSodas = Math.max(0, numSodas);
    }

    public boolean isOrderToGo() {
        return orderToGo;
    }

    public void setOrderToGo(boolean orderToGo) {
        this.orderToGo = orderToGo;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public int getTotalBurgers() {
        return numHamburgers + numCheeseburgers + numVeggieburgers;
    }

    @Override
    public String toString() {
        return "BurgerOrder{" +
                "numHamburgers=" + numHamburgers +
                ", numCheeseburgers=" + numCheeseburgers +
                ", numVeggieburgers=" + numVeggieburgers +
                ", numSodas=" + numSodas +
                ", orderToGo=" + orderToGo +
                ", orderNum=" + orderNum +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                '}';
    }
}
