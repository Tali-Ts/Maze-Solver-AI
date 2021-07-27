
public class Main {
	public static String fileName;
	public static String alg;

	public static void main(String[] args) {
		alg = args[0];
		fileName = args[1];
		System.out.println("alg= " + alg + " fileName=" + fileName);
		//fileName = "maze4.txt";
		
		General rf = new General();
		char[][] matrix = rf.readFileByName(fileName);
		System.out.println("sizes in main:" + rf.row + " " + rf.col);
		
		switch (alg.toUpperCase()) {
		case "BFS":
			System.out.println("\n----------BFS----------");
			Bfs bfs = new Bfs();
			System.out.println("Alg Name : " + alg);
			System.out.println("Input : " + fileName);
			bfs.BFS(matrix, rf.start.get(0), rf.start.get(1), rf.row, rf.col, rf.goal.get(0), rf.goal.get(1));
			break;
		case "BESTFIRSTSEARCH":
			System.out.println("\n----------BestFirstSearch----------");
			BestFirstSearch bestFirstSearch = new BestFirstSearch();
			System.out.println("Alg Name : " + alg);
			System.out.println("Input : " + fileName);
			bestFirstSearch.bestFirstSearch(matrix, rf.start.get(0), rf.start.get(1), rf.row, rf.col, rf.goal.get(0), rf.goal.get(1));
			break;
		case "A*":
			System.out.println("\n----------A*----------");
			Astart aStar = new Astart();
			System.out.println("Alg Name : " + alg);
			System.out.println("Input : " + fileName);
			aStar.aStart(matrix, rf.start.get(0), rf.start.get(1), rf.row, rf.col, rf.goal.get(0), rf.goal.get(1));
			break;
		default:
			break;
		}
	}

}
