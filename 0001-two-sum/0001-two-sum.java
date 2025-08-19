class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> nmap= new HashMap<>();
        int n = nums.length;
        for (int i=0;i<n;i++){
            nmap.put(nums[i],i);
        }
        for (int i=0;i<n;i++){
            int c=target-nums[i];
            if (nmap.containsKey(c) && nmap.get(c)!=i){
                return new int[]{i,nmap.get(c)};
            }
              
        }
        return new int[]{};
    }
}