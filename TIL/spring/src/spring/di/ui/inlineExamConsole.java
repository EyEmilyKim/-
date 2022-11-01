package spring.di.ui;

import spring.di.entity.Exam;

public class inlineExamConsole implements ExamConsole {

	private Exam exam;
	
	public inlineExamConsole() {
		// TODO Auto-generated constructor stub
	}
	
	public inlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}
	
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
