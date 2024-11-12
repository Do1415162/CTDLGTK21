package Nganxepvahangdoi;

public class mangxoayvong {
    private int[] queue;   // Mảng để lưu trữ các phần tử của hàng đợi
    private int front;     // Chỉ số của phần tử đầu tiên
    private int rear;      // Chỉ số của phần tử cuối cùng
    private int size;      // Số lượng phần tử hiện tại trong hàng đợi
    private int capacity;  // Kích thước tối đa của hàng đợi

    // Constructor để khởi tạo hàng đợi với kích thước cố định
    public mangxoayvong(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    // Kiểm tra nếu hàng đợi đầy
    public boolean isFull() {
        return size == capacity;
    }

    // Kiểm tra nếu hàng đợi rỗng
    public boolean isEmpty() {
        return size == 0;
    }

    // Thêm phần tử vào hàng đợi
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Hàng đợi đã đầy, không thể thêm phần tử!");
            return;
        }

        // Nếu hàng đợi rỗng, đặt front bằng 0
        if (isEmpty()) {
            front = 0;
        }

        // Tính vị trí rear mới theo vòng
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
        System.out.println("Đã thêm " + item + " vào hàng đợi.");
    }

    // Lấy phần tử từ đầu hàng đợi
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Hàng đợi rỗng, không thể lấy phần tử!");
            return -1;
        }

        int item = queue[front];
        queue[front] = 0;  // Xóa phần tử

        // Nếu chỉ còn một phần tử, reset front và rear
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            // Tính vị trí front mới theo vòng
            front = (front + 1) % capacity;
        }

        size--;
        System.out.println("Đã lấy " + item + " ra khỏi hàng đợi.");
        return item;
    }

    // Xem phần tử đầu tiên của hàng đợi
    public int peek() {
        if (isEmpty()) {
            System.out.println("Hàng đợi rỗng, không có phần tử để xem!");
            return -1;
        }
        return queue[front];
    }

    // Hiển thị hàng đợi hiện tại
    public void display() {
        if (isEmpty()) {
            System.out.println("Hàng đợi rỗng.");
            return;
        }

        System.out.print("Hàng đợi: ");
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    // Trả về kích thước hiện tại của hàng đợi
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        // Khởi tạo hàng đợi với kích thước 5
        mangxoayvong queue = new mangxoayvong(5);

        // Thêm phần tử vào hàng đợi
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();  // Hàng đợi: 10 20 30 40 50

        // Lấy phần tử ra khỏi hàng đợi
        queue.dequeue();  // Đã lấy 10 ra khỏi hàng đợi.
        queue.display();  // Hàng đợi: 20 30 40 50

        // Thêm phần tử mới sau khi dequeue
        queue.enqueue(60);
        queue.display();  // Hàng đợi: 20 30 40 50 60

        // Xem phần tử đầu tiên
        System.out.println("Phần tử đầu tiên: " + queue.peek());  // Phần tử đầu tiên: 20

        // Tiếp tục dequeue và hiển thị hàng đợi
        queue.dequeue();  // Đã lấy 20 ra khỏi hàng đợi.
        queue.dequeue();  // Đã lấy 30 ra khỏi hàng đợi.
        queue.display();  // Hàng đợi: 40 50 60

        // Thêm phần tử sau khi dequeue
        queue.enqueue(70);
        queue.enqueue(80);
        queue.display();  // Hàng đợi: 40 50 60 70 80
    }
}
