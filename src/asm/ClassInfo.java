package asm;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class ClassInfo extends ClassLoader implements Opcodes {

	@Test
	@SuppressWarnings("unchecked")
	public void test() throws IOException {
		ClassReader cr = new ClassReader("asm.Test");
		ClassNode cn = new ClassNode();
		cr.accept(cn, ClassReader.SKIP_CODE);
		System.out.println("Class Name : " + cn.name + "\n");
		System.out.println("Super Class : " + cn.superName + "\n");

		System.out.println("Interfaces :");
		List<String> interfaces = cn.interfaces;
		for (int i = 0; i < interfaces.size(); i++) {
			System.out.println(interfaces.get(i));
		}

		System.out.println("\nMethods :");
		List<MethodNode> methods = cn.methods;
		for (int i = 0; i < methods.size(); ++i) {
			MethodNode method = (MethodNode) methods.get(i);
			System.out.println(method.name + method.desc);
		}
	}
}