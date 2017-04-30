import java.util.Scanner;

public class Test {

	private String regNo;
	private String fName;
	private String lName;
	private int project1;
	private int project2;
	private int ict1;
	private int ict2;
	private int ict3;
	private int codingAssign;
	private int actParticipation1;
	private int actParticipation2;
	private int actParticipation3;
	private int overallMarks1;
	private int overallMarks2;
	private int overallMarks3;
	private int qualifyingSetMarks;
	private int moduleMarks;
	private Grade moduleGrade;
	private String mitigationStatus1;
	private String mitigationStatus2;
	private String mitigationStatus3;

	public Test() {

		Scanner input = new Scanner(System.in);

		System.out.println("==========ENTER STUDENT DETAILS BELOW============");
		System.out.print("Enter Registration Number: ");
		regNo = input.next();
		System.out.print("Enter First Name: ");
		fName = input.next();
		System.out.print("Enter Last Name: ");
		lName = input.next();

		project1 = validateMarks(input, "Enter Project 01 Marks: ");
		ict1 = validateMarks(input, "Enter ICT 01 Marks: ");
		actParticipation1 = validateMarks(input, "Weekly Participation in Component 01: ");
		mitigationStatus1 = validateMitigation(overallMarks1, input);

		codingAssign = validateMarks(input, "Enter Coding Assignment Marks: ");
		ict2 = validateMarks(input, "Enter ICT 02 Marks: ");
		actParticipation2 = validateMarks(input, "Weekly Participation in Component 02: ");
		mitigationStatus2 = validateMitigation(overallMarks2, input);

		project2 = validateMarks(input, "Enter Project 02 Marks: ");
		ict3 = validateMarks(input, "Enter ICT 03 Marks: ");
		actParticipation3 = validateMarks(input, "Weekly Participation in Component 03: ");
		mitigationStatus3 = validateMitigation(overallMarks3, input);

		marksCalculator();
		gradeCalculator();
	}

	private static int validateMarks(Scanner input, String msg) {
		int marks = 1;
		do {
			System.out.print(msg);
			int getMarks = input.nextInt();
			if ((getMarks >= 0) && (getMarks <= 100)) {
				System.out.println("Saved!");
				marks = getMarks;
			} else {

				System.err.println("Enter Valid Mark from 0 to 100!");
			}

		} while (marks == 1);
		return marks;

	}

	private static String validateMitigation(int desiredComp, Scanner scanner) {
		String mitigationStatus = "";
		char input;
		if (desiredComp == 0) {
			do {
				System.out.println("Mitigation Approved?" + "\n" + "Press \'Y\' if YES and \'N\' if NO");
				input = scanner.next().charAt(0);
				if (input == 'Y') {
					mitigationStatus = "Deferred";
				} else if (input == 'N') {
					mitigationStatus = "Rejected";
				} else {
					System.out.println("Invalid Entry! Retry with Valid Response.");
				}
			} while (input != 'Y' && input != 'N');

		} else {
			mitigationStatus = "No Mitigation Brought Forward!";
		}
		return mitigationStatus;
	}

	private void gradeCalculator() {

		if (moduleMarks >= 80) {
			moduleGrade = Grade.HIGHER_DISTINCTION;
		} else if (moduleMarks >= 70) {
			moduleGrade = Grade.DISTINCTION;
		} else if (moduleMarks >= 60) {
			moduleGrade = Grade.CREDIT;
		} else if (moduleMarks >= 50) {
			moduleGrade = Grade.PASS;
		} else {
			moduleGrade = Grade.RETAKE;
		}
		if (moduleMarks < 50 && (qualifyingSetMarks <= 40 || overallMarks3 <= 40)) {
			moduleGrade = Grade.RESIT;
		}

	}

	private void marksCalculator() {
		overallMarks1 = (int) Math.round(project1 * 0.2 + ict1 * 0.7 + actParticipation1 * 0.1);
		overallMarks2 = (int) Math.round(codingAssign * 0.5 + ict2 * 0.4 + actParticipation2 * 0.1);
		overallMarks3 = (int) Math.round(project2 * 0.6 + ict3 * 0.3 + actParticipation3 * 0.1);
		qualifyingSetMarks = (overallMarks1 + overallMarks2) / 2;

		if (mitigationStatus1 == "Rejected") {
			overallMarks1 = 0;
		}
		if (mitigationStatus2 == "Rejected") {
			overallMarks2 = 0;
		}
		if (mitigationStatus3 == "Rejected") {
			overallMarks3 = 0;
		}
		moduleMarks = (int) Math.round(overallMarks1 * 0.3 + overallMarks2 * 0.35 + overallMarks3 * 0.35);

	}

