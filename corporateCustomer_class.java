public class corporateCustomer_class extends customer_class{
    /**
     * @param company_name is the name of the company
     */
    protected String company_name;

    //constructor for corporate customer
    public corporateCustomer_class(String name, String surname, String address, String phone, int ID, int operator_ID, order_class[] order_array, String company_name) {
        super(name, surname, address, phone, ID, operator_ID, order_array);
        this.company_name = company_name;
    }

    //get and set methods for the company name
    public String getCompany_name() {
        return company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    //print method of corporate customer
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
