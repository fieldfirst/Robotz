package com.robotz.view.texture;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Robot extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String variableName;
	
	private final String NORTH_DIRECTION = "north";
	private final String EAST_DIRECTION = "east";
	private final String WEST_DIRECTION = "west";
	private final String SOUTH_DIRECTION = "south";
	
	private ImageIcon NORTH_TEXTURE;
	private ImageIcon EAST_TEXTURE;
	private ImageIcon WEST_TEXTURE;
	private ImageIcon SOUTH_TEXTURE;
	
	private int xPosition;
	private int yPosition;
	
	private Image background;
	
	public Robot(String name, int xPosition, int yPosition) {
		
		// Initial robot's heading direction is north
		
		this.variableName = name;
		
		this.xPosition = xPosition;
		
		this.yPosition = yPosition;
		
		selectRandomColor();
		
		background = NORTH_TEXTURE.getImage();
		
		Dimension size = new Dimension(NORTH_TEXTURE.getIconWidth(), NORTH_TEXTURE.getIconHeight());
		
		setMinimumSize(size);
		
		setPreferredSize(size);
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
		g.drawImage(background, 0, 0, null);
		
		g.drawString(variableName, 20, 50);
		
		g.drawString(xPosition + "," + yPosition, 20, 62);
		
	}
	
	public void setDirection(String direction) {
		
		if (direction.equals(NORTH_DIRECTION))
			background = NORTH_TEXTURE.getImage();
		
		else if (direction.equals(EAST_DIRECTION))
			background = EAST_TEXTURE.getImage();
		
		else if (direction.equals(WEST_DIRECTION))
			background = WEST_TEXTURE.getImage();
		
		else if (direction.equals(SOUTH_DIRECTION))
			background = SOUTH_TEXTURE.getImage();
		
		
	}
	
	public void selectRandomColor() {
		
		Random rand = new Random();
		
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		
		switch (randomNum) {
		
		case 1 : 
			
			NORTH_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_north_red.png"));
			
			EAST_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_east_red.png"));
			
			WEST_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_west_red.png"));
			
			SOUTH_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_south_red.png"));
						
			break;
			
		case 2 : 
			
			NORTH_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_north_yellow.png"));
			
			EAST_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_east_yellow.png"));
			
			WEST_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_west_yellow.png"));
			
			SOUTH_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_south_yellow.png"));
						
			break;
			
		case 3 :
			
			NORTH_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_north_gray.png"));
			
			EAST_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_east_gray.png"));
			
			WEST_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_west_gray.png"));
			
			SOUTH_TEXTURE = new ImageIcon(getClass().getResource("../resources/robot_south_gray.png"));
						
			break;
		
		}
		
	}

}
