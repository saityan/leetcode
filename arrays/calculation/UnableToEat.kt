package leetcode.arrays.calculation

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch
 *
 * Return the number of students who are unable to eat.
 */

private class UnableToEat {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        var studentsZero = 0
        var studentsOne = 0

        for (student in students) {
            when (student) {
                0 -> studentsZero++
                1 -> studentsOne++
            }
        }

        for (sandwich in sandwiches) {
            when {
                sandwich == 0 && studentsZero > 0 -> studentsZero--
                sandwich == 1 && studentsOne > 0 -> studentsOne--
                else -> break
            }
        }

        return studentsZero + studentsOne
    }
}
