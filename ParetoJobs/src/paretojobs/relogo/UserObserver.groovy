package paretojobs.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*
import paretojobs.ReLogoObserver
import repast.simphony.engine.environment.RunEnvironment
import repast.simphony.relogo.Stop
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup


class UserObserver extends ReLogoObserver{
	static Queue completedJobs = [] as Queue
	def getCompletedJobs(){
		return completedJobs.size()
	}

	static Queue jobs = [] as Queue

	Double scale = null
	Double shape= 1

	@Setup
	def setup(){
		clearAll()
		jobs = [] as Queue
		completedJobs = [] as Queue
		// need to wait until after initialisation
		scale = minWorkEffort

		// init the jobs - work effort is pareto distributed with shape 1
		// so that we get the 80-20 rule
		(0..numJobs).each{
			def x = new Random().nextGaussian() * avgWorkEffort + varWorkEffort 
			double effort = 0
			if (x < shape){
				effort = scale
			} else {
				effort = shape * Math.pow(scale, shape )  / Math.pow(x, shape+1) + scale
			}

			jobs << new Job(level:Level.EASY, effort: effort)

		}

		// create workers
		createWorkers ( numWorkers ){
		}
	}

	@Go
	def go(){

		int idleWorkers =0

		ask(workers()){ it ->
			if (!it.job){
				def _job = jobs.poll()

				if (!_job){
					idleWorkers ++
					// we have nothing for him to do ... next, please
					return
				} else {
					it.job = _job
				}
			}
			// let him work on the job
			def job = it.step()

			if (job && job.completion >= job.effort){
				// remove job from worker
				it.job = null
				// add to completed jobs
				UserObserver.completedJobs << job;
			}
		}

		// we've completed our work
		if (idleWorkers == numWorkers){
			RunEnvironment.getInstance().endRun();
		}
	}


}

