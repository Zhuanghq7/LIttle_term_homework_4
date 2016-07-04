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
		System.out.println("这个calculator类的这个包啊，是这个这个……额，，这个 ---> "+package_c1);
		int mod = c1.getModifiers();
		String modifier = Modifier.toString(mod);
		System.out.println("这个类啊，，他的这个修饰符呢，是--->"+modifier);
		String className = c1.getName();
		System.out.println("那他的这个名字呢，是--->"+className);
		String superClass = c1.getSuperclass().getName();
		System.out.println("这个父类呢，为--->"+superClass);
		System.out.println("展示成员变量--->");
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
		System.out.println("展示成员函数--->");
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
		///////////////接下去是作业内容//////////////////////////////
		System.out.println("");
		System.out.println("********************接下去是作业内容********************");
		System.out.println("");
		try {
			calculator c = (calculator)c1.newInstance();
			Student s = (Student)c2.newInstance();
			Field[] f_s = c2.getFields();
			try {
				Field name = c2.getDeclaredField("name");
				name.setAccessible(true);
				System.out.println("学生类私有变量name原为："+name.get(s));
				name.set(s, "庄浩麒");
				System.out.println("现在讲该私有变量的name变为: "+name.get(s));
				
				Field age = c2.getDeclaredField("age");
				age.setAccessible(true);
				System.out.println("同理，学生类私有变量age的原值为: "+age.get(s));
				age.set(s, 21);
				System.out.println("现在把我自己的年龄改成了: "+age.get(s));
				
				
				
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
				System.out.println("反射调用私有方法1+2--->"+method.invoke(c1, 1,2));
				System.out.println("反射调用私有方法2-1--->"+method_2.invoke(c1, 2,1));
				
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
