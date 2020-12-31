public class SAsa {
    public static int f1(int n)
    {
        int sum = 0;
        int theNumber = 0;
        for (int i = 1; i <=n; i++) {
            if(i%2!=0)
            {
               theNumber++;
                if(theNumber%2!=0)
                    sum+=i;
                else
                    sum-=i;
            }

        }
        return  sum;
    }
    public static String f2(int n){
        int sum = 0;
        int theNumber = 0;
        String str = "";
        for (int i = 1; i <=n; i++) {
            if(i%2!=0)
            {
                theNumber++;
                str+=i+"";
                if(theNumber%2!=0)
                {

                    str+="-";

                }else
                {

                    str+="+";
                }
            }

        }
        return  str;
    }

    public static void main(String[] args) {
        System.out.println(SAsa.f2(25));
    }
}
