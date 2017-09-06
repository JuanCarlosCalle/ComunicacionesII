package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class Personaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1605196378640192870L;
	
	int x;
	int y;

	int hp = 100;

	ArrayList<Point> tirosUsuario;

	Rectangle area;


	public Personaje(int x) {
		this.x = x;
		y = 5;
		area = new Rectangle(x, y, 40, 40);

		tirosUsuario = new ArrayList<Point>();
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


	public ArrayList<Point> getTirosUsuario() {
		return tirosUsuario;
	}


	public int getHp() {
		return hp;
	}
	
	public void pegarDados(){}
}
