object P6 {
  // P06: Find out whether a list is a palindrome.
  def isPalindrome[A](xs: List[A]): Boolean = xs == xs.reverse
}
