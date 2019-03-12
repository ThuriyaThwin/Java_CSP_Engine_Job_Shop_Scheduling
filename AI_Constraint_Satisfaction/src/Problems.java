import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class Problems{
	public static void main(String [] args){
		Scanner userInput = new Scanner(System.in);
		System.out.print("Demonstrating my CSP solver...\n\n"
				+ "Choose either of the following provided samples\n"
				+ "1. The Australia Map Coloring problem\n"
				+ "2. The Job Shop Scheduling problem\n"
				+ "3. The n-Queens problem\n"
				+ "Your choice? ");
		int input = userInput.nextInt();
		while(input < 1 || input > 3){
			System.out.print("Incorrect Input! Try again... \nYour Choice? ");
			input  = userInput.nextInt();
		}
		if(input!=3)
			System.out.println("\nSolution: ");
		BacktrackSearch backtrack =  new BacktrackSearch();
		switch (input){
		case 1:
			AustraliaProblem problem1 = new AustraliaProblem();
			if (backtrack.Backtracking_Search(problem1).size() != 0)
				for(Variable n: backtrack.Backtracking_Search(problem1))
					System.out.println("\t"+n.Name() + ": \t" + n.GetValue().Name());
			else
				System.out.println("Failure");
			break;
		case 2:
			JobSchedulingProblem problem2 = new JobSchedulingProblem();
			if (backtrack.Backtracking_Search(problem2).size() != 0)
				for(Variable n: backtrack.Backtracking_Search(problem2))
					System.out.println("\t"+n.Name() + ": \t" + n.GetValue().Name());			
			else
				System.out.println("Failure");
			break;
		case 3:
			System.out.print("\nEnter the value of n: ");
			n_QueensProblem problem3 = new n_QueensProblem(userInput.nextInt());
			System.out.println("Solution: ");
			ArrayList<Variable> results = backtrack.Backtracking_Search(problem3);
			if (results.size() != 0)
				for(Variable v: results){
					Value [] col = (Value[]) v.GetObject();
					for(int i = 0; i < col.length; i++)
						if(col[i] != null)
//							System.out.print("\t@column "+v.Name()+"\t"+v.GetValue().Name()+"\n");
							System.out.print("\t"+(1+Integer.parseInt(v.Name()))+"\t"+(1+(int)v.GetValue().Object()) +"\n");
				}
			else
				System.out.println("Failure");
			break;
		}	
		userInput.close();
	}
}