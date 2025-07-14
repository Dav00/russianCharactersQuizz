package org.davodas.russianlearningprocess.model;

import java.util.List;

public class QuizQuestion {
    private String russianCharacter;
    private List<String> options;
    private String rightAnswer;

    public QuizQuestion(String russianCharacter, List<String> options, String rightAnswer) {
        this.russianCharacter = russianCharacter;
        this.options = options;
        this.rightAnswer = rightAnswer;
    }

    public String getRussianCharacter() {
        return russianCharacter;
    }

    public void setRussianCharacter(String russianCharacter) {
        this.russianCharacter = russianCharacter;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
