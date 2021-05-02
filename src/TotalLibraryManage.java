import java.util.Scanner;

public class TotalLibraryManage {
    MemberManage memberManage;
    BookManage bookManage;

    private Scanner scanner;

    public TotalLibraryManage(){
        memberManage = new MemberManage();
        bookManage = new BookManage();
        scanner = new Scanner(System.in);
    }

    public MemberManage getMemberManage(){return memberManage;}

    public BookManage getBookManage(){return bookManage;}

    public void ManagerRun(Person person){
        //관리자
        //(D)
        //루프를 돌면서 관리자 기능 수행
        // 1. 전체 도서 목록 출력
        // 2. 도서 등록
        // 3. 도서 재고 추가
        // 4. 회원 목록 보기
        // 5. 돌아가기(루프탈출)
    }

    public void MemberRun(Person person){
        //회원
        //(E)
        //루프를 돌면서 회원 기능 수행
        // 1. 전체 도서 목록 출력
        // 2. 도서 대여
        // 3. 도서 반납
        // 4. 대여 도서 목록
        // 5. 돌아가기(루프 탈출)
    }
}
