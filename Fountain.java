
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Shopping Cart
// Files:           None.
// Course:          Comp Sci 300, LEC-005, Spring 2019
//
// Author:          Shihan Cheng
// Email:           scheng93@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Ruoxi Shen
// Partner Email:   rshen27@wisc.edu
// Partner Lecturer's Name: LEC-005
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Random;

public class Fountain {

	private static Particle[] particles; // Array to store particle objects
	private static Random randGen; // Random field
	
	// Features of the particle
	private static int positionX;
	private static int positionY;
	private static int startColor;
	private static int endColor;

	/**
	 * This method should be the firstly called by class Utility, and should be only
	 * called once to build a new object of array to store the reference of
	 * particles.
	 * 
	 * No return type
	 */
	public static void setup() {
		testUpdateParticle();
		testRemoveOldParticles();
		
		if (testUpdateParticle() == true || testRemoveOldParticles() == true) {
			System.out.println("FAILED");
		}
		
		// Build a new random field.
		randGen = new Random();

		positionX = 400; // middle of the screen (left to right): 400
		positionY = 300; // middle of the screen (top to bottom): 300
		startColor = Utility.color(23, 141, 235); // blue: Utility.color(23,141,235)
		endColor = Utility.color(23, 200, 255); // lighter blue: Utility.color(23,200,255)
		
		// This array can store 800 particles
		particles = new Particle[800];

	}

	/**
	 * This method should be clearing the background, and then looping through the
	 * the indexes of your particles array, and calling updateParticle() for each
	 * index that does not contain a null reference.
	 * 
	 * No return type
	 */
	public static void update() {
		
		// Fill the background for every call
		Utility.background(Utility.color(235, 213, 186));
		
		// Create 10 new random particles
		createNewParticles(10);
		
		// Track every particle in the array then update their feature
		for (int i = 0; i < particles.length; i++) {
			if (particles[i] != null) {
				updateParticle(i);
			}

		}

	}

	/**
	 * This method should do all of the moving, accelerating, and drawing of a
	 * particle that we have implemented so far, but should be able to do that with
	 * whatever particle is specified through the provided index.
	 * 
	 * @param index the index of the specified particle in the array
	 * 
	 *              No return type
	 */
	private static void updateParticle(int index) {

		float posX = particles[index].getPositionX(); // Current X position of the particle
		float posY = particles[index].getPositionY(); // Current Y position of the particle
		float vX = particles[index].getVelocityX(); // Current horizontal velocity of the particle
		float vY = particles[index].getVelocityY();	// Current vertical velocity of the particle
		int age = particles[index].getAge();	// Current age of the particle
		
		// Fill the circle's color and transparency
		Utility.fill(particles[index].getColor(), particles[index].getTransparency());
		
		// Draw the circle
		Utility.circle(posX, posY, particles[index].getSize());
		
		// Update vertical velocity effected by gravity
		vY = vY + 0.3f;
		// Update the particle's vertical velocity, XY positions and its age
		particles[index].setVelocityY(vY);
		particles[index].setPositionX(posX + vX);
		particles[index].setPositionY(posY + vY);
		particles[index].setAge(age + 1);
		
		// Call this method to remove the old particles
		removeOldParticles(80);
		

	}

