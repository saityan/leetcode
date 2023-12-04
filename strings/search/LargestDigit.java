package leetcode.strings.search;

/**
 * leetcode.com/problems/largest-3-same-digit-number-in-string/
 */

class LargestDigit {
    public String largestGoodInteger(String num) {

        String result = "";

        if (num.length() < 3)
            return result;

        for (int i = 0; i < num.length() - 2; i++) {
            int c = num.charAt(i);
            if (c != num.charAt(i + 1) || num.charAt(i) != num.charAt(i + 2)) {
                continue;
            } else if (c == '9') {
                   return "999";
            } else {
                int number = Character.getNumericValue(c);
                if (result.isEmpty())
                    result = String.valueOf(number) + number + number;
                if (result.charAt(0) == '9')
                    return "999";
                if (number > Character.getNumericValue(result.charAt(0)))
                    result = String.valueOf(number) + number + number;
            }
        }
        return result;
    }
}
