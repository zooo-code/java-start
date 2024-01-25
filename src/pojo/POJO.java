package pojo;

public class POJO {
    // 아래는 POJO(Plain Old Java Object)의 예시입니다. Student라는 클래스를 정의하고,
    // name과 age라는 프로퍼티를 가지고 있습니다.
    // 각 프로퍼티에 대해 getter와 setter 메소드를 제공하며,
    // 특정 프레임워크나 인터페이스에 종속되지 않는 단순한 자바 객체입니다.
    public class Student {
        private String name;
        private int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
