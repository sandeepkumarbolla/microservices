package Model;

public class Subjects {
    private int maths;
    private int english;
    private int science;
    private int computers;

    public Subjects(int maths, int english, int science, int computers) {
        this.maths = maths;
        this.english = english;
        this.science = science;
        this.computers = computers;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getComputers() {
        return computers;
    }

    public void setComputers(int computers) {
        this.computers = computers;
    }



    @Override
    public String toString() {
        return "Subjects{" +
                "maths=" + maths +
                ", english=" + english +
                ", science=" + science +
                ", computers=" + computers +
                '}';
    }
}
