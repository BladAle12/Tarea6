package TareaProgra;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class INIinput extends InputListener {
	INI inicio;
	boolean activacion = false;
	public INIinput(INI ini){
		super();
		this.inicio = ini;
	}
		@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		System.out.println("Inicio");
		//Activacion
		activacion = true;
		
		return super.touchDown(event, x, y, pointer, button);
	}
	public boolean getActivacion(){
		return activacion;
	}
	public void setDesactivacion(){
		activacion = false;
	}
}
