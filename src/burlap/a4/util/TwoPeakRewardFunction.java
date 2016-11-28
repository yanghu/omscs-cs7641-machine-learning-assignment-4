package burlap.a4.util;

import burlap.a4.BasicGridWorld;
import burlap.oomdp.core.objects.ObjectInstance;
import burlap.oomdp.core.states.State;
import burlap.oomdp.singleagent.GroundedAction;
import burlap.oomdp.singleagent.RewardFunction;

public class TwoPeakRewardFunction implements RewardFunction {

	int goalX;
	int goalY;
	int localX;
	int localY;

	public TwoPeakRewardFunction(int goalX, int goalY, int localX, int localY) {
		this.goalX = goalX;
		this.goalY = goalY;
		this.localX = localX;
		this.localY = localY;
	}

	@Override
	public double reward(State s, GroundedAction a, State sprime) {

		// get location of agent in next state
		ObjectInstance agent = sprime.getFirstObjectOfClass(BasicGridWorld.CLASSAGENT);
		int ax = agent.getIntValForAttribute(BasicGridWorld.ATTX);
		int ay = agent.getIntValForAttribute(BasicGridWorld.ATTY);

		// are they at goal location?
		if (ax == this.goalX && ay == this.goalY) {
			return 100.;
		}
		if (ax == this.localX && ay == this.localY) {
			return 70.;
		}

		return 0;
	}

}
