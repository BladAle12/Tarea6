package TareaProgra;

import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class SALinput extends InputListener {
	SAL inicio;
	static boolean activacion = false;
	public SALinput(SAL ini){
		super();
		this.inicio = ini;
	}
		@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
		int button) {
		System.out.println("Salir");
		//Activacion
		activacion = true;
		System.exit(0);
		return super.touchDown(event, x, y, pointer, button);
	}
	public boolean getActivacion(){
		return activacion;
	}


}
