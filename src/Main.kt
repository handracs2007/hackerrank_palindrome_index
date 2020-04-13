// https://www.hackerrank.com/challenges/palindrome-index/problem

fun String.isNotPalindrome(): Boolean = this != this.reversed()
fun String.isPalindrome(): Boolean = this == this.reversed()

fun palindromeIndex(s: String): Int {
    if (s.isNotPalindrome()) {
        for (i in s.indices) {
            if (s[i] != s[s.length - i - 1]) {
                // Try remove character at i, then check the string.
                // If the string is Palindrome, all is good, return i
                val left = s.substring(0, i)
                val right = if (i + 1 == s.length) "" else s.substring(i + 1)

                return if ((left + right).isPalindrome()) {
                    i
                } else {
                    // Let's try to remove the other end of the i instead.
                    val left = s.substring(0, s.length - i - 1)
                    val right = if (s.length - i == s.length) "" else s.substring(s.length - i)

                    if ((left + right).isPalindrome()) {
                        s.length - i - 1
                    } else {
                        // Impossible to get palindrome
                        -1
                    }
                }
            }
        }
    }

    return -1
}

fun main() {
    println(palindromeIndex("aaab"))
    println(palindromeIndex("baa"))
    println(palindromeIndex("aaa"))
}