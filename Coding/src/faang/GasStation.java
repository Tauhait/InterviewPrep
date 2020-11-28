package faang;

public class GasStation {
	private static final int EMPTY = 0;
    public int canCompleteCircuit(int[] gas, int[] cost) {
        assert gas != null && cost != null && gas.length == cost.length;
        int start = 0;
        int tank = EMPTY; // cumulated from station at start
        int total = EMPTY; // extra fuel left at the end of a full circle
        for (int station = 0, count = gas.length; station < count; ++station) {
            int fuel = gas[station] - cost[station]; // re-fuel and drive to the next station
            tank += fuel;
            total += fuel;
            if (tank < EMPTY) { // Ran out of gas on this circle starting from start, so
                tank = EMPTY; // we're starting again
                start = station + 1; // from next station.
                // We already left this station when run out of gas.
                // Starting anywhere (>= 0) up to this station would be futile,
                // because we'll run out of gas somewhere before this station.
                // Assuming that until previous start point our tank was EMPTY
                // meaning that the cost and gas re-fueling balanced each other
                // for the rest part of the circuit.
            }
        }
        return total < EMPTY?
            -1 // cannot complete the full circle, because we would run out of gas somewhere
            :
            start // something is left in the tank so the last starting point is valid
        ;
    }
}
