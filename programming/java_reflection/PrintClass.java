import java.lang.reflect.*;

public class PrintClass {
	public static void main(String[] args) throws ClassNotFoundException {
		if (args.length != 1) {
			System.err.println("Usage: java PrintClass <class>");
			System.exit(1);
		} else {
			dumpClass(Class.forName(args[0]));
		}
	}

	static void dumpClass(Class c) {
		System.out.println(c + " {");

		for (Constructor con : c.getConstructors()) {
			System.out.println(" " + con);
		}

		for (Method m : c.getDeclaredMethods()) {
			if (! Modifier.isPrivate(m.getModifiers())) {
				System.out.println(" " + m);
			}
		}

		System.out.println("}");
	}
}
