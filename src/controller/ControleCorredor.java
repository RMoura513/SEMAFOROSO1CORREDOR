package controller;

import java.util.concurrent.Semaphore;

public class ControleCorredor extends Thread {
	
	private int id;
	private Semaphore semaforo;

	public ControleCorredor(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
		
	}
	
	@Override
	public void run() {
		andando();
		
		try {
			semaforo.acquire();
			porta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
		
	}
	
	public void andando() {
		int dst = 200;
		int dstp = 0;
		int dstr = 0;
		
		
		while(dstp < dst) {
			dstr = (int)((Math.random()* 3)+ 4);
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dstp = dstp + dstr;
			
			if (dstp < dst) {
			System.out.println("Pessoa #" + id + " andou " + dstr + " metros e já percorreu " + dstp + " metros no total");
		
			}
			else {
			System.out.println("Pessoa #" + id + " percorreu todo o caminho até a porta");	
			}
			
			
		}
		
		
	}
	
	public void porta() {
		int abrep;
		abrep = (int)((Math.random()* 2)+ 1);
		
		try {
			sleep(abrep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Pessoa #" + id + " passou pela porta");
	}
	
	
	
}
