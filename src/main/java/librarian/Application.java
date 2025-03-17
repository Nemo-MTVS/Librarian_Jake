package librarian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        LibraryMember[] membersArr = new LibraryMember[]{
                new LibraryMember("Jake", "LM001", 3),
                new LibraryMember("Lyn", "LM002", 3),
                new LibraryMember("Kyle", "LM003", 3),
                new StudentMember("Alan", "LM004", 3, 2),
                new StudentMember("Bob", "LM005", 3, 2),
        };
        List<String> members = new ArrayList(Arrays.asList(membersArr));

        int totalMembers = members.size();
        System.out.println("Total members: " + totalMembers);
        // Scanner를 이용한 회원 등록
        Scanner scanner = new Scanner(System.in);
        System.out.print("회원 이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("학생 회원입니까? (Y/N): ");
        boolean isStudent = scanner.nextLine().toUpperCase().equals("Y");

        LibraryMember newMember;
        newMember = new LibraryMember(
            name,
            generateMemberId(isStudent, totalMembers),
            (isStudent ? 5 : 3)
        );
        members.add(newMember.toString());
        System.out.println("회원이 등록되었습니다:");
        System.out.println("이름: " + newMember.getName());
        System.out.println("ID: " + newMember.getMemberShipId());
        System.out.println("대출 한도: " + newMember.getBorrowLimit());


    };

    public static String generateMemberId(boolean isStudent, int totalMembers) {
        int memberId = 0;
        memberId = totalMembers + 1;
        String memberIdStr = memberId + "";
        if (isStudent) {
            return "SM" + memberIdStr;
        } else {
            return "LM" + memberIdStr;
        }
    };
}
