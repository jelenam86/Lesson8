package exercises;

import java.util.Arrays;

/* 
 * 1. Make the JobCandidate class implement Comparable.  
 * 2. Add a JobCandadate instance that represents yourself, and use compareTo() to see who should be given the job.
 * 
 */

import java.util.List;

public class JobCandidate implements Comparable<JobCandidate> {

	private List<String> personalityTraits;
	private int hoursSpentCoding;
	private String teacherName;
	private int salaryRequired;

	public JobCandidate(List<String> personalityTraits, int hoursSpentCoding, String teacherName, int salaryRequired) {
		super();
		this.personalityTraits = personalityTraits;
		this.hoursSpentCoding = hoursSpentCoding;
		this.teacherName = teacherName;
		this.salaryRequired = salaryRequired;
	}

	public static void main(String[] args) {
		JobCandidate june = new JobCandidate(Arrays.asList(new String[] { "adaptable", "scatty", "curious" }), 650,
				"Vinny Wade", 1200000);
		JobCandidate me = new JobCandidate(
				Arrays.asList(new String[] { "fast-learner", "goal-oriented", "persistant" }), 60, "June Clark",
				100000);

		if (me.compareTo(june) >= 0)
			System.out.println("Awesome! Maybe you can get a job somewhere...");
		else
			System.out.println("Sorry. Maybe next time.");
	}

	@Override
	public int compareTo(JobCandidate o) {
		int hours = this.hoursSpentCoding - o.hoursSpentCoding;
		int salary = this.salaryRequired - o.salaryRequired;
		int bonus = bonus(this) - bonus(o);
		if (hours == 0 && salary == 0 && bonus == 0)
			return 0;
		else if (hours > 0 && bonus > 0)
			return 1;
		else
			return -1;
	}

	private static int bonus(JobCandidate jc) {
		int bonus = 0;
		if (jc.personalityTraits.size() > 5)
			bonus++;
		if (jc.teacherName.equals("June Clark"))
			bonus += 5;
		if (jc.hoursSpentCoding > 600)
			bonus++;
		if (jc.salaryRequired < 150000)
			bonus++;
		if (jc.personalityTraits.contains("persistant"))
			bonus++;
		if (jc.personalityTraits.contains("adaptable"))
			bonus++;
		if (jc.personalityTraits.contains("confident"))
			bonus++;
		if (jc.personalityTraits.contains("responsible"))
			bonus++;
		return bonus;
	}

}
