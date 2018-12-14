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
      Integer output = getData();
      data = i;
      return output;
    }
    public String toString(){
      String output = "" + data;
      return output;
    }
  }

  private int size;
  private Node start,end;

  public static void main(String[] args) {
    MyLinkedList test = new MyLinkedList();
    test.add(2);
    test.add(5);
    test.add(7);
    System.out.println("add(2) and add(5) and add(7) performed...");
    System.out.println("Size: " + test.size());
    System.out.println("test: " + test);
    System.out.println("get(0): " + test.get(0));
    System.out.println("set(1,11): " + test.set(1,11));
    System.out.println("get(1): " + test.get(1));
    System.out.println("contains(11): " + test.contains(11));
    System.out.println("indexOf(7): " + test.indexOf(7));

  }

  public MyLinkedList(){
    size = 0;
  }
  public int size(){
    return size;
  }
  public boolean add(int value){
    if (size() == 0){
      start = new Node(value, null, null);
      end = start;
      size = 1;
      return true;
    }
    Node oldEnd = end;
    end = new Node(value, null , oldEnd);
    end.prev().setNext(end);
    size++;
    return true;
  }
  public String toString(){
    String output = "{";
    Node x = this.start;
    for (int s = 0; s < size() ; s++){
      output += x.getData() + ", ";
      x = x.next();
    }
    return output.substring(0,output.length()-2) + "}";
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
    Node target = start;
    int output = target.getData();
    for (int x  = 0; x < index; x++){
      output = target.getData();
      target = target.next();
    }
    target.setData(value);
    return output;
  }

  public boolean contains(Integer value){
    Node target = start;
    for (int x  = 0; x < size(); x++){
      if (target.getData() == value){
        return true;
      }
      target = target.next();
    }
    return false;
  }
  public int indexOf(Integer value){
    Node target = start;
    for (int x  = 0; x < size(); x++){
      if (target.getData() == value){
        return size;
      }
      target = target.next();
    }
    return -1;
  }

  //void add(int index,Integer value){}
  //Integer remove(int index){}
  //boolean remove(Integer value){}
}
