package TareaProgra;


//import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class INSTinput extends InputListener{
	INST inicio;
	//Texture	instruc = new Texture("instrucciones.png");
	//Image in = new Image(instruc);
	static boolean activacion = false;
	public INSTinput(INST ini){
		super();
		this.inicio = ini;
	}
		@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
		int button) {
		System.out.println("Instrucciones");
		//Activacion
		activacion = true;
		return super.touchDown(event, x, y, pointer, button);
	}
	public boolean getActivacion(){
		return activacion;
	}
	public void setActivacion(){
		activacion = false;
	}
}
