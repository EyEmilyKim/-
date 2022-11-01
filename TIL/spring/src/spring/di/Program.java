package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.gridExamConsole;
import spring.di.ui.inlineExamConsole;

public class Program {
	
	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코드를 변경
		Exam exam = new NewlecExam();
		ExamConsole console = new gridExamConsole();
		
		console.setExam(exam);
		*/
		
		ExamConsole console;
		console.print();
	}

}
