import java.util.Scanner;

public class LibraryManagementProgram {
    private static Scanner scanner = new Scanner(System.in);
    private static final String managerID = "0000";
    private static final String managerName = "홍길동";
    private static final String managerPWD = "1234";

    private static TotalLibraryManage libManager = new TotalLibraryManage();
    static Person currentPerson = null;

    public static void main(String[] args) {
        //(N)
        while (true) {
            printMainMenu();
            System.out.print("입력 >> ");
            int selectNum = scanner.nextInt();

            if (selectNum == 1) { //관리자 모드
                //로그인 후 이용가능, 정보가 일치하지 않으면 초기 메뉴로
                System.out.println("-----관리자 모드입니다. 로그인 하십시오.--------------");
                Manager manager = new Manager(managerID, managerName, managerPWD);
                System.out.print("ID : ");
                String ID = scanner.next();
                System.out.print("비밀번호 : ");
                String Password = scanner.next();
                if (manager.getID().equals(ID) && manager.getPassword().equals(Password)) {
                    System.out.println("로그인 되었습니다.");
                } else {
                    System.out.println("관리자 아이디 혹은 비밀번호가 일치하지 않아 초기 화면으로 돌아갑니다.");
                    continue;
                }

                while (true) {
                    //1. 도서관리
                    //2. Logout (currentPerson = null; 후 break;)
                    System.out.println("------------------관리자 모드-------------------");
                    System.out.println("1. 도서 관리 | 2. 로그아웃");
                    System.out.println("-----------------------------------------------");
                    System.out.print("입력 >> ");
                    int managerMode = scanner.nextInt();

                    if (managerMode == 1) {
                        currentPerson = manager;
                        libManager.ManagerRun(currentPerson);
                    } else if (managerMode == 2) {
                        currentPerson = null;
                        break;
                    }
                }
            } else if (selectNum == 2) {//회원 메뉴

                while (true) {
                    //1. 회원 가입
                    //2. 로그인
                    //3. 도서 대출(로그인 후 이용가능 제약)
                    //2. Logout (currentPerson = null; 후 break;)
                    System.out.println("-------------------회원 모드----------------------");
                    System.out.println("1. 회원가입 | 2. 로그인 | 3. 도서대출 | 4. 로그아웃");
                    System.out.println("--------------------------------------------------");
                    System.out.print("입력 >> ");
                    int userMode = scanner.nextInt();


                    if (userMode == 1) {
                        libManager.getMemberManage().signup();
                        System.out.println("회원가입 완료");
                    } else if (userMode == 2) {
                        currentPerson = libManager.getMemberManage().Login();
                        if (currentPerson == null) {
                            System.out.println("로그인 실패!!");
                        } else {
                            System.out.println("로그인 성공!\n");
                        }
                    } else if (userMode == 3) {
                        if (currentPerson == null) {
                            System.out.println("로그인 해야 이용할 수 있습니다.");
                        } else {
                            libManager.MemberRun(currentPerson);
                        }
                    } else if (userMode == 4) {
                        currentPerson = null;
                        break;
                    }

                }
            } else if (selectNum == 3) {//종료
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
        }
    }

    public static void printMainMenu() {
        //(O)
        //메인 메뉴 작성
        System.out.println("-----전북대학교 컴퓨터 공학과 도서관 관리 프로그램입니다.-----");
        System.out.println("1. 관리자 메뉴 | 2. 회원 메뉴 | 3. 종료");
        System.out.println("-----------------------------------------------------------");
    }

    public static void printManagerMenu() {
        //(P)
        //관리자 메뉴 작성
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("1. 전체 도서 목록 출력 | 2. 도서 등록 | 3. 도서 재고 추가 | 4. 회원 목록 보기 | 5.돌아가기");
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public static void printMemberMenu() {
        //(Q)
        //회원 메뉴 작성
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("1. 전체 도서 목록 출력 | 2. 도서 대여 | 3. 도서 반납 | 4. 대여 도서 목록 | 5. 돌아가기");
        System.out.println("-----------------------------------------------------------------------------------");
    }
}



