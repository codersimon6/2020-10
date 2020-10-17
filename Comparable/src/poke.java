import java.util.Comparator;

public class poke implements Comparable<poke> {
    public int rank;
    public String suit;

    public poke(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    // 取数值进行比较，不管花色
    // 这里我们认为 null 是最小的
    public int compareTo(poke o) {
        if (o == null) return 0;
        // == 0，表示牌相等
        // < 0，表示 p 比较小
        // > 0，表示 q 比较大
        return rank - o.rank;
    }


    public static class pokecompare implements Comparator<poke> {
        @Override
        // 返回值:
        // 0，表示牌相等
        // < 0，表示前者比较小
        // > 0，表示前者比较大
        public int compare(poke o1, poke o2) {
            if (o1 == o2) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.rank - o2.rank;
        }
    }


    public static void main(String[] args) {
        poke p = new poke(1, "♠");
        poke q = new poke(2, "♠");
        poke o = new poke(1, "♠");
        Comparator<poke> compare = new pokecompare();
        System.out.println(compare.compare(o, q));
        System.out.println(compare.compare(o, p));
        System.out.println(compare.compare(q, p));
    }
}
