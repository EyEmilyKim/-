package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.gridExamConsole;
import spring.di.ui.inlineExamConsole;

public class Program {
	
	public static void main(String[] args) {
		
		Exam exam = new NewlecExam();
		ExamConsole console = new inlineExamConsole(exam); //DI
//		ExamConsole console = new gridExamConsole(exam); //DI
		console.print();
	}

}
