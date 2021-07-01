package com.itwn.test.examtest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test02 {
	public static void main(String[] args) {
		Map<Student,Score> map=new HashMap<>();
		map.put(new Student(1,"张三"),new Score(90,80,60));
		map.put(new Student(2,"李四"),new Score(70,56,45));
		map.put(new Student(1,"张三"),new Score(90,80,60));
		System.out.println(new Student(1,"张三").hashCode());
		System.out.println(new Student(1,"张三").hashCode());

		for (Student s:map.keySet() ){
			System.out.println(s.hashCode());
			System.out.println(s+""+map.get(s));
		}


		Set<StudentScore> set=new HashSet<>();
		set.add(new StudentScore(new Student(1,"张三"),new Score(90,80,60)));
		set.add(new StudentScore(new Student(2,"李四"),new Score(70,56,45)));
		set.add(new StudentScore(new Student(1,"张三"),new Score(90,80,60)));
		for (StudentScore s:set){
			System.out.println(s.hashCode());
		}
		System.out.println(set);

	}
}
class StudentScore {
	private Student student;
	private Score score;

	public StudentScore(Student student, Score score) {
		this.student = student;
		this.score = score;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StudentScore)) return false;

		StudentScore that = (StudentScore) o;

		if (student != null ? !student.equals(that.student) : that.student != null) return false;
		return score != null ? score.equals(that.score) : that.score == null;
	}

	@Override
	public int hashCode() {
		int result = student != null ? student.hashCode() : 0;
		result = 31 * result + (score != null ? score.hashCode() : 0);
		return result;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Scores{" +
				"student=" + student +
				", score=" + score +
				'}'+"\n";
	}
}


class Student{
	private Integer id;
	private String name;

	public Student() {
	}

	public Student(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Student)) return false;

		Student student = (Student) o;

		if (id != null ? !id.equals(student.id) : student.id != null) return false;
		return name != null ? name.equals(student.name) : student.name == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
class Score{
	private Integer chinese;
	private Integer math;
	private  Integer english;

	public Score() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Score)) return false;

		Score score = (Score) o;

		if (chinese != null ? !chinese.equals(score.chinese) : score.chinese != null) return false;
		if (math != null ? !math.equals(score.math) : score.math != null) return false;
		return english != null ? english.equals(score.english) : score.english == null;
	}

	@Override
	public int hashCode() {
		int result = chinese != null ? chinese.hashCode() : 0;
		result = 31 * result + (math != null ? math.hashCode() : 0);
		result = 31 * result + (english != null ? english.hashCode() : 0);
		return result;
	}

	public Score(Integer chinese, Integer math, Integer english) {
		this.chinese = chinese;
		this.math = math;
		this.english = english;
	}

	public Integer getChinese() {
		return chinese;
	}

	public void setChinese(Integer chinese) {
		this.chinese = chinese;
	}

	public Integer getMath() {
		return math;
	}

	public void setMath(Integer math) {
		this.math = math;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	@Override
	public String toString() {
		return "Score{" +
				"chinese=" + chinese +
				", math=" + math +
				", english=" + english +
				'}';
	}
}
