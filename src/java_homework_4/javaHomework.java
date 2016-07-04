package java_homework_4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class javaHomework {
	public static void main(String[] args){
		Class c1 = calculator.class;
		Class c2 = Student.class;
		String package_c1 = c1.getPackage().getName();
		System.out.println("���calculator������������������������������ ---> "+package_c1);
		int mod = c1.getModifiers();
		String modifier = Modifier.toString(mod);
		System.out.println("����డ��������������η��أ���--->"+modifier);
		String className = c1.getName();
		System.out.println("��������������أ���--->"+className);
		String superClass = c1.getSuperclass().getName();
		System.out.println("��������أ�Ϊ--->"+superClass);
		System.out.println("չʾ��Ա����--->");
		Field[] fields = c1.getDeclaredFields();
		for(Field field:fields){
			modifier = Modifier.toString(field.getModifiers());
			Class type = field.getType();
			String name = field.getName();
			if(type.isArray()){
				String arrType = type.getComponentType().getName()+"[]";
				System.out.println(""+modifier+" "+arrType+" "+name+";");
				
			}else{
				System.out.println(""+modifier +" "+type+" "+name +";");
			}
		
		}
		System.out.println("չʾ��Ա����--->");
		Method[] methods = c1.getDeclaredMethods();
		for(Method method:methods){
			modifier = Modifier.toString(method.getModifiers());
			Class returnType = method.getReturnType();
			if(returnType.isArray()){
				String arrType = returnType.getComponentType().getName()+"[]";
				System.out.print(""+modifier+" "+arrType+" "+method.getName()+"(");
				
			}else{
				System.out.print("" + modifier+" "+returnType.getName()+" "+method.getName()+"(");
				
			}
			Class[] paramTypes = method.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++){
				if(i>0){
					System.out.print(",");
				}
				if(paramTypes[i].isArray()){
					System.out.print(paramTypes[i].getComponentType().getName()+"[]");
					
				}
				else{
					System.out.print(paramTypes[i].getName());
				}
			}
			System.out.println(");");
		}
		///////////////����ȥ����ҵ����//////////////////////////////
		System.out.println("");
		System.out.println("********************����ȥ����ҵ����********************");
		System.out.println("");
		try {
			calculator c = (calculator)c1.newInstance();
			Student s = (Student)c2.newInstance();
			Field[] f_s = c2.getFields();
			try {
				Field name = c2.getDeclaredField("name");
				name.setAccessible(true);
				System.out.println("ѧ����˽�б���nameԭΪ��"+name.get(s));
				name.set(s, "ׯ����");
				System.out.println("���ڽ���˽�б�����name��Ϊ: "+name.get(s));
				
				Field age = c2.getDeclaredField("age");
				age.setAccessible(true);
				System.out.println("ͬ��ѧ����˽�б���age��ԭֵΪ: "+age.get(s));
				age.set(s, 21);
				System.out.println("���ڰ����Լ�������ĳ���: "+age.get(s));
				
				
				
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Method method = c1.getDeclaredMethod("add",int.class,int.class);
			Method method_2 = c1.getDeclaredMethod("sub", int.class,int.class);
			method_2.setAccessible(true);
			method.setAccessible(true);
			try {
				System.out.println("�������˽�з���1+2--->"+method.invoke(c1, 1,2));
				System.out.println("�������˽�з���2-1--->"+method_2.invoke(c1, 2,1));
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
