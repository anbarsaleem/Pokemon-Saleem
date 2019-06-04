
public class MaxPotion extends Items {

	private String name;
	private int price;

	public MaxPotion() {

		super("MAX POTION", 1200);
		this.name = "MAX POTION";
		this.price = 1200;

	}

	// Sets the Pokemon's HP to max
	public void use(Pokemon p) {

		p.setCurrentHP(p.getMaxHP());

	}

	public String effect() {

		return "Heals all HP";

	}

	public String getName() {

		return name;

	}

	public String toString() {

		return "MAX POTION";

	}

	public int getPrice() {

		return price;

	}

}