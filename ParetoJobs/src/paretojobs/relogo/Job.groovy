package paretojobs.relogo

class Job {
	Level level
	double effort
	double completion = 0
	
	
	
}

class JobComparator implements Comparator<Job>{

	@Override
	public int compare(Job o1, Job o2) {		
		return o1.effort.compareTo(o2.effort);
	}
	
}

