package paretojobs;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoObserver extends BaseObserver{

	/**
	 * Makes a number of randomly oriented workers and then executes a set of commands on the
	 * created workers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created workers
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> createWorkers(int number, Closure closure) {
		AgentSet<paretojobs.relogo.Worker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Worker");
		for (Turtle t : createResult){
			if (t instanceof paretojobs.relogo.Worker){
				result.add((paretojobs.relogo.Worker)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented workers and then executes a set of commands on the
	 * created workers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created workers
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> createWorkers(int number) {
		return createWorkers(number,null);
	}

	/**
	 * Makes a number of uniformly fanned workers and then executes a set of commands on the
	 * created workers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created workers
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> createOrderedWorkers(int number, Closure closure) {
		AgentSet<paretojobs.relogo.Worker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Worker");
		for (Turtle t : createResult){
			if (t instanceof paretojobs.relogo.Worker){
				result.add((paretojobs.relogo.Worker)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned workers and then executes a set of commands on the
	 * created workers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created workers
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> createOrderedWorkers(int number) {
		return createOrderedWorkers(number,null);
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
		for (Object e : this.getContext().getObjects(paretojobs.relogo.Worker.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof paretojobs.relogo.Worker)
			return (paretojobs.relogo.Worker) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"worker")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"worker")){
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
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> createUserTurtles(int number, Closure closure) {
		AgentSet<paretojobs.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof paretojobs.relogo.UserTurtle){
				result.add((paretojobs.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> createUserTurtles(int number) {
		return createUserTurtles(number,null);
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> createOrderedUserTurtles(int number, Closure closure) {
		AgentSet<paretojobs.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof paretojobs.relogo.UserTurtle){
				result.add((paretojobs.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> createOrderedUserTurtles(int number) {
		return createOrderedUserTurtles(number,null);
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
		for (Object e : this.getContext().getObjects(paretojobs.relogo.UserTurtle.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof paretojobs.relogo.UserTurtle)
			return (paretojobs.relogo.UserTurtle) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"userTurtle")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"userTurtle")){
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
		for (Object e : this.getContext().getObjects(paretojobs.relogo.UserLink.class)) {
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
		return (paretojobs.relogo.UserLink)(this.getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
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
	 * Returns the value of the global variable totalRequirements.
	 *
	 * @return the value of the global variable totalRequirements
	 */
	@ReLogoBuilderGeneratedFor("global: totalRequirements")
	public Object getTotalRequirements(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("totalRequirements");
	}

	/**
	 * Sets the value of the global variable totalRequirements.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: totalRequirements")
	public void setTotalRequirements(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("totalRequirements",value);
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
	 * Returns the value of the global variable distShape.
	 *
	 * @return the value of the global variable distShape
	 */
	@ReLogoBuilderGeneratedFor("global: distShape")
	public Object getDistShape(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("distShape");
	}

	/**
	 * Sets the value of the global variable distShape.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: distShape")
	public void setDistShape(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("distShape",value);
	}


}