class SubAnimalDemo {
  public static void main(String[] args){
    Animal a = new Animal();
    a.breath();
    a.move();

    Fish f = new Fish();
    f.breath();
    f.move();
    
    Bird b = new Bird();
    b.breath();
    b.move();

    Human h = new Human();
    h.breath();
    h.move();
    h.think();

    Human2 h2 = new Human2("peko", "Female", 20);
    h2.breath();
    h2.move();
    h2.think();
    h2.introduceOneself();
  }
}