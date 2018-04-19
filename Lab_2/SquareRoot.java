public class SquareRoot {

    public static void main(String[] args) {
        double a = 3;
        double b = 2.5;
        double c = -0.5;
        mysqrt(a,b,c);

    }

    public static void mysqrt (double a, double b, double c) {
        double  x1, x2, cor;
        
            if( a==0) {
                if(b!=0){
                    if(c!=0){
                        System.out.println("x1="+ (-c/b));
                        System.out.println("x2="+ (-c/b));
                    }
                    else {
                        System.out.println("x1="+ 0.0);
                        System.out.println("x2="+ 0.0);
                    }
                }
                else{
                    System.out.println("x1=");
                    System.out.println("x2=");
                }
            }
            else {
                cor = Math.sqrt(b*b - 4*a*c);
                x1 = (-1 * b + cor) / (2 * a);
                x2 = (-1 * b - cor) / (2 * a);
                System.out.println("x1="+ x1 +"\nx2=" + x2);
            }

    }
}
      
      