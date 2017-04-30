import java.util.ArrayList;
import java.util.Collections;

public class Options {

	public static void componentAvg(ArrayList<Test> markList) {
		double componentAvg1 = 0;
		double componentAvg2 = 0;
		double componentAvg3 = 0;
		int componentTot1 = 0;
		int componentTot2 = 0;
		int componentTot3 = 0;

		for (Test testObj : markList) {
			componentTot1 += testObj.getOverallMarks1();
			componentTot2 += testObj.getOverallMarks2();
			componentTot3 += testObj.getOverallMarks3();
		}
		componentAvg1 = componentTot1 / markList.size();
		componentAvg2 = componentTot2 / markList.size();
		componentAvg3 = componentTot3 / markList.size();

		System.out.println("-------------------Average for Each Component---------------------");
		System.out.println("The Average Marks for Project 1 with ICT Component: " + componentAvg1);
		System.out.println("The Average Marks for Coding Assignment with ICT Component: " + componentAvg2);
		System.out.println("The Average Marks for Project 2 with ICT  Component: " + componentAvg3);
	}

	public static void lowMarks(ArrayList<Test> markList) {
		int componentCounter1 = 0;
		int componentCounter2 = 0;
		int componentCounter3 = 0;

		for (Test testObj : markList) {

			if (testObj.getOverallMarks1() < 40) {
				componentCounter1++;
			}

			if (testObj.getOverallMarks2() < 40) {
				componentCounter2++;
			}

			if (testObj.getOverallMarks3() < 40) {
				componentCounter3++;
			}

		}

		System.out.println(
				"\n\n" + componentCounter1 + " Student/s received Marks less than 40 for Project 1 with ICT Component");
		System.out.println("\n\n" + componentCounter2
				+ " Student/s received Marks less than 40 for Coding Assignment with ICT Component");
		System.out.println(
				"\n\n" + componentCounter3 + " Student/s received Marks less than 40 for Project 2 with ICT Component");
	}

	public static void totalModuleMarks(ArrayList<Test> markList) {
		for (Test testObj : markList) {
			System.out.println("\n\nTotal Module Marks for " + testObj.getfName() + " " + testObj.getlName() + " is "
					+ testObj.getModuleMarks() + "\n\n");
		}
	}

	public static int classAvgCalculator(ArrayList<Test> markList) {
		int classAvg = 0;
		int moduleMarksTot = 0;
		for (Test testObj : markList) {
			moduleMarksTot += testObj.getModuleMarks();
		}

		classAvg = (int) Math.round((double) moduleMarksTot / markList.size());
		System.out.println("\n\n The Class Average for the Module is --------> " + classAvg + "\n\n");
		return classAvg;
	}

	public static void moduleMarksBelowAvg(ArrayList<Test> markList, int average) {
		System.out.println(
				"----------------Students with Total Module Marks lower than the Class Average----------------- \n");
		if (average == 0) {
			average = classAvgCalculator(markList);
		}

		for (Test testObj : markList) {
			if (testObj.getModuleMarks() < average) {
				System.out.println("First Name: " + testObj.getfName());
				System.out.println("Last Name: " + testObj.getlName());
				System.out.println("Registration Number: " + testObj.getRegNo());
				System.out.println("Total Overall Module Marks: " + testObj.getModuleMarks() + "\n\n");
			}
		}

	}

