public class Person {
    private String ID;
    private String name;
    private String password;

    public Person(String ID, String name, String password){
        this.ID = ID;
        this.name = name;
        this.password = password;
    }

    public String getID() {return ID;}
    public String getName() {return name;}
    public String getPassword(){return password;}

    public void setID(String id){this.ID = ID;}
    public void setName(String name){this.name = name;}
    public void setPassword(String password){this.password = password;}
}
