
import java.util.LinkedList;
import java.util.Queue;
public class Tester2 {

    public static int toNumber(Queue<Integer> q)
    {
        int mul = 1;
        int sum = 0;
        int count = 0;
        int x = 0;

        Queue<Integer> temp = new LinkedList<>();

        while(!q.isEmpty())
        {
            temp.add(q.remove());
            count++;
        }

        for(int i = 0; i < count; i++) {
            x = temp.remove();
            mul *= 10;
            sum += x * mul;
            q.add(x);
        }


        return sum;
    }

    public static boolean isIdentical(Queue<Integer> q1, Queue<Integer> q2)
    {
        boolean identical = true;
        int x, y;
        if (q1.size() == q2.size())
        {
            for(int i = 0; i < q1.size(); i++)
            {
                x = q1.remove();
                y = q2.remove();

                if (x != y)
                {
                    identical = false;
                }

                q1.add(x);
                q2.add(y);
            }
            return identical;
        }
        
        return false;
    }

    public static boolean isSimilar(Queue<Integer> q1, Queue<Integer> q2)
    {
        boolean flag = true; 
        if(!isIdentical(q1, q2))
        {
            for(int i = 0; i<q2.size(); i++)
            {
                q1.add(q1.remove());
                if (!isIdentical(q1, q2))
                {
                    flag = false;
                }
            }
            return flag;
        }

        return true;
    }
}
