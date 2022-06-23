class Solution {
    class Pair{
        int duration, lastDay ;
        Pair(int duration,int lastDay){
            this.duration = duration;
            this.lastDay = lastDay;
           
        }
    }
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new custom());
        
        Arrays.sort(courses, new custom_arr());
        int sum = 0;
        int max = 0;
        for(int[] t : courses){
            int duration = t[0];
            int lastDay = t[1];
        
            sum += duration;
            pq.add(new Pair(duration,lastDay));
            if(sum > lastDay){
                sum -= pq.poll().duration;
            }
        }
        return pq.size();
    }
    class custom implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            return b.duration - a.duration;
        }
    }
    class custom_arr implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[1]== b[1]) return a[0] - b[0];
            return a[1] - b[1];
        }
    }
}
