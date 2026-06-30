package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("\n===== Library Lending System =====");
            System.out.println("1. Add Item");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. List Catalog");
            System.out.println("6. Report");
            System.out.println("7. Search By Title");
            System.out.println("8. Show Available Items");
            System.out.println("9. Exit");
            System.out.print("Enter Choice: ");

            int choice;

            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please enter a number.");
                input.nextLine();
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.println("1. Book");
                    System.out.println("2. Magazine");
                    System.out.println("3. DVD");
                    System.out.print("Choose Item Type: ");

                    int type;

                    try {
                        type = input.nextInt();
                        input.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid item type.");
                        input.nextLine();
                        break;
                    }

                    switch (type) {

                        case 1:

                            try {

                                System.out.print("Title: ");
                                String title = input.nextLine();

                                System.out.print("Author: ");
                                String author = input.nextLine();

                                System.out.print("Pages: ");
                                int pages = input.nextInt();
                                input.nextLine();

                                library.addItem(new Book(title, author, pages));

                                System.out.println("Book Added Successfully.");

                            } catch (InputMismatchException e) {

                                System.out.println("Pages must be a number.");
                                input.nextLine();

                            } catch (IllegalArgumentException e) {

                                System.out.println(e.getMessage());

                            }

                            break;

                        case 2:

                            try {

                                System.out.print("Title: ");
                                String title = input.nextLine();

                                System.out.print("Issue Number: ");
                                int issue = input.nextInt();
                                input.nextLine();

                                library.addItem(new Magazine(title, issue));

                                System.out.println("Magazine Added Successfully.");

                            } catch (InputMismatchException e) {

                                System.out.println("Issue Number must be a number.");
                                input.nextLine();

                            } catch (IllegalArgumentException e) {

                                System.out.println(e.getMessage());

                            }

                            break;

                        case 3:

                            try {

                                System.out.print("Title: ");
                                String title = input.nextLine();

                                System.out.print("Runtime Minutes: ");
                                int runtime = input.nextInt();
                                input.nextLine();

                                library.addItem(new DVD(title, runtime));

                                System.out.println("DVD Added Successfully.");

                            } catch (InputMismatchException e) {

                                System.out.println("Runtime must be a number.");
                                input.nextLine();

                            } catch (IllegalArgumentException e) {

                                System.out.println(e.getMessage());

                            }

                            break;

                        default:
                            System.out.println("Invalid Item Type.");

                    }

                    break;

                case 2:

                    try {

                        System.out.print("Member ID: ");
                        String memberId = input.nextLine();

                        System.out.print("Member Name: ");
                        String name = input.nextLine();

                        System.out.print("Max Allowed: ");
                        int max = input.nextInt();
                        input.nextLine();

                        library.addMember(new Member(memberId, name, max));

                        System.out.println("Member Added Successfully.");

                    } catch (InputMismatchException e) {

                        System.out.println("Max Allowed must be a number.");
                        input.nextLine();

                    } catch (IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    }

                    break;

                case 3:

                    try {

                        System.out.print("Member ID: ");
                        String memberId = input.nextLine();

                        System.out.print("Item ID: ");
                        String itemId = input.nextLine();

                        library.borrowItem(memberId, itemId);

                    } catch (LibraryException e) {

                        System.out.println(e.getMessage());

                    }

                    break;

                case 4:

                    try {

                        System.out.print("Member ID: ");
                        String memberId = input.nextLine();

                        System.out.print("Item ID: ");
                        String itemId = input.nextLine();

                        library.returnItem(memberId, itemId);

                    } catch (LibraryException e) {

                        System.out.println(e.getMessage());

                    }

                    break;

                case 5:

                    library.listCatalog();

                    break;

                case 6:

                    library.printReport();

                    break;

                case 7:

                    System.out.print("Enter Title: ");
                    String title = input.nextLine();

                    library.searchByTitle(title);

                    break;

                case 8:

                    library.showAvailableItems();

                    break;

                case 9:

                    System.out.println("Thank you for using Library Lending System.");
                    input.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}