import java.util.Scanner;
class AlphabetWarGame{
	String[][] rules=new String[8][2];
	AlphabetWarGame(){
		this.rules[0][0]="w";
		this.rules[1][0]="p";
		this.rules[2][0]="b";
		this.rules[3][0]="s";
		this.rules[4][0]="m";
		this.rules[5][0]="q";
		this.rules[6][0]="d";
		this.rules[7][0]="z";
		this.rules[0][1]="4";
		this.rules[1][1]="3";
		this.rules[2][1]="2";
		this.rules[3][1]="1";
		this.rules[4][1]="4";
		this.rules[5][1]="3";
		this.rules[6][1]="2";
		this.rules[7][1]="1";
	}
	AlphabetWarGame(int i){
		this();
		Scanner sc=new Scanner(System.in);
		for(int j=0;j<8;j++){
			System.out.println("Enter the strength for "+this.rules[j][0]+":");
			this.rules[j][1]=sc.nextLine();
		}
	}
	AlphabetWarGame(AlphabetWarGame a){
		this.rules=a.rules;
	}
	void winner(String s){
		int right=0,left=0;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<8;j++){
				if(Character.toLowerCase(s.charAt(i))==this.rules[j][0].charAt(0)){
					if(j<4){
						left+=Integer.parseInt(this.rules[j][1]);
					}
					else{
						right+=Integer.parseInt(this.rules[j][1]);
					}
				}
			}
		}
		if(left>right){
			System.out.println("Left Side Wins!");
		}
		else if(right>left){
			System.out.println("Right Side Wins!");			
		}
		else{
			System.out.println("Let's Fight Again!");			
		}
	}
	void winner(String l,String r){
		int right=0,left=0;
		for(int i=0;i<l.length();i++){
			for(int j=0;j<8;j++){
				if(Character.toLowerCase(l.charAt(i))==this.rules[j][0].charAt(0)){
					left+=Integer.parseInt(this.rules[j][1]);
				}
			}
		}
		for(int i=0;i<r.length();i++){
			for(int j=0;j<8;j++){
				if(Character.toLowerCase(r.charAt(i))==this.rules[j][0].charAt(0)){
					right+=Integer.parseInt(this.rules[j][1]);
				}
			}
		}
		if(left>right){
			System.out.println("Left Side Wins!");
		}
		else if(right>left){
			System.out.println("Right Side Wins!");			
		}
		else{
			System.out.println("Let's Fight Again!");			
		}
	}
}
class Lab1Program2{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a,b,c,d;
		String s1;
		do{
			System.out.println("Welcome to Alphabet War, Play with\n1.Default Rules\n2.Own Rules");
			a=sc.nextInt();
			switch(a){
			case 1: AlphabetWarGame obj=new AlphabetWarGame();
					do{
					System.out.println("Choose gameplay:\n1.One Word Input\n2.Seperate words for left and right");
					b=sc.nextInt();
					sc.nextLine();
					switch(b){
					case 1: System.out.println("Enter the warriors among (w,p,b,s,m,q,d,z)");
							s1=sc.nextLine();
							obj.winner(s1);
							break;
					case 2: System.out.println("Left Team enter the warriors among (w,p,b,s,m,q,d,z)");
							s1=sc.nextLine();
							System.out.println("Right Team enter the warriors among (w,p,b,s,m,q,d,z)");
							String s2=sc.nextLine();
							obj.winner(s1,s2);
							break;
					default: System.out.println("Invalid Choice");
							break;
					}
					System.out.println("Do you want to:\n1.Play Again with same rules\n2.Play with different rules or quit");
					c=sc.nextInt();
					}while(c!=2);
					break;
			case 2: AlphabetWarGame obj1=new AlphabetWarGame(1);
					do{
					System.out.println("Choose gameplay:\n1.One Word Input\n2.Seperate words for left and right");
					b=sc.nextInt();
					sc.nextLine();
					switch(b){
					case 1: System.out.println("Enter the warriors among (w,p,b,s,m,q,d,z)");
							s1=sc.nextLine();
							obj1.winner(s1);
							break;
					case 2: System.out.println("Left Team enter the warriors among (w,p,b,s,m,q,d,z)");
							s1=sc.nextLine();
							System.out.println("Right Team enter the warriors among (w,p,b,s,m,q,d,z)");
							String s2=sc.nextLine();
							obj1.winner(s1,s2);
							break;
					default: System.out.println("Invalid Choice");
							break;
					}
					System.out.println("Do you want to:\n1.Play Again with same rules\n2.Play with different rules or quit");
					c=sc.nextInt();
					}while(c!=2);
					break;
			default: System.out.println("Invalid Choice,so going ahead with default rules");
					 break;
			}
			System.out.println("Do you want to:\n1.Play with different rules\n2.Exit");
			d=sc.nextInt();
		}while(d!=2);
		System.out.println("Peace!");
	}
}