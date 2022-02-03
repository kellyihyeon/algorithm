package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 미로 상자의 구조가 0(갈 수 있는 곳), 1(벽 또는 장애물)로 주어지고,
 * 먹이가 2로 주어질 때, 성실한 개미의 이동 경로를 예상해보자.
 * <p>
 * 단, 맨 아래의 가장 오른쪽에 도착한 경우, 더 이상 움직일 수 없는 경우, 먹이를 찾은 경우에는
 * 더이상 이동하지 않고 그 곳에 머무른다고 가정한다.
 * <p>
 * 미로 상자의 테두리는 모두 벽으로 되어 있으며,
 * 개미집은 반드시 (2, 2)에 존재하기 때문에 개미는 (2, 2)에서 출발한다.
 */
public class TwoDimensionalArray1099 {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            // 10*10 크기의 미로 상자의 구조와 먹이의 위치가 입력된다.
            // 성실한 개미가 이동한 경로를 9로 표시해 출력한다.
            int[][] maze = new int[11][11];

            // construct maze
            for (int i = 0; i < 10; i++) {  // 열
                final String[] raws = br.readLine().split(" ");
                for (int j = 0; j < 10; j++) {  // 행
                    maze[i + 1][j + 1] = Integer.parseInt(raws[j]);
                    System.out.print(maze[i + 1][j + 1] + " ");
                }
                System.out.println();
            }

            // how to find the way: turn right -> 1 -> go down
            maze[2][2] = 9;

            // turn right == x, y+1
            // go down == x+1, y
            for (int i = 2; i < 10; i++) {  // 열
                for (int j = 2; j < 10; j++) {  // 행
                    if (maze[i][j] == 0) {  // 2,2  2,3  2,4  2,5  ...2,10
                        maze[i][j] = 9;
                    } else if (maze[i][j] == 1) {   // 2,4
                        System.out.println("break 걸린 i, j = " + i + "," + j);
//                        maze;
                        // j 가 2가 되면 안되고 유동적이어야 한다.
                        break;
                    }

                }//

            }//


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
