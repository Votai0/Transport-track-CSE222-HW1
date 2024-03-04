public class operator_class extends person_class {
    /**
     * @param wage: wage of the operator
     * @param customer: list of the customers
     */
    protected int wage;
    protected customer_class[] customer;

    //constructor for the operator class
    public operator_class(String name, String surname, String address, String phone, int ID, int wage, customer_class[] customer) {
        super(name, surname, address, phone, ID);
        this.wage = wage;
        // if customer is empty dont assign
        if(customer!=null){
            this.customer = customer;
        }
    }
    
    //getters and setters
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
     * @method print_customers: prints the customers of the operator
     * @method print_operator: prints the operator details
     * @method define_customers: defines the customers of the operator
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
                    System.out.println(" (a retail customer)");
                }
                else if (customer[i] instanceof corporateCustomer_class) {
                    System.out.println(" (a corporate customer)");
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

    /*
     * @method define_customers: defines the customers of the operator
     * HOW THIS METHOD WORKS:
     * 1. First, count the number of non-null customers with an operator ID
     * 2. Create a new array with the size of the counted customers
     * 3. Add the relevant customers to the new array
     * 4. Assign the updated customer list
     * @param customer: list of the customers
     */
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
