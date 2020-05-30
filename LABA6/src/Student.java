package student;

abstract class Student implements student.Abiturient {
    private String surname;
    private String name;
    private int course;
    private int group;

    Student(String surname_new, String name_new, int course_new, int group_new) {
        this.surname = surname_new;
        this.name = name_new;
        this.course = course_new;
        this.group = group_new;
    }

    int getCourse() {
        return this.course;
    }

    String getSurname() {
        return this.surname;
    }

    String getName() {
        return this.name;
    }

    int getGroup() {
        return this.group;
    }

    public abstract void searchType(String var1);
}