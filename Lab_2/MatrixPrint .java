public class MatrixPrint {
	public static void main(String args[]){

            int size=5, buf=1;
                for(int i=1; i < size + 1; i++) {
                    for (int j = 1, p = size; j < size + 1; j++, p--) {
                        if(i==j || i==p)
                            System.out.print(" *" + " ");
                        else{
                            if(buf<9)
                                System.out.print(" " + buf + " ");
                            else 
                                System.out.print(buf + " ");
                            }
                        buf++;
                    }
                    System.out.println();
                }

	}
}
      
   