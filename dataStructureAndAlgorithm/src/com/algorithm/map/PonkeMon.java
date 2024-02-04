package com.algorithm.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PonkeMon {

    public int solution(int[] nums) {
        Map<Integer, Integer> pokemons = new HashMap<>();
        for (int pokemonNumber : nums) {
            pokemons.put(pokemonNumber, 0);
        }

        int myChoice = nums.length / 2;
        int totalPokemon = pokemons.keySet().size();

        return Math.min(myChoice, totalPokemon);
    }

    // 중복되는 거 줄일 거면 Set 쓰는 게 낫지 않나? value 가 필요가 없는데?
    // => HashSet 을 보면 HashMap 을 사용해서 기능을 구현하고 있어!
    public int usingSet(int[] nums) {
        Set<Integer> pokemons = new HashSet<>();
        for (int pokemonNumber : nums) {
            pokemons.add(pokemonNumber);
        }

        int myChoice = nums.length / 2;
        int totalPokemon = pokemons.size();

        return Math.min(myChoice, totalPokemon);
    }

}
