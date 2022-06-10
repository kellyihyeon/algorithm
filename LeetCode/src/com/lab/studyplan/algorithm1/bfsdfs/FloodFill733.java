package com.lab.studyplan.algorithm1.bfsdfs;

public class FloodFill733 {

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if(image[sr][sc] != color) {
            return;
        }

        image[sr][sc] = newColor;

        if (sr + 1 < image.length) {
            fill(image, sr + 1, sc, color, newColor);
        }

        if (sr - 1 >= 0) {
            fill(image, sr - 1, sc, color, newColor);
        }

        if (sc + 1 < image[0].length) {
            fill(image, sr, sc + 1, color, newColor);
        }

        if (sc - 1 >= 0) {
            fill(image, sr, sc - 1, color, newColor);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];

        if (color != newColor) {
            fill(image, sr, sc, color, newColor);
        }

        return image;
    }
}
