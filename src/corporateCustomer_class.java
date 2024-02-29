public class corporateCustomer_class extends customer_class{
    /**
     * Variables
     * company_name: name of the company
     */
    protected String company_name;

    /**
     * Constructor
     */
    public corporateCustomer_class(String name, String surname, String address, String phone, int ID, int operator_ID, order_class[] order_array, String company_name) {
        super(name, surname, address, phone, ID, operator_ID, order_array);
        this.company_name = company_name;
    }

    /**
     * get and set methods for the variables
     */
    public String getCompany_name() {
        return company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    /**
     * methods
     */
    public void print_corporate_customer(){
        System.out.println("*** Corporate Customer Screen ***\n" + //
                        "----------------------------");
        System.out.println("Name & Surname: "+name+" "+surname);
        System.out.println("Address: "+address);
        System.out.println("Phone: "+phone);
        System.out.println("ID: "+ID);
        System.out.println("Operator ID: "+operator_ID);
        System.out.println("Company Name: "+company_name);
        System.out.println("Orders: ");
        print_orders();

    }
}
