package library;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {

    private Map<String, LibraryItem> catalog;
    private Map<String, Member> members;
    private Set<String> borrowedIds;

    // Constructor
    public Library() {
        catalog = new HashMap<>();
        members = new HashMap<>();
        borrowedIds = new HashSet<>();
    }

    // Add Item
    public void addItem(LibraryItem item) {
        catalog.put(item.getId(), item);
    }

    // Add Member
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    // Borrow Item
    public void borrowItem(String memberId, String itemId) throws LibraryException {

        Member member = members.get(memberId);
        LibraryItem item = catalog.get(itemId);

        if (member == null) {
            throw new LibraryException("Member not found.");
        }

        if (item == null) {
            throw new LibraryException("Item not found.");
        }

        if (item.isBorrowed()) {
            throw new LibraryException("Item is already borrowed.");
        }

        if (!member.canBorrowMore()) {
            throw new LibraryException("Member reached borrowing limit.");
        }

        item.markBorrowed();

        member.addBorrowedItem(item);

        borrowedIds.add(itemId);

        System.out.println("Borrowed Successfully.");
    }

    // Return Item
    public void returnItem(String memberId, String itemId) throws LibraryException {

        Member member = members.get(memberId);
        LibraryItem item = catalog.get(itemId);

        if (member == null) {
            throw new LibraryException("Member not found.");
        }

        if (item == null) {
            throw new LibraryException("Item not found.");
        }

        if (!member.getBorrowedItems().contains(item)) {
            throw new LibraryException("This member didn't borrow this item.");
        }

        item.markReturned();

        member.removeBorrowedItem(item);

        borrowedIds.remove(itemId);

        System.out.println("Returned Successfully.");
    }

    // List Catalog
    public void listCatalog() {

        for (LibraryItem item : catalog.values()) {

            item.displayInfo();

        }

    }
//searchByTitle
    public void searchByTitle(String title){

        boolean found = false;

        for(LibraryItem item : catalog.values()){

            if(item.getTitle().equalsIgnoreCase(title)){

                item.displayInfo();
                found = true;

            }

        }

        if(!found){

            System.out.println("Item not found.");

        }

    }


//showAvailableItems
    public void showAvailableItems(){

        for(LibraryItem item : catalog.values()){

            if(!item.isBorrowed()){

                item.displayInfo();

            }

        }

    }

    // Report
    public void printReport() {

        Map<String, Integer> itemsByType = new HashMap<>();

        for (LibraryItem item : catalog.values()) {

            itemsByType.put(
                    item.getType(),
                    itemsByType.getOrDefault(item.getType(), 0) + 1
            );

        }

        System.out.println("\n---------- REPORT ----------");
        System.out.println("Total items : " + catalog.size());
        System.out.println("Currently out : " + borrowedIds.size());
        System.out.println("Borrowed ids : " + borrowedIds);
        System.out.println("Items by type : " + itemsByType);
        System.out.println("Total created : " + LibraryItem.getTotalItemsCreated());
        System.out.println("----------------------------");
    }

}