package 프로그래머스.wintersummer2019.멀쩡한사각형_자료형;

/**
 * slide 변수를 보면 h / w를 볼 수 있다.
 * double 이 되는데 이후에 long을 곱해주면 같은 크기여도 double이 더 넓기 때문에 값이 변할 수 있다.
 */
public class Solution {

    public long solution(int w, int h) {
        if (w == h) return (long) w * h - w;
        else if (w == 1 || h == 1) return 0;
        else return find(w, h);
    }

    static long find(int w, int h) {
        long count = 0;
        // double slide = (double) h / w;
        for (int x = 0; x < w; x++) {
            count += (long) Math.ceil(((long) h * (x + 1)) / (double) w) - Math.floor(((long) h * x) / (double) w);
        }

        return (long) w * h - count;
    }
}
