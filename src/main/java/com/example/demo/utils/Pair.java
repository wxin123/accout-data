package com.example.demo.utils;

import java.io.Serializable;

public final class Pair<S, T> implements Serializable {
    private S first;
    private T second;

    public static <S, T> Pair<S, T> of(S first, T second) {
        return new Pair(first, second);
    }

    public boolean equals(Object object) {
        if(!(object instanceof Pair)) {
            return false;
        } else if(null != this.getFirst() && null != this.getSecond()) {
            if(null != ((Pair)object).getFirst() && null != ((Pair)object).getSecond()) {
                return !this.getFirst().equals(((Pair)object).getFirst())?false:this.getSecond().equals(((Pair)object).getSecond());
            } else {
                throw new IllegalStateException("ele can not be null");
            }
        } else {
            throw new IllegalStateException("ele can not be null");
        }
    }

    public String toString() {
        return "Pair(first=" + this.getFirst() + ", second=" + this.getSecond() + ")";
    }

    public Pair(S first, T second) {
        this.first = first;
        this.second = second;
    }

    public Pair() {
    }

    public S getFirst() {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }
}
