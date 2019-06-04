public class Pokemon {

  private String name, type;
  private int maxHP, currentHP;
  private Move strongMove;
  private Move weakMove;

  public static class Move {

    int damage;
    String name;

    public Move(String name, int damage) {

      this.damage = damage;
      this.name = name;

    }

    public int getDamage() {

      return damage;

    }

    public String getName() {

      return name;

    }

  }

  // Constructs a Pokemon which has a name, a type, and a maximum HP
  public Pokemon(String name, String type, int maxHP) {

    this.name = name;
    this.type = type;
    this.maxHP = maxHP;
    this.currentHP = maxHP;

  }

  // Adds either a strong move or a weak move to the Pokemon's moveset
  // Each move has a name and a set amount of damage
  public void addMove(String strength, String name, int damage) {

    if (strength == "STRONG") {

      this.strongMove = new Move(name, damage);

    }

    else {

      this.weakMove = new Move(name, damage);

    }

  }

  public int getCurrentHP() {

    return currentHP;

  }

  public void setCurrentHP(int n) {

    currentHP = n;

  }

  public int getMaxHP() {

    return maxHP;

  }

  public String getName() {

    return name;

  }

  public Move getStrongMove() {

    return strongMove;

  }

  public Move getWeakMove() {

    return weakMove;

  }

  public String toString() {

    return String.format("Name: %s, Type: %s", name, type);

  }

}