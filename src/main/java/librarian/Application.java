package librarian;

public class Application {
    public static void main(String[] args) {
        LibraryMember[] members = new LibraryMember[]{
                new LibraryMember("Jake", "LM001", 3),
                new LibraryMember("Lyn", "LM002", 3),
                new LibraryMember("Kyle", "LM003", 3),
                new StudentMember("Alan", "LM004", 3, 2),
                new StudentMember("Bob", "LM005", 3, 2),
        };
    }
}
