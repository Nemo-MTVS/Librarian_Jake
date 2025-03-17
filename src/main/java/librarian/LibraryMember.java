package librarian;

public class LibraryMember {
    private String name;
    private String memberShipId;
    private int borrowLimit;


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
    public void setName(String name) {
        this.name = name;
    }
    public void setMemberShipId(String memberShipId) {
        this.memberShipId = memberShipId;
    }
    public void setBorrowLimit(int borrowLimit) {
        this.borrowLimit = borrowLimit;
    }


}
