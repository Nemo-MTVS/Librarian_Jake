package librarian;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExportMemberListTest {
    private ExportMemberList exportMemberList;
    private LibraryMember[] members;

    @BeforeEach
    void setUp() {
        members = new LibraryMember[]{
                new LibraryMember("Jake", "LM001", 3),
                new LibraryMember("Lyn", "LM002", 3),
                new LibraryMember("Kyle", "LM003", 3),
                new StudentMember("Alan", "LM004", 3, 2),
                new StudentMember("Bob", "LM005", 3, 2)
        };
        exportMemberList = new ExportMemberList(members);
    }

    @Test
    void exportMemberList() {
        String result = exportMemberList.exportMemberList();
        Assertions.assertEquals("Jake, LM001, 3; Lyn, LM002, 3; Kyle, LM003, 3; Alan, LM004, 5; Bob, LM005, 5/"
                , result);
        Assertions.assertTrue(
                "Jake, LM001, 3; Lyn, LM002, 3; Kyle, LM003, 3; Alan, LM004, 5; Bob, LM005, 5/".equals(result)
        );

    }

    @AfterEach
    void tearDown() {
        members = null;
        exportMemberList = null;
    }
}