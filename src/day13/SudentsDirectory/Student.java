package day13.SudentsDirectory;

public class Student {
    String name;
    String group;
    String studentId;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public boolean isId(String studentId) {
        if (this.studentId == null) {
            return false;
        }
        return this.studentId.equals(studentId);
    }

    public Student addStudent(String name, String group, String studentId) throws Exception {
        if (isId(studentId)) {
            System.out.println("Error");
            return null;
        } else {
            try {
                setName(name);
                setGroup(group);
                setStudentId(studentId);
                return this;
            } catch (Exception e) {
                System.out.println("Error studentId");
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return "\t - '" + name + '\'' +
                ", '" + group + '\'' +
                ", '" + studentId + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return studentId.hashCode();
    }

}