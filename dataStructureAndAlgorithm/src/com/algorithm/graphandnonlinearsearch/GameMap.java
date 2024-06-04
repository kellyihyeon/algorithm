package com.algorithm.graphandnonlinearsearch;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class GameMap {

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        int answer = new GameMap().solution(maps);
        System.out.println("answer = " + answer);
    }

    class Position {
        Location location;

        int step;
        public Position(Location location, int step) {
            this.location = location;
            this.step = step;
        }

    }
    class Location {
        int x;

        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Location right() {
            return new Location(x, y + 1);
        }

        public Location left() {
            return new Location(x, y - 1);
        }

        public Location up() {
            return new Location(x - 1, y);
        }

        public Location down() {
            return new Location(x + 1, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x && y == location.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    public int solution(int[][] maps) {
        final int mapSizeX = maps.length;
        final int mapSizeY = maps[0].length;
        final Location target = new Location(mapSizeX - 1, mapSizeY - 1);

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(new Location(0, 0), 1));

        boolean[][] visited = new boolean[mapSizeX][mapSizeY];

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            if (now.location.equals(target)) {
                return now.step;
            }

            if(now.location.x < 0) continue;
            if(now.location.x >= mapSizeX) continue;
            if(now.location.y < 0) continue;
            if(now.location.y >= mapSizeY) continue;
            if(maps[now.location.x][now.location.y] == 0) continue;
            if(visited[now.location.x][now.location.y]) continue;

            visited[now.location.x][now.location.y] = true;

            Position right = new Position(now.location.right(), now.step + 1);
            Position left = new Position(now.location.left(), now.step + 1);
            Position up = new Position(now.location.up(), now.step + 1);
            Position down = new Position(now.location.down(), now.step + 1);

            queue.add(right);
            queue.add(left);
            queue.add(up);
            queue.add(down);
        }

        return -1;
    }
}