	public Grade getModuleGrade() {
		return moduleGrade;
	}

	public void setModuleGrade(Grade moduleGrade) {
		this.moduleGrade = moduleGrade;
	}

	public String getMitigationStatus1() {
		return mitigationStatus1;
	}

	public void setMitigationStatus1(String mitigationStatus1) {
		this.mitigationStatus1 = mitigationStatus1;
	}

	public String getMitigationStatus2() {
		return mitigationStatus2;
	}

	public void setMitigationStatus2(String mitigationStatus2) {
		this.mitigationStatus2 = mitigationStatus2;
	}

	public String getMitigationStatus3() {
		return mitigationStatus3;
	}

	public void setMitigationStatus3(String mitigationStatus3) {
		this.mitigationStatus3 = mitigationStatus3;
	}

	@Override
	public String toString() {
		return "First Name = " + fName + "\n" + "Last Name = " + lName + "\n" + "Registration Number = " + regNo + "\n"
				+ "Project 01 Marks = " + project1 + "\n" + "ICT 01 Marks = " + ict1 + "\n"
				+ "Marks for Participation for 1st Component = " + actParticipation1 + "\n"
				+ "Mitigation Exists for Project 1 with ICT? = " + mitigationStatus1 + "\n"
				+ "Coding Assignment Marks = " + codingAssign + "\n" + "ICT 02 Marks = " + ict2 + "\n"
				+ "Marks for Participation for 2nd Component = " + actParticipation2 + "\n"
				+ "Mitigation Exists for Coding Assignment with ICT? = " + mitigationStatus2 + "Project 02 Marks = "
				+ project2 + "\n" + "ICT 03 Marks = " + ict3 + "\n" + "Marks for Participation for 3rd Component = "
				+ actParticipation3 + "\n" + "Mitigation Exists for Project 2 with ICT? = " + mitigationStatus3
				+ "Overall Marks for Project 1 with ICT: " + overallMarks1 + "\n"
				+ "Overall Marks for Coding Assignment with ICT: " + overallMarks2 + "\n"
				+ "Overall Marks for Project 2 with ICT: " + overallMarks3 + "\n"
				+ "Average Marks for Qualifying Set 1: " + qualifyingSetMarks + "\n";
	}

	public int getModuleMarks() {
		return moduleMarks;
	}

	public void setModuleMarks(int moduleMarks) {
		this.moduleMarks = moduleMarks;
	}

	public int getOverallMarks1() {
		return overallMarks1;
	}

	public void setOverallMarks1(int overallMarks1) {
		this.overallMarks1 = overallMarks1;
	}

	public int getOverallMarks2() {
		return overallMarks2;
	}

	public void setOverallMarks2(int overallMarks2) {
		this.overallMarks2 = overallMarks2;
	}

	public int getOverallMarks3() {
		return overallMarks3;
	}

	public void setOverallMarks3(int overallMarks3) {
		this.overallMarks3 = overallMarks3;
	}

	public int getQualifyingSetMarks() {
		return qualifyingSetMarks;
	}

	public void setQualifyingSetMarks(int qualifyingSetMarks) {
		this.qualifyingSetMarks = qualifyingSetMarks;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getProject1() {
		return project1;
	}

	public void setProject1(int project1) {
		this.project1 = project1;
	}

	public int getProject2() {
		return project2;
	}

	public void setProject2(int project2) {
		this.project2 = project2;
	}

	public int getIct1() {
		return ict1;
	}

	public void setIct1(int ict1) {
		this.ict1 = ict1;
	}

	public int getIct2() {
		return ict2;
	}

	public void setIct2(int ict2) {
		this.ict2 = ict2;
	}

	public int getIct3() {
		return ict3;
	}

	public void setIct3(int ict3) {
		this.ict3 = ict3;
	}

	public int getCodingAssign() {
		return codingAssign;
	}

	public void setCodingAssign(int codingAssign) {
		this.codingAssign = codingAssign;
	}

	public int getActParticipation1() {
		return actParticipation1;
	}

	public void setActParticipation1(int actParticipation1) {
		this.actParticipation1 = actParticipation1;
	}

	public int getActParticipation2() {
		return actParticipation2;
	}

	public void setActParticipation2(int actParticipation2) {
		this.actParticipation2 = actParticipation2;
	}

	public int getActParticipation3() {
		return actParticipation3;
	}

	public void setActParticipation3(int actParticipation3) {
		this.actParticipation3 = actParticipation3;
	}

}
