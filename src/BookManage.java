import java.util.*;
import java.util.Scanner;

public class BookManage {
    private Scanner scanner;
    private HashMap<String, Book> bookHash;

    public BookManage(){
        this.scanner = new Scanner(System.in);
        this.bookHash = new HashMap<String, Book>();
    }

    void printBookList(){
        //(F)
        // bookHash 에 저장된 모든 도서 정보 출력
    }

    boolean AddBook(){
        //(G)
        // scanner 개체를 통해 도서 정보를 입력 받아 bookHash 에 저장
        // 현재 보유중인 도서가 아닌 도서만 추가 가능하도록 제약 필요
        // 원하는 재고 수량이 0보다 작으면 갱신 불가능 제약 필요
        return false;
    }

    boolean UpdateBookStock(){
        //(H)
        // scanner 를 통해 도서 번호로 bookHash 에 접근하여 재고 업데이트
        // 현재 보유중인 도서만 가능하도록 제약 필요
        // 추가하고자 하는 재고 수량이 0보다 작으면 갱신 불가능 제약 필요

        return false;
    }

    boolean ReturnBook(Member member){
        //(I)
        // 도서 번호를 입력 받아 현재 회원이 대여중인 도서 반납
        // 현재 회원이 대여중인 도서만 반납 가능하도록 제약 필요
        // 재고는 다시 올려줌
        return false;
    }

    boolean RentalBook(Member member){
        //(J)
        // 도서 번호를 입력 받아 현재 도서 대여
        // 도서가 존재하지 않거나 재고가 0개 이면 대여 불가능
        // 대여하는 책의 수량은 1개만 가능
        return  false;
    }
}
