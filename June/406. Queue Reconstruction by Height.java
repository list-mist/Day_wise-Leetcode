class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, new custom());
        List<int[]> list = new LinkedList<>();
        for(int[] t : people){
            list.add(t[1],t);
        }
        return list.toArray(new int[n][2]);
    }
    class custom implements Comparator<int[]>{  
        public int compare(int[] a, int[] b){
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        }
    }
}
