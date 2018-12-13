public class MyLinkedList{

  private class Node{

    private int data;
    private Node next,prev;

    public Node(int data, Node next, Node prev){
      this.data = data;
      this.next = next;
      this.prev = prev;
    }

    public Node next(){
      return next;
    }
    public Node prev(){
      return prev;
    }
    public void setNext(Node other){
      next = other;
    }
    public void setPrev(Node other){
      prev = other;
    }
    public Integer getData(){
      return data;
    }
    public Integer setData(Integer i){
      data = i;
    }
    public String toString(){
      String output = "" + data;
      return output;
    }
  }

  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
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
