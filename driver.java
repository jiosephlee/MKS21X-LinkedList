import java.util.Random;
public class driver{
  public static void main(String[]args){
    //Debugging stuffs
    int addintValErrors = 0;
    int getErrors = 0;
    int setErrors = 0;
    int containsErrors = 0;
    int indexOfErrors = 0;
    int voidAddErrors = 0;
    int indexRemoveErrors = 0;
    int valueRemoveErrors = 0;


//------------------------------------------------------------------------------------------------------------------------------------//

    //Testing the constructor of MyLinkedList
    MyLinkedList empty = new MyLinkedList();
    MyLinkedList a = new MyLinkedList();
    MyLinkedList b = new MyLinkedList();
    Random rand = new Random();
    int nums;
    int seed;
    if (args.length>0){
      nums = Integer.parseInt(args[0]);
    }
    else{
      nums = Math.abs(rand.nextInt() % 1000);
    }
    if (args.length>1){
      seed = Integer.parseInt(args[1]) % 10000;
    }
    else{
      seed = rand.nextInt() % 10000;
    }
    Random rander = new Random(seed);
    System.out.println("MyLinkedList empty: Length (Should be 0): "+empty.size());

    //Testing toString
    System.out.println("\n\n---------Testing toString()--------");
    System.out.println("Printing empty: should print []: "+empty.toString());
    if (!empty.toString().equals("[]")){
      System.out.println("TEST FAILED :( \nCheck your toString())");
    }
    else{
      System.out.println("TEST PASSED!!! :D");
    }


//------------------------------------------------------------------------------------------------------------------------------------//

    //Testing add(int value), size(), and toString
    for (int i = 0; i < nums; ++i){
      a.add(rander.nextInt()% 100);
    }
    System.out.println("\n\n---------Testing add(int value), size(), and toString()---------");
    System.out.println("a: "+a.toString());
    System.out.println("Seed: "+seed);
    System.out.println("New a length (Should be " + nums + "): "+a.size());
    if (nums != a.size()){
      System.out.println("TEST FAILED :( \nCheck your size(), constructor, or add(int value)");
      addintValErrors ++;
    }
    else{
      System.out.println("TEST PASSED!!! :D");
    }
    int[] creator = {10, 20, 39, 4, 70, -1, 8, -41, 9, 9};
    System.out.println("MyLinkedList b: Length (Should be 0): "+b.size());
    for (int i = 0; i < creator.length;i++){
      b.add(creator[i]);
    }
    System.out.println("b: "+b.toString());
    System.out.println("New b length (Should be 10): "+b.size());
    if (10 != b.size()){
      System.out.println("TEST FAILED :( \nCheck your size(), constructor, or add(int value)");
      addintValErrors ++;
    }
    else{
      System.out.println("TEST PASSED!!! :D");
    }


//------------------------------------------------------------------------------------------------------------------------------------//

    //Testing get(int index)
    System.out.println("\n\n---------Testing get(int index)---------");
    try{
      System.out.println("b.get(0) --> 10: "+b.get(0));
      if (b.get(0)!=10){
        getErrors++;
        System.out.println("TEST FAILED :( \nCheck your get!");
      }
      else{
        System.out.println("TEST PASSED!!! :D");
      }
      System.out.println("b.get(2) --> 39: "+b.get(2));
      if (b.get(2)!=39){
        getErrors++;
        System.out.println("TEST FAILED :( \nCheck your get!");
      }
      else{
        System.out.println("TEST PASSED!!! :D");
      }
      System.out.println("b.get(9) --> 9: "+b.get(9));
      if (b.get(9)!=9){
        getErrors++;
        System.out.println("TEST FAILED :( \nCheck your get!");
      }
      else{
        System.out.println("TEST PASSED!!! :D");
      }
      //Error testing
      //Should throw error if index < 0
      System.out.println("\nBegin error testing for get(int index)");
      System.out.println("b.get(-1) --> Error: ");
      b.get(-1);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("Get error handled! Index < 0");
    }
    try{
      //Should throw error if index >= size
      System.out.println("b.get(10) --> Error: ");
      b.get(10);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("get(int index) error handled! Index >= size()");
    }
    try{
      //Testing with an empty list
      System.out.println("empty.get(0) --> Error: ");
      empty.get(0);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("get(int index) error handled! Index >= size()");
    }


//------------------------------------------------------------------------------------------------------------------------------------//

    //Testing set(int index, Integer value)
    System.out.println("\n\n---------Testing set(int index, Integer value)---------");
    System.out.println("b: "+ b.toString());
    b.set(4, 8);
    System.out.println("Testing b.set(4, 8)--> b.get(4) == 8");
    System.out.println(b.get(4));
    if (b.get(4)!=8){
      setErrors++;
      System.out.println("TEST FAILED :( \nCheck your set()!");
    }
    else {
      System.out.println("TEST PASSED!!! :D");
    }
    System.out.println("b: "+ b.toString());
    //Should look like {10, 20, 39, 4, 8, -1, 8, -41, 9, 9}

    b.set(0, 83);
    System.out.println("Testing b.set(0, 83)--> b.get(0) == 83");
    System.out.println(b.get(0));
    if (b.get(0)!=83){
      setErrors++;
      System.out.println("TEST FAILED :( \nCheck your set()!");
    }
    else {
      System.out.println("TEST PASSED!!! :D");
    }
    System.out.println("b: "+ b.toString());
    //Should look like {83, 20, 39, 4, 8, -1, 8, -41, 9, 9}

    b.set(9, 13);
    System.out.println("Testing b.set(4, 8)--> b.get(9) == 13");
    System.out.println(b.get(9));
    if (b.get(9)!=13){
      setErrors++;
      System.out.println("TEST FAILED :( \nCheck your set()!");
    }
    else {
      System.out.println("TEST PASSED!!! :D");
    }
    try{//Error testing
      //Should throw error if index < 0
      System.out.println("\nBegin error testing for set(int index)");
      System.out.println("b.set(-1, 111) --> Error: ");
      b.set(-1, 111);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("Set error handled! Index < 0");
    }
    System.out.println("b: "+ b.toString());
    //Should look like {83, 20, 39, 4, 8, -1, 8, -41, 13, 9}

    try{
      //Should throw error if index >= size
      System.out.println("b.set(10, 8888) --> Error: ");
      b.set(10, 8888);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("set(int index, Integer value) error handled! Index >= size()");
    }
    System.out.println("b: "+ b.toString());
    try{
      //Testing with an empty list
      System.out.println("empty.set(0, 1) --> Error: ");
      empty.set(0,1);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("set(int index, Integer value) error handled! Index >= size()");
    }
    System.out.println("b: "+ b.toString());


//------------------------------------------------------------------------------------------------------------------------------------//

    //Testing contains(Integer value)
    System.out.println("\n\n---------Testing contains(Integer value)---------");
    System.out.println("b: "+ b.toString());
    System.out.println("b.contains(-1) --> TRUE: "+b.contains(-1));
    if (!b.contains(-1)){
      containsErrors++;
      System.out.println("TEST FAILED: check your contains()");
    }
    else{
      System.out.println("TEST PASSED!!! :D");
    }
    System.out.println("b.contains(10) --> FALSE: "+b.contains(10));
    if (b.contains(10)){
      containsErrors++;
      System.out.println("TEST FAILED: check your contains() or set() --should have been changed in set tests");
    }
    else{
      System.out.println("TEST PASSED!!! :D");
    }


//------------------------------------------------------------------------------------------------------------------------------------//

    //Testing indexOf(Integer value)
    Integer num = 20;
    System.out.println("\n\n---------Testing indexOf(Integer value)---------");
    System.out.println("b: "+ b.toString());
    //Should look like {83, 20, 39, 4, 8, -1, 8, -41, 9, 13}

    System.out.println("indexOf(20) --> 1: "+b.indexOf(num));
    if(b.indexOf(num)!=1){
      System.out.println("TEST FAILED: check your indexOf!");
      indexOfErrors++;
    }
    else{
      System.out.println("TEST PASSED!!! :D");
    }

    num = 0;
    System.out.println("indexOf(0) --> -1: "+b.indexOf(num));
    if(b.indexOf(num)!=-1){
      System.out.println("TEST FAILED: should return -1 if it doesn't exist in the list");
      indexOfErrors++;
    }
    else{
      System.out.println("TEST PASSED!!! :D");
    }

    num = 4;
    System.out.println("indexOf(4) --> 3: "+b.indexOf(num));
    if(b.indexOf(num)!=3){
      System.out.println("TEST FAILED: check your indexOf!");
      indexOfErrors++;
    }
    else{
      System.out.println("TEST PASSED!!! :D");
    }

    num = 8;
    System.out.println("indexOf(8) --> 4: "+b.indexOf(num));
    if(b.indexOf(num)!=4){
      System.out.println("TEST FAILED: should return the index of the first instance of the value specified!");
      indexOfErrors++;
    }
    else{
      System.out.println("TEST PASSED!!! :D");
    }

//------------------------------------------------------------------------------------------------------------------------------------//

    //Testing add(int index,Integer value)
    System.out.println("\n\n---------Testing add(int index, Integer value)---------");
    System.out.println("b: "+ b.toString());
    //Should look like {83, 20, 39, 4, 8, -1, 8, -41, 9, 13}

    num = 9;
    System.out.println("add(1, 9) --> [83, 9, 20, 39, 4, 8, -1, 8, -41, 9, 13]");
    b.add(1,num);
    System.out.println("b: "+ b.toString());
    System.out.println("Size should be 11: "+b.size());
    if (!b.toString().equals("[83, 9, 20, 39, 4, 8, -1, 8, -41, 9, 13]")){
      System.out.println("VALUES TEST FAILED: check your add(int index, Integer value) for adding to the middle");
      voidAddErrors++;
    }
    else{
      System.out.println("VALUES TEST PASSED!!! :D");
    }
    if (b.size()!= 11){
      System.out.println("SIZE TEST FAILED: remember to increase the length!");
      voidAddErrors++;
    }
    else{
      System.out.println("SIZE TEST PASSED!!! :D");
    }

    num = 6;
    b.add(9,num);
    System.out.println("add(9, 6) --> [83, 9, 20, 39, 4, 8, -1, 8, -41, 6, 9, 13]");
    System.out.println("b: "+ b.toString());
    System.out.println("Size should be 12: "+b.size());
    if (!b.toString().equals("[83, 9, 20, 39, 4, 8, -1, 8, -41, 6, 9, 13]")){
      System.out.println("VALUES TEST FAILED: check your add(int index, Integer value) for adding to the middle");
      voidAddErrors++;
    }
    else{
      System.out.println("VALUES TEST PASSED!!! :D");
    }
    if (b.size()!= 12){
      System.out.println("SIZE TEST FAILED: remember to increase the length!");
      voidAddErrors++;
    }
    else{
      System.out.println("SIZE TEST PASSED!!! :D");
    }

    num = -2;
    b.add(12,num);
    System.out.println("add(12, -2) --> [83, 9, 20, 39, 4, 8, -1, 8, -41, 6, 9, 13, -2]");
    System.out.println("b: "+ b.toString());
    System.out.println("Size should be 13: "+b.size());
    if (!b.toString().equals("[83, 9, 20, 39, 4, 8, -1, 8, -41, 6, 9, 13, -2]")){
      System.out.println("VALUES TEST FAILED: check your add(int index, Integer value) for adding to the end");
      voidAddErrors++;
    }
    else{
      System.out.println("VALUES TEST PASSED!!! :D");
    }
    if (b.size()!= 13){
      System.out.println("SIZE TEST FAILED: remember to increase the length!");
      voidAddErrors++;
    }
    else{
      System.out.println("SIZE TEST PASSED!!! :D");
    }

    num = -2;
    b.add(0,num);
    System.out.println("add(0, -2) --> [-2, 83, 9, 20, 39, 4, 8, -1, 8, -41, 6, 9, 13, -2]");
    System.out.println("b: "+ b.toString());
    System.out.println("Size should be 14: "+b.size());
    if (!b.toString().equals("[-2, 83, 9, 20, 39, 4, 8, -1, 8, -41, 6, 9, 13, -2]")){
      System.out.println("VALUES TEST FAILED: check your add(int index, Integer value) for adding to the beginning");
      voidAddErrors++;
    }
    else{
      System.out.println("VALUES TEST PASSED!!! :D");
    }
    if (b.size()!= 14){
      System.out.println("SIZE TEST FAILED: remember to increase the length!");
      voidAddErrors++;
    }
    else{
      System.out.println("SIZE TEST PASSED!!! :D");
    }

    //Error testing
    try{
      System.out.println("\nBegin error testing for add(int index, Integer value)");
      System.out.println("add(-1, -2) --> Error");
      //Should cause error because index < 0
      b.add(-1,num);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("add(int index, Integer value) error handled! Index < 0");
    }
    try{
      System.out.println("add(15, -2) --> Error");
      //Should cause error because index > size()
      b.add(15,num);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("add(int index, Integer value) error handled! Index > size()");
    }

//------------------------------------------------------------------------------------------------------------------------------------//

    //Testing remove(int index)
    System.out.println("\n\n---------Testing remove(int index)---------");
    System.out.println("b: "+b.toString());
    //Should look like {-2, 83, 9, 20, 39, 4, 8, -1, 8, -41, 6, 9, 13, -2}

    int Num = b.remove(0);
    System.out.println("b.remove(0) --> -2: "+ Num);
    System.out.println("New list --> [83, 9, 20, 39, 4, 8, -1, 8, -41, 6, 9, 13, -2]");
    System.out.println("b: "+ b.toString());
    System.out.println("Size should be 13: "+b.size());
    if (!b.toString().equals("[83, 9, 20, 39, 4, 8, -1, 8, -41, 6, 9, 13, -2]")){
      System.out.println("VALUES TEST FAILED: check your remove(int index) for beginning values");
      indexRemoveErrors++;
    }
    else{
      System.out.println("VALUES TEST PASSED!!! :D");
    }
    if (b.size()!= 13){
      System.out.println("SIZE TEST FAILED: remember to decrease the length!");
      indexRemoveErrors++;
    }
    else{
      System.out.println("SIZE TEST PASSED!!! :D");
    }

    int number = b.remove(8);
    System.out.println("b.remove(8) --> -41: "+ number);
    System.out.println("New list --> [83, 9, 20, 39, 4, 8, -1, 8, 6, 9, 13, -2]");
    System.out.println("b: "+ b.toString());
    System.out.println("Size should be 12: "+b.size());
    if (!b.toString().equals("[83, 9, 20, 39, 4, 8, -1, 8, 6, 9, 13, -2]")){
      System.out.println("VALUES TEST FAILED: check your remove(int index) for middle values");
      indexRemoveErrors++;
    }
    else{
      System.out.println("VALUES TEST PASSED!!! :D");
    }
    if (b.size()!= 12){
      System.out.println("SIZE TEST FAILED: remember to decrease the length!");
      indexRemoveErrors++;
    }
    else{
      System.out.println("SIZE TEST PASSED!!! :D");
    }

    number = b.remove(11);
    System.out.println("b.remove(11) --> -2: "+ number);
    System.out.println("New list --> [83, 9, 20, 39, 4, 8, -1, 8, 6, 9, 13]");
    System.out.println("b: "+ b.toString());
    System.out.println("Size should be 11: "+b.size());
    if (!b.toString().equals("[83, 9, 20, 39, 4, 8, -1, 8, 6, 9, 13]")){
      System.out.println("VALUES TEST FAILED: check your remove(int index) for ending values");
      indexRemoveErrors++;
    }
    else{
      System.out.println("VALUES TEST PASSED!!! :D");
    }
    if (b.size()!= 11){
      System.out.println("SIZE TEST FAILED: remember to decrease the length!");
      indexRemoveErrors++;
    }
    else{
      System.out.println("SIZE TEST PASSED!!! :D");
    }

    number = b.remove(2);
    System.out.println("b.remove(2) --> 20: "+ number);
    System.out.println("New list --> [83, 9, 20, 39, 4, 8, -1, 8, 6, 9, 13, -2]");
    System.out.println("b: "+ b.toString());
    System.out.println("Size should be 10: "+b.size());
    if (!b.toString().equals("[83, 9, 39, 4, 8, -1, 8, 6, 9, 13]")){
      System.out.println("VALUES TEST FAILED: check your remove(int index) for middle values");
      indexRemoveErrors++;
    }
    else{
      System.out.println("VALUES TEST PASSED!!! :D");
    }
    if (b.size()!= 10){
      System.out.println("SIZE TEST FAILED: remember to decrease the length!");
      indexRemoveErrors++;
    }
    else{
      System.out.println("SIZE TEST PASSED!!! :D");
    }

    //Error testing
    try{
      System.out.println("\nBegin error testing for add(int index, Integer value)");
      System.out.println("remove(-1) --> Error");
      //Should cause error because index < 0
      b.remove(-1);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("remove(int index) error handled! Index < 0");
    }
    try{
      System.out.println("remove(15) --> Error");
      //Should cause error because index >= size()
      b.remove(15);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("remove(int index) error handled! Index >= size()");
    }
//------------------------------------------------------------------------------------------------------------------------------------//

    //Testing remove(Integer value)
      System.out.println("\n\n---------Testing remove(Integer value)---------");
      System.out.println("b: "+b.toString());
      //Should look like {83, 9, 39, 4, 8, -1, 8, 6, 9, 13}

      num = 83;
      System.out.println("b.remove(83) --> true: "+ b.remove(num));
      System.out.println("New list --> [9, 39, 4, 8, -1, 8, 6, 9, 13]");
      System.out.println("b: "+ b.toString());
      System.out.println("Size should be 9: "+b.size());
      if (!b.toString().equals("[9, 39, 4, 8, -1, 8, 6, 9, 13]")){
        System.out.println("VALUES TEST FAILED: check your remove(Integer value) for case in removing a beginning value");
        valueRemoveErrors++;
      }
      else{
        System.out.println("VALUES TEST PASSED!!! :D");
      }
      if (b.size()!= 9){
        System.out.println("SIZE TEST FAILED: remember to decrease the length!");
        valueRemoveErrors++;
      }
      else{
        System.out.println("SIZE TEST PASSED!!! :D");
      }

      num = 4;
      System.out.println("b.remove(4) --> true: "+ b.remove(num));
      System.out.println("New list --> [9, 39, 8, -1, 8, 6, 9, 13]");
      System.out.println("b: "+ b.toString());
      System.out.println("Size should be 8: "+b.size());
      if (!b.toString().equals("[9, 39, 8, -1, 8, 6, 9, 13]")){
        System.out.println("VALUES TEST FAILED: check your remove(Integer value) for case in removing a middle value");
        valueRemoveErrors++;
      }
      else{
        System.out.println("VALUES TEST PASSED!!! :D");
      }
      if (b.size()!= 8){
        System.out.println("SIZE TEST FAILED: remember to decrease the length!");
        valueRemoveErrors++;
      }
      else{
        System.out.println("SIZE TEST PASSED!!! :D");
      }

      num = 0;
      System.out.println("b.remove(0) --> false: "+ b.remove(num));
      System.out.println("New list --> [9, 39, 8, -1, 8, 6, 9, 13]");
      System.out.println("b: "+ b.toString());
      System.out.println("Size should be 8: "+b.size());
      if (!b.toString().equals("[9, 39, 8, -1, 8, 6, 9, 13]")){
        System.out.println("VALUES TEST FAILED: check your remove(Integer value) for case in removing a nonexistent value");
        valueRemoveErrors++;
      }
      else{
        System.out.println("VALUES TEST PASSED!!! :D");
      }
      if (b.size()!= 8){
        System.out.println("SIZE TEST FAILED: list should NOT be altered!");
        valueRemoveErrors++;
      }
      else{
        System.out.println("SIZE TEST PASSED!!! :D");
      }

      num = 13;
      System.out.println("b.remove(13) --> true: "+ b.remove(num));
      System.out.println("New list --> [9, 39, 8, -1, 8, 6, 9]");
      System.out.println("b: "+ b.toString());
      System.out.println("Size should be 7: "+b.size());
      if (!b.toString().equals("[9, 39, 8, -1, 8, 6, 9]")){
        System.out.println("VALUES TEST FAILED: check your remove(Integer value) for case in removing an ending value");
        valueRemoveErrors++;
      }
      else{
        System.out.println("VALUES TEST PASSED!!! :D");
      }
      if (b.size()!= 7){
        System.out.println("SIZE TEST FAILED: remember to decrease the length!");
        valueRemoveErrors++;
      }
      else{
        System.out.println("SIZE TEST PASSED!!! :D");
      }

    //RESULTS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\n\n---------Test Results---------");
    if (addintValErrors == 0){
      System.out.println("Woohoo! Your add(int value) works nicely! :D");
    }
    else{
      System.out.println("Oops! Your add(int value) had "+addintValErrors+" failed tests. Scroll up for test cases. Continue debugging, you can do it!");
    }
    if (getErrors == 0){
      System.out.println("Woohoo! Your get(int index) works nicely! :D");
    }
    else{
      System.out.println("Oops! Your get had "+getErrors+" failed tests. Scroll up for test cases. Continue debugging, you can do it!");
    }
    if (setErrors == 0){
      System.out.println("Woohoo! Your set(int index, Integer value) works nicely! :D");
    }
    else{
      System.out.println("Oops! Your set had "+setErrors+" failed tests. Scroll up for test cases. Continue debugging, you can do it!");
    }
    if (containsErrors == 0){
      System.out.println("Woohoo! Your contains(Integer value) works nicely! :D");
    }
    else{
      System.out.println("Oops! Your contains had "+containsErrors+" failed tests. Scroll up for test cases. Continue debugging, you can do it!");
    }
    if (indexOfErrors == 0){
      System.out.println("Woohoo! Your indexOf(Integer value) works nicely! :D");
    }
    else{
      System.out.println("Oops! Your indexOf had "+indexOfErrors+" failed tests. Scroll up for test cases. Continue debugging, you can do it!");
    }
    if (voidAddErrors == 0){
      System.out.println("Woohoo! Your add(int index, Integer value) works nicely! :D");
    }
    else{
      System.out.println("Oops! Your add(int index, Integer value) had "+voidAddErrors+" failed tests. Scroll up for test cases. Continue debugging, you can do it!");
    }
    if (indexRemoveErrors == 0){
      System.out.println("Woohoo! Your remove(int index) works nicely! :D");
    }
    else{
      System.out.println("Oops! Your remove(int index) had "+indexRemoveErrors+" failed tests. Scroll up for test cases. Continue debugging, you can do it!");
    }
    if (valueRemoveErrors == 0){
      System.out.println("Woohoo! Your remove(Integer value) works nicely! :D");
    }
    else{
      System.out.println("Oops! Your remove(Integer value) had "+valueRemoveErrors+" failed tests. Scroll up for test cases. Continue debugging, you can do it!");
    }

    if(addintValErrors==0&&getErrors==0&&setErrors==0&&containsErrors==0&&indexOfErrors==0&&voidAddErrors==0&&indexRemoveErrors==0&&valueRemoveErrors==0){
      System.out.println("\n~~~All tests passed!!! Nice work :D~~~");
    }
  }
}
