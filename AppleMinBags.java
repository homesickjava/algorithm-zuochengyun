public class AppleMinBags {

    /**
     * 小虎去买苹果，商店只提供两种类型的塑料袋，每种类型都有任意数量。
     * 1）能装下6个苹果的袋子
     * 2）能装下8个苹果的袋子
     * 小虎可以自由使用两种袋子来装苹果，但是小虎有强迫症，他要求自己使用的袋子数量必须最少，且使用的每个袋子必须装满。
     * 给定一个正整数N，返回至少使用多少袋子。如果N无法让使用的每个袋子必须装满，返回-1
     */

    /**
     * 所需要的6号袋和8号袋的总个数
     * @param apple 苹果数
     * @return 所需要的6号袋和8号袋的总个数
     */
    public static int minBags(int apple) {
        int minbag6 = -1;
        int minbag8 = apple/8;
        int rest = apple - minbag8*8;

        while (minbag8>=0 && rest<24) {  //如果8号袋>0，逐个减少8号袋，计算6号袋是否能装满
            int rest6=minBag6(rest);
            if(rest6!=-1) {
                minbag6 = rest6;
                break;
            }
            rest = apple - 8 * (--minbag8); //减少8号袋，计算6号袋能否装满
        }
        return minbag6==-1? -1 : minbag6 + minbag8;
    }

    /**
     * 最少的6号袋的个数
     * @param rest 剩余的苹果数
     * @return  6号袋的个数
     */
    public static int minBag6(int rest) {
        return rest%6==0? rest/6 : -1;
    }

    public static int minBagAwesome(int apple) {
        if( (apple & 1) !=0) {
            return -1;
        }
        if(apple < 18) {
            return apple==0? 0: (apple==6||apple==8)? 1:
                    (apple==12||apple==14||apple==16)?2:-1;
        }
        return (apple-18)/8+3;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++) {
            System.out.println("苹果个数："+i +" --> 需要的袋子数："+ minBags(i));
        }
    }
}
