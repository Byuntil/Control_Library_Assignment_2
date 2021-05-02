import java.util.Scanner;

public class LibraryManagementProgram {
    private static Scanner scanner = new Scanner(System.in);
    private static final String managerID = "000";
    private static final String managerName = "홍길동";
    private static final String managerPWD = "1234";

    private static TotalLibraryManage libManager = new TotalLibraryManage();
    static  Person currentPerson = null;

    public static void main(String[] args){
        //(N)
        while(true){
            printMainMenu();
            System.out.print("입력 >> ");
            int selectNum = scanner.nextInt();

            if(selectNum == 1){ //관리자 모드
                //로그인 후 이용가능, 정보가 일치하지 않으면 초기 메뉴로
                while{
                    //1. 도서관리
                    //2. Logout (currentPerson = null; 후 break;)
                }
            }else if(selectNum == 2){//회원 메뉴
                while{
                    //1. 회원 가입
                    //2. 로그인
                    //3. 도서 대출(로그인 후 이용가능 제약)
                    //2. Logout (currentPerson = null; 후 break;)
                }
            }else if(selectNum == 3){//종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    public static void printMainMenu(){
        //(O)
        //메인 메뉴 작성
    }

    public static void printManagerMenu(){
        //(P)
        //관리자 메뉴 작성
    }

    public static void printMemberMenu(){
        //(Q)
        //회원 메뉴 작성
    }
}



