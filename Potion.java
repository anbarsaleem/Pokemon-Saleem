
public class Potion extends Items {

	private String name;
	private int price;

	public Potion() {

		super("POTION", 300);
		this.name = "POTION";
		this.price = 300;

	}

	// Adds 20 HP to a Pokemon and
	// if the current HP is >= the max HP - 20,
	// sets the Pokemon's HP to max
	public void use(Pokemon p) {

		if (p.getMaxHP() - p.getCurrentHP() <= 20) {

			p.setCurrentHP(p.getMaxHP());

		}

		else {

			p.setCurrentHP(p.getCurrentHP() + 20);

		}

	}

	public String effect() {

		return "Heals 20 HP";

	}

	public String getName() {

		return name;

	}

	public String toString() {

		return "POTION";

	}

	public int getPrice() {

		return price;

	}

}