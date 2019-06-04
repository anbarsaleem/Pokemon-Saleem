
public class SuperPotion extends Items {

	private String name;
	private int price;
  
	public SuperPotion() {
	  
		super("SUPER POTION", 700);
		this.name = "SUPER POTION";
		this.price = 700;
	  
	}
  
    //Adds 50 HP to a Pokemon and 
	//if the current HP is >= the max HP - 50, 
	//sets the Pokemon's HP to max
	public void use(Pokemon p) {
		  
		if(p.getMaxHP() - p.getCurrentHP() <= 50) {
		  
			p.setCurrentHP(p.getMaxHP());
	  	  
		}
	  
		else {
		  
			p.setCurrentHP(p.getCurrentHP() + 50);
		  
		}
	  
	}
  
	public String effect() {
	  
		return "Heals 50 HP";
	  
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String toString() {
		
		return "SUPER POTION";
		
	}
	
	public int getPrice() {
		
		return price;
		
	}
	
}