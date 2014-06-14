package paretojobs.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		
//		addSliderWL ("learningRate", "Learning Rate", 1, 1 ,100, 1)
		addSliderWL ("avgWorkEffort ", "Average Job Effort", 1, 100 ,1000, 101)
		addSliderWL ("varWorkEffort ", "Variance Job Effort", 1, 100 ,1000, 10)
//		addSliderWL ("minWorkEffort ", "Minimum Job Effort", 1, 10 ,100, 11)
		addSliderWL ("numWorkers", "Number of Workers", 1 , 1 , 100 , 2)		
		addSliderWL ("numJobs", "Number of Jobs", 1 , 1000 , 10000 , 1001)
		addMonitorWL ("getCompletedJobs", "Completed Jobs", 1)
	}
}