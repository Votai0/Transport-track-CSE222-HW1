public class customer_class extends person_class {

    /**
     * @param operator_ID: ID of the operator
     * @param order_array: list of the orders
     */
    protected int operator_ID;
    protected order_class[] order_array;

    // constructor for the customer class
    public customer_class(String name, String surname, String address, String phone, int ID, int operator_ID, order_class[] order_array) {
        super(name, surname, address, phone, ID);
        this.operator_ID = operator_ID;

        //if order array is empty dont assign
        if(order_array!=null){
            this.order_array = order_array;
        }   
    }

    // getters and setters
    public int getOperator_ID() {
        return operator_ID;
    }
    public void setOperator_ID(int operator_ID) {
        this.operator_ID = operator_ID;
    }
    public order_class[] getOrder_array() {
        return order_array;
    }
    public void setOrder_array(order_class[] order_array) {
        this.order_array = order_array;
    }

    /**
     * Methods
     * @method print_orders: prints the orders of the customer
     * @method print_customer: prints the customer details
     * @method define_orders: defines the orders of the customer
     */

    public void print_orders(){
        for(int i=0; i<order_array.length; i++){
            System.out.print("Order #"+(i+1) + " =>" );
            order_array[i].print_order();
        }
    }

    public void print_customer(){
        System.out.println("Name & Surname: "+name+" "+surname);
        System.out.println("Address: "+address);
        System.out.println("Phone: "+phone);
        System.out.println("ID: "+ID);
        System.out.println("Operator ID: "+operator_ID);
        if (this instanceof corporateCustomer_class) {
            System.out.println("Company Name: "+((corporateCustomer_class)this).getCompany_name());
        }    


        print_orders();
        
    }


    /**
     * @method define_orders: defines the orders of the customer
     * @param order_array : list of the orders
     * HOW THIS METHOD WORKS:
     * 1. First, count the number of orders that are not null and have the customer ID
     * 2. Create a new array to hold the orders of the customer
     * 3. Add the relevant orders to the new array
     * 4. Assign the updated order list
     */
    public void define_orders(order_class[] order_array) {
        if (order_array != null) {
            int order_count = 0;
            // Öncelikle, null olmayan ve müşteri ID'sine sahip sipariş sayısını say
            for (int i = 0; i < order_array.length; i++) {
                if (order_array[i] != null && order_array[i].getCostumer_ID() == ID) {
                    order_count++;
                }
            }
    
            // Müşteriye ait siparişleri tutacak yeni bir dizi oluştur
            order_class[] customer_orders = new order_class[order_count];
            int j = 0; // Yeni dizi için index
    
            // İlgili siparişleri yeni diziye ekle
            for (int i = 0; i < order_array.length; i++) {
                if (order_array[i] != null && order_array[i].getCostumer_ID() == ID) {
                    customer_orders[j] = order_array[i];
                    j++;
                }
            }
    
            this.order_array = customer_orders; 
        }
    }
    


}
