package TareaProgra;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Regreso extends Image {
	ReInput Toque;
	public Regreso (Texture tex){
		super(tex);
		Toque = new ReInput(this);
		addListener(Toque);
		
	}
	public boolean Activacion(){
		System.out.print("Si");
		return Toque.getActivacion();
	}
	public void Desactivacion(){
		Toque.setDesactivacion();
	}
}
