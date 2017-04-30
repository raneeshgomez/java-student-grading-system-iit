import java.util.Comparator;

public class MyComparator implements Comparator<Test> {

	@Override
	public int compare(Test testObj1, Test testObj2) {
		return String.valueOf(testObj1.getModuleMarks()).compareTo(String.valueOf(testObj2.getModuleMarks()));
	}

	public int compareString(Test stringObj1, Test stringObj2) {
		return stringObj1.getlName().compareTo(stringObj2.getlName());
	}

}
