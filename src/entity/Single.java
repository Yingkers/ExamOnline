package entity;

public class Single{
    //单选题id
    private int single_id;
    //题
    private String subject;
    //选项A
    private String option_A;
    //选项B
    private String option_B;
    //选项C
    private String option_C;
    //选项D
    private String option_D;
    //答案
    private String answer;
    //科目
    private String paper;

    public int getSingle_id() {
        return single_id;
    }

    public void setSingle_id(int single_id) {
        this.single_id = single_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOption_A() {
        return option_A;
    }

    public void setOption_A(String option_A) {
        this.option_A = option_A;
    }

    public String getOption_B() {
        return option_B;
    }

    public void setOption_B(String option_B) {
        this.option_B = option_B;
    }

    public String getOption_C() {
        return option_C;
    }

    public void setOption_C(String option_C) {
        this.option_C = option_C;
    }

    public String getOption_D() {
        return option_D;
    }

    public void setOption_D(String option_D) {
        this.option_D = option_D;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    @Override
    public String toString() {
        return "SingleDao{" +
                "single_id=" + single_id +
                ", subject='" + subject + '\'' +
                ", option_A='" + option_A + '\'' +
                ", option_B='" + option_B + '\'' +
                ", option_C='" + option_C + '\'' +
                ", option_D='" + option_D + '\'' +
                ", answer='" + answer + '\'' +
                ", paper='" + paper + '\'' +
                '}';
    }
}
