package librarian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<LibraryMember> members = new ArrayList<>();
        
        // Add initial members
        addMemberAndPrint(members, new LibraryMember("Jake", "LM001", 3));
        addMemberAndPrint(members, new LibraryMember("Lyn", "LM002", 3));
        addMemberAndPrint(members, new LibraryMember("Kyle", "LM003", 3));
        addMemberAndPrint(members, new StudentMember("Alan", "SM004", 3, 2));
        addMemberAndPrint(members, new StudentMember("Bob", "SM005", 3, 2));

        int totalMembers = members.size();
        System.out.println("Total members: " + totalMembers);

        // Scanner를 이용한 회원 등록
        Scanner scanner = new Scanner(System.in);
        System.out.print("회원 이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("학생 회원입니까? (Y/N): ");
        boolean isStudent = scanner.nextLine().toUpperCase().equals("Y");

        LibraryMember newMember;
        if (isStudent) {
            newMember = new StudentMember(name, generateMemberId(isStudent, totalMembers), 3, 2);
        } else {
            newMember = new LibraryMember(name, generateMemberId(isStudent, totalMembers), 3);
        }
        addMemberAndPrint(members, newMember);
    }

    private static void addMemberAndPrint(List<LibraryMember> members, LibraryMember member) {
        members.add(member);
        System.out.println("회원이 등록되었습니다:");
        System.out.println("이름: " + member.getName());
        System.out.println("ID: " + member.getMemberShipId());
        System.out.println("대출 한도: " + member.getBorrowLimit());
    }

    public static String generateMemberId(boolean isStudent, int totalMembers) {
        int memberId = totalMembers + 1;
        String memberIdStr = String.valueOf(memberId);
        return (isStudent ? "SM" : "LM") + memberIdStr;
    }
}
