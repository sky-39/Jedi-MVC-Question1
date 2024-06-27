package com.example.gaming;

import org.springframework.stereotype.Component;

@Component
public class TempleRun implements Game {
    @Override
    public void up() {
        System.out.println("Templerun character jumps up");
    }

    @Override
    public void down() {
        System.out.println("Templerun character slides");
    }

    @Override
    public void left() {
        System.out.println("Templerun character turns left");
    }

    @Override
    public void right() {
        System.out.println("Templerun character turns right");
    }
}
