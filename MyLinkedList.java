public class MyLinkedList{
 private int size;
 private Node start,end;

 public MyLinkedList(int[] data){

 }
 public int size(){
   return size;
 }
 public boolean add(int value){
   Node oldEnd = end;
   size++;
   end = new Node(value, end, oldEnd);
   return true;
 }
 public String toString(){
   String output = "";
   Node x = this.start;
   for (int s = 0; s < size ; s++ ){
     output += x.data();
     x = x.next;
   }
   return output;
 }
}
