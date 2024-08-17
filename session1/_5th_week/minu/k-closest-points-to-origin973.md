> 문제 확인 하러 가기 : https://leetcode.com/problems/k-closest-points-to-origin/

```java
import java.util.*;
import java.lang.*;

class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // 유클리드거리가 가장 짧은걸 구해야하므로 
    // compareTo() 가 오름차순으로 정렬되도록 세팅해야함
    public int compareTo(Point o){
        if(this.getLength() > o.getLength()){
            return 1;
        }else if(this.getLength() < o.getLength()){
            return -1;
        }
        return 0;
    }

    // 유클리드 거리 구하는 메서드
    // 반환타입 조심 (int 로 하면 틀림)
    public double getLength(){
        return Math.sqrt(x*x + y*y);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> queue = new PriorityQueue<>();
        int pointsNum = points.length;

        // 전달받은 points 배열로부터 Point 객체 만들기
        // 그 다음 우선순위 큐에 저장
        for(int[] point : points){
            Point p = new Point(point[0], point[1]);
            queue.add(p);
        }

        int[][] result = new int[k][2];

        // Comparable 을 오름차순으로 구현하였으므로 
        // 큐의 가장 앞 부터 k번째 원소까지 result 배열에 저장
        for(int i=0; i<k; i++){
            Point p = queue.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        
        return result;
    }
}
```
