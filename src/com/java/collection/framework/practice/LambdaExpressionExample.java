package com.java.collection.framework.practice;

/**
 * This class demonstrates functional interfaces with inheritance.
 * How to use lambda expression w.r.t to functional interface
 * 
 * @author Srilalitha
 *
 */
public class LambdaExpressionExample {

	public static void main(String[] args) {
		
		// Animal interface is functional interface.
		// we can use lambda expression to invoke functional interface
		Animal animal = () -> System.out.println("Animal");
		// now invoke printName() method of Animal interface
		animal.printName();
		// by default all the variables in interface are public static final. So we have
		// to access variables of interface with interface name
		System.out.println(Animal.num);
		
		// Now will see inheritance with functional interfaces
		// Here Dog is child interface of Animal interface doesn't contain any new abstract method.
		// so Dog is also a functional interface since it is using parent interface abstract method
		Dog dog = () -> System.out.println("Dog");
		dog.printName();
		System.out.println(Dog.num);
		
		// Cat is child interface of Animal interface and declaring same abstract method. So still
		// it is a functional interface. We can use lambda expression 
		Cat cat = () -> System.out.println("Cat");
		cat.printName();
		System.out.println(Cat.num);
		
		// Lion is child interface of Animal interface and it is declaring another abstract method.
		// so Lion is not a functional interface. So we can't use lambda expression
		// below line gives compilation error since we cant use lambdas with Lion interface. So commenting
		//Lion lion = () -> System.out.println("Lion");
		// am using annonymous interface to provide implemention for Lion interface
		// or we can create child class for Lion and with child class reference we can call abstract method of Lion
		Lion lion = new Lion() {

			@Override
			public void printName() {
				System.out.println("Lion");	
			}

			@Override
			public String getName() {
				return "in method of getName";
			}	
		};
		lion.printName();
		System.out.println(lion.getName());
		System.out.println(Lion.num);
		
		
		// Tiger is child interface of Animal interface and it is not declaring any new abstract methods
		// so it is a functional interface. We can use lambda expression
		// for parent abstract method we can use lamda expression like below
		Tiger tiger = () -> System.out.println("Tiger");
		// calling parent abstract method with child interface
		tiger.printName();
		// calling Tiger default method
		tiger.print();
		System.out.println(tiger.num);
		
		// Hippo is child interface of Animal but it is declaring default method with same name of abstract method in
		// parent Animal interface. i.e., we are providing implementation for abstract method in interface. So it child interface
		// will not be a functional interface. So we cant use lambda expression in this case
		//Hippo hippo = () -> System.out.println("Hippo");
		
		// To call Hippo class default method using annonymous immplementaion
		Hippo hippo = new Hippo() {
			// since only default method is present we no need to provide any implementation
		};
		hippo.printName();
		System.out.println(hippo.num);
		
		Hippo hippo1 = new Hippo() {
			// we can provide our implementation by overriding default methods as well
			// so lets override default method
			@Override
			public void printName() {
				System.out.println("in overridden method of Hippo");
			}
		};
		hippo1.printName();
		System.out.println(hippo1.num);
		
		// Lets create object of HippoChild class
		HippoChild child = new HippoChild();
		// will call overridden printName method
		child.printName();
		System.out.println(child.num);
		
		
		
	}
}

@FunctionalInterface
interface Animal {
	
	int num = 10;
	
	public void printName();
	
} 

// lets create another interface which extends Animal interface
@FunctionalInterface
interface Dog extends Animal {
	
	int num = 20;
}

// lets create another interface which extends Animal interface but declare same abstract method
@FunctionalInterface
interface Cat extends Animal {
	
	int num = 30;
	
	// declaring same abstract method of parent Animal interface. Since same abstract method
	// it still holds as Functional Interface
	public void printName();
}

// lets create another interface which extends Animal interface
// but declare new abstract method in this child interface and annotate this @FunctionalInterface
// Compiler throws Compilation error saying Lion is not Functional interface since it is declaring
// another abstract method
//@FunctionalInterface

// If i remove FunctionalInterface annotation then it works since we can have non functional interfaces
// as child interface for parent functional interface
interface Lion extends Animal {
	
	int num = 40;
	
	public String getName();	
}

// lets declare another interface which extends Animal interface
// but declare one default method still it act as Functional interface since it is not 
// declaring new abstract methods
@FunctionalInterface
interface Tiger extends Animal {
	
	int num = 50;
	
	default void print() {
		System.out.println("in Tiger print method");
	}
}

// lets create another child interface for Animal. 
// declare default method with name of parent Animal interface abstract method name
// it will not be a functional interface since we are using same abstract method name and providing implementation
// so we can't annotate hippo with functionalInterface annotation. If we annotate, we get
// compilation error
//@FunctionalInterface
interface Hippo extends Animal {
	
	int num = 60;
	
	// printName is abstract method in Animal. Here I am declaring it as default and providing implementation
	default void printName() {
		System.out.println("in default printName method of Hippo");
	}
}

// creating a child class for Hippo
class HippoChild implements Hippo {
	
	// So we can override printName() method of Hippo in child class
	// it is not mandatory to override printName() method since it is a default method
	
	@Override
	public void printName() {
		System.out.println("In Hippo child class");
		
		// To call parent interface printName default method we can use below
		Hippo.super.printName();
	}
	
}