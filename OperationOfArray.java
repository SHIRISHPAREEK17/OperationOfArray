import java.util.Scanner;
class OperationOfArray{// Class name in Title case

    // Method defintion Input,Output,Sorting and Searching

    static void input(int a[]){//Method name in Camel case 
        Scanner sc =new Scanner(System.in);

         for (int i=0;i<a.length;i++){
         System.out.println("Enter Element ::"+(i+1)+"->");
         a[i]=sc.nextInt();
        }
    }

    static void output(int a[]){
      

        for (int i:a){
        System.out.print(i+"\t");
        }
        System.out.println();
    }

   //Sorting method

    static void bubbleSorting(int a[]){
         boolean ans=true;
       for (int i=1;i<a.length && ans ==true ;i++){
             ans=false;
        for (int j=0;j<a.length-i;j++){

            if (a[j]>a[j+1]){ //Swapping
               
                int temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                ans=true;

            }
        }
      }
    }
    
    static void selectionSorting(int a[]){
    for (int i=0;i<a.length;i++){
        for (int j=i+1;j<a.length;j++){
            if (a[i]>a[j]){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
      } 
    }

    static void insertionSorting(int a[]){
     int j;
    for (int i=0;i<a.length;i++){
           int item =a[i];
       for ( j=i-1;j>=0 && a[j]>item;j--){
             a[j+1]=a[j];
        }
             a[j+1]=item;
       } 
    }

    // Linear Searching
    static int linearSearching(int a[],int item){
        for (int i=0;i<a.length;i++){
           if(a[i]==item){
             return i;
         }  
     }
      return -1;
    }
    
    // Binary Searching
    static int binarySearching(int a[],int item){
       int low=0;
       int high=a.length-1;
       int mid=0;
       while(low<=high)
       {
        mid=(low+high)/2;
         if(a[mid]==item)
            return mid;
         else if(a[mid]<item) 
            low =(mid+1);
         else
           high=(mid-1);            
       }
       return -1;
    }

    static void searchInput(int a[]){

      Scanner sc=new Scanner(System.in);
      int search;
      System.out.println("Enter the number you want to search: ");
      search=sc.nextInt();

      System.out.println(" Which searching method do you want? Enter 0 for linear search or 1 for binary search:  ");
      int choice=sc.nextInt();
      int index;

      if(choice==0){
        index=linearSearching(a,search);

      if(index!=-1)
         System.out.println("Found at postion "+(index+1));
      else 
         System.out.println(" Not Found at postion ");

      }
      else if (choice==1) {
         bubbleSorting(a);
         index=binarySearching(a,search);

         if(index!=-1)
           System.out.println("Found at postion ");
         else 
         System.out.println(" Not Found at postion ");

    } 
    else 
       System.out.println("Oh.!! Wrong Selection");
    } 

    //main function start execution from here 
    public static void main(String args[]){

    int n;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter how many number: ");
    n=sc.nextInt();

    int a[]=new int[n]; //dynamic array creation

     //input method calling
      input(a);
      System.out.println();
      
      while (true) {
            System.out.println("Select operation: ");
            System.out.println("1. Sorting\n2. Search\n3. Exit");
            int c = sc.nextInt();

            switch (c) {
                case 1:
                    System.out.println("Select sorting method: ");
                    System.out.println("1. Bubble Sort\n2. Selection Sort\n3. Insertion Sort");
                    int sortChoice = sc.nextInt();
                    switch (sortChoice) {
                        case 1:
                            bubbleSorting(a);
                            break;
                        case 2:
                            selectionSorting(a);
                            break;
                        case 3:
                            insertionSorting(a);
                            break;
                        default:
                            System.out.println("Invalid selection");
                    }
                    output(a);
                    break;
                case 2:
                    searchInput(a);
                    break;
                case 3:
                    System.out.println("Exiting...");
                   break;
                default:
                    System.out.println("Invalid selection");
               }
      }
    } 
}
