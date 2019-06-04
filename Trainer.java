import java.util.ArrayList;

public class Trainer {
	
	private String name, type;
	private ArrayList<Pokemon> team;
	private ArrayList<Items> items;
	
	//Constructs a Trainer with a name, a type (Ex. Rival, You, Lass), 
	//a team of Pokemon, and a bag of items
	public Trainer(String name, String type) {
		
		this.name = name;
		this.type = type;
		team = new ArrayList<Pokemon>();
		items = new ArrayList<Items>();
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String getType() {
		
		return type;
		
	}
	
	//Adds a Potion to the items bag
	public void addPotion() {
		
		items.add(new Potion());
		
	}
	
	//Adds a Super Potion to the items bag
	public void addSuperPotion() {
		
		items.add(new SuperPotion());
		
	}
	
	//Adds a Max Potion to the items bag
	public void addMaxPotion() {
		
		items.add(new MaxPotion());
		
	}
	
	public int getTeamSize() {
		
		return team.size();
		
	}
	
	public int getItemsSize() {
		
		return items.size();
		
	}
	
	//Checks if the bag is empty or not
	public boolean hasNoItems() {
		
		if(items.size() == 0) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public ArrayList<Pokemon> getTeam(){
		
		return team;
		
	}
	
	//Adds a Pokemon to the team
	public void addToTeam(Pokemon p) {
		
		team.add(p);
		
	}
	
	//Removes a random Pokemon from the team and returns that Pokemon
	public Pokemon removeFromTeam() {
		
		return team.remove((int)(Math.random() * team.size()));
		
	}
	
	//Finds a Potion in the items bag, uses it, and removes it from the bag
	public void usePotion(Pokemon a) {

		for(int i = 0; i < items.size(); i++) {
			
			if(items.get(i) instanceof Potion) {
				
				((Potion) items.get(i)).use(a);
				items.remove(i);
				break;
				
			}
			
		}
		
	}

	//Finds a Super Potion in the items bag, uses it, and removes it from the bag
	public void useSuperPotion(Pokemon a) {

		for(int i = 0; i < items.size(); i++) {
			
			if(items.get(i) instanceof SuperPotion) {
				
				((SuperPotion) items.get(i)).use(a);
				items.remove(i);
				break;
				
			}
			
		}
			
	}
	
	//Finds a Max Potion in the items bag, uses it, and removes it from the bag
	public void useMaxPotion(Pokemon a) {
		
		for(int i = 0; i < items.size(); i++) {
			
			if(items.get(i) instanceof MaxPotion) {
				
				((MaxPotion) items.get(i)).use(a);
				items.remove(i);
				break;
				
			}
			
		}
		
	}
	
	//Checks if the items bag has a Potion inside of it
	public boolean hasPotion() {
		
		for(int i = 0; i < items.size(); i++) {
			
			if(items.get(i) instanceof Potion) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	//Checks if the items bag has a Super Potion inside of it
	public boolean hasSuperPotion() {
		
		for(int i = 0; i < items.size(); i++) {
			
			if(items.get(i) instanceof SuperPotion) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	//Checks if the items bag has a Max Potion inside of it
	public boolean hasMaxPotion() {
		
		for(int i = 0; i < items.size(); i++) {
			
			if(items.get(i) instanceof MaxPotion) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
}