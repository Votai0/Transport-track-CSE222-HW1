public class customer_class extends person_class {

    /**
     * Variables
     * operator_ID: ID of the operator
     * order array: array of the orders
     */
    protected int operator_ID;
    protected order_class[] order_array;

    /**
     * Constructor
     */
    public customer_class(String name, String surname, String address, String phone, int ID, int operator_ID, order_class[] order_array) {
        super(name, surname, address, phone, ID);
        this.operator_ID = operator_ID;

        //if order array is empty dont assign
        if(order_array!=null){
            this.order_array = order_array;
        }   
    }

    /**
     * get and set methods for the variables
     */
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
     * methods
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
    
            // Güncellenmiş sipariş listesini atama
            // Bu satırda belirttiğiniz 'this.order_array' yerine, bu değişkenin adını 'customer_class' içinde tanımlı olan sipariş dizisine göre düzeltmeniz gerekebilir.
            // Örneğin, eğer 'customer_class' içinde siparişleri tutan dizi 'orders' adında ise, 'this.orders = customer_orders;' şeklinde olmalıdır.
            this.order_array = customer_orders; // Örnek: this.orders = customer_orders;
        }
    }
    


}
