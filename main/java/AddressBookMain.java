import java.util.*;

public class AddressBookMain {
    static Scanner input = new Scanner(System.in);
    static List<Contacts> contactsList = new ArrayList<>();
    private static HashMap<String, List<Contacts>> books =  new HashMap<String, List<Contacts>>();
    static String addressBookName;
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");

        while(true) {
            AddressBookMenu();
            int selectionAddressBook = input.nextInt();
            if(selectionAddressBook < 1 || selectionAddressBook > 3) {
                System.out.println("Please enter the number in the menu");
                continue;
            }

            switch (selectionAddressBook){
                case 1:
                    createAddressBook();
                    break;
                case 2:
                    contacts();
                    break;
                case 3:
                    exit();
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }

    private static void createAddressBook() {
        addressBookName = getAddressBookName();
    }

    private static void contacts() {
        while(true) {
            Menu();
            System.out.println("Enter your selection");
            int selection = input.nextInt();
            if (selection < 1 || selection > 6) {
                System.out.println("Please enter the number in the menu");
                continue;
            }

            switch (selection) {
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
                    AddressBookMenu();
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }

    private static void AddressBookMenu() {
        System.out.println("------------------------------------------");
        System.out.println("| 1. Address Book |");
        System.out.println("| 2. Contacts |");
        System.out.println("| 3. Exit |");
        System.out.println("------------------------------------------");
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
        Iterator<String> iterator = books.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            List<Contacts> value = books.get(key);
            System.out.println("key : " + key + " Value : " + value);
            Iterator<Contacts> itr = contactsList.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next());
            }
        }
    }

    private static void search() {
        System.out.println("------Query Contact------");
        System.out.println("Please enter the contact first name");
        String name = input.next();

        for(Contacts c : contactsList){
            if(c.getFirstName().equals(name)){
                System.out.println("First name: " + c.getFirstName());
                System.out.println("Last name: " + c.getLastName());
                System.out.println("Address：" + c.getAddress());
                System.out.println("City：" + c.getCity());
                System.out.println("State: " + c.getState());
                System.out.println("Zip code: " + c.getZipCode());
                System.out.println("Phone number: " + c.getPhoneNumber());
                System.out.println("Email: " + c.getEmail());
            }
        }
    }

    private static void upDate() {
        System.out.println("------Update contact information------");
        System.out.println("Please enter the contact first name");
        String name=input.next();
        System.out.println("First name: " + " Please enter a new contact first name");
        String firstName = input.next();
        System.out.println("Last name: " + " Please enter a new contact last name");
        String lastName = input.next();
        System.out.println("Address: " + " Please enter the new contact address");
        String address = input.next();
        System.out.println("City: " + " Please enter a new contact city");
        String city = input.next();
        System.out.println("State: " + " Please enter a new contact state");
        String state = input.next();
        System.out.println("Zip code: " + " Please enter a new contact zip code");
        String zipCode = input.next();
        System.out.println("Phone number: " + " Please enter a new contact phone number");
        String phoneNumber = input.next();
        System.out.println("Email: " + " Please enter a new contact email");
        String email = input.next();

        for(Contacts c : contactsList){
            if(c.getFirstName().equals(name)){
                contactsList.set(contactsList.indexOf(c),new Contacts(firstName, lastName, address, city, state, zipCode,
                        phoneNumber, email));
            }else {
                System.out.println("Contact does not exist");
            }
        }

    }

    private static void delete() {
        System.out.println("------Delete a contact------");
        System.out.println("Please enter the contact first name");
        String name = input.next();
        for(Contacts c : contactsList){
            if(c.getFirstName().equals(name)){
                contactsList.remove(contactsList.indexOf(c));
            }
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

        contactsList.add(new Contacts(firstName, lastName, address, city, state, zipCode,
                phoneNumber, email));
        books.put(addressBookName,contactsList);
        System.out.println(books.get(addressBookName).toString());
    }

    private static String getAddressBookName() {
        System.out.println("Give a address book name");
        String addressBookName = input.next();
        return addressBookName;
    }

}
