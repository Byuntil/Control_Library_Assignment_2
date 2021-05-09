import java.util.*;

public class Member extends Person {
    HashMap<String, Book> bookHash; //대여 중인 도서를 저장하는 hash

    //(B)
    // 생성자 구현
    public Member(String ID, String name, String password) {
        super(ID, name, password);
    }

    HashMap<String, Book> getBookHash() {
        return bookHash;
    }

    void PrintRentalList() {
        //(C)
        // 대출 중인 도서를 출력
        bookHash.forEach((key, value) -> {
            System.out.println("도서번호 : " + getBookHash().get(key).getBookNumber() + ", " + "도서 명 : "
                    + getBookHash().get(key).getName() + ", " + "도서 장르 : " + getBookHash().get(key).getGenre());
        });
    }
}
