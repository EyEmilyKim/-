class StringArgsSample{
	public static void main(String[] args){
		if(args.length < 3){
			System.out.println("give me 3 or more than 3 args plz.");
			return;
 		}
		for(int i=0; i<args.length; i++){
			System.out.println(args[i]);
		}

	}
}