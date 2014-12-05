package TareaProgra;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
//import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Actor2 extends Actor {
	ArrayList<Image>images;
	int dibujo_actual=0;
	float tiempo_act=0;
	Personaje per;
	
	public Actor2(Personaje per){
		super();
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("bomba01.png")));
		images.add(new Image(new Texture("bomba02.png")));
		images.add(new Image(new Texture("bomba03.png")));
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
//		System.out.println(delta);
		tiempo_act+=delta;
		if(tiempo_act>0.1f){
			dibujo_actual++;
			tiempo_act=0;
		}
		if(dibujo_actual >= images.size()){
			dibujo_actual=0;
		}
		this.setX(this.getX()-6);
		
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		images.get(dibujo_actual).setX(this.getX()+600);
		images.get(dibujo_actual).setY(60);
		images.get(dibujo_actual).draw(batch, parentAlpha);
	}
}
