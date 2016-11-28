package burlap.a4.util;

import burlap.a4.BasicGridWorld;
import burlap.oomdp.core.TerminalFunction;
import burlap.oomdp.core.objects.ObjectInstance;
import burlap.oomdp.core.states.State;

public class TwoPeakTerminalFunction implements TerminalFunction {

	int goalX;
	int goalY;
	int localX;
	int localY;

	public TwoPeakTerminalFunction(int goalX, int goalY, int localX, int localY) {
		this.goalX = goalX;
		this.goalY = goalY;
		this.localX = localX;
		this.localY = localY;
	}

	@Override
	public boolean isTerminal(State s) {

		// get location of agent in next state
		ObjectInstance agent = s.getFirstObjectOfClass(BasicGridWorld.CLASSAGENT);
		int ax = agent.getIntValForAttribute(BasicGridWorld.ATTX);
		int ay = agent.getIntValForAttribute(BasicGridWorld.ATTY);

		// are they at goal location?
		if (ax == this.goalX && ay == this.goalY) {
			return true;
		}
		if (ax == this.localX && ay == this.localY) {
			return true;
		}

		return false;
	}

}
