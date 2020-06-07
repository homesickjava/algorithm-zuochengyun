public class MSumToN {

    /**
     * 定义一种数：可以表示成若干（数量>1）连续正数和的数
     * 比如:
     * 5 = 2+3，5就是这样的数
     * 12 = 3+4+5，12就是这样的数
     * 1不是这样的数，因为要求数量大于1个、连续正数和
     * 2 = 1 + 1，2也不是，因为等号右边不是连续正数
     * 给定一个参数N，返回是不是可以表示成若干连续正数和的数
     */

    /**
     * 从1开始暴力破解，如果1所获得的值无法满足需求，依次从2,3,4……查看
     * @param num 输入参数num
     * @return 返回
     */
    public static boolean isMSum1(int num) {

        for(int i=1;i<=num;i++) {
            int sum=i;
            for(int j=i+1;j<=num;j++) {
                if(sum>num) {
                    break;
                }
                if(sum==num) {
                    return true;
                }
                sum += j ;
            }
        }
        return false;
    }

    public static boolean isMSum2(int num) {
        if(num<3)
            return false;
        return ((num & (num-1))!=0);
    }

    public static void main(String[] args) {
        for (int k=0;k<200;k++) {
            System.out.println(k + "--> " + isMSum1(k));
        }
        System.out.println("test begin");
        for (int i=0;i<5000;i++) {
            if(isMSum1(i)!=isMSum2(i)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test end");
    }
}
