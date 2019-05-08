package p0110.study;

public class ClassPath {

	public static void main(String[] args) {
		try {
			Class myClass=Class.forName("p0110.game.GameMain");
			try {
				Object obj=myClass.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
