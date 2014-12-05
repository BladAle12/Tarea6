package TareaProgra;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class INI extends Image {
	INIinput Toque;
	public INI (Texture tex){
		super(tex);
		Toque = new INIinput(this);
		addListener(Toque);
	}
	public boolean Activacion(){
		return Toque.getActivacion();
	}
	public void Desactivacion(){
		Toque.setDesactivacion();
	}
}