	/**
	 * This method should do all of the moving, accelerating, and drawing of a
	 * particle that we have implemented so far, but should be able to do that with
	 * whatever particle is specified through the provided index.
	 * 
	 * @param index the index of the specified particle in the array
	 * 
	 *              No return type
	 */
	private static void createNewParticles(int number) {
		// The following declarations are to initialize the random range for the 
		// particle's feature
		int maxX = Fountain.positionX + 3;
		int minX = Fountain.positionX - 3;
		int boundX = maxX - minX;
		int maxY = Fountain.positionY + 3;
		int minY = Fountain.positionY - 3;
		int boundY = maxY - minY;
		
		int particleCount = 0; // For counting the new particles' amount

		
			for (int i = 0; i < particles.length; i++) {
				if (particles[i] == null) {
					++particleCount;
					
					// Following codes are to prepare the setting for the particle
					int positionX = randGen.nextInt(boundX + 1) + maxX;
					int positionY = randGen.nextInt(boundY + 1) + maxY;
					float xVelocity = -1 + randGen.nextFloat() * (2);
					float yVelocity = -10 + randGen.nextFloat() * (5);
					float amount = randGen.nextFloat() * 1;
					int color = Utility.lerpColor(Fountain.startColor, Fountain.endColor, amount);
					float size = randGen.nextFloat() * (11 - 4);
					int age = randGen.nextInt(40 + 1);
					int transparency = randGen.nextInt((96)) + 32;
					
					// TO set the new particle with random feature
					particles[i] = new Particle();
					particles[i].setPositionX(positionX);
					particles[i].setPositionY(positionY);
					particles[i].setVelocityX(xVelocity);
					particles[i].setVelocityY(yVelocity);
					particles[i].setSize(size);
					particles[i].setColor(color);
					particles[i].setAge(age);
					particles[i].setTransparency(transparency);
				}
				
				// Once after creating 10 new particles, ends this method
				if (particleCount >= number) {
					break;
				}
			}
		}
	
	/**
	 * This method should do removing the old particles which is older than 80
	 * 
	 * @param maxAge the particle length longer than 80 
	 * 
	 *              No return type
	 */
	private static void removeOldParticles(int maxAge) {
		// Track the whole array
		for (int i = 0; i < particles.length; i++) {
			// If the particle is null reference, continue to track
			if (particles[i] == null) {
				continue;
			}
			// If the particle's age is greater than 80
			// change it to a null reference
			else if (particles[i].getAge() > maxAge) {
				particles[i] = null;
			}
		}
	}
	
	/**
	 * This method set up the mouse's position
	 * 
	 * @param posX mouse's position on x-coordinate 
	 * @param posY mouse's position on y-coordinate
	 *
	 *              No return type
	 */
	public static void mousePressed(int posX, int posY) {
		// Move the fountain's starting position as the user's choice made by mouse
		positionX = posX;
		positionY = posY;
	}
	
	/**
	 * This method check if the user pressed p to save a screenshot
	 * @param click User's click
	 *
	 * No return type
	 */
	public static void keyPressed(char click) {
		// When users click left button of the mouse
		if (click == 'p' ) {
			Utility.save("screenshot.png");
		}
	}

	/**
	 * Creates a single particle at position (3,3) with velocity (-1,-2). Then
	 * checks whether calling updateParticle() on this particle's index correctly
	 * results in changing its position to (2,1.3).
	 * 
	 * @return true when no defect is found, and false otherwise
	 */
	private static boolean testUpdateParticle() {
		particles = new Particle[1];
		particles[0] = new Particle(3, 3, 10, 10);
		
		particles[0].setVelocityX(-1);
		particles[0].setVelocityY(-2);
		updateParticle(0);
		
		if (particles[0].getPositionX() != 2 || particles[0].getPositionY() != 1.3) {
			return true;
		}
		return false; 
	}

	/**
	 * Calls removeOldParticles(6) on an array with three particles (two of which
	 * have ages over six and another that does not). Then checks whether the old
	 * particles were removed and the young particle was left alone.
	 * 
	 * @return true when no defect is found, and false otherwise
	 */
	private static boolean testRemoveOldParticles() {
		particles = new Particle[3];
		particles[0] = new Particle();
		particles[1] = new Particle();
		particles[2] = new Particle();
		particles[0].setAge(7);
		particles[1].setAge(7);
		particles[2].setAge(3);
		removeOldParticles(6);
		
		if (particles[0] != null || particles[1] != null || particles[2].getAge() != 3) {
			return true;
		}

		return false; 
	}

	/**
	 * Main method in this class only calls the run function from class Utility
	 * 
	 * @param args (input arguments if any)
	 */
	public static void main(String arg[]) {

		Utility.runApplication();
	}

}
