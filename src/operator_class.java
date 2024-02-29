public class operator_class extends person_class {
    /**
     * Variables
     * 
     */
    protected int wage;
    protected customer_class[] customer;

    /**
     * constructor
     */
    public operator_class(String name, String surname, String address, String phone, int ID, int wage, customer_class[] customer) {
        super(name, surname, address, phone, ID);
        this.wage = wage;
        //if customer is empty dont assign
        if(customer!=null){
            this.customer = customer;
        }
    }
    
    /**
     * get and set methods for the variables
     */
    public int getWage() {
        return wage;
    }
    public void setWage(int wage) {
        this.wage = wage;
    }
    public customer_class[] getCustomer() {
        return customer;
    }
    public void setCustomer(customer_class[] customer) {
        this.customer = customer;
    }


    /**
     * methods
     */
    public void print_customers(){
        if (customer.length == 0) {
            System.out.println("----------------------------\n"+
                "This operator doesn't have any customer.\n"+
                "----------------------------\n");
        }
        else if (customer.length>0) {
            for(int i=0; i<customer.length; i++){
                System.out.println("----------------------------");
                System.out.print("Customer #"+(i+1));
                if (customer[i] instanceof retailCustomer_class) {
                    System.out.println(" (a retail customera)");
                }
                else if (customer[i] instanceof corporateCustomer_class) {
                    System.out.println(" (a corporate customera)");
                }
                customer[i].print_customer();
                
            }
        }
    }

    public void print_operator(){
        System.out.println("----------------------------");
        System.out.println("Name & Surname: "+name+" "+surname);
        System.out.println("Address: "+address);
        System.out.println("Phone: "+phone);
        System.out.println("ID: "+ID);
        System.out.println("Wage: "+wage);
        print_customers();
    }

    public void define_customers(customer_class[] customer){
        if (customer != null) {
            int customer_count = 0;
            // İlk olarak, null olmayan ve operatör ID'sine sahip müşteri sayısını say
            for(int i = 0; i < customer.length; i++){
                if(customer[i] != null && customer[i].getOperator_ID() == ID){
                    customer_count++;
                }
            }
    
            customer_class[] operators_customers = new customer_class[customer_count];
            int j = 0; // Yeni dizi için index
    
            // İlgili müşterileri yeni diziye ekle
            for(int i = 0; i < customer.length; i++){
                if(customer[i] != null && customer[i].getOperator_ID() == ID){
                    operators_customers[j] = customer[i];
                    j++;
                }
            }
    
            this.customer = operators_customers; // Güncellenmiş müşteri listesini atama
        }
    }
    
}
