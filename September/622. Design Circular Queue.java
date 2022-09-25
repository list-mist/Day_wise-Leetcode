class MyCircularQueue {
    int[] arr;
    int size;
    int front = -1;
    int rear = -1;
    int count = 0;
    public MyCircularQueue(int k) {
        arr = new int[k];
        size = k;
        Arrays.fill(arr, -1);
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        
       
        int idx = (rear + 1) % size;
        arr[(idx)] = value;
            
        rear = idx;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

            
            int idx = (front + 1) % size;
            front = idx;
        arr[front] = -1;
        count--;
        return true;
    }
    
    public int Front() {
        if(count == 0) return -1;
        int idx = (front + 1) % size;
        return arr[idx];
    }
    
    public int Rear() {
        if(rear == -1 || rear == size) return -1;
        return arr[rear];   
    }
    
    public boolean isEmpty() {
       return count == 0;
    }
    
    public boolean isFull() {
        return count == size;
    }
}
