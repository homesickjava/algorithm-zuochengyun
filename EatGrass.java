public class EatGrass {

    /**
     * 给定一个正整数N，表示有N份青草统一堆放在仓库里
     * 有一只牛和一只羊，牛先吃，羊后吃，它俩轮流吃草
     * 不管是牛还是羊，每一轮能吃的草量必须是：
     * 1，4，16，64…(4的某次方)
     * 谁最先把草吃完，谁获胜
     * 假设牛和羊都绝顶聪明，都想赢，都会做出理性的决定
     * 根据唯一的参数N，返回谁会赢
     */

    public static String winner1(int n) {
        //0  1  2  3  4
        //后 先 后 先 先
        if(n<5) {
            if(n==0||n==2) {
                return "后手";
            } else {
                return "先手";
            }
        }
        int base=1;//base是先手吃的分
        while (base<=n){
            //winner1母程序中的先手，是子程序里的后手，子程序里剩余的数是：n-base;
            if(winner1(n-base).equals("后手")) {
                return "先手";
            } else {

                if (base*4>n) {
                    break;
                }
                base = base*4;
            }
        }
        return "后手";
    }

    public static String winner2(int n) {
        if(n%5==0||n%5==2) {
            return "后手";
        } else {
            return "先手";
        }
    }

    public static void main(String[] args) {

        for(int i=0;i<50;i++) {
            System.out.println(i + "---> " + winner1(i));
        }
    }
}
