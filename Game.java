import java.util.Scanner;

public class Game {

	private static boolean winState;

	public Game() {

		winState = false;

	}

	public boolean getWinState() {

		return winState;

	}

	public static void win() {

		winState = true;

	}

	public static void lose() {

		winState = false;

	}

	public static void battle(Trainer trainer, Trainer foe, Scanner scan) {

		// Introduction
		System.out.println();
		System.out.println("Hello " + trainer.getName()
				+ "! What you see above is your team of Pokemon.\nThese little companions will try to see you to victory in the upcoming battle.\nNow, all you gotta do is pick the one you want to take into battle with you. Choose wisely.");
		System.out.println("Start by entering a number that corresponds with any of the pokemon above");
		
		
		//Input Checker
		while(!scan.hasNextInt()) {
			
			System.out.println("Invalid entry. Try again.");
			scan.next();
			
		}
		
		int pokeindex = scan.nextInt();
		
		while(pokeindex < 1 || pokeindex > 6) {
			
			System.out.println("Invalid entry. Try again.");
			
			while(!scan.hasNextInt()) {
				
				System.out.println("Invalid entry. Try again.");
				scan.next();
				
			}
			
			pokeindex = scan.nextInt();
			
		}
			
		
		System.out.println("You chose " + trainer.getTeam().get(pokeindex - 1).getName());
		System.out.println();

		System.out.println("LET THE BATTLE COMMENCE!");
		System.out.println();

		// Sends out Pokemon
		Pokemon you = trainer.getTeam().get(pokeindex - 1);
		Pokemon enemy = foe.getTeam().get((int) (Math.random() * foe.getTeamSize()));
		System.out.println(foe.getType() + " " + foe.getName() + " sent out " + enemy.getName());

		System.out.println("An enemy " + enemy.getName() + " appeared!");
		System.out.println();

		System.out.println(String.format("%s's starting HP: %s", enemy.getName(), enemy.getCurrentHP()));
		System.out.println(String.format("%s's starting HP: %s", you.getName(), you.getCurrentHP()));
		System.out.println();

		// Randomizes who gets the first turn
		int turn = (int) (Math.random() * 2) + 1;

		// 70% of the Enemy Pokemon's Health - Use Potion
		// 50% of the Enemy Pokemon's Health - Use Super Potion
		// 20% of the Enemy Pokemon's Health - Use Max Potion
		double seventyFoe = ((double) enemy.getCurrentHP() / 100) * 70;
		double fiftyFoe = ((double) enemy.getCurrentHP() / 100) * 50;
		double twentyFoe = ((double) enemy.getCurrentHP() / 100) * 20;

		while (you.getCurrentHP() > 0 && enemy.getCurrentHP() > 0) {

			// User's turn
			if (turn == 1) {

				// 30% Chance of using the User Pokemon's Strong Move
				if (Math.random() < 0.3) {

					Potion obj1 = new Potion();
					SuperPotion obj2 = new SuperPotion();
					MaxPotion obj3 = new MaxPotion();

					// Subtracts the User's Strong Move's damage from the Enemy's Current HP
					System.out.println(String.format("%s used %s", you.getName(), you.getStrongMove().getName()));
					enemy.setCurrentHP(enemy.getCurrentHP() - you.getStrongMove().getDamage());

					if (!foe.hasNoItems()) {

						// Uses a Potion on the Enemy Pokemon if it's HP drops below 70%
						if (foe.hasPotion()) {

							if (enemy.getCurrentHP() <= seventyFoe && enemy.getCurrentHP() > fiftyFoe) {

								foe.usePotion(enemy);

								System.out.println();
								System.out.println(foe.getName() + " used a " + obj1.getName() + " on " + enemy.getName() + "!");
								System.out.println();

							}

						}

						// Uses a Super Potion on the Enemy Pokemon if it's HP drops below 50%
						if (foe.hasSuperPotion()) {

							if (enemy.getCurrentHP() <= fiftyFoe && enemy.getCurrentHP() > twentyFoe) {

								foe.useSuperPotion(enemy);

								System.out.println();
								System.out.println(foe.getName() + " used a " + obj2.getName() + " on " + enemy.getName() + "!");
								System.out.println();

							}

						}

						// Uses a Max Potion on the Enemy Pokemon if it's HP drops below 20%
						if (foe.hasMaxPotion()) {

							if (enemy.getCurrentHP() <= twentyFoe && enemy.getCurrentHP() > 0) {

								foe.useMaxPotion(enemy);

								System.out.println();
								System.out.println(foe.getName() + " used a " + obj3.getName() + " on " + enemy.getName() + "!");
								System.out.println();

							}

						}

					}

					// Checks if the enemy has fainted or not
					if (enemy.getCurrentHP() < 0) {

						System.out.println(String.format("%s's current HP: 0", enemy.getName()));
						System.out.println(enemy.getName() + " fainted!");

					}

					else {

						System.out.println(String.format("%s's current HP: %s", enemy.getName(), enemy.getCurrentHP()));

					}

					System.out.println();

				}

				// 70% Chance of using the User Pokemon's Weak Move
				else {

					Potion obj1 = new Potion();
					SuperPotion obj2 = new SuperPotion();
					MaxPotion obj3 = new MaxPotion();

					// Subtracts the User's Weak Move's damage from the Enemy's Current HP
					System.out.println(String.format("%s used %s", you.getName(), you.getWeakMove().getName()));
					enemy.setCurrentHP(enemy.getCurrentHP() - you.getWeakMove().getDamage());

					if (!foe.hasNoItems()) {

						if (foe.hasPotion()) {

							if (enemy.getCurrentHP() <= seventyFoe && enemy.getCurrentHP() > fiftyFoe) {

								foe.usePotion(enemy);

								System.out.println();
								System.out.println(foe.getName() + " used a " + obj1.getName() + " on " + enemy.getName() + "!");
								System.out.println();

							}

						}

						if (foe.hasSuperPotion()) {

							if (enemy.getCurrentHP() <= fiftyFoe && enemy.getCurrentHP() > twentyFoe) {

								foe.useSuperPotion(enemy);

								System.out.println();
								System.out.println(foe.getName() + " used a " + obj2.getName() + " on " + enemy.getName() + "!");
								System.out.println();

							}

						}

						if (foe.hasMaxPotion()) {

							if (enemy.getCurrentHP() <= twentyFoe && enemy.getCurrentHP() > 0) {

								foe.useMaxPotion(enemy);

								System.out.println();
								System.out.println(foe.getName() + " used a " + obj3.getName() + " on " + enemy.getName() + "!");
								System.out.println();

							}

						}

					}

					if (enemy.getCurrentHP() < 0) {

						System.out.println(String.format("%s's current HP: 0", enemy.getName()));
						System.out.println(enemy.getName() + " fainted!");

					}

					else {

						System.out.println(String.format("%s's current HP: %s", enemy.getName(), enemy.getCurrentHP()));

					}

					System.out.println();

				}

				// Switches it over to the Enemy Pokemon
				turn = 2;

			}

			// Enemy Pokemon's Turn
			else {

				if (Math.random() < 0.3) {

					// Subtracts the Enemy's Strong Move's damage from the User's Current HP
					System.out.println(String.format("%s used %s", enemy.getName(), enemy.getStrongMove().getName()));
					you.setCurrentHP(you.getCurrentHP() - enemy.getStrongMove().getDamage());

					if (you.getCurrentHP() <= 0) {

						System.out.println(String.format("%s's current HP: 0", you.getName()));
						System.out.println(you.getName() + " fainted!");

					}

					else {

						System.out.println(String.format("%s's current HP: %s", you.getName(), you.getCurrentHP()));
						System.out.println();

						// Prompt to use an Item after each time the User Pokemon gets hit
						System.out.println("Would you like to use an item? Enter y or n");
						String ans = scan.nextLine();
						
						while (!ans.equals("y") && !ans.equals("n")) {
							
							ans = scan.nextLine();
							
						}
						
						// The User says yes
						if (ans.equals("y")) {

							System.out.println();

							if (!trainer.hasNoItems()) {

								Potion obj1 = new Potion();
								SuperPotion obj2 = new SuperPotion();
								MaxPotion obj3 = new MaxPotion();

								boolean check = true;

								while (check) {

									// Asks the User which Item they want to use
									System.out.println("Would you like to use...\n1 - 1 " + obj1.getName() + " - " + obj1.effect()
											+ "\n2 - 1 " + obj2.getName() + " - " + obj2.effect() + "\n3 - 1 " + obj3.getName() + " - "
											+ obj3.effect());
									
									//Input Checker
									while(!scan.hasNextInt()) {
										
										System.out.println("Invalid entry. Try again.");
										scan.next();
										
									}
									
									int itemToUse = scan.nextInt();
									
									while(itemToUse < 1 || itemToUse > 3) {
										
										System.out.println("Invalid entry. Try again.");
										
										while(!scan.hasNextInt()) {
											
											System.out.println("Invalid entry. Try again.");
											scan.next();
											
										}
										
										itemToUse = scan.nextInt();
										
									}

									// They said Potion
									if (itemToUse == 1) {

										// Checks to see if the User has a Potion in its bag and then uses it
										if (trainer.hasPotion()) {

											trainer.usePotion(you);

											System.out.println();
											System.out
													.println(trainer.getName() + " used a " + obj1.getName() + " on " + you.getName() + "!");
											System.out.println();

											check = false;

										}

										else {

											System.out.println("You don't have any " + obj1.getName() + "s.");
											System.out.println();

										}

									}

									// They said Super Potion
									else if (itemToUse == 2) {

										// Checks to see if the User has a Super Potion in its bag and then uses it
										if (trainer.hasSuperPotion()) {

											trainer.useSuperPotion(you);

											System.out.println();
											System.out
													.println(trainer.getName() + " used a " + obj2.getName() + " on " + you.getName() + "!");
											System.out.println();

											check = false;

										}

										else {

											System.out.println("You don't have any " + obj2.getName() + "s.");
											System.out.println();

										}

									}

									// They said Max Potion
									else {

										// Checks to see if the User has a Max Potion in its bag and then uses it
										if (trainer.hasMaxPotion()) {

											trainer.useMaxPotion(you);

											System.out.println();
											System.out
													.println(trainer.getName() + " used a " + obj3.getName() + " on " + you.getName() + "!");
											System.out.println();

											check = false;

										}

										else {

											System.out.println("You don't have any " + obj3.getName() + "s.");
											System.out.println();

										}

									}

									System.out.println();

								}

							}

							// Says you are out of items
							else {

								System.out.println("You have no items to use.");
								System.out.println();

							}

						}

						// The User said no
						else if (ans.equals("n")) {

							System.out.println();
							System.out.println("OK. Good Luck!");
							System.out.println();

						}

						System.out.println(String.format("%s's current HP: %s", you.getName(), you.getCurrentHP()));
						System.out.println();

					}

				}

				else {

					// Subtracts the Enemy's Weak Move's damage from the User's Current HP
					System.out.println(String.format("%s used %s", enemy.getName(), enemy.getWeakMove().getName()));
					you.setCurrentHP(you.getCurrentHP() - enemy.getWeakMove().getDamage());

					if (you.getCurrentHP() <= 0) {

						System.out.println(String.format("%s's current HP: 0", you.getName()));
						System.out.println(you.getName() + " fainted!");

					}

					else {

						System.out.println(String.format("%s's current HP: %s", you.getName(), you.getCurrentHP()));
						System.out.println();

						System.out.println("Would you like to use an item? Enter y or n");
						String ans = scan.nextLine();

						while (!ans.equals("y") && !ans.equals("n")) {
							
							ans = scan.nextLine();
							
						}

						if (ans.equals("y")) {

							System.out.println();

							if (!trainer.hasNoItems()) {

								Potion obj1 = new Potion();
								SuperPotion obj2 = new SuperPotion();
								MaxPotion obj3 = new MaxPotion();

								boolean check = true;

								while (check) {

									System.out.println("Would you like to use...\n1 - 1 " + obj1.getName() + " - " + obj1.effect()
											+ "\n2 - 1 " + obj2.getName() + " - " + obj2.effect() + "\n3 - 1 " + obj3.getName() + " - "
											+ obj3.effect());

									//Input Checker
									while(!scan.hasNextInt()) {
										
										System.out.println("Invalid entry. Try again.");
										scan.next();
										
									}
									
									int itemToUse = scan.nextInt();
									
									while(itemToUse < 1 || itemToUse > 3) {
										
										System.out.println("Invalid entry. Try again.");
										
										while(!scan.hasNextInt()) {
											
											System.out.println("Invalid entry. Try again.");
											scan.next();
											
										}
										
										itemToUse = scan.nextInt();
										
									}

									if (itemToUse == 1) {

										if (trainer.hasPotion()) {

											trainer.usePotion(you);

											System.out.println();
											System.out
													.println(trainer.getName() + " used a " + obj1.getName() + " on " + you.getName() + "!");
											System.out.println();

											check = false;

										}

										else {

											System.out.println("You don't have any " + obj1.getName() + "s.");
											System.out.println();

										}

									}

									else if (itemToUse == 2) {

										if (trainer.hasSuperPotion()) {

											trainer.useSuperPotion(you);

											System.out.println();
											System.out
													.println(trainer.getName() + " used a " + obj2.getName() + " on " + you.getName() + "!");
											System.out.println();

											check = false;

										}

										else {

											System.out.println("You don't have any " + obj2.getName() + "s.");
											System.out.println();

										}

									}

									else {

										if (trainer.hasMaxPotion()) {

											trainer.useMaxPotion(you);

											System.out.println();
											System.out
													.println(trainer.getName() + " used a " + obj3.getName() + " on " + you.getName() + "!");
											System.out.println();

											check = false;

										}

										else {

											System.out.println("You don't have any " + obj3.getName() + "s.");
											System.out.println();

										}

									}

									System.out.println();

								}

							}

							else {

								System.out.println("You have no items to use.");
								System.out.println();

							}

						}

						else if (ans.equals("n")) {

							System.out.println();
							System.out.println("OK. Good Luck!");
							System.out.println();

						}

						System.out.println(String.format("%s's current HP: %s", you.getName(), you.getCurrentHP()));
						System.out.println();

					}

				}

				// Switches it over to the User Pokemon
				turn = 1;

			}
		}

		// If your Pokemon fainted, the Enemy wins.
		if (you.getCurrentHP() <= 0) {

			System.out.println(enemy.getName() + " WINS!");
			lose();

		}

		// If the enemy Pokemon fainted, you win.
		else {

			System.out.println(you.getName() + " WINS!");
			win();

		}

	}

