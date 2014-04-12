package ohtu;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Submission {
    private String student_number;
	private int week;
	private int hours;
	private Boolean a1;
	private Boolean a2;
	private Boolean a3;
	private Boolean a4;
	private Boolean a5;
	private Boolean a6;
	private Boolean a7;
	private Boolean a8;
	private Boolean a9;
	private Boolean a10;
	private Boolean a11;
	private Boolean a12;
	private Boolean a13;
	private Boolean a14;
	private Boolean a15;
	private Boolean a16;
	private Boolean a17;
	private Boolean a18;
	private Boolean a19;
	private Boolean a20;
	private Boolean a21;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
	
	public int getHours() {
		return hours;
	}
	
	private boolean[] allExercisesDone() {
		boolean[] exercisesDone = new boolean[20];
		for(int i = 1; i <= 21; i++) {
			try {
				Field field = this.getClass().getDeclaredField("a" + i);
				Boolean done = (Boolean) field.get(this);
				if(done != null && done) {
					exercisesDone[i - 1] = true;
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return exercisesDone;
	}
	
	private String exercisesDoneAsString() {
		String exercisesDone = "";
		boolean[] done = allExercisesDone();
		for(int i = 0; i < done.length; i++) {
			if(done[i]) exercisesDone += " " + (i + 1);
		}
		return exercisesDone;
	}
	
	public int numberOfExercisesDone() {
		int exercisesDone = 0;
		boolean[] done = allExercisesDone();
		for(int i = 0; i < done.length; i++) {
			if(done[i]) exercisesDone++;
		}
		return exercisesDone;
	}

    @Override
    public String toString() {
        return " viikko " + week + ": tehtyjä tehtäviä yhteensä: " + numberOfExercisesDone() + ", aikaa kului " + hours  + "tuntia, tehdyt tehtävät:" + exercisesDoneAsString();
    }
    
}