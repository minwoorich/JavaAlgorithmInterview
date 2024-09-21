> 문제 확인 하러 가기 : https://leetcode.com/problems/number-of-islands/

```java

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public int numIslands(char[][] grid) {
        int count = 0; // 섬의 개수
        
        // 맵의 모든 점을 순회 하면서 육지인곳을 찾는다
        for(int x=0; x<grid[0].length; x++){
            for(int y=0; y<grid.length; y++){
                // 육지를 찾은 경우
                if(grid[y][x]=='1'){
                    // bfs() 실행
                    count = bfs(count,x,y,grid);
                }
            }
        }
        return count;
    }

    public int bfs(int count, int startX, int startY, char[][] grid) {
        int width = grid[0].length; // 섬 가로
        int height = grid.length; // 섬 높이

        Queue<Point> queue = new ArrayDeque<>(); // bfs 에 사용 될 큐
        Point start = new Point(startX, startY); // 시작 좌표      
        queue.add(start);
        grid[startY][startX] = '0';

        // 큐가 텅 빌 때까지
        while(!queue.isEmpty()){
            Point crnt = queue.poll(); // 큐에 가장 앞 원소 꺼냄

            int cx = crnt.x; // 현재 x 좌표
            int cy = crnt.y; // 현재 y 좌표

            // 4 방향을 순서대로 순회
            for(int i=0; i<4; i++){
                // (cx, cy) -> (nx, ny) : 현재좌표에서 특정 방향으로 이동
                int nx = cx + dx[i]; 
                int ny = cy + dy[i]; 

                // 만약 (nx,ny) 가 맵 밖으로 나간다면 continue
                if(!(nx>=0 && ny>=0 && nx<width && ny<height)){
                    continue;
                }

                // 만약 (nx,ny) 가 바다(혹은 이미 방문한곳) 인 경우 continue
                if(grid[ny][nx] == '0'){
                    continue;
                }

                // (nx,ny) 를 방문했으므로 '0' 으로 변경
                grid[ny][nx] = '0';

                // 큐에 (nx,ny) 를 추가
                queue.add(new Point(nx,ny));
            }
        }
        return ++count;
    }
}
```
