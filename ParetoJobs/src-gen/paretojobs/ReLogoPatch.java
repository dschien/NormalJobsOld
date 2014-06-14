package paretojobs;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoPatch extends BasePatch{

	/**
	 * Sprouts (makes) a number of new workers and then executes a set of commands on the
	 * created workers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created workers
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> sproutWorkers(int number, Closure closure) {
		AgentSet<paretojobs.relogo.Worker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"Worker");
		for (Turtle t : createResult){
			if (t instanceof paretojobs.relogo.Worker){
				result.add((paretojobs.relogo.Worker)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new workers and then executes a set of commands on the
	 * created workers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created workers
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> sproutWorkers(int number) {
		return sproutWorkers(number,null);
	}

	/**
	 * Returns an agentset of workers from the patch of the caller.
	 * 
	 * @return agentset of workers from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> workersHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<paretojobs.relogo.Worker> result = new AgentSet<paretojobs.relogo.Worker>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"worker")){
			if (t instanceof paretojobs.relogo.Worker)
			result.add((paretojobs.relogo.Worker)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of workers on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of workers at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> workersAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<paretojobs.relogo.Worker> result = new AgentSet<paretojobs.relogo.Worker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"worker")){
			if (t instanceof paretojobs.relogo.Worker)
			result.add((paretojobs.relogo.Worker)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<paretojobs.relogo.Worker>();
		}
	}

	/**
	 * Returns an agentset of workers on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of workers on patch p
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> workersOn(Patch p){
		AgentSet<paretojobs.relogo.Worker> result = new AgentSet<paretojobs.relogo.Worker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"worker")){
			if (t instanceof paretojobs.relogo.Worker)
			result.add((paretojobs.relogo.Worker)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of workers on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of workers on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> workersOn(Turtle t){
		AgentSet<paretojobs.relogo.Worker> result = new AgentSet<paretojobs.relogo.Worker>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"worker")){
			if (tt instanceof paretojobs.relogo.Worker)
			result.add((paretojobs.relogo.Worker)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of workers on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of workers on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> workersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<paretojobs.relogo.Worker>();
		}

		Set<paretojobs.relogo.Worker> total = new HashSet<paretojobs.relogo.Worker>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(workersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(workersOn(p));
				}
			}
		}
		return new AgentSet<paretojobs.relogo.Worker>(total);
	}

	/**
	 * Queries if object is a worker.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a worker
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public boolean isWorkerQ(Object o){
		return (o instanceof paretojobs.relogo.Worker);
	}

	/**
	 * Returns an agentset containing all workers.
	 * 
	 * @return agentset of all workers
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> workers(){
		AgentSet<paretojobs.relogo.Worker> a = new AgentSet<paretojobs.relogo.Worker>();
		for (Object e : this.getMyObserver().getContext().getObjects(paretojobs.relogo.Worker.class)) {
			if (e instanceof paretojobs.relogo.Worker){
				a.add((paretojobs.relogo.Worker)e);
			}
		}
		return a;
	}

	/**
	 * Returns the worker with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public paretojobs.relogo.Worker worker(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof paretojobs.relogo.Worker)
			return (paretojobs.relogo.Worker) turtle;
		return null;
	}

	/**
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> sproutUserTurtles(int number, Closure closure) {
		AgentSet<paretojobs.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof paretojobs.relogo.UserTurtle){
				result.add((paretojobs.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> sproutUserTurtles(int number) {
		return sproutUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<paretojobs.relogo.UserTurtle> result = new AgentSet<paretojobs.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof paretojobs.relogo.UserTurtle)
			result.add((paretojobs.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<paretojobs.relogo.UserTurtle> result = new AgentSet<paretojobs.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof paretojobs.relogo.UserTurtle)
			result.add((paretojobs.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<paretojobs.relogo.UserTurtle>();
		}
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<paretojobs.relogo.UserTurtle> result = new AgentSet<paretojobs.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof paretojobs.relogo.UserTurtle)
			result.add((paretojobs.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<paretojobs.relogo.UserTurtle> result = new AgentSet<paretojobs.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof paretojobs.relogo.UserTurtle)
			result.add((paretojobs.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<paretojobs.relogo.UserTurtle>();
		}

		Set<paretojobs.relogo.UserTurtle> total = new HashSet<paretojobs.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<paretojobs.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof paretojobs.relogo.UserTurtle);
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> userTurtles(){
		AgentSet<paretojobs.relogo.UserTurtle> a = new AgentSet<paretojobs.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(paretojobs.relogo.UserTurtle.class)) {
			if (e instanceof paretojobs.relogo.UserTurtle){
				a.add((paretojobs.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public paretojobs.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof paretojobs.relogo.UserTurtle)
			return (paretojobs.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof paretojobs.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet<paretojobs.relogo.UserLink> userLinks(){
		AgentSet<paretojobs.relogo.UserLink> a = new AgentSet<paretojobs.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(paretojobs.relogo.UserLink.class)) {
			if (e instanceof paretojobs.relogo.UserLink){
				a.add((paretojobs.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public paretojobs.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (paretojobs.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public paretojobs.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Returns the value of the global variable avgWorkEffort .
	 *
	 * @return the value of the global variable avgWorkEffort 
	 */
	@ReLogoBuilderGeneratedFor("global: avgWorkEffort ")
	public Object getAvgWorkEffort (){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("avgWorkEffort ");
	}

	/**
	 * Sets the value of the global variable avgWorkEffort .
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: avgWorkEffort ")
	public void setAvgWorkEffort (Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("avgWorkEffort ",value);
	}

	/**
	 * Returns the value of the global variable varWorkEffort .
	 *
	 * @return the value of the global variable varWorkEffort 
	 */
	@ReLogoBuilderGeneratedFor("global: varWorkEffort ")
	public Object getVarWorkEffort (){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("varWorkEffort ");
	}

	/**
	 * Sets the value of the global variable varWorkEffort .
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: varWorkEffort ")
	public void setVarWorkEffort (Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("varWorkEffort ",value);
	}

	/**
	 * Returns the value of the global variable numWorkers.
	 *
	 * @return the value of the global variable numWorkers
	 */
	@ReLogoBuilderGeneratedFor("global: numWorkers")
	public Object getNumWorkers(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numWorkers");
	}

	/**
	 * Sets the value of the global variable numWorkers.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numWorkers")
	public void setNumWorkers(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numWorkers",value);
	}

	/**
	 * Returns the value of the global variable numJobs.
	 *
	 * @return the value of the global variable numJobs
	 */
	@ReLogoBuilderGeneratedFor("global: numJobs")
	public Object getNumJobs(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numJobs");
	}

	/**
	 * Sets the value of the global variable numJobs.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numJobs")
	public void setNumJobs(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numJobs",value);
	}


}