package library;
    public abstract class LibraryItem {

        private String id;
        private String title;
        private boolean borrowed;

        private static int totalItemsCreated = 0;
        private static int nextNumber = 1;

        // Constructor
        public LibraryItem(String title) {

            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Title cannot be empty");
            }

            this.title = title;
            this.id = "ITEM-" + nextNumber;

            nextNumber++;
            totalItemsCreated++;

            borrowed = false;
        }

        // Getters
        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public boolean isBorrowed() {
            return borrowed;
        }

        public static int getTotalItemsCreated() {
            return totalItemsCreated;
        }

        // Setter
        public void setTitle(String title) {

            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Title cannot be empty");
            }

            this.title = title;
        }

        // Borrow
        public void markBorrowed() {
            borrowed = true;
        }

        // Return
        public void markReturned() {
            borrowed = false;
        }

        // Display
        public void displayInfo() {

            System.out.println(
                    getId() + " | "
                            + getTitle() + " | "
                            + getType() + " | loan: "
                            + getLoanPeriodDays()
                            + " days | "
                            + (isBorrowed() ? "OUT" : "available")
            );

        }

        // Abstract Methods
        public abstract int getLoanPeriodDays();

        public abstract String getType();

    }


