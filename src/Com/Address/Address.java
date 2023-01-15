package Com.Address;

import java .util.*;
import java.util.stream.Collectors;
public class Address {
    static Scanner sc = new Scanner(System.in);
    static List<Contact> list = new ArrayList<Contact>();

    public static void addContact() {
        System.out.println("Enter your firstName : ");
        String firstName = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println("This name is already exists try with another name");
                addPerson();
                break;
            }
        }
        System.out.println("Enter your lastName : ");
        String lastName = sc.nextLine();
        System.out.println("Enter your address : ");
        String address = sc.nextLine();
        System.out.println("Enter your city : ");
        String city = sc.nextLine();
        System.out.println("Enter your state : ");
        String state = sc.nextLine();
        System.out.println("Enter your zipCode : ");
        String zip = sc.nextLine();
        System.out.println("Enter your phoneNo : ");
        String phoneNo = sc.nextLine();
        System.out.println("Enter your emailId : ");
        String email = sc.nextLine();
        Contact addressBook = new Contact();
        addressBook.setFirstName(firstName);
        addressBook.setEmail(email);
        addressBook.setAddress(address);
        addressBook.setCity(city);
        addressBook.setLastName(lastName);
        addressBook.setState(state);
        addressBook.setZip(zip);
        addressBook.setPhoneNo(phoneNo);
        list.add(addressBook);
    }
    public static void addPerson() {
        System.out.println("-----------add multiple person to Address Book-----------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many contact you want to add : ");
        int noOfAddressBook = sc.nextInt();
        int person = 1;
        while (person <= noOfAddressBook) {
            addContact();
            person++;
        }
    }
    public static void sortingByCity() {
        list = list.stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());
        list.forEach(i -> System.out.println(i));
    }
    public static void main(String[] args) {
        Address address= new Address();
        System.out.println("Welcome to Address Book Program..");
        addPerson();
        Address.sortingByCity();
        System.out.println(list);

    }
}