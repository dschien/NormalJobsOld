package tests;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

import org.junit.Test;
import paretojobs.relogo.Job
import paretojobs.relogo.JobComparator
import paretojobs.relogo.Level

class AllTests {

	@Test
	public void testJobComparator() {
		PriorityQueue jobs = new PriorityQueue(3, new JobComparator())
		jobs << new Job(level:Level.EASY, effort: 0.2)
		jobs << new Job(level:Level.EASY, effort: 0.1)
		jobs << new Job(level:Level.EASY, effort: 0.3)
		
		(0..10).each{
			println jobs.poll()?.effort
		}
		
		
	}

}
