package ss9_danh_sach.bai_tap.trien_khai_cac_phuong_thuc_cua_array_list_theo_thu_vien;

public class MyArrayListTest {
    public static class Student{
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        Student a = new Student(1,"hung");
        Student b = new Student(2,"hh");
        Student c = new Student(3,"h");
        Student d = new Student(4,"hun");
        Student f = new Student(5,"hu");
        Student e = new Student(10,"kin");

        MyArrayList<Student> studentMyArrayList=new MyArrayList<>();

        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(f);

        for(int i=0;i<studentMyArrayList.getSize();i++){
            Student student= (Student) studentMyArrayList.elements[i];
            System.out.println(student.getName());
            System.out.println(student.getId());
        }
        System.out.println(studentMyArrayList.getSize());
        studentMyArrayList.add(e,5);
        studentMyArrayList.ensureCapacity(3);
        studentMyArrayList.get(3);

        System.out.println("----------------------------------");

        for(int i=0;i<studentMyArrayList.getSize();i++){
            Student student= (Student) studentMyArrayList.elements[i];
            System.out.println(student.getName());
            System.out.println(student.getId());
        }
        System.out.println(studentMyArrayList.getSize());
    }
}
