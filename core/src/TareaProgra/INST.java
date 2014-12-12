package TareaProgra;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class INST extends Image { 
	INSTinput Toque;
	public INST (Texture tex){
		super(tex);
		Toque = new INSTinput(this);
		addListener(Toque);
	}
	public boolean Activacion(){
		return Toque.getActivacion();
	}
	public void Desactivar(){
		Toque.setActivacion();
	}
	//public Image getImage(){
	//return Toque.in;
	//}
	
}
