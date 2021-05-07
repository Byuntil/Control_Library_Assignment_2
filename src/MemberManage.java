import java.util.*;
import java.util.Scanner;

public class MemberManage {
    private Scanner scanner;
    private HashMap<String, Member> memberHash;

    public MemberManage() {
        this.scanner = new Scanner(System.in);
        this.memberHash = new HashMap<String, Member>();
    }

    public void signup() {
        /*
          (K)
         회원 ID, 이름, 비밀번호를 입력받아 memberHash 에 추가
         루프를 돌면서 ID가 이미 존재하면 "이미 존재하는 ID 입니다" 출력후
         재입력, 재입력된 ID 가 중복되지 않으면 루프 탈출
        */

        while(true) {
            System.out.print("ID : ");
            String userID = scanner.next();
            if (!memberHash.containsKey(userID)) {
                System.out.print("이름 : ");
                String userName = scanner.next();
                System.out.print("비밀번호 : ");
                String userPassword = scanner.next();
                Member member = new Member(userID, userName, userPassword);
                memberHash.put(userID, member);
                break;
            } else {
                System.out.println("이미 존재하는 ID 입니다.");
            }
        }
    }

    public Member Login() {
        Member member = null;
        /*
         (L)
         ID가 존재하지 않거나 비밀번호가 틀릴 경우 메시지 출력후 null 반환
         로그인 성공 시 해당 멤버 객체 반환
        */
        System.out.print("ID : ");
        String userID = scanner.next();
        System.out.print("비밀번호 : ");
        String userPassword = scanner.next();
        if(memberHash.containsKey(userID) && memberHash.get(userID).getPassword().equals(userPassword)){
            member = memberHash.get(userID);
            return member;
        }else{
            return member;
        }

    }

    public void PrintMemberList() {
        /*
         (M)
         memberHash 로부터 회원 리스트 출력
        */
        memberHash.forEach((key, value)->{
            System.out.println("ID : "+memberHash.get(key).getID()+", "+"이름 : "+memberHash.get(key).getName());
        });

    }
}
