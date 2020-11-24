package entity;


public class Grade{
    //成绩id
    private int grade_id;
    //用户id
    private int user_id;
    //科目
    private String paper;
    //得分
    private int score;
    //考试时间
    private String time;

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_id=" + grade_id +
                ", user_id=" + user_id +
                ", paper='" + paper + '\'' +
                ", score=" + score +
                ", time='" + time + '\'' +
                '}';
    }
}
