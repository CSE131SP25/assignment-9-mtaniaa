package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		
		segments = new LinkedList<>();
		
		BodySegment initialSegment = new BodySegment (0.5, 0.5, SEGMENT_SIZE);
		segments.add(initialSegment);
		
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		BodySegment head = segments.getFirst();
		double newX = head.getX() + deltaX;
	    double newY = head.getY() + deltaY;
	    BodySegment newHead = new BodySegment(newX, newY, SEGMENT_SIZE);
	    segments.addFirst(newHead);
	}
	
	public void grow() {
        // Duplicate the tail to grow
        BodySegment tail = segments.getLast();
        BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE);
        segments.addLast(newSegment);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		for(int i = 0; i<segments.size(); i++) {
			segments.get(i).draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		BodySegment head = segments.getFirst();
	    double headX = head.getX();
	    double headY = head.getY();
	    
	    double foodX = f.getX();
	    double foodY = f.getY();
	    double foodRadius = f.getFoodSize();

	    
	    double dx = headX - foodX;
	    double dy = headY - foodY;
	    double distance = Math.sqrt(dx * dx + dy * dy);
	    
	    
	    if (distance < SEGMENT_SIZE / 2 + foodRadius) {
	        
	        return true;
	    } else {
	       
	    	if (segments.size() > 1) {
	            segments.removeLast();
	        }
	        return false;
	    }
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		BodySegment head = segments.getFirst();
        double x = head.getX();
        double y = head.getY();
        return x >= 0 && x <= 1 && y >= 0 && y <= 1;
	}
}
