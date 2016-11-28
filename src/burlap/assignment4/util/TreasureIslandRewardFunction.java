package burlap.a4.util;

import burlap.a4.BasicGridWorld;
import burlap.oomdp.core.objects.ObjectInstance;
import burlap.oomdp.core.states.State;
import burlap.oomdp.singleagent.GroundedAction;
import burlap.oomdp.singleagent.RewardFunction;
import java.lang.Math;

public class TreasureIslandRewardFunction implements RewardFunction {

	int goalX;
	int goalY;

	public TreasureIslandRewardFunction(int goalX, int goalY) {
		this.goalX = goalX;
		this.goalY = goalY;
	}

	@Override
	public double reward(State s, GroundedAction a, State sprime) {

		// get location of agent in next state
		ObjectInstance agent = sprime.getFirstObjectOfClass(BasicGridWorld.CLASSAGENT);
		int ax = agent.getIntValForAttribute(BasicGridWorld.ATTX);
		int ay = agent.getIntValForAttribute(BasicGridWorld.ATTY);

		// are they at goal location?
		if (ax == this.goalX && ay == this.goalY) {
			return 1000.;
		} else if ( Math.abs(ax - this.goalX) <= 1 && Math.abs(ay - this.goalY) <= 1) {
			// for neighboring cubes around the island, return negative reward.
			return -50.;
		}

		return 0;
	}

}
