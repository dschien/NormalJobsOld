package paretojobs.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		
		addSliderWL ("totalRequirements", "Total number of requirements", 1 , 1000 , 100000 , 10001)		
		addSliderWL ("numWorkers", "Number of Workers", 1 , 1 , 1000 , 11)		
		addSliderWL ("distShape", "Shape", 1 , 1 , 100, 2)		
		addMonitorWL ("getCompletedJobs", "Completed Jobs", 1)
	}
}