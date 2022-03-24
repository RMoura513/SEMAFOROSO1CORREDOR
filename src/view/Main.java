package view;

import java.util.concurrent.Semaphore;

import controller.ControleCorredor;

public class Main {

	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);

		for(int id = 1; id < 5; id++) {
			ControleCorredor controlecorredor = new ControleCorredor(id, semaforo);
			controlecorredor.start();		
					
		}
		
		
	}

}
