package linearsearch;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Student target = obj instanceof Student ? ((Student) obj) : null;
        if (target == null) {
            return false;
        }
        return this.name.equals(target.name);
    }
}
