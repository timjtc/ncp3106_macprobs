package com.uecpe20231122784.macprob6;

public class WrittenExam {
    
    private String[] answer_key;
    private String[] examinee_answers;

    public WrittenExam(String[] answer_key) {
        for (String answer : answer_key) {
            if (validateAnswer(answer)) {
                this.answer_key = answer_key;
                this.examinee_answers = new String[answer_key.length];
            }
        }
    }

    public int totalCorrect() {
        int total = 0;
        for (int i = 0; i < answer_key.length; i++) {
            if (answer_key[i].equalsIgnoreCase(examinee_answers[i])) {
                total++;
            }
        }
        return total;
    }

    public int totalIncorrect() {
        return answer_key.length - totalCorrect();
    }

    public boolean passed() {
        return totalCorrect() >= 15;
    }

    public int[] questionsMissed() {
        int[] missed = new int[totalIncorrect()];
        int missed_counter = 0;
        for (int i = 0; i < answer_key.length; i++) {
            if (!answer_key[i].equalsIgnoreCase(examinee_answers[i]))  {
                missed[missed_counter] = i + 1;
                missed_counter++;
            }
        }
        return missed;
    }

    public String[] getAnswerKey() {
        return answer_key;
    }

    public String[] getExamineeAnswers() {
        return examinee_answers;
    }

    public void setCorrectAnswer(int question, String answer) {
        if (validateQuestionIndex(question) && validateAnswer(answer)) {
            answer_key[question - 1] = answer;
        }
    }

    public void setExamineeResponse(int question, String answer) {
        if (validateQuestionIndex(question) && validateAnswer(answer)) {
            examinee_answers[question - 1] = answer;
        }
    }

    private boolean validateAnswer(String answer) {
        if (!answer.equalsIgnoreCase("a") && !answer.equalsIgnoreCase("b") && !answer.equalsIgnoreCase("c") && !answer.equalsIgnoreCase("d")) {
            throw new IllegalArgumentException("Answer must be A, B, C, or D");
        }
        else {
            return true;
        }
    }

    private boolean validateQuestionIndex(int question) {
        if (question > answer_key.length || question < 1) {
            throw new IllegalArgumentException("Question number must be between 1 and " + answer_key.length);
        }
        else {
            return true;
        }
    }

}
