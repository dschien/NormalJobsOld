package paretojobs.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import org.apache.commons.math3.distribution.NormalDistribution

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

	NormalDistribution X
	double coveredRequirements
	double totalReqs
	double maxEffort

	@Setup
	def setup(){
		clearAll()
		this.completedJobs = [] as Queue

		this.totalReqs = totalRequirements
		
		double w  = numWorkers
		double T = totalReqs / w

		double sd = T/ distShape
		double mean = T / 2
		this.X = new NormalDistribution(mean, sd)

		this.maxEffort = this.X.density(mean) * totalReqs
		
		// create workers
		createWorkers ( numWorkers ){

		}
	}

	@Go
	def go(){

		int idleWorkers =0

		ask(workers()){ it ->
			if (!it.job){

				// if more todo, create a new job with normal distributed effort relative to time of project (tickcount)
				 
				if (this.coveredRequirements < this.totalReqs){
					double currentTick = RunEnvironment.getInstance().getCurrentSchedule().getTickCount();
					
					def effort = this.X.density(currentTick) * this.totalReqs
//					println "\t${currentTick}:\t${effort}"
					it.job = new Job(level:Level.EASY, effort: this.maxEffort - effort)
				} else {
					idleWorkers ++
					// we have nothing for him to do ... next, please
					return
				}
			}
			// let him work on the job
			def job = it.step()

			if (job && job.completion >= job.effort){
				// remove job from worker
				it.job = null
				// we've covered requirements
				this.coveredRequirements += job.effort
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

