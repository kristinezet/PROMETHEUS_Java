public class BinarySearch {

        int data[] = { 3, 6, 7, 10, 34, 56, 60 };
        int numberToFind = 10;

        int L = 0 ;
        int R = data.length - 1 ;
        int m;
        do
        {
            m = R - ((R - L) / 2) ;
            if (data[m]<numberToFind)
             L = m + 1 ;
            else
             R = m - 1 ;
        }
        while ( (L<=R) && (data[m]!=numberToFind) ) ;

        if(data[m]==numberToFind)
            System.out.print(m);
        else
            System.out.print(-1);
	}
}
   