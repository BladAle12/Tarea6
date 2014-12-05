package TareaProgra;

import java.util.ArrayList;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Ghost extends Actor {
	ArrayList <Image> images;
	ArrayList <Image> imagesZ; 
	int dibujo_actual=0;
	 boolean GameOver = false;
	 float tiemp = 0;
	 int degrees=0;
	 
	 Personaje per;
		public Ghost(Personaje per){
		super();
		this.per = per;
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("voladorD01.png")));
		images.add(new Image(new Texture("voladorD02.png")));
		images.add(new Image(new Texture("voladorD03.png")));
		imagesZ = new ArrayList<Image>();
		imagesZ.add(new Image(new Texture("voladorZ01.png")));
		imagesZ.add(new Image(new Texture("voladorZ02.png")));
		imagesZ.add(new Image(new Texture("voladorZ03.png")));
		 this.setX(600);
	}
		public void act(float delta){
			
			super.act(delta);
			
			tiemp+=delta;
			if(tiemp>0.1f){
			dibujo_actual++;
			tiemp=0;
			}
			if(dibujo_actual>=imagesZ.size()){
				dibujo_actual = 0;
			}
			/*if(this.getX()>=0 && op ==true){
			this.setX(this.getX()+2);
			//this.setY(this.getX());
			if(this.getX()==350){	
				op = false;
			}}else if(op == false){
				*/this.setX(this.getX()-5);
				//this.setY(this.getX());
				//if(this.getX() == 0){
					//op = true;
				//}
			//}
				Rectangle r1=new Rectangle(this.getX(), this.getY(), 85, 85);
				Rectangle r2=new Rectangle(per.getX(), per.getY(), 95, 95);
				if(r1.overlaps(r2)){
					System.out.println("Game Over");
					setGameOver(true);
				}
		}
		public void draw(Batch batch, float parentAlpha){
			super.draw(batch, parentAlpha);
			/*if(op==true){
			images.get(dibujo_actual).setX(this.getX());
			images.get(dibujo_actual).setY(200);
			images.get(dibujo_actual).draw(batch, parentAlpha);
			}else{*/
				
				imagesZ.get(dibujo_actual).setX(this.getX());
				imagesZ.get(dibujo_actual).setY(50);	
				this.setY(imagesZ.get(dibujo_actual).getY());
				imagesZ.get(dibujo_actual).draw(batch, parentAlpha);
			}
		
		
		public boolean gameOver(){
			System.out.println(GameOver);
			return GameOver;
		}
		public void setGameOver(boolean fil){
			GameOver = fil;
		}
}
