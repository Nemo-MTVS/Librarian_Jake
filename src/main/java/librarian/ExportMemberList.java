package librarian;

public class ExportMemberList {
    private List<LibraryMember> members = new ArrayList<>();

    public ExportMemberList(List<LibraryMember> members) {
        this.members = members;
    }

    public String exportMemberList() {
        StringBuilder sb = new StringBuilder();
        int totalMembers = 0;
        totalMembers = members.size();
        if (totalMembers > 0) {
            for (int i = 0; i < totalMembers; i++) {
                if (i == 0) {
                    sb.append(buildMemberInfo(members.get(i)));
                } else {
                    sb.append("; " + buildMemberInfo(members.get(i)));
                }
            }
        } else {
            return "No Members";
        }
        return sb.toString();
    }

    private String buildMemberInfo(LibraryMember member) {
        StringBuilder sb = new StringBuilder();
        sb.append(member.getName() + ", "
                + member.getMemberShipId() + ", "
                + member.getBorrowLimit());
        return sb.toString();
    };
}
