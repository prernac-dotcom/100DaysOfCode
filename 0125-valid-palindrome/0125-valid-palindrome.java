class Solution {
    public boolean isPalindrome(String s) {
        
        int start = 0;
        int last = s.length()-1;
        if (s.isEmpty())
         return true;
        while(start<=last){
            if (!Character.isLetterOrDigit(s.charAt(start)))
             start++;
            else if (!Character.isLetterOrDigit(s.charAt(last)))
             last --;
            else{ 
                if( Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(last))){
                return false;
            }
            
                start++;
                last--;


        }
        }
        return true;
    }

    }