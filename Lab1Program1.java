import java.util.Scanner;
class Performance{
	int[] mark=new int[60];
	Performance(){
		this.readMarks();
	}
	void readMarks(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter marks of 10 students");
		for(int i=0;i<10;i++){
			do {
           			this.mark[i]= sc.nextInt();
           			if(this.mark[i]<0 || this.mark[i]>100){
           				System.out.println("Invalid Mark,Enter Mark again between 0-100");
           			}
        	} while (this.mark[i]<0 || this.mark[i]>100);
		}
	}
	int highestMark(){
		int high=this.mark[0];
		for(int i=0;i<10;i++){
			if(this.mark[i]>high){
				high=this.mark[i];
			}
		}
		return high;
	}
	int leastMark(){
		int low=this.mark[0];
		for(int i=0;i<10;i++){
			if(this.mark[i]<low){
				low=this.mark[i];
			}
		}
		return low;
	}
	int getFregAtMode(){
		int count=0;
		int marks;
		for(int i=0;i<10;i++){
			int flag=0;
			for(int j=0;j<10;j++){
				if(this.mark[i]==this.mark[j]){
					flag++;
				}
			}
			if(flag>count){
				count=flag;
				marks=this.mark[i];
			}
		}
		return count;
	}
	int getMode(){
		int count=0;
		int marks=this.mark[0];
		int trick=0;
		for(int i=0;i<10;i++){
			int flag=0;
			for(int j=0;j<10;j++){
				if(this.mark[i]==this.mark[j]){
					flag++;
				}
			}
			if(flag>count){
				count=flag;
				marks=this.mark[i];
				trick=1;
			}
			if(flag==count && this.mark[i]!=marks){
				trick=0;
			}
		}
		if(trick==1){
			return marks;
		}
		else{
			System.out.println("Multi Mode Mark found!");
			return 0;
		}
	}	
}
class Lab1Program1{
	public static void main(String[] args) {
		int a,c;
		Scanner sc=new Scanner(System.in);
		do{
		Performance obj=new Performance();
		do{
			System.out.println("Choose an oparation\n1.Highest Marks\n2.Least Mark\n3.Mode Mark\n4.Frequency of Mode Mark\n");
			int b=sc.nextInt();
			int x=0;
			switch(b){
				case 1:
					x=obj.highestMark();
					System.out.println("Highest Mark is:"+x);
					break;
				case 2:
					x=obj.leastMark();
					System.out.println("Least Mark is:"+x);
					break;
				case 3:
					x=obj.getMode();
					if(x!=0){
						System.out.println("Mode Mark is:"+x);
					}
					break;
				case 4:
					x=obj.getFregAtMode();
					System.out.println("Frequency of Mode Mark is:"+x);
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
			System.out.println("Do you wish to continue: 1.Yes. 2.No.");
			a=sc.nextInt();
		}while(a!=2);
		System.out.println("Do you want to:\n1.Start Again\n2.Exit");
		c=sc.nextInt();
	}while(c!=2);
	System.out.println("Thank You");
	}
}