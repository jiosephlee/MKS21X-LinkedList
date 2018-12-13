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
    end = new Node(value, null , oldEnd);
    end.prev().setNext(end);
    size++;
    return true;
  }
  public String toString(){
    String output = "";
    Node x = this.start;
    for (int s = 0; s < size ; s++){
      output += x.getData();
      x = x.next();
    }
    return output;
  }
  public Integer get(int index){
    if (index == 0){
      return start.getData();
    }
    if (index == size-1){
      return end.getData();
    }
    Node output = start;
    for (int x  = 1; x <= index; x++){
      output = output.next();
    }
    return output.getData();
  }
  public Integer set(int index,Integer value){
    int output = 
    Node target = start;
    for (int x  = 1; x <= index; x++){
      output = target.next();
    }

  }

  boolean contains(Integer value){}
  int indexOf(Integer value){}

  void add(int index,Integer value){}
  Integer remove(int index){}
  boolean remove(Integer value){}
}
