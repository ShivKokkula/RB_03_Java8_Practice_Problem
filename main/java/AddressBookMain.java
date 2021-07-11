import java.util.Scanner;

public class AddressBookMain {
    static Scanner input=new Scanner(System.in);
    static int max_contacts = 100;
    static int current_contacts_counts = 0;
    static Contacts[] contacts = new Contacts[max_contacts];
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");

        while(true) {
            Menu();
            System.out.println("Enter your selection");
            int selection = input.nextInt();
            if(selection < 1 || selection > 6) {
                System.out.println("Please enter the number in the menu");
                continue;
            }

            switch (selection){
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    upDate();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    showAll();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("Invalid selection");
            }

        }
    }

    public static void Menu() {
        System.out.println("------------------------------------------");
        System.out.println("| 1. Add contact |");
        System.out.println("| 2. Delete contact |");
        System.out.println("| 3. Modify contact |");
        System.out.println("| 4. Search for a contact |");
        System.out.println("| 5. Show all contacts |");
        System.out.println("| 6. Exit |");
        System.out.println("------------------------------------------");
    }

    private static void exit() {
        System.out.println("Invalid selection");
        System.exit(1);
    }

    private static void showAll() {
        System.out.println("------Query all contacts------");
        for(int i = 0; i < current_contacts_counts; i++) {
            System.out.println(contacts[i]);
        }
    }

    private static void search() {
        System.out.println("------Query Contact------");
        System.out.println("Please enter the contact first name");
        String name = input.next();
        int index = getIndex(name);
        if(-1 == index) {
            System.out.println("Contact does not exist");
        }else {
            System.out.println("First name: "+contacts[index].getFirstName());
            System.out.println("Last name: "+contacts[index].getLastName());
            System.out.println("Address："+contacts[index].getAddress());
            System.out.println("City："+contacts[index].getCity());
            System.out.println("State: "+contacts[index].getState());
            System.out.println("Zip code: "+contacts[index].getZipCode());
            System.out.println("Phone number: "+contacts[index].getPhoneNumber());
            System.out.println("Email: "+contacts[index].getEmail());
        }
    }

    private static void upDate() {
        System.out.println("------Update contact information------");
        System.out.println("Please enter the contact first name");
        String name=input.next();
        int index = getIndex(name);
        if(-1 == index) {
            System.out.println("Contact does not exist");
        }else {
            System.out.println("First name: "+contacts[index].getFirstName()+" Please enter a new contact first name");
            String firstName = input.next();
            contacts[index].setFirstName(firstName);
            System.out.println("Last name: "+contacts[index].getLastName()+" Please enter a new contact last name");
            String lastName = input.next();
            contacts[index].setLastName(lastName);
            System.out.println("Address: "+contacts[index].getAddress()+" Please enter the new contact address");
            String address = input.next();
            contacts[index].setAddress(address);
            System.out.println("City: "+contacts[index].getCity()+" Please enter a new contact city");
            String city = input.next();
            contacts[index].setCity(city);
            System.out.println("State: "+contacts[index].getState()+" Please enter a new contact state");
            String state = input.next();
            contacts[index].setState(state);
            System.out.println("Zip code: "+contacts[index].getZipCode()+" Please enter a new contact zip code");
            String zipCode = input.next();
            contacts[index].setZipCode(zipCode);
            System.out.println("Phone number: "+contacts[index].getPhoneNumber()+" Please enter a new contact phone number");
            String phoneNumber = input.next();
            contacts[index].setPhoneNumber(phoneNumber);
            System.out.println("Email: "+contacts[index].getEmail()+" Please enter a new contact email");
            String email = input.next();
            contacts[index].setEmail(email);

        }
    }

    private static void delete() {
        System.out.println("------Delete a contact------");
        System.out.println("Please enter the contact first name");
        String name = input.next();
        int index = getIndex(name);
        if(-1 == index) {
            System.out.println("Contact does not exist");
        }else {
            contacts[index]=contacts[current_contacts_counts-1];
            current_contacts_counts--;
            System.out.println("successfully deleted");
        }
    }

    public static void add() {
        System.out.println("------Add a contact------");
        System.out.println("Please enter the contact first name");
        String firstName = input.next();
        System.out.println("Please enter the contact last name");
        String lastName = input.next();
        System.out.println("Please enter the contact address");
        String address = input.next();
        System.out.println("Please enter the contact city");
        String city = input.next();
        System.out.println("Please enter the contact state");
        String state = input.next();
        System.out.println("Please enter the contact zipCode");
        String zipCode = input.next();
        System.out.println("Please enter the contact phoneNumber");
        String phoneNumber = input.next();
        System.out.println("Please enter the contact email");
        String email = input.next();

        contacts[current_contacts_counts] = new Contacts(firstName, lastName, address, city, state, zipCode,
                phoneNumber, email);

        System.out.println(contacts[current_contacts_counts].toString());
        current_contacts_counts++;
    }

    public static int getIndex(String firstName) {
        for(int i = 0; i < current_contacts_counts; i++)
            if (contacts[i].getFirstName().equals(firstName)) {
                return i;
            }
        return -1;
    }
}

