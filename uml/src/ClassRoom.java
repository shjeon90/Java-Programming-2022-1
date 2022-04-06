public class ClassRoom {

    private Professor prof;
    private Assistant assist;
    private Student[] stu;
    private PC[] desktops;

    public ClassRoom(Student student) {
        this.stu = new Student[100];
        this.desktops = new PC[40];
        this.stu[0] = student;
        this.desktops[0] = new PC();
    }

    public void showData() {
        System.out.println(this.stu[0].getName());
        System.out.println(this.stu[0].getAge());
    }
}


