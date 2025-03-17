package librarian;

public class LibraryMember {
    private String name;
    private String memberShipId;
    private int borrowLimit;

    public abstract int getFinalBorrowLimit();

    public LibraryMember(String name, String memberShipId, int borrowLimit) {
        this.name = name;
        this.memberShipId = memberShipId;
        this.borrowLimit = borrowLimit;
    }

    public String getName() {
        return name;
    }
    public String getMemberShipId() {
        return memberShipId;
    }
    public int getBorrowLimit() {
        return borrowLimit;
    }
}
