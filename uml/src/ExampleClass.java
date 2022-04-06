public class ExampleClass {
    private static int count;
    private String name;

    public ExampleClass() {
        count++;
    }

    public ExampleClass(String name) {
        this.name = name;
        count++;
    }

    public static int getInstanceCount() {
        return count;
    }
}



