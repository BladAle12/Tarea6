package TareaProgra;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Llama extends Actor {
	ArrayList<Image>images;
	int dibujo_actual=0;
	float tiempo_act=0;
	
	
	public Llama(){
		super();
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("antorcha01.png")));
		images.add(new Image(new Texture("antorcha02.png")));
		images.add(new Image(new Texture("antorcha03.png")));
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		tiempo_act+=delta;
		if(tiempo_act>0.1f){
			dibujo_actual++;
			tiempo_act=0;
		}
		if(dibujo_actual >= images.size()){
			dibujo_actual=0;
		}
		System.out.println(dibujo_actual);
}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		images.get(dibujo_actual).setX(300);
		images.get(dibujo_actual).setY(60);
		images.get(dibujo_actual).draw(batch, parentAlpha);
	}
}

