package librarian;

import java.lang.reflect.Member;

public class StudentMember extends LibraryMember {
    private int additionalBorrowLimit;

    public StudentMember(String name, String id, int borrowLimit, int additionalBorrowLimit) {
        super(name, id, borrowLimit);
        this.additionalBorrowLimit = additionalBorrowLimit;
    }

    @Override
    public int getFinalBorrowLimit() {
        return super.getBorrowLimit() + additionalBorrowLimit;
    }
}
