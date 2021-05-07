import java.util.*;
import java.util.Scanner;

public class BookManage {
    private Scanner scanner;
    private HashMap<String, Book> bookHash;

    public BookManage() {
        this.scanner = new Scanner(System.in);
        this.bookHash = new HashMap<String, Book>();
    }

    void printBookList() {
        //(F)
        // bookHash 에 저장된 모든 도서 정보 출력
        bookHash.forEach((key,value)->{
            System.out.println("도서번호 : " + bookHash.get(key).getBookNumber() + ", " + "도서 명 : " + bookHash.get(key).getName()
                    + ", " + "도서 장르 : " + bookHash.get(key).getGenre() + ", " + "재고 : " + bookHash.get(key).getStock());
        });


    }

    boolean AddBook() {
        //(G)
        // scanner 개체를 통해 도서 정보를 입력 받아 bookHash 에 저장
        // 현재 보유중인 도서가 아닌 도서만 추가 가능하도록 제약 필요
        // 원하는 재고 수량이 0보다 작으면 갱신 불가능 제약 필요

        System.out.print("도서 번호 : ");
        String bookNumber = scanner.next();
        if (!bookHash.containsKey(bookNumber)) {
            try {
                if (bookHash.get(bookNumber).getStock() >= 0) {
                    System.out.print("도서 이름 : ");
                    String bookName = scanner.next();
                    System.out.print("도서 장르 : ");
                    String bookGenre = scanner.next();
                    System.out.print("도서 수량 : ");
                    int bookStock = scanner.nextInt();
                    Book book = new Book(bookNumber, bookName, bookGenre, bookStock);
                    bookHash.put(bookNumber, book);
                }else{
                    System.out.println("갱신 불가능.\n");
                    return false;
                }
            }catch (NullPointerException e){
                System.out.print("도서 이름 : ");
                String bookName = scanner.next();
                System.out.print("도서 장르 : ");
                String bookGenre = scanner.next();
                System.out.print("도서 수량 : ");
                int bookStock = scanner.nextInt();
                Book book = new Book(bookNumber, bookName, bookGenre, bookStock);
                bookHash.put(bookNumber, book);
            }
        } else {
            System.out.println("현재 보유중인 도서 입니다.\n");
            return false;
        }
        return true;
    }

    boolean UpdateBookStock() {
        //(H)
        // scanner 를 통해 도서 번호로 bookHash 에 접근하여 재고 업데이트
        // 현재 보유중인 도서만 가능하도록 제약 필요
        // 추가하고자 하는 재고 수량이 0보다 작으면 갱신 불가능 제약 필요
        System.out.print("추가하고자 하는 도서 번호 : ");
        String bookNumber = scanner.next();
        if (bookHash.containsKey(bookNumber)) {
            //기존 수량
            int originalStock = bookHash.get(bookNumber).getStock();
            //추가
            System.out.print("추가하고자 하는 수량 : ");
            int bookStock = scanner.nextInt();
            bookHash.get(bookNumber).updateStock(bookStock);
            //추가한 후의 수량
            int updateStock = bookHash.get(bookNumber).getStock();
            System.out.println("[도서번호 : " + bookNumber + "] + [도서명 : "+bookHash.get(bookNumber).getName()+"]의 수량이 "
                    +originalStock+"에서 "+updateStock+"로 증가되었습니다.");
            if (bookStock < 0) {
                System.out.println("추가하고자 하는 재고 수량이 0보다 작아 갱신 불가능.\n");
                return false;
            }
        } else {
            System.out.println("현재 보유중인 도서가 아닙니다.\n");
            return false;
        }
        return true;
    }

    boolean ReturnBook(Member member) {
        //(I)
        // 도서 번호를 입력 받아 현재 회원이 대여중인 도서 반납
        // 현재 회원이 대여중인 도서만 반납 가능하도록 제약 필요
        // 재고는 다시 올려줌

        System.out.print("도서 번호 : ");
        String bookNumber = scanner.next();
        if (member.getBookHash().containsKey(bookNumber)) {
            bookHash.get(bookNumber).AddStock();
            System.out.println("[도서번호 : "+ bookNumber +"]"+" + "+"[도서명 : "+ member.getBookHash().get(bookNumber).getName()+
                    "]이 정상적으로 반납되었습니다.\n");
            member.getBookHash().remove(bookNumber, bookHash.get(bookNumber));
            return true;
        }else{
            System.out.println("대여중인 도서가 아닙니다.");
            return false;
        }
    }

    boolean RentalBook(Member member) {
        //(J)
        // 도서 번호를 입력 받아 현재 도서 대여
        // 도서가 존재하지 않거나 재고가 0개 이면 대여 불가능
        // 대여하는 책의 수량은 1개만 가능
        System.out.print("도서 번호 : ");
        String bookNumber = scanner.next();
        if (bookHash.containsKey(bookNumber) && bookHash.get(bookNumber).getStock() > 0) {
            bookHash.get(bookNumber).SubstractStock();
            System.out.println("[도서번호 : "+ bookNumber +"]"+" + "+"[도서명 : "+ bookHash.get(bookNumber).getName()+
                    "]이 정상적으로 대여되었습니다.\n");
            try{
                member.bookHash.put(bookNumber, bookHash.get(bookNumber));
            }catch (NullPointerException n){
                HashMap<String, Book> hashMap = new HashMap<>();
                hashMap.put(bookNumber, bookHash.get(bookNumber));
                member.bookHash = hashMap;
            }
            return true;
        }else{
            System.out.println("도서가 존재하지 않거나 재고가 없어 대여 불가능");
            return false;
        }
    }


}
