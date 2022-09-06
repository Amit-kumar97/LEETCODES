class Solution {
    public boolean isPowerOfTwo(int n) {
        return IntStream.rangeClosed(0,31).anyMatch(a->Math.pow(2,a)==n);
    }
    
}