public class order_class {
    /**
     * @param product_name: name of the product
     * @param count: number of the product
     * @param total_price: total price of the product
     * @param status: status of the order
     * @param costumer_ID: ID of the costumer
     */
    protected String product_name;
    protected int count;
    protected int total_price;
    protected int status;
    protected int costumer_ID;

    //constructor for the order class
    public order_class(String product_name, int count, int total_price, int status, int costumer_ID) {
        this.product_name = product_name;
        this.count = count;
        this.total_price = total_price;
        this.status = status;
        this.costumer_ID = costumer_ID;
    }

    //getters and setters
    public int getCostumer_ID() {
        return costumer_ID;
    }
    public void setCostumer_ID(int costumer_ID) {
        this.costumer_ID = costumer_ID;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getTotal_price() {
        return total_price;
    }
    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }


    /**
     * @method print_order: prints the order details
     * 1=Initialized, 2=Processing, 3=Completed, 4=Cancelled
     */
    
    public void print_order(){
        System.out.print("Product Name: "+product_name);
        System.out.print(" - Count: "+count);
        System.out.print(" - Total Price: "+total_price);
        System.out.print(" - Status: ");
        if (status == 0) {
            System.out.print("Initialized.\n");
        }
        else if (status == 1) {
            System.out.print("Processing.\n");
        }
        else if (status == 2) {
            System.out.print("Completed.\n");
        }
        else if (status == 3) {
            System.out.print("Cancelled.\n");
            
        }
        
    }
}
