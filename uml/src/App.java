import family.Parent;

public class App {

    public static void main(String[] args) {
        Parent parent = new Parent(1, 2, 3);
        System.out.println(parent.itemPrivate);
        System.out.println(parent.itemProtected);
        System.out.println(parent.itemPublic);
    }
}



