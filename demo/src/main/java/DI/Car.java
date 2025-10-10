package DI;

public class Car {
	private Engine engine;
	private Music music;
	
	public Car(Engine engine) {
		this.engine = engine;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
	
	 public void startCar() {
	        engine.carEngine();
	        music.Musicsystem();
	    }

}
