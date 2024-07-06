package leetcode.beweekly.bw134

// https://leetcode.com/contest/biweekly-contest-134/problems/maximum-points-after-enemy-battles/

private class BattlePoints {
    fun maximumPoints(enemyEnergies: IntArray, currentEnergy: Int): Long {
        var min = Integer.MAX_VALUE
        var sum = 0L
        for (energy in enemyEnergies) {
            min = minOf(energy, min)
            sum += energy
        }

        sum = sum + currentEnergy.toLong() - min.toLong()

        return if (currentEnergy < min) 0 else sum / min
    }
}
