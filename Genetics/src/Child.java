import java.util.Random;

class Characteristics
{
	//{"Eye Color", "Hair Color", "Sex", "Height", "Vision"}
	public String [] Characteristic;
	
	public Characteristics(String[] Ch) 
	{
		Characteristic = new String [5];
		Characteristic = Ch;
	}
}

class FamilyExpressions extends Characteristics
{
       //instance variable(s);
       
       //constructor 
       {
		   
       }
	
}

class Mother extends FamilyExpressions
{
       //instance variable;
       
       //constructor 
       {
		   
       }
       public void changeMother(String[]M) 
       {
    	   //add code;
       }
}
 
class Father 
{
        //instance variable;
       // constructor 
        {
			
        }
        public void changeFather(String[]F) 
        {
        	//add code;
        }
}

public class Child
{
    public static void main(String[] args)
    {   
        Random gene = new Random();
        String[] M = new String[5];
        String[] F = new String[5];
        String [] NoValues = new String[5];

//Characteristics, FamilyExpressions, and FamilyCombinations are fixed values
//so they can be defined here in string arrays initialized with the values in the specifications
        String [] [] Exp = {{"Brown","Blue","Green","Grey"},{"Brown","Black","Blonde","Red"},{"Male","Female","Female","Male"},{"6.5","6.0","5.5","5.0"},{"normal","near","far","color"}};
    	String [] Comb = {"DD","RR","DR","RD"};
        String [] Ch = {"Eye Color", "Hair Color", "Sex", "Height", "Vision"};

//Send constructor values for Characteristics, Family Expressions, and Family Combinations when constructing Mother
//and use super to construct them. Initially construct Mother and Father with No gene Values.
        Mother mother = new Mother(NoValues,Exp,Comb,Ch);
        Father father = new Father(NoValues);
        

//Now use some looping to allow reset of parents gene information and print the information for each child
//Since Mother and Father genes are randomly generated, you should see different output for each iteration

		//Now Create Mothers Genes M with a loop
		//Generate a random number 1-100. If number >= 50 "R" else "D"
		//Use changeMother() to reset Mother at end
 
 
 
        //Now Create Fathers Genes F with a loop
		//Generate a random number 1-100. If number >= 50 "R" else "D"
        //Use changeFather() to reset Father at end


        //Use looping to iterate through all 5 characteristcs, printing the information for the child
        //If the mother and father genes when combined match one of the 4 paired values in Combination the child inherits the Expression
        //that for that Characteristic

        //For example below: if mothers 'vision' gene 4 and fathers 'vision' gene 4 combined equal FamilyExpression Combination[1] 'DD' for Characteristic[4] 'vision'
		//the child will inherit the FamilyExpression Expression[4][0] 'normal' and it will print 'Vision normal'.
        if((mother.MGene[4]+father.FGene[4]).equals(mother.Combination[0])) 
        {
        	System.out.print(mother.Characteristic[4]+" "+mother.Expression[4][0]);
        }
    
    }
}
