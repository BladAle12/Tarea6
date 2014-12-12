package TareaProgra;




import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;



public class Principal extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture  img,opc,  ini, instru, salir, men, instruc, cuadro;
	Image imag, ImaCuadro;
	Stage capa, menu, inst;
	Music replay, salto;
	Personaje corredor;
	Plataform tierra;
	INST ins;
	Regreso regre;
	INI inic;
	Regreso in;
	Ghost ac1;
	Llama llama;
	Image rotate;
	int cont = 0, cont2 = 0, cont3 = 200, extra = 0, extra2 = 0;
	boolean activado = true, activado2= false;
	static MultiplataformInterface mutiplatafom_interface;
	
	public Principal(MultiplataformInterface multiplataform_interface){
		this.mutiplatafom_interface = multiplataform_interface;
		
	}
	
	@Override
	public void create () {
		instruc = new Texture("instrucciones.png");
		in = new Regreso(instruc);
		cuadro = new Texture("cuadro.png");
		ImaCuadro = new Image(cuadro);
		men = new Texture("MENU.png");
		instru = new Texture("INS.png");
		llama = new Llama();
		ins = new INST(instru);
		ini = new Texture("INI.png");
		inic = new INI(ini);
		batch = new SpriteBatch();
		capa = new Stage();
		menu = new Stage();
		inst = new Stage();
		opc = new Texture("INS.png");
		ins = new INST(opc);
		tierra = new Plataform();
		corredor = new Personaje();
		//musica bajada = https://www.jamendo.com/es/list/a140048/eye-of-the-storm
		img = new Texture("fondo.jpg");
		replay = Gdx.audio.newMusic(Gdx.files.getFileHandle("rola.mp3", FileType.Internal));
		replay.setLooping(true);
		replay.play();
		salto = Gdx.audio.newMusic(Gdx.files.getFileHandle("rola2.mp3", FileType.Internal));
		salto.setLooping(true);
		
		//Prueba de Rotacion
		rotate = new Image(cuadro);
		rotate.setOrigin(rotate.getWidth()/2, rotate.getHeight()/2);
		rotate.setPosition(500, 100);
		menu.addActor(rotate);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(cont == 0){
			Plata();
			cont = 100;
		}
		cont3--;
		cont--;
		if(activado && !activado2){
			MENU();
			batch.begin();
			batch.draw(men, 100, 150);
			batch.end();
			rotate.setRotation(extra2++);
			}
			if(!activado){
				Gdx.input.setInputProcessor(this);
				batch.begin();
				batch.draw(img, 0, 0);
				batch.end();
				capa.addActor(corredor);
				capa.draw();
				capa.act();
				if(cont2%200==0){
					Enemigo1();
					cont2 = 0;
				}
				cont2++;
			}
		if(activado2){
			REG();
		}
	}
	
	public void Plata(){
		Plataform ob = new Plataform();
		capa.addActor(ob);
	}
	public void Cuadro(){
		if(extra<=700){
		ImaCuadro.setX(ImaCuadro.getX()+1);
		menu.addActor(ImaCuadro);}
		else{extra = 0;
		ImaCuadro.setX(-100);
		}
		extra++;
	}
	public void Enemigo1(){
		ac1 = new Ghost(corredor);
		System.out.print(""+ac1.gameOver());
		ac1.rotateBy(60);
		if(ac1.gameOver()){
			System.out.print("Por Fin");
			activado = true;
			inic.Desactivacion();
		}
		capa.addActor(ac1);
		
	}
	public void LLama(){
		menu.addActor(llama);
	}
	
	//MENU
	public void MENU(){
		Gdx.input.setInputProcessor(menu);
		Inicio();
		Instrucciones();
		Salir();
		LLama();
		Cuadro();
		menu.draw();
		menu.act();
	}
	public void Inicio(){
		inic.setY(350);
		inic.setX(250);
		menu.addActor(inic);
		if(inic.Activacion()){
			System.out.println("inicie");
			activado = false;
		}
	}
	public void Instrucciones(){
		ins.setY(200);
		ins.setX(350);
		//DESACTIVA LA FUNCION 
		if(ins.Activacion()){
			System.out.println("veo");
			activado2 = true;
			ins.Desactivar();
			return;
		}
		menu.addActor(ins);
	}
	public void REG(){
		Gdx.input.setInputProcessor(inst);
		RegresoIns();
		inst.draw();
		inst.act();
	}
	public void RegresoIns(){
		in.setX(190);
		in.setY(150);
		inst.addActor(in);
		//DESACTIVA LA FUNCION
		if(in.Activacion()){
			System.out.println("Funciona");
			in.Desactivacion();
			activado2  = false;
		}
	}
	public void Salir(){
		salir = new Texture("SAL.png");
		SAL sal = new SAL(salir);
		sal.setY(30);
		sal.setX(250);
		menu.addActor(sal);
		
	}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		System.out.println("Test");
		corredor.salta();
		salto.play();
		replay.stop();
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		salto.stop();
		replay.play();
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
