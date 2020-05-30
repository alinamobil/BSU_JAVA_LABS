package student;

public class zaochnik extends student.Student {
    private String type;

    public zaochnik(String surname_new, String name_new, int course_new, int group_new, String typeName) {
        super(surname_new, name_new, course_new, group_new);
        this.type = typeName;
    }

    public void showInfo() {
        System.out.println("Фамилия: " + this.getSurname() + "\nИмя: " + this.getName() + "\nКурс: " + this.getCourse() + "\nГруппа: " + this.getGroup() + "\nФорма обучения: " + this.type + "\n------------------------------");
    }

    public void searchBySurname(String surname_b) {
        if (surname_b.equals(this.getSurname())) {
            this.showInfo();
        }

    }

    public void searchByCourse(int course_b) {
        if (course_b == (this.getCourse())) {
            this.showInfo();
        }

    }

    public void searchType(String type_b) {
        if (type_b.equals(this.type)) {
            this.showInfo();
        }

    }
}