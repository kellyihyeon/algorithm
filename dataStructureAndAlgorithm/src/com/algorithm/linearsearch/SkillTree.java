package com.algorithm.linearsearch;

import java.util.Arrays;

public class SkillTree {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        int answer = new SkillTree().useStream(skill, skillTrees);
        System.out.println("answer = " + answer);
    }

    public int useStream(String skill, String[] skill_trees) {
        String regex = "[^" + skill + "]";

        return (int) Arrays.stream(skill_trees)
                .map(s -> s.replaceAll(regex, ""))
                .filter(skill::startsWith)
                .count();
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String regex = "[^" + skill + "]";

        for (String skillTree : skill_trees) {
            String remainedSkillTree = skillTree.replaceAll(regex, "");
            if (skill.startsWith(remainedSkillTree)) {
                answer++;
            }
        }

        return answer;
    }
}
