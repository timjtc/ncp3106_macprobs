package com.uecpe20231122784.macprob6;

import java.util.Arrays;

import com.uecpe20231122784.lib.input;
import com.uecpe20231122784.lib.print;

public class macprob6_problem2 {
    
    public static void main(String[] args) {
            
            // Create WrittenExam instance
            WrittenExam exam = new WrittenExam(new String[] {
                "B", "D", "A", "A", "C",
                "A", "B", "A", "C", "D",
                "B", "C", "D", "A", "D",
                "C", "C", "B", "D", "A"
            });
    
            // Get examinee answers from user
            for (int i = 0; i < exam.getAnswerKey().length; i++) {
    
                print.s("Enter answer for question " + (i + 1) + ": ");
                try {
                    exam.setExamineeResponse(i + 1, (String) input.wait("string"));
                } catch (IllegalArgumentException e) {
                    print.ln("(!) ERROR: " + e.getMessage());
                    i--;
                }
            }
            
            // Print exam results with given data
            print.ln(
                "----------------------------------------\n" +
                "Exam results:"
            );
            print.ln(" Passed: " + (exam.passed() ? "Yes" : "No"));
            print.ln(" Total correct responses: " + exam.totalCorrect());
            print.ln(" Total incorrect responses: " + exam.totalIncorrect());
            print.ln(" Questions missed: " + 
                Arrays.toString(exam.questionsMissed())
                .replace("[]", "")
                .replace("[1", "#1")
                .replace("]", "")
                .replace(", ", ", #")
                .replace("[", "#")
            );
    }

}
