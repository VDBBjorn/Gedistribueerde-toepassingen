/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Question;
import domain.Quiz;

/**
 *
 * @author bjorn
 */
public class test {
    public static void main(String [] args) {        
        Quiz quiz = new Quiz();
        Question q = quiz.getQuestion();
        //System.out.println(q.getQuestion());
    }
    
}
