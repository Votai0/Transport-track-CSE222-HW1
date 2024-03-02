import java.util.Scanner;
import java.io.File;

public class App {
    /**
     * control for the object
     * @param parcalanmisSatir is the array of the datas from txt file
     * @param ID_list is the list of the IDs for controlling the same ID
     * @return 1 if the object is valid, 0 if the object is not valid
    */
    public static int object_control(String[] parcalanmisSatir,int [] ID_list){
        for(int i=0; i<parcalanmisSatir.length; i++){
            // this if controls the empty string
            if(parcalanmisSatir[i].equals("")){
                return 0;
            }
            // this if and else-if controls the integer values for they are out of range or negative
            if (parcalanmisSatir[0]=="order" && (i==5 || i==4 || i==3 || i==2) ) {
                if (Integer.parseInt(parcalanmisSatir[i])<0) {
                    return 0;
                }
            }
            else if (parcalanmisSatir[0]!="order" && (i==6 || i==5) ) {
                if (Integer.parseInt(parcalanmisSatir[i])<0) {
                    return 0;
                }
            }
        }
        // this if controls the same ID for the operator and customer. not the order because because orders dont have ID's
        if (!(parcalanmisSatir[0].equals("order"))) {
            for(int i=0; i<ID_list.length; i++){
                if(ID_list[i]==Integer.parseInt(parcalanmisSatir[5])){
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {
        // open file and read
        File file = new File("content.txt");
        Scanner fileScanner = new Scanner(file); // Scanner nesnesi oluştur

        /**
         * @param customers is contains retail and corporate customers
         * @param operator and order is contains the operators and orders
        */
        operator_class [] operator = new operator_class [100];
        int operator_count = 0;
        order_class [] order = new order_class [100];
        int order_count = 0;
        customer_class [] customers = new customer_class [200];
        int customer_count = 0;

        // @param id_control is the contains all ID's and it is for the check same ID's
        // @param id_control_count is the count of the ID's
        int []id_control = new int[400]; //control for the same id
        int id_control_count = 0;

        
        /**THIS IS GENERAL STRUCTURE OF THE HOW CODE WORKS
         * Read file until the end create the objects and add them to the arrays
         * Find the user input ID in the arrays and print the user's information
         * @param operator_class: operator;name;surname;address;phone;ID;wage
         * @param order_class: order;product_name;count;total_price;status;customer_id
         * @param customer_class: retail_customer;name;surname;address;phone;ID;operator_ID
         * customer_class contains retail_customer and corporate_customer
         * retail_customer: retail_customer;name;surname;address;phone;ID;operator_ID
         * corporate_customer: corporate_customer;name;surname;address;phone;ID;operator_ID;company_name
        */


        /*THIS IS HOW THIS WHILE WORKS
         * this while loop reads the file until the end. Creates objects and adds them to the arrays. Nothing more.
         * @param satir is the line of the txt file
         * @param parcalanmisSatir is the array of the datas from line in txt file
         * @function object_control is the function for the control the same ID's and the empty strings
         * parcalanmisSatir[0] determines the object type
         * parcalanmisSatir.length used for controlling the correct number of data fields
         * object_control function used for the control the same ID's and the empty strings. if the function returns 1, the object is valid
         */
        while (fileScanner.hasNextLine()) {
            String satir = fileScanner.nextLine();
            String[] parcalanmisSatir = satir.split(";"); // ";" ile parçala
            try {
                if(parcalanmisSatir[0].equals("operator") && parcalanmisSatir.length==7 && object_control(parcalanmisSatir,id_control)==1){ 
                    operator[operator_count] = new operator_class(parcalanmisSatir[1], parcalanmisSatir[2], parcalanmisSatir[3], parcalanmisSatir[4], Integer.parseInt(parcalanmisSatir[5]), Integer.parseInt(parcalanmisSatir[6]), null);
                    operator_count++;
                    id_control[id_control_count] = Integer.parseInt(parcalanmisSatir[5]);
                    id_control_count++;
    
                }
                else if(parcalanmisSatir[0].equals("corporate_customer") && parcalanmisSatir.length==8 && object_control(parcalanmisSatir,id_control)==1){
                    customers[customer_count] = new corporateCustomer_class(parcalanmisSatir[1], parcalanmisSatir[2], parcalanmisSatir[3], parcalanmisSatir[4], Integer.parseInt(parcalanmisSatir[5]), Integer.parseInt(parcalanmisSatir[6]), null, parcalanmisSatir[7]);
                    customer_count++;
                    id_control[id_control_count] = Integer.parseInt(parcalanmisSatir[5]);
                    id_control_count++;
                }
                else if(parcalanmisSatir[0].equals("retail_customer") && parcalanmisSatir.length==7 && object_control(parcalanmisSatir,id_control)==1){
                    customers[customer_count] = new retailCustomer_class(parcalanmisSatir[1], parcalanmisSatir[2], parcalanmisSatir[3], parcalanmisSatir[4], Integer.parseInt(parcalanmisSatir[5]), Integer.parseInt(parcalanmisSatir[6]), null);
                    customer_count++;
                    id_control[id_control_count] = Integer.parseInt(parcalanmisSatir[5]);
                    id_control_count++;
    
                }
                else if(parcalanmisSatir[0].equals("order") && parcalanmisSatir.length==6 && object_control(parcalanmisSatir,id_control)==1){
                    order[order_count] = new order_class(parcalanmisSatir[1], Integer.parseInt(parcalanmisSatir[2]), Integer.parseInt(parcalanmisSatir[3]), Integer.parseInt(parcalanmisSatir[4]), Integer.parseInt(parcalanmisSatir[5]));
                    order_count++;
                }
            } catch (Exception e) {
                
            }
        }
        fileScanner.close(); // Scanner nesnesini kapat


        // HACK init the operator customer array
        //This for loop is for the define the customers for the operators 
        for(int i=0; i<operator_count; i++){
            operator[i].define_customers(customers);
        }

        // HACK init the customer order array
        //This for loop is for the define the orders for the customers 
        for(int i=0; i<customer_count; i++){
            customers[i].define_orders(order);
        }


        //takes the user input
        Scanner kullaniciGirdisiScanner = new Scanner(System.in); // Kullanıcıdan girdi almak için Scanner nesnesi oluştur
        System.out.println("Please enter your ID...");
        String kullaniciGirdisi = kullaniciGirdisiScanner.nextLine(); // Kullanıcıdan girdi al
        try{
            Integer.parseInt(kullaniciGirdisi);
        }        
        catch (Exception e) {
            System.out.println("Invalid ID. Please try again.");
            System.exit(0);
        }
        /*
         * This for loop is for the find the user input ID in the arrays and print the user's information
         */
        int control_for_nFound = 0;
        for(int i=0; i<operator_count; i++){
            if(String.valueOf(operator[i].ID).equals(String.valueOf(kullaniciGirdisi))){
                System.out.println("*** Operator Screen ***\n");
                operator[i].print_operator();
                control_for_nFound++;
            }
        }
        for(int i=0; i<customer_count; i++){
            if(String.valueOf(customers[i].ID).equals(String.valueOf(kullaniciGirdisi))){
                System.out.println("*** Customer Screen ***\n"+"----------------------------");
                customers[i].print_customer();
                control_for_nFound++;
            }
        }
        if (control_for_nFound==0) {
            System.out.println("No operator/customer was found with ID "+kullaniciGirdisi+". Please try again.");
        }


        kullaniciGirdisiScanner.close(); // Kullanıcı girdisi için Scanner nesnesini kapat
    }
}
