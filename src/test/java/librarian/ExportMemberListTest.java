package librarian;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExportMemberListTest {
    private ExportMemberList exportMemberList;
    private List<LibraryMember> members;

    @BeforeEach
    void setUp() {
        members = new ArrayList<>();
        // Add initial members
        members.add(new LibraryMember("Jake", "LM001", 3));
        members.add(new LibraryMember("Lyn", "LM002", 3));
        members.add(new LibraryMember("Kyle", "LM003", 3));
        members.add(new StudentMember("Alan", "SM004", 3, 2));
        members.add(new StudentMember("Bob", "SM005", 3, 2));

        exportMemberList = new ExportMemberList(members);
        System.out.println("System Initialized");
    }

    @Test
    void exportMemberList() {
        String result = exportMemberList.exportMemberList();
        System.out.println(result);
        Assertions.assertEquals("Jake, LM001, 3; Lyn, LM002, 3; Kyle, LM003, 3; Alan, SM004, 5; Bob, SM005, 5"
                , result);
        Assertions.assertTrue(
                "Jake, LM001, 3; Lyn, LM002, 3; Kyle, LM003, 3; Alan, SM004, 5; Bob, SM005, 5".equals(result)
        );

    }

    @AfterEach
    void tearDown() {
        members = null;
        exportMemberList = null;
        System.out.println("System Terminated");
    }
}