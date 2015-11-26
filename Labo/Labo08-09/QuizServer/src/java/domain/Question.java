package domain;

/**
 *
 * @author Bjorn Vandenbussche
 */
public class Question {

    private final int id;
    private final String question, answer;

    public Question(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isCorrect(String myAnswer) {
        return answer.equals(myAnswer);
    }

}