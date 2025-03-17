# Librarian Jake

<요구사항 명세화>  
**미션 2: 회원 대출 한도 계산 기능 구현 (학생용 과제)**
- **입력:** LibraryMember 객체 배열 (기본 회원과 학생 회원 포함)
    #### 객체 배열 필요.
- **처리:**
    1. LibraryMember 클래스를 정의한다.
        - private 멤버 변수: name(String), membershipId(String)
        - 생성자와 getter 메서드를 구현하고, 기본 대출 한도(getBorrowLimit())는 3권을 반환한다.
        #### 멤버 클래스 필요
    2. StudentMember 클래스를 정의하여 LibraryMember를 상속받고, getBorrowLimit()를 오버라이딩하여 5권을 반환하도록 구현한다.
        #### 학생 멤버 클래스 별도 필요.
        #### 오버라이딩 필요.
    3. MemberManager 클래스를 작성하여 LibraryMember 배열을 입력받고, for문을 사용하여 각 회원의 정보를  
       "회원: [name], ID: [membershipId], 대출 한도: [borrowLimit]" 형태의 문자열로 결합한 후,  
       세미콜론(;)으로 구분하여 최종 문자열로 반환한다.
        #### 출력 기능 필요, join 사이 ; 로 구분
- **출력:** 예시 결과:  
  "회원: Alice, ID: LM001, 대출 한도: 3; 회원: Bob, ID: LM002, 대출 한도: 5"
- 
- **목표:** 학생들이 객체지향 기본 개념(클래스, 상속, 메서드 오버라이딩)을 이해하고, 이를 활용하여 간단한 회원 관리 기능을 구현하도록 한다.

<개발 순서>
1. LibraryMember 클래스를 정의하여 private 멤버 변수, 생성자, getter 및 기본 getBorrowLimit() (3권) 메서드를 구현한다.
2. StudentMember 클래스를 정의하여 LibraryMember를 상속하고, getBorrowLimit() 메서드를 오버라이딩하여 5권을 반환하도록 구현한다.
3. MemberManager 클래스를 정의하여 LibraryMember 배열을 입력받고, for문을 사용하여 각 회원의 정보를 문자열로 결합하는 processMembers() 메서드를 구현한다.
4. main() 메서드에서 예제 데이터를 이용하여 결과 문자열을 출력한다.

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
// setter 설정 필요 - Name/Id/limit
        
// 회원 생성
LibraryMember member;
if (isStudent) {
    member = new StudentMember(name, generateStudentId(), 3, 2);
} else {
    member = new LibraryMember(name, generateMemberId(), 3);
}
### GenerateID
// Normal Member, Student Member ID 생성 필요.
// 현재까지 멤버 수 인식.
// 일반 멤버인 경우 LM 시작, 학생 멤버인 경우 SM 시작.
// 뒷자리 숫자는 그냥 전체 멤버 수 + 1 방식.
// 현재 상태에서 학생 생성시 SM006 생성 예정.
// 전체 명단 출력.
// 사서가 특정 회원의 대출 한도 수정

System.out.print("대출 한도를 수정하시겠습니까? (Y/N): ");
if (scanner.nextLine().toUpperCase().equals("Y")) {
    System.out.print("새로운 대출 한도를 입력하세요: ");
    int newLimit = Integer.parseInt(scanner.nextLine());
    member.setBorrowLimit(newLimit);
}
//대출한도 수정 Setter 함수 사용 인터페이스 생성
//이름 기준으로 같은 사람 찾기.
//찾은 후 멤버 대출 한도 변경.

```

