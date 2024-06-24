package leetcode.arrays.path

// https://leetcode.com/problems/gas-station/

private class GasStations {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val gasSize = gas.size
        val costSize = cost.size
        if (gasSize != costSize || gas.isEmpty()) return -1

        var totalGas = 0
        var totalCost = 0
        var tank = 0
        var result = 0

        for (i in gas.indices) {
            totalGas += gas[i]
            totalCost += cost[i]
            tank += gas[i] - cost[i]

            if (tank < 0) {
                result = i + 1
                tank = 0
            }
        }

        return if (totalGas >= totalCost) result else -1
    }
}
