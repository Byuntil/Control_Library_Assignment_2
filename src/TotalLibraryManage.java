import java.util.Scanner;

public class TotalLibraryManage {
    MemberManage memberManage;
    BookManage bookManage;

    private Scanner scanner;

    public TotalLibraryManage() {
        memberManage = new MemberManage();
        bookManage = new BookManage();
        scanner = new Scanner(System.in);
    }

    public MemberManage getMemberManage() {
        return memberManage;
    }

    public BookManage getBookManage() {
        return bookManage;
    }

    public void ManagerRun(Person person) {
        //관리자
        //(D)
        //루프를 돌면서 관리자 기능 수행
        // 1. 전체 도서 목록 출력
        // 2. 도서 등록
        // 3. 도서 재고 추가
        // 4. 회원 목록 보기
        // 5. 돌아가기(루프탈출)
        boolean bool = true;
        while (bool) {
            LibraryManagementProgram.printManagerMenu();
            System.out.print("<선택> ");
            int mangerRunMenu = scanner.nextInt();
            switch (mangerRunMenu) {
                case 1 -> getBookManage().printBookList();
                case 2 -> {
                    if (!getBookManage().AddBook()) {
                        bool = false;
                    } else {
                        continue;
                    }
                }
                case 3 -> {
                    if (!getBookManage().UpdateBookStock()) {
                        bool = false;
                    } else {
                        continue;
                    }
                }
                case 4 -> getMemberManage().PrintMemberList();
                case 5 -> {
                    System.out.println("이전화면으로 돌아갑니다.");
                    bool = false;
                }
            }
        }
    }

    public void MemberRun(Person person) {
        //회원
        //(E)
        //루프를 돌면서 회원 기능 수행
        // 1. 전체 도서 목록 출력
        // 2. 도서 대여
        // 3. 도서 반납
        // 4. 대여 도서 목록
        // 5. 돌아가기(루프 탈출)
        boolean bool = true;
        while (bool) {
            LibraryManagementProgram.printMemberMenu();
            System.out.print("<선택> ");
            int memberRunMenu = scanner.nextInt();
            switch (memberRunMenu) {
                case 1 -> getBookManage().printBookList();
                case 2 -> {
                    if (!getBookManage().RentalBook(((Member) person))) {
                        bool = false;
                    } else {
                        continue;
                    }
                }
                case 3 -> {
                    if (!getBookManage().ReturnBook((Member) person)) {
                        bool = false;
                    } else {
                        continue;
                    }
                    ;
                }
                case 4 -> {
                    Member member = (Member) person;
                    member.PrintRentalList();
                }
                case 5 -> {
                    System.out.println("이전화면으로 돌아갑니다.");
                    bool = false;
                }
            }
        }
    }
}
