import java.util.Random;
import java.util.Scanner;

class Characteristics {
	
	public String [] Characteristic;
	
	public Characteristics(String[] Ch) 
	{
		Characteristic = new String [5];
		Characteristic = Ch;
	}
}//Characteristics

class FamilyExpressions extends Characteristics {
	
		public String[] Combinations;
		public String[][] Expressions;

	//Constructor
	public FamilyExpressions(String[] characters, String[][] expressions, String[] combos) {
		super(characters);
		Combinations = new String[4];
		Combinations = combos;
		Expressions = new String[5][4];
		Expressions = expressions;
		
	}
	
}//FamilyExpressions

class Mother extends FamilyExpressions {
	
	public String mName;
	public String [] mGene;
	
	//Constructor
 	public Mother(String[] characters, String[][] expressions, String[] combos) {
		super(characters, expressions, combos);
		mGene = new String[5];
 	}
 	public void motherName(String scannedName) {
 	mName = scannedName;
 	}
 	
}//Mother

class Father extends FamilyExpressions {
	
		public String fName;
		public String [] fGene;
		
		//Constructor
		public Father(String[] characters, String[][] expressions, String[] combos) {
			super(characters, expressions, combos);
			fGene = new String [5];
		}
		public void fatherName(String scannedName) {
			fName = scannedName;
		}
		
}//Father

public class Child {  // ---------------------Gene Selecting, Combining Process/Printing----------------------
	
    	public static String nameGenerator(String scannedGender) {
    		String name;
    		Random Generator = new Random();
    		String[] maleNames = { "Tony", "Bill", "Paul", "Nick", "Shane", "Brandon", "Travis", "Michael", "Joseph",
    		"Ken" };
    		String[] femaleNames = { "Katherine", "Michele", "Amy", "Laura", "Reina", "Sarah", "Sally", "Erica", "Justine",
    		"Samantha" };
    		int index = Generator.nextInt(9);
    		if (scannedGender.equals("Male"))
    			name = maleNames[index];
    		else
    			name = femaleNames[index];
    		return name;
    	}//Names for children and parents
    	
    	public static String pronoun(String scannedName){
    		String pronoun = "She";
    		String[] maleNames = { "Tony", "Bill", "Paul", "Nick", "Shane", "Brandon", "Travis", "Michael", "Joseph",
    		"Ken" };
    		for (int i = 0; i < maleNames.length; i++) {
    			if (maleNames[i].equals(scannedName))
    				pronoun = "He";
    		}
    		return pronoun;
    	}//Child's pronoun during print segment

    	public static String[] geneGeneration() {
    
    		String[] parentTrait = new String[5];
    		Random Generator = new Random();
    		
    		for (int i = 0; i < parentTrait.length; i++) {
    			int gene = Generator.nextInt(100) + 1;
    			if (gene <= 50)
    				parentTrait[i] = "D"; //dominant
    			else
    				parentTrait[i] = "R"; //recessive
    		} 
    		return parentTrait;
    	}//Determining D or R Genes for parents

    	public static String[] childGenes(String[] scanMother, String[] scanFather) {
 
    		String[] childGenes = new String[5];
    		for (int i = 0; i < 5; i++)
    			childGenes[i] = scanMother[i] + scanFather[i];
    		
    		return childGenes;
    	}//Child's genetics

    	public static int expression(String[] child, String[] combination, int characteristic) {
    		int slot = 0;
    		for (int i = 0; i < combination.length; i++) {
    			if (child[characteristic].equals(combination[i]))
    				slot = i;
    		} 
    		return slot;
    	}

    	public static String gender(String[] genes) {
    		if (genes[3].equals("DD") || genes[3].equals("RD"))
    			return "Male";
    		else
    			return "Female";
    	}//Gender trait

    	public static String vision(String[] scanChildGenes, String[] scanCombination, String[][] scanExpression) {
    		String output = null;
    		if (expression(scanChildGenes, scanCombination, 4) == 0) {
    			output = "normal vision";
    		}
    		else if (expression(scanChildGenes, scanCombination, 4) == 1
    				|| (expression(scanChildGenes, scanCombination, 4) == 2))
    			output = scanExpression[4][expression(scanChildGenes, scanCombination, 4)];
    		else
    			output =  scanExpression[4][expression(scanChildGenes, scanCombination, 4)];
    		return output;
    	}//Vision trait

    	public static void main(String[] args) {
    	
    		Scanner scan = new Scanner(System.in);

    		String input = null;
    		boolean complete = false;
    		
    		//Characteristics and genes
    		String [] child = new String[5];
    		String[][] expressions = { { "brown", "blue", "green", "gray" }, { "brown", "black", "blonde", "red" },
    				{ "Male", "Female", "Female", "Male" }, { "6.5", "6", "5.5", "5" },
    				{ "normal-sighted", "near-sighted", "far-sighted", "colorblind" } };
    		String[] combos = { "DD", "RR", "DR", "RD" };
    		String[] characteristics = { "Eye Color", "Hair Color", "Sex", "Height", "Vision" };

    		Mother mother = new Mother(characteristics, expressions, combos);
    		Father father = new Father(characteristics, expressions, combos);

    		//Child information loop
    		while(complete == false){
    			mother.motherName(nameGenerator("Female"));
    			mother.mGene = geneGeneration();
    			
    			father.fatherName(nameGenerator("Male"));
    			father.fGene = geneGeneration();
    			
    			child = childGenes(mother.mGene, father.fGene);
    			String childName = nameGenerator(gender(child));
    			
    			System.out.println(childName + " is the child of " + mother.mName  + " and " + father.fName + ".");
    			System.out.print(Child.pronoun(childName) + " was born with " + expressions[0][expression(child, combos, 0)] + " eyes, ");
    			System.out.print(expressions[1][expression(child, combos, 1)] + " hair, "); 
    			System.out.print("will grow to a height of " + expressions[3][expression(child, combos, 3)]);
    			System.out.print(" and will be " + vision(child, combos, expressions) + "." );
    			System.out.println();
    			System.out.println();

    			System.out.println("Would you like to do another simulation? Type Y or N: ");
    			input = scan.next();
    			if (input.equals("Y"))
    				complete = false;
    			else if (input.equals("N")) {
    				complete = true;
    				scan.close();  }
    			
    		}//while loop
    		
    		System.out.println();
    	
    }//main
    
}//Child