// Brute Force is considering all substrings, and using hashset O(N^3), Sc is O(N)
// Better, using two loops Tc is O(N^2), Sc is O(N)
// Optimal Approach
// Tc is O(2*N), Sc is O(N)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();

        int i=0;
        int j=0;
        int result=0;
        HashSet<Character> hash=new HashSet<>();

        while(j<n){
            char letter=s.charAt(j);
            if(hash.contains(letter)){
                result=Math.max(result,j-i);
                hash.remove(s.charAt(i));
                i++;
            }else{
                hash.add(letter);
                j++;
            }
        }

        result=Math.max(result,j-i);
        return result;
    }
}