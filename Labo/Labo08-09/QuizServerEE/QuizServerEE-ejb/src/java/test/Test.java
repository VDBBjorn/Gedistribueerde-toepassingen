/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Question;
import domain.Quiz;

/**
 *
 * @author bjorn
 */
public class Test {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Question q = quiz.getQuestion();
    }
}
