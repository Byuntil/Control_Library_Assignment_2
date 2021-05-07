public class Manager extends Person {
    //(A)
    // 상위 클래스 생성자 호출
    public Manager(String ID, String name, String password) {
        super(ID, name, password);
    }
}
