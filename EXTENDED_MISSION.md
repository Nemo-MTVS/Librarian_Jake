# 확장 미션: 회원 관리 시스템 고도화

## 회원 관리 기능

### 회원 등록 시스템
- **자동 회원 ID 생성**
  - 일반 회원: "LM" + 3자리 숫자 (예: LM001)
  - 학생 회원: "ST" + 3자리 숫자 (예: ST001)
  - ID는 순차적으로 자동 할당

### 회원 유형별 대출 한도
1. **일반 회원**
   - 기본 대출 한도: 3권
   - 개별 회원별로 한도 조정 가능

2. **학생 회원**
   - 기본 대출 한도: 3권
   - 추가 대출 한도: 2권
   - 총 기본 한도: 5권
   - 개별 학생별로 한도 조정 가능

### 회원 정보 관리
- 이름
- 회원 ID (자동 생성)
- 회원 유형 (일반/학생)
- 현재 대출 한도
- 등록일

### 구현 예시
```java
// Scanner를 이용한 회원 등록 예시
Scanner scanner = new Scanner(System.in);

System.out.print("회원 이름을 입력하세요: ");
String name = scanner.nextLine();

System.out.print("학생 회원입니까? (Y/N): ");
boolean isStudent = scanner.nextLine().toUpperCase().equals("Y");

// 회원 생성
LibraryMember member;
if (isStudent) {
    member = new StudentMember(name, generateStudentId(), 3, 2);
} else {
    member = new LibraryMember(name, generateMemberId(), 3);
}

// 사서가 특정 회원의 대출 한도 수정
System.out.print("대출 한도를 수정하시겠습니까? (Y/N): ");
if (scanner.nextLine().toUpperCase().equals("Y")) {
    System.out.print("새로운 대출 한도를 입력하세요: ");
    int newLimit = Integer.parseInt(scanner.nextLine());
    member.setBorrowLimit(newLimit);
}
```