	public static void highestScorer(ArrayList<Test> markList) {

		System.out.println("---------------Highest Scorers List----------------- \n");
		int componentMax1 = 0;
		int componentMax2 = 0;
		int componentMax3 = 0;
		int overallMax = 0;
		int maxCounter = 0;

		for (Test testObj : markList) {
			if (maxCounter == 0) {
				componentMax1 = testObj.getOverallMarks1();
				componentMax2 = testObj.getOverallMarks2();
				componentMax3 = testObj.getOverallMarks3();
				overallMax = testObj.getModuleMarks();
				maxCounter++;
			} else {
				if (testObj.getOverallMarks1() > componentMax1) {
					componentMax1 = testObj.getOverallMarks1();
				}
				if (testObj.getOverallMarks2() > componentMax2) {
					componentMax2 = testObj.getOverallMarks2();
				}
				if (testObj.getOverallMarks3() > componentMax3) {
					componentMax3 = testObj.getOverallMarks3();
				}
				if (testObj.getModuleMarks() > overallMax) {
					overallMax = testObj.getModuleMarks();
				}
			}
		}

		for (Test testObj : markList) {
			if (componentMax1 == testObj.getOverallMarks1()) {
				System.out.println("Highest Scorer for Project 1 with ICT Component is " + testObj.getfName() + " "
						+ testObj.getlName() + " " + testObj.getRegNo() + "with " + testObj.getOverallMarks1()
						+ " marks");
			}
		}

		for (Test testObj : markList) {
			if (componentMax2 == testObj.getOverallMarks2()) {
				System.out.println("Highest Scorer for Coding Assignment with ICT Component is " + testObj.getfName()
						+ " " + testObj.getlName() + " " + testObj.getRegNo() + "with " + testObj.getOverallMarks2()
						+ " marks");
			}
		}

		for (Test testObj : markList) {
			if (componentMax3 == testObj.getOverallMarks3()) {
				System.out.println("Highest Scorer for Project 2 with ICT Component is " + testObj.getfName() + " "
						+ testObj.getlName() + " " + testObj.getRegNo() + "with " + testObj.getOverallMarks3()
						+ " marks");
			}
		}

		for (Test testObj : markList) {
			if (overallMax == testObj.getModuleMarks()) {
				System.out.println("Highest Scorer for t is " + testObj.getfName() + testObj.getlName()
						+ testObj.getRegNo() + "with " + testObj.getModuleMarks() + " marks");
			}
		}
	}

	public static void retakeStudents(ArrayList<Test> markList) {
		System.out.println("--------------RETAKE Students' List------------------\n");
		for (Test testObj : markList) {
			if (testObj.getModuleGrade() == Grade.RETAKE) {
				System.out.println("First Name: " + testObj.getfName());
				System.out.println("Last Name: " + testObj.getlName());
				System.out.println("Registration Number: " + testObj.getRegNo());
				System.out.println("Module Grade: RETAKE " + "\n\n");
			}
		}
	}

	public static void resitStudents(ArrayList<Test> markList) {
		ArrayList<Test> componentResit = new ArrayList<Test>();

		for (Test testObj : markList) {
			if (testObj.getModuleGrade() == Grade.RESIT) {
				componentResit.add(testObj);
			}
		}

		System.out.println("-----------RESIT Students for Project 1 with ICT Component------------");
		Collections.sort(componentResit, new MyComparator());
		for (Test testObj : componentResit) {
			System.out.println(testObj.getfName() + " " + testObj.getlName() + "\n");
		}

	}

	public static void gradeStudents(ArrayList<Test> markList) {
		ArrayList<Test> higherDistinctionList = new ArrayList<Test>();
		ArrayList<Test> distinctionList = new ArrayList<Test>();
		ArrayList<Test> creditList = new ArrayList<Test>();
		ArrayList<Test> passList = new ArrayList<Test>();

		for (Test testObj : markList) {
			if (testObj.getModuleGrade() == Grade.HIGHER_DISTINCTION) {
				higherDistinctionList.add(testObj);
			}
		}

		for (Test testObj : markList) {
			if (testObj.getModuleGrade() == Grade.DISTINCTION) {
				distinctionList.add(testObj);
			}
		}

		for (Test testObj : markList) {
			if (testObj.getModuleGrade() == Grade.CREDIT) {
				creditList.add(testObj);
			}
		}

		for (Test testObj : markList) {
			if (testObj.getModuleGrade() == Grade.PASS) {
				passList.add(testObj);
			}
		}

		System.out.println("-----------------Higher Distinction Awardees----------------");
		Collections.sort(higherDistinctionList, new MyComparator());
		for (int i = (higherDistinctionList.size() - 1); i >= 0; i--) {
			System.out.println(higherDistinctionList.get(i));
		}

		System.out.println("-----------------Distinction Awardees----------------");
		Collections.sort(distinctionList, new MyComparator());
		for (int i = (distinctionList.size() - 1); i >= 0; i--) {
			System.out.println(distinctionList.get(i));
		}

		System.out.println("-----------------Credit Awardees----------------");
		Collections.sort(creditList, new MyComparator());
		for (int i = (creditList.size() - 1); i >= 0; i--) {
			System.out.println(creditList.get(i));
		}

		System.out.println("-----------------Pass Awardees----------------");
		Collections.sort(passList, new MyComparator());
		for (int i = (passList.size() - 1); i >= 0; i--) {
			System.out.println(passList.get(i));
		}
	}

}