	// Starts the game
	public void game(Scanner scan) {

		// Creates 12 Pokemon objects to be randomly assigned to 2 teams

		Pokemon p1 = new Pokemon("Squirtle", "Water", 200);

		p1.addMove("WEAK", "Bubble", 10);
		p1.addMove("STRONG", "Water Gun", 20);

		Pokemon p2 = new Pokemon("Charmander", "Fire", 200);

		p2.addMove("WEAK", "Ember", 10);
		p2.addMove("STRONG", "Flamethrower", 20);

		Pokemon p3 = new Pokemon("Bulbasaur", "Grass", 200);

		p3.addMove("WEAK", "Razor Leaf", 10);
		p3.addMove("STRONG", "Vine Whip", 20);

		Pokemon p4 = new Pokemon("Mankey", "Fighting", 175);

		p4.addMove("WEAK", "Low Kick", 8);
		p4.addMove("STRONG", "Karate Chop", 16);

		Pokemon p5 = new Pokemon("Caterpie", "Bug", 125);

		p5.addMove("WEAK", "String Shot", 5);
		p5.addMove("STRONG", "Leech Life", 10);

		Pokemon p6 = new Pokemon("Ekans", "Poison", 140);

		p6.addMove("WEAK", "Poison Sting", 6);
		p6.addMove("STRONG", "Acid", 12);

		Pokemon p7 = new Pokemon("Rhydon", "Ground", 175);

		p7.addMove("WEAK", "Mud Slap", 8);
		p7.addMove("STRONG", "Dig", 16);

		Pokemon p8 = new Pokemon("Sandshrew", "Ground", 175);

		p8.addMove("WEAK", "Fissure", 8);
		p8.addMove("STRONG", "Earthquake", 16);

		Pokemon p9 = new Pokemon("Geodude", "Rock", 150);

		p9.addMove("WEAK", "Rock Throw", 7);
		p9.addMove("STRONG", "Rock Blast", 14);

		Pokemon p10 = new Pokemon("Pikachu", "Electric", 200);

		p10.addMove("WEAK", "Thunder Shock", 10);
		p10.addMove("STRONG", "Thunder Bolt", 20);

		Pokemon p11 = new Pokemon("Onix", "Rock", 150);

		p11.addMove("WEAK", "Rollout", 7);
		p11.addMove("STRONG", "Rock Blast", 14);

		Pokemon p12 = new Pokemon("Abra", "Psychic", 150);

		p12.addMove("WEAK", "Confusion", 7);
		p12.addMove("STRONG", "Psybeam", 14);

		Trainer enemy = new Trainer("Gary", "Rival");

		enemy.addToTeam(p1);
		enemy.addToTeam(p2);
		enemy.addToTeam(p3);
		enemy.addToTeam(p4);
		enemy.addToTeam(p5);
		enemy.addToTeam(p6);
		enemy.addToTeam(p7);
		enemy.addToTeam(p8);
		enemy.addToTeam(p9);
		enemy.addToTeam(p10);
		enemy.addToTeam(p11);
		enemy.addToTeam(p12);

		System.out.println();

		System.out.print("What's your name? ");

		String name = scan.nextLine();

		Trainer you = new Trainer(name, "You");

		while (you.getTeamSize() < 6) {

			you.addToTeam(enemy.removeFromTeam());

		}

		// Sets both you and the enemy up with one of each Potion

		you.addPotion();
		you.addSuperPotion();
		you.addMaxPotion();

		enemy.addPotion();
		enemy.addSuperPotion();
		enemy.addMaxPotion();

		System.out.println();

		for (int i = 1; i <= 6; i++) {

			System.out.println(i + " - " + you.getTeam().get(i - 1).toString());

		}

		// Begins the battle sequence
		battle(you, enemy, scan);

	}

}