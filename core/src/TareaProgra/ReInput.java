package TareaProgra;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ReInput extends InputListener {
	Regreso inicio;
	boolean activacion = false;
	public ReInput(Regreso ini){
		super();
		this.inicio = ini;
	}
		@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
		int button) {
		System.out.println("Regreso");
		activacion = true;
		//Activacion
		return super.touchDown(event, x, y, pointer, button);
	}
	public boolean getActivacion(){
		System.out.println("entro111");
		return activacion;
	}
	public void setDesactivacion(){
		activacion = false;
	}
	
}
