package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Drone extends MovableGameObject {
	
	public Drone(float x, float y, int size, int color, int heading, int speed) {
		super(x,y,size,color,heading,speed);
	}

	//Drones cannot set color after creation
	public void setColor() {}

	public String toString() {
		return "Drone: loc=" + this.location.getX() + "," + this.location.getY() +
		" color=[" + ColorUtil.red(this.color) + "," + ColorUtil.blue(this.color) + "," + ColorUtil.green(this.color) + "]" +
		" heading=" + this.getHeading() +
		" speed=" + this.getSpeed() +
		" size=" + this.getSize();
	}

	protected void updateHeading() {
		Random rand = new Random();
		//Drones randomly update their heading to be 5 degrees in either direction
		//generate a random number between -5 and 5
		int headingAdjustment = rand.nextInt(10) - 5;
		
		//update drone heading
		this.setHeading(this.getHeading() + headingAdjustment);
	}

	public void update() {
		move(20);
		updateHeading();
	}

	public String getClassName() {
		return "Drone";
	}
	public void draw(Graphics g, Point p) {
		Point drawAt = new Point();
		drawAt.setX(getLocation().getX() - getSize()/2);
		drawAt.setY(getLocation().getY() - getSize()/2);
		

		g.setColor(getColor());
		g.fillRect((int)(p.getX()+drawAt.getX()), (int)(p.getY()+drawAt.getY()), size, size);
	}
}