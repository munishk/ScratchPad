import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PolicyEnforcerService {
	
	private ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	
	public void submit(Runnable job) {
		executorService.submit(job);
	}
	
	public void shutdown() {
		executorService.shutdown();
		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdownNow() {
		executorService.shutdownNow();
	}
	
	
	static class Job implements Runnable {
		
		private int JobNumber;
		
		public Job(int count) {
			this.JobNumber = count;
		}

		@Override
		public void run() {
			try {
				System.out.println("Executing job: " + JobNumber + ", Thread: " + Thread.currentThread().getName());
				Thread.sleep(1000);
				System.out.println("Executed job: " + JobNumber + ", Thread: " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		PolicyEnforcerService polService = new PolicyEnforcerService();
		for(int i=0; i < 10000; i++) {
			polService.submit(new Job(i));
		}
		
		System.out.println("Submitted Job...");
		
		Thread.sleep(10*1000);
		
		System.out.println("After sleep...");
		
		polService.shutdown();
		
       Thread.sleep(10*1000);
		
		System.out.println("After sleep...");
		
		polService.shutdownNow();
		
	}

}
