import java.util.Scanner;
import java.util.ArrayList;

public class Student {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String mainOption;
		int calcOption;
		int studentCount = 0;
		int average = 0;

		ArrayList<Test> markList = new ArrayList<Test>();

		System.out.println(
				"**************** Welcome to the Student Details Registry*****************************************************"
						+ "*************************************************************************************************\n");
		System.out.println(
				"=================MAIN MENU====================================================================================="
						+ "==============================================================================================\n");
		System.out.println("(1)Press \"U\" to Add Student Details");
		System.out.println(
				"(Active Partcipation: Marks for a week for Component 1 - 20, Marks for a week for Component 2 - 25, Marks for a week for Component 3 - 33.33)");
		System.out.println("(2)Press \"N\" to Quit \n");
		System.out.print("Enter Desired Option: ");
		mainOption = input.next();
		System.out.println("--------");
		System.out.println("\n");

		while (mainOption.equals("U") || mainOption.equals("u")) {
			Test testObj = new Test();
			studentCount++;
			markList.add(testObj);

			System.out.println(
					"=================MAIN MENU======================================================================================="
							+ "================================================\n");
			System.out.println("\n" + "(1)Press \"U\" to continue Updating Student Details");
			System.out.println(
					"(Active Partcipation: Marks for a week for Component 1 - 20, Marks for a week for Component 2 - 25, Marks for a week for Component 3 - 33.33)\n");
			System.out.println("(2)Press \"V\" to view Entered Student Details: ");
			System.out.println("(3)Press \"P\" to proceed to Ranking Calculation Menu");
			System.out.println("(3)Press \"N\" to Quit");
			System.out.print("Enter Desired Option: ");
			mainOption = input.next();
			System.out.println("--------");
			System.out.println("\n");
		}

		if (mainOption.equals("V") || mainOption.equals("v")) {
			for (int i = 0; i < markList.size(); i++) {
				System.out.println("-----------------Student Details--------------------");
				System.out.println("Student No. " + i + "\n\n" + markList.get(i) + "\n");
			}
		}

		while (mainOption.equals("P") || mainOption.equals("p")) {
			System.out.println("=============RANKING CALCULATIONS MENU================ \n");
			System.out.println("(1)Calculate Average for each component");
			System.out.println("(2)Display No. of Students with Marks below 40 for each component");
			System.out.println("(3)Calculte Overall Module Marks for each Student");
			System.out.println("(4)Calculate Overall Class Average");
			System.out.println("(5)Display Students with Overall Module Marks less than Class Average");
			System.out.println("(6)Display Highest Scorer for each Component and Overall Module");
			System.out.println("(7)Display RETAKE Students");
			System.out.println("(8)Display RESIT Students");
			System.out.println("(9)Display HIGHER DISTINCTION, DISTINCTION, CREDIT, PASS Students");
			System.out.println("(10)Quit");
			System.out.print("Enter Desired Option Number: ");
			calcOption = input.nextInt();

			switch (calcOption) {
			case 1:
				Options.componentAvg(markList);
				break;
			case 2:
				Options.lowMarks(markList);
				break;
			case 3:
				Options.totalModuleMarks(markList);
				break;
			case 4:
				average = Options.classAvgCalculator(markList);
				break;
			case 5:
				Options.moduleMarksBelowAvg(markList, average);
				break;
			case 6:
				Options.highestScorer(markList);
				break;
			case 7:
				Options.retakeStudents(markList);
				break;
			case 8:
				Options.resitStudents(markList);
				break;
			case 9:
				Options.gradeStudents(markList);
				break;
			case 10:
				System.exit(0);
				;
				break;
			}
		}

		if (mainOption.equals("N") || mainOption.equals("n")) {
			System.exit(0);
		}

	}

}
