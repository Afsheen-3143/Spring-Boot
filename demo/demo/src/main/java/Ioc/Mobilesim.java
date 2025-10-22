package Ioc;

public class Mobilesim {
	
			private Sim sim;

			public Mobilesim(Sim sim) {
				super();
				this.sim = sim;
			}
			 public void makeCall() {
			        sim.callcenter();
			 }
			 public void network() {
				 sim.browseinternet();
			 }
		}


