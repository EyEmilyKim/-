class Human2 extends Animal {
  String name;
  String gender;
  int age;

  void move(){
    System.out.println("A Human walks.");
  }

  void think(){
    System.out.println("A Human thinks.");
  }

  void introduceOneself(){
     System.out.println("Hi, I am "+name+", "+gender+", "+ age+"years old.");

  }

  Human2(){};

  Human2(String n, String g, int a){
      name = n;
      gender = g;
      age = a;
  };

}