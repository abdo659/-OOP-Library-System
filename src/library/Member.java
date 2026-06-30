package library;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String memberId;
    private String name;
    private int maxAllowed;

    private List<LibraryItem> borrowedItems;

    // Constructor
    public Member(String memberId, String name, int maxAllowed) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if (maxAllowed <= 0) {
            throw new IllegalArgumentException("Max allowed must be greater than zero.");
        }

        this.memberId = memberId;
        this.name = name;
        this.maxAllowed = maxAllowed;

        borrowedItems = new ArrayList<>();
    }

    // Getters

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getMaxAllowed() {
        return maxAllowed;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    // Setters

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    public void setMaxAllowed(int maxAllowed) {

        if (maxAllowed <= 0) {
            throw new IllegalArgumentException("Max allowed must be greater than zero.");
        }

        this.maxAllowed = maxAllowed;
    }

    // Methods

    public int getBorrowedCount() {
        return borrowedItems.size();
    }

    public boolean canBorrowMore() {
        return borrowedItems.size() < maxAllowed;
    }

    public void addBorrowedItem(LibraryItem item){
        borrowedItems.add(item);
    }

    public void removeBorrowedItem(LibraryItem item){
        borrowedItems.remove(item);
    }

}