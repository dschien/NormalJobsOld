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
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoTurtle extends BaseTurtle{

	/**
	 * Makes a number of new workers and then executes a set of commands on the
	 * created workers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created workers
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> hatchWorkers(int number, Closure closure) {
		AgentSet<paretojobs.relogo.Worker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Worker");
		for (Turtle t : createResult){
			if (t instanceof paretojobs.relogo.Worker){
				result.add((paretojobs.relogo.Worker)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new workers and then executes a set of commands on the
	 * created workers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created workers
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.Worker")
	public AgentSet<paretojobs.relogo.Worker> hatchWorkers(int number) {
		return hatchWorkers(number,null);
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
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
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
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> hatchUserTurtles(int number, Closure closure) {
		AgentSet<paretojobs.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof paretojobs.relogo.UserTurtle){
				result.add((paretojobs.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserTurtle")
	public AgentSet<paretojobs.relogo.UserTurtle> hatchUserTurtles(int number) {
		return hatchUserTurtles(number,null);
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
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
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
	 * Makes a directed userLink from a turtle to the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public paretojobs.relogo.UserLink createUserLinkFrom(Turtle t, Closure closure){
		paretojobs.relogo.UserLink link = (paretojobs.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public paretojobs.relogo.UserLink createUserLinkFrom(Turtle t){
			return createUserLinkFrom(t,null);
	}

	/**
	 * Makes directed userLinks from a collection to the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet<paretojobs.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<paretojobs.relogo.UserLink> links = new AgentSet<paretojobs.relogo.UserLink>();
		for(Turtle t : a){
			links.add((paretojobs.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet<paretojobs.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a){
		return createUserLinksFrom(a,null);
	}

	/**
	 * Makes a directed userLink to a turtle from the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public paretojobs.relogo.UserLink createUserLinkTo(Turtle t, Closure closure){
		paretojobs.relogo.UserLink link = (paretojobs.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public paretojobs.relogo.UserLink createUserLinkTo(Turtle t){
			return createUserLinkTo(t,null);
	}

	/**
	 * Makes directed userLinks to a collection from the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet<paretojobs.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<paretojobs.relogo.UserLink> links = new AgentSet<paretojobs.relogo.UserLink>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((paretojobs.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet<paretojobs.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a){
		return createUserLinksTo(a,null);
	}

	/**
	 * Queries if there is a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public boolean inUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed userLinks to the caller.
	 * 
	 * @return agentset with directed userLinks to the caller
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet inUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public paretojobs.relogo.UserLink inUserLinkFrom(Turtle t){
		return (paretojobs.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed userLinks from other turtles to the caller.
	 * 
	 * @return agentset of directed userLinks from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet<paretojobs.relogo.UserLink> myInUserLinks(){
		AgentSet<paretojobs.relogo.UserLink> result = new AgentSet<paretojobs.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getInEdges(this)){
			if (o instanceof paretojobs.relogo.UserLink){
				result.add((paretojobs.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed userLinks to other turtles from the caller.
	 * 
	 * @return agentset of directed userLinks to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet<paretojobs.relogo.UserLink> myOutUserLinks(){
		AgentSet<paretojobs.relogo.UserLink> result = new AgentSet<paretojobs.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getOutEdges(this)){
			if (o instanceof paretojobs.relogo.UserLink){
				result.add((paretojobs.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public boolean outUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed userLinks from the caller.
	 * 
	 * @return agentset with directed userLinks from the caller
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet outUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public paretojobs.relogo.UserLink outUserLinkTo(Turtle t){
		return (paretojobs.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(this, t);
	}

	/**
	 * Reports true if there is a userLink connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public boolean userLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * userLinks connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet userLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's userLinks.
	 * 
	 * @return agentset of the caller's userLinks
	 */
	@ReLogoBuilderGeneratedFor("paretojobs.relogo.UserLink")
	public AgentSet<paretojobs.relogo.UserLink> myUserLinks(){
		AgentSet<paretojobs.relogo.UserLink> result = new AgentSet<paretojobs.relogo.UserLink>();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getEdges(this)){
			if (o instanceof paretojobs.relogo.UserLink){
				result.add((paretojobs.relogo.UserLink)o);
			}
		}
		return result;
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