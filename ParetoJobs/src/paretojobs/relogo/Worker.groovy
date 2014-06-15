package paretojobs.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*
import paretojobs.ReLogoTurtle
import repast.simphony.engine.environment.RunEnvironment

class Worker extends ReLogoTurtle {

	double skill = 1
	Job job
	double maxEffort
	
	/**
	 * If he has a job, works on it
	 * with each iteration, he learns. Learning is on a log scale
	 * @return
	 */
	def step(){

		if (job){
			double increment = skill
			job.completion += increment

//			double ticks = RunEnvironment.getInstance().getCurrentSchedule().getTickCount()
//			skill += Math.sqrt(ticks)
			return job
		}
		return null
	}
}
