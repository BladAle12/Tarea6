package TareaProgra;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.Actor;
public class Personaje extends Actor {
	ArrayList<Image>images;
	int dibujo_actual=0;
	float tiempo_act=0;
	float velocidadY = 0;
	float acelerationY = 1f;
	
	public Personaje(){
		super();
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("corre1.png")));
		images.add(new Image(new Texture("corre2.png")));
		images.add(new Image(new Texture("corre3.png")));
		images.add(new Image(new Texture("corre4.png")));
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
		
		
		//Desplazamiento
		velocidadY+=acelerationY;
		this.setY(this.getY()+velocidadY);
		
		
		//Gravedad
		acelerationY -= 0.09;
		
		
		if(this.getY()<=70){//Caigo en el piso
		velocidadY = 0;
		acelerationY = 0;
		this.setY(70);
		}
}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		images.get(dibujo_actual).setX(5);
		images.get(dibujo_actual).setY(this.getY());
		images.get(dibujo_actual).draw(batch, parentAlpha);
	}
	public void salta(){
		if(this.getY()==70){
		acelerationY =1.5f;}
	}
}
