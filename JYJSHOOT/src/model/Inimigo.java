package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class Inimigo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7508901287376056130L;
	
	int x;
	int y;

	int hp = 100;

	ArrayList<Point> tirosInimigo;

	Rectangle area;


	public Inimigo(int x) {
		this.x = x;
		y = 5;
		area = new Rectangle(x, y, 40, 40);

		tirosInimigo = new ArrayList<Point>();
	}

	public void dano(){
		hp -= 10;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Rectangle getArea() {
		area.x = this.x;
		area.y = this.y;
		return area;
	}


	public void setArea(Rectangle area) {
		this.area = area;
	}


	public ArrayList<Point> getTirosInimigo() {
		return tirosInimigo;
	}

	public int getHp() {
		return hp;
	}
	public void setHp (int hp){
		this.hp = hp;
	}


}
