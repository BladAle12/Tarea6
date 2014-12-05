package TareaProgra;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SAL extends Image {
	SALinput Toque;
	
	public SAL (Texture tex){
		super(tex);
		Toque = new SALinput(this);
		addListener(Toque);
	}
	public boolean Activacion(){
		return Toque.getActivacion();
	}
}
