package TareaProgra;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Plataform extends Image {
public Plataform(){
	super(new Texture("tierra.png"));
	this.setX(500);
	this.setY(-200);
}
public void act(float delta){
	super.act(delta);
	this.setX(this.getX()-delta*200);
}
}
